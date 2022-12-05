/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

public class Patient extends User {

    public PaymentunUsed payment;
    public String patientID;
    public String patientDayOfBirth;

    public Patient() throws SQLException {
        super();
        this.patientID = super.getId();
        this.payment = new PaymentunUsed();
    }

    public Patient(PaymentunUsed payment, HealthStatus healthStatus, String patientID, String patientDayOfBirth) {
        this.payment = payment;
        this.patientID = patientID;
        this.patientDayOfBirth = patientDayOfBirth;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getPatientDayOfBirth() {
        return patientDayOfBirth;
    }

    public void setPatientDayOfBirth(String patientDayOfBirth) {
        this.patientDayOfBirth = patientDayOfBirth;
    }

    public void askDoctorToConsult(int consultNumber) {

    }

    public PaymentunUsed showPayment() {
        return payment;
    }

    public void giveHealthMeasure(HealthStatus patientHealth) {

    }

}
