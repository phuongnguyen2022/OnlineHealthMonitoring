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
import transferModels.ConsultTranfer;

/**
 *
 * @author Admin
 */
public class ViewConsult extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DatabaseConnect mydb = new DatabaseConnect();
            Connection con = mydb.getCon();
            Statement stmt = con.createStatement();
            Gson gson = new Gson();
            String query = "Select * from consultdata";
            ResultSet rs = stmt.executeQuery(query);
            List<ConsultTranfer> list = new ArrayList<>();
            while (rs.next()) {
                ConsultTranfer temp = new ConsultTranfer();
                temp.patientName = rs.getString("patientName");
                temp.doctorName = rs.getString("doctorName");
                temp.content = rs.getString("symptom");
                list.add(temp);
            }
            String usedString = gson.toJson(list);
            out.write(usedString);
        } catch (SQLException ex) {
            Logger.getLogger(ViewConsult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
