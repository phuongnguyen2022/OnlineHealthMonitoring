/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Database.DatabaseConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HealthStatus {

    String userID;
    int weight;
    int height;
    String bloodPressure;
    String bloodSugar;
    String unineSuger;
    String allergy;
    String backgroundDisease;
    String checkupDate;

    DatabaseConnect mydb = new DatabaseConnect();
    Connection con = mydb.getCon();

    public HealthStatus(String id) throws SQLException {
        this.userID = id;
    }

    public void getStatus() throws SQLException {
        String query = "SELECT * FROM healthstatus where id = " + "'" + this.userID + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        if (rs.next()) {

        	String a = rs.getString("id"); 
            this.weight = rs.getInt("weight");  
            this.height = rs.getInt("height");
            this.bloodPressure = rs.getString("bloodpressure");

            this.bloodSugar = rs.getString("bloodsugar");
            this.unineSuger = rs.getString("urinesugar");
            this.allergy = rs.getString("Allergy");
            this.backgroundDisease = rs.getString("BackgroundDisease");
            this.checkupDate = rs.getString("CheckupDate");
        }
    }

    public HealthStatus(int weight, int height, String bloodPressure, String bloodSugar, String unineSuger,String allergy,String backgroundDisease, String checkupDate) {
        this.weight = weight;
        this.height = height;
        this.bloodPressure = bloodPressure;
        this.bloodSugar = bloodSugar;
        this.unineSuger = unineSuger;
        this.allergy = allergy;
        this.backgroundDisease = backgroundDisease;
        this.checkupDate = checkupDate;
    }
    
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(String bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public String getUnineSuger() {
        return unineSuger;
    }

    public void setUnineSuger(String unineSuger) {
        this.unineSuger = unineSuger;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getBackgroundDisease() {
        return backgroundDisease;
    }

    public void setBackgroundDisease(String backgroundDisease) {
        this.backgroundDisease = backgroundDisease;
    }

    public String getCheckupDate() {
        return checkupDate;
    }

    public void setCheckupDate(String checkupDate) {
        this.checkupDate = checkupDate;
    }

    @Override
    public String toString() {
        String str = "";
        str += this.weight + " ";
        str += this.height + " ";
        str += this.bloodPressure + " ";
        str += this.bloodSugar + " ";
        str += this.unineSuger + " ";
        str += this.allergy + " ";
        str += this.backgroundDisease + " ";
        str += this.checkupDate + " ";
        return str;
    }
}
