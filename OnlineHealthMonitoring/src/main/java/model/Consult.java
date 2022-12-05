/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Consult {

    public int id;
    public String title;
    public String content;
    public Doctor doctor;
    public Patient patient;

    public Consult(String title, String content, Doctor doctor, Patient patient) throws SQLException {
        this.patient = new Patient();
        this.title = title;
        this.content = content;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Consult() throws SQLException {
        this.patient = new Patient();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
