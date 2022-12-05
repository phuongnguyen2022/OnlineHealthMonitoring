/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferModels;

import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class HealthStatusTranfer {

    public int weight;
    public int height;
    public String bloodPressure;
    public String bloodSugar;
    public String allergy;
    public String urineSugar;
    public String backgroundDisease;
    public String checkupDate;
    public HealthStatusTranfer() throws SQLException {
    }
}
