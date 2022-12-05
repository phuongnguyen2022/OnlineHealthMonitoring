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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import transferModels.Sensor;

/**
 *
 * @author Admin
 */
public class Scan extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            DatabaseConnect mydb = new DatabaseConnect();
            Connection con = mydb.getCon();
            Statement stmt = con.createStatement();
            Sensor sensor = new Sensor();
            Random gs = new Random();

            String query = "SELECT * FROM scan_infor where scan_id = " + "'" + gs.nextInt(4) + "'";
            System.out.print(query);
            ResultSet rs = stmt.executeQuery(query);

            Date date = new Date();
            while (rs.next()) {
                int id = rs.getInt("scan_id");
                String temp = rs.getString("scan_date");
                sensor.temperature = rs.getString("temperature");
                sensor.heartRate = rs.getString("heartrate");
                sensor.pressure = rs.getString("pressure");
                sensor.date = date.toString();
            }

            Gson gson = new Gson();
            String usedJson = gson.toJson(sensor);
            
            out.write(usedJson);
            out.close();
        } catch (SQLException ex) {
            Logger.getLogger(Scan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
