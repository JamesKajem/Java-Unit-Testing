package com.tasks;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    //Private hash field
    private final Map<String, Appointment> appointments = new HashMap<>();
    //Add appointment to map
    public boolean addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentID())) {
            return false; // Duplicate ID not allowed
        }
        appointments.put(appointment.getAppointmentID(), appointment);
        return true; //Bool return true
    }

    //Remove from map 
    public boolean deleteAppointment(String appointmentID) {
        if (appointments.containsKey(appointmentID)) {
            appointments.remove(appointmentID);
            return true; //Match found
        }
        return false; //Bool return false
    }

    //Return (Object - ID match)
    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID);
    }
}
