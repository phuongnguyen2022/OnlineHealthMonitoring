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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manageRegisteredPatients.RegisteredPatientsManagement;
import model.HealthStatus;
import transferModels.HealthStatusTranfer;

public class DoctorViewHealth extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //requirements to get health status
            RegisteredPatientsManagement IDList = new RegisteredPatientsManagement();
            List<HealthStatusTranfer> list = new ArrayList<>();
            DatabaseConnect mydb = new DatabaseConnect();
            Connection con = mydb.getCon();
            Statement stmt = con.createStatement();

            String query = "SELECT * FROM patient where P_member = true";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                IDList.addRegisters(rs.getString("Acc_ID"));
            }
            for (String id : IDList.getList()) {
                HealthStatus status = new HealthStatus(id);
                status.getStatus();

                HealthStatusTranfer a = new HealthStatusTranfer();
                a.weight = status.getWeight();
                a.height = status.getHeight();
                a.bloodPressure = status.getBloodPressure();
                a.bloodSugar = status.getBloodSugar();
                a.urineSugar = status.getUnineSuger();
                a.allergy = status.getAllergy();
                a.backgroundDisease = status.getBackgroundDisease();
                a.checkupDate = status.getCheckupDate();
                list.add(a);
            }
            Gson gson = new Gson();
            String userJoin = gson.toJson(list);
            out.write(userJoin);
            out.close();
        } catch (SQLException ex) {
            Logger.getLogger(DoctorViewHealth.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
