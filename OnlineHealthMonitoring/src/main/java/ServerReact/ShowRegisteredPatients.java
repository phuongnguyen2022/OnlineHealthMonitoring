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
import transferModels.UserTranfer;

public class ShowRegisteredPatients extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DatabaseConnect mydb = new DatabaseConnect();
            Connection con = mydb.getCon();
            Statement stmt = con.createStatement();

            List<UserTranfer> list = new ArrayList<>();
            RegisteredPatientsManagement IDList = new RegisteredPatientsManagement();

            String query = "SELECT * FROM patient where P_member = true";
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                UserTranfer temp = new UserTranfer();
                IDList.addRegisters(rs.getString("Acc_ID"));
                temp.fullName = rs.getString("P_FullName");
                temp.dob = rs.getString("P_DOB");
                temp.gender = rs.getString("P_gender");
                temp.address = rs.getString("P_address");
                list.add(temp);
            }
            int i = 0;
            for (UserTranfer index : list) {
                query = "SELECT email, phone, picture FROM accountmanagement where id = '" + IDList.getElement(i) + "'";
                rs = stmt.executeQuery(query);
                if (rs.next()) {
                    index.email = rs.getString("email");
                    index.phoneNumber = rs.getString("phone");
                    index.picturePath = rs.getString("picture");
                }
                i++;
            }
            Gson gson = new Gson();
            String userJoin = gson.toJson(list);
            out.write(userJoin);
        } catch (SQLException ex) {
            Logger.getLogger(ShowRegisteredPatients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
