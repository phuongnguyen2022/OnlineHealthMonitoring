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
public class PaymentunUsed {

    public String paymentID;
    public int payNumber;
    public String payDate;
    public int count;
    public int discount;

    public PaymentunUsed(String paymentID, int payNumber, String payDate, int count, int discount) {
        this.paymentID = paymentID;
        this.payNumber = payNumber;
        this.payDate = payDate;
        this.count = count;
        this.discount = discount;
    }

    public PaymentunUsed() throws SQLException {
    }

    public String getPaymentID() {
        return paymentID;
    }

    public int getPayNumber() {
        return payNumber;
    }

    public void setPayNumber(int payNumber) {
        this.payNumber = payNumber;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

}
