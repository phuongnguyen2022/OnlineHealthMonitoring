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
import model.TestServices;

/**
 *
 * @author Admin
 */
public class GetServices extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            DatabaseConnect mydb = new DatabaseConnect();
            Connection con = mydb.getCon();
            Random rn = new Random();
            Statement stmt = con.createStatement();
            Gson gson = new Gson();

            List<TestServices> packages = new ArrayList<TestServices>();

            String query = "SELECT * FROM testservices";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                TestServices testPackage = new TestServices();

                testPackage.id = rs.getInt("Test_ID");
                testPackage.testPackagesName = rs.getString("Test_Packages");
                testPackage.price = rs.getInt("Price");
                packages.add(testPackage);
            }

            String outwriter = gson.toJson(packages);
            out.write(outwriter);
        } catch (SQLException ex) {
            Logger.getLogger(GetServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
