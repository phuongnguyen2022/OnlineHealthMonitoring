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
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferModels.DoctorTranfer;

/**
 *
 * @author Admin
 */
public class DoctorAvailableList extends HttpServlet {

    static final int allowedDoctors = 3;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DatabaseConnect mydb = new DatabaseConnect();
            Connection con = mydb.getCon();
            Random rn = new Random();
            Statement stmt = con.createStatement();

            List<DoctorTranfer> list = new ArrayList<DoctorTranfer>();
            for (int i = 0; i < allowedDoctors; i++) {
                int id = rn.nextInt(11);
                String query = "SELECT * FROM doctor where id = " + "'D_" + id + "'";
                System.out.print(query + "\n");
                ResultSet rs = stmt.executeQuery(query);
                DoctorTranfer doctor = new DoctorTranfer();
                
                if (rs.next()) {
                	System.out.print(rs.getString("fullName"));
                    doctor.fullName = rs.getString("fullName");
                    doctor.dob = rs.getString("dob");
                    doctor.gender = rs.getString("gender");
                    doctor.phone = rs.getLong("phone");
                    doctor.address = rs.getString("address");
                    doctor.speciality = rs.getString("specialisation");
                    
                    list.add(doctor);
                }
                query = "SELECT picture FROM accountmanagement where id = " + "'D_" + id + "'";
                rs = stmt.executeQuery(query);
                if (rs.next()) {
                    doctor.picture = rs.getString("picture");
                }
            }
            System.out.print(list);
            Gson gson = new Gson();
            String usedJson = gson.toJson(list);
            out.write(usedJson);
        } catch (SQLException ex) {
            Logger.getLogger(DoctorAvailableList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
