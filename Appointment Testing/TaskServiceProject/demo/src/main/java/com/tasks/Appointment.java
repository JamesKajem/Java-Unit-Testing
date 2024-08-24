package com.tasks;

import java.util.Date;

public class Appointment {
    // Static Variables ID,Date & description
    private final String appointmentID;
    private final Date appointmentDate;
    private final String description;

    //Appointment Constructor
    public Appointment(String appointmentID, Date appointmentDate, String description) {
        if (appointmentID == null || appointmentID.length() > 10) {//ID requirement
            throw new IllegalArgumentException("Invalid ID"); //Exception
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) { //Date requirement(Past dates are not allowed)
            throw new IllegalArgumentException("Invalid date"); //Exception
        }
        if (description == null || description.length() > 50) { //Description requirement
            throw new IllegalArgumentException("Invalid description"); //Exception
        }

        //Return
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    //Getters
    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}
