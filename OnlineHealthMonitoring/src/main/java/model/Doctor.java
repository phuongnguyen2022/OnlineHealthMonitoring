package model;

import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Doctor extends User {

    public String doctorID;
    public String workingSchedule;
    public String specialty;
    public boolean isAvailable;

    public Doctor() throws SQLException {
        super();
        this.doctorID = super.getId();
        this.isAvailable = true;
    }

    public Doctor(String doctorID, String workingSchedule, String specialty) throws SQLException {
        this.doctorID = doctorID;
        this.workingSchedule = workingSchedule;
        this.specialty = specialty;
    }
    public String getDoctorID() {
        return doctorID;
    }

    public String getWorkingSchedule() {
        return workingSchedule;
    }

    public void setWorkingSchedule(String workingSchedule) {
        this.workingSchedule = workingSchedule;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
