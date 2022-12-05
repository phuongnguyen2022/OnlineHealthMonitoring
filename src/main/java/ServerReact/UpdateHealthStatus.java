/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerReact;

import Database.DatabaseConnect;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Patient;

/**
 *
 * @author Admin
 */
public class UpdateHealthStatus extends HttpServlet {

    DatabaseConnect mydb = new DatabaseConnect();
    Connection con = mydb.getCon();
    Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");
        String pressure = request.getParameter("bPressure");
        String bSugar = request.getParameter("bSugar");
        String uSugar = request.getParameter("uSugar");
        String allergy = request.getParameter("allergy");
        String desease = request.getParameter("bDesease");
        String date = request.getParameter("cDate");

        Patient patient;
        try {
            patient = new Patient();
            Statement stmt = con.createStatement();

//            update in mySQL
            String query = "update healthstatus SET weight=" + weight + ",";
            query += "height=" + height + ",";
            query += "bloodPressure= '" + pressure + "',";
            query += "bloodSugar = '" + bSugar + "',";
            query += "urineSugar = '" + uSugar + "',";
            query += "allergy= '" + allergy + "',";
            query += "backgroundDisease= '" + desease + "',";
            query += "checkupDate= '" + date + "'";
            query += " WHERE id = '" + patient.patientID + "'";
            stmt.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateHealthStatus.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("healthstatus.html");
    }
}
