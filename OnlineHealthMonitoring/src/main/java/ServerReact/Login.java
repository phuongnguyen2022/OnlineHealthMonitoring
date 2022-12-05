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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String userName = request.getParameter("username");
            String password = request.getParameter("password");

            DatabaseConnect mydb = new DatabaseConnect();
            Connection con = mydb.getCon();
            Statement stmt = con.createStatement();

            String query = "SELECT * FROM accountmanagement where username = " + "'" + userName + "'";
            ResultSet rs = stmt.executeQuery(query);

            String page = "";
            User user = new User();
            while (rs.next()) {
                if (password.equals(rs.getString("password"))) {
                    user.id = rs.getString("id");
                    user.userName = rs.getString("username");
                    user.password = rs.getString("password");
                    page = "homepage.html";
                } else {
                    page = "fail.html";
                }
            }
            RequestDispatcher dd = request.getRequestDispatcher(page);
            dd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
