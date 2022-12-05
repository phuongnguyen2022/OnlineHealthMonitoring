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
import java.time.Year;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import transferModels.UserTranfer;

public class UserManage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DatabaseConnect mydb = new DatabaseConnect();
            Connection con = mydb.getCon();
            Statement stmt = con.createStatement();

            User user = new User();
            UserTranfer temp = new UserTranfer();
            String query = "SELECT email, phone, picture FROM accountmanagement where id = " + "'" + user.getId() + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                temp.email = rs.getString("email");
                temp.phoneNumber = rs.getString("phone");
                temp.picturePath = rs.getString("picture");
            }
            
            if(user.getId() == null) {return;}
            
            if (user.getId().charAt(0) == 'D') {
                query = "SELECT * FROM doctor where id = " + "'" + user.getId() + "'";
                temp.isDoctor = true;
                rs = stmt.executeQuery(query);
                if (rs.next()) {
                    temp.fullName = rs.getString("fullName");
                    temp.dob = rs.getString("dob");
                    temp.age = calAge(temp.dob.substring(0, 4));
                    temp.gender = rs.getString("gender");
                    temp.address = rs.getString("address");
                }
            } else {
                query = "SELECT * FROM patient where Acc_ID = " + "'" + user.getId() + "'";
                temp.isDoctor = false;
                System.out.print(query);
                rs = stmt.executeQuery(query);
                if (rs.next()) {
                    temp.fullName = rs.getString("P_FullName");
                    temp.dob = rs.getString("P_DOB");
                    temp.age = calAge(temp.dob.substring(0, 4));
                    temp.gender = rs.getString("P_gender");
                    temp.address = rs.getString("P_address");
                }
            }
            Gson gson = new Gson();
            String usedString = gson.toJson(temp);
            out.write(usedString);
        } catch (SQLException ex) {
            Logger.getLogger(UserManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int calAge(String year) {
        int yearCurrent = Year.now().getValue();
        Integer number = Integer.valueOf(year.substring(0, 4));
        return yearCurrent - number;
    }
}
