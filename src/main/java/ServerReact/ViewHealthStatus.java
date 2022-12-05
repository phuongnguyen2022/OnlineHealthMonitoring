/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerReact;

import model.HealthStatus;
import model.Patient;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferModels.HealthStatusTranfer;

/**
 *
 * @author Admin
 */
public class ViewHealthStatus extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //requirements to get health status
            Patient patient = new Patient();
            HealthStatus status = new HealthStatus(patient.patientID);
            status.getStatus();

            //fix the Json 
            HealthStatusTranfer a = new HealthStatusTranfer();
            a.weight = status.getWeight();
            a.height = status.getHeight();
            a.bloodPressure = status.getBloodPressure();
            a.bloodSugar = status.getBloodSugar();
            a.urineSugar = status.getUnineSuger();
            a.allergy = status.getAllergy();
            a.backgroundDisease = status.getBackgroundDisease();
            a.checkupDate = status.getCheckupDate();

            Gson gson = new Gson();
            String userJoin = gson.toJson(a);
            out.write(userJoin);
            out.close();

        } catch (SQLException ex) {
            Logger.getLogger(ViewHealthStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
