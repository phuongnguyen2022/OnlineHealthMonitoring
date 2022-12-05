/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerReact;

import Database.DatabaseConnect;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HealthStatus;
import model.Patient;
import transferModels.HealthStatusTranfer;

/**
 *
 * @author Admin
 */
public class DoctorMonitoring extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            DatabaseConnect mydb = new DatabaseConnect();
            Connection con = mydb.getCon();
            Random rn = new Random();
            Statement stmt = con.createStatement();

            List<String> list = new ArrayList<>();
            List<HealthStatusTranfer> registeredPatientList = new ArrayList<>();

            String query = "SELECT Acc_ID FROM patient where P_member = true";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                list.add(rs.getString("Acc_ID"));
            }
            for (String index : list) {
                HealthStatus status = new HealthStatus(index);
                status.getStatus();

                HealthStatusTranfer temp = new HealthStatusTranfer();
                temp.weight = status.getWeight();
                temp.height = status.getHeight();
                temp.bloodPressure = status.getBloodPressure();
                temp.bloodSugar = status.getBloodSugar();
                temp.urineSugar = status.getUnineSuger();
                temp.allergy = status.getAllergy();
                temp.backgroundDisease = status.getBackgroundDisease();
                temp.checkupDate = status.getCheckupDate();
                registeredPatientList.add(temp);
            }
            Gson gson = new Gson();
            String userJoin = gson.toJson(registeredPatientList);
            out.write(userJoin);

        } catch (Exception ex) {

        }
    }
}
