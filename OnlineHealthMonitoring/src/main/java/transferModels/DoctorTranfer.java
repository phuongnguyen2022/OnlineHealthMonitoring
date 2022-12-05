/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferModels;

public class DoctorTranfer {

    public String fullName;
    public String dob;
    public String gender;
    public long phone;
    public String address;
    public String speciality;
    public String picture;

    public DoctorTranfer(String fullName, String dob, String gender, long phone, String address, String speciality, String picture) {
        this.fullName = fullName;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.speciality = speciality;
        this.picture = picture;
    }

    
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    
    
    public DoctorTranfer() {
    }

    public String toString() {
        String str = "";
        str += fullName + " ";
        str += dob + " ";
        str += gender + " ";
        str += phone + " ";
        str += address + " ";
        str += speciality;
        return str;
    }
}
