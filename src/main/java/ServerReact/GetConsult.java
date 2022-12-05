/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerReact;

import Database.DatabaseConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetConsult extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("nameInput");
            String doctorName = request.getParameter("doctor");
            String consult = request.getParameter("symptom");

            DatabaseConnect mydb = new DatabaseConnect();
            Connection con = mydb.getCon();
            Statement stmt = con.createStatement();

            String query = "insert into consultdata (patientName, doctorName, symptom)";
            query += " values('" + name + "','" + doctorName + "','" + consult + "')";
            stmt.execute(query);

        } catch (SQLException ex) {
            Logger.getLogger(GetConsult.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
