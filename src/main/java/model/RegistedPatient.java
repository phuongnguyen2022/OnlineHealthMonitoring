/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author dangt
 */
public class RegistedPatient extends Patient {

    public boolean priority;
    public String registedID;

    public RegistedPatient(boolean priority, String registedID) throws SQLException {
        super();
        this.priority = priority;
        this.registedID = registedID;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public String getRegistedID() {
        return registedID;
    }

}
