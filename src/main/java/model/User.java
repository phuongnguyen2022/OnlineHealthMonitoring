/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class User {

    public static String id;
    public static String userName;
    public static String password;
    public static String fullName;
    public static String gender;
    public static int age;
    public static String address;
    public static int phoneNumber;
    public static String email;
    public String picturePath;
    
    public User() {
    }
    
    public String getId() {
        return id;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        User.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        User.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        User.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        User.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        User.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        User.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        User.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getString() {
        String out = "";
        out += User.fullName + " ";
        out += User.gender + " ";
        out += User.age + " ";
        out += User.address + " ";
        out += User.phoneNumber + " ";
        out += User.email;
        return out;
    }
}
