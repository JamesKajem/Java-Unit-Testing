package com.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class AppointmentServiceTest {
    
    //Test adding a valid appointment
    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60); //1 hour in the future
        Appointment appointment = new Appointment("69420", futureDate, "Description");

        assertTrue(service.addAppointment(appointment)); //Check successful add
        assertNotNull(service.getAppointment("69420")); //Verify appointment exists
    }

    //Test adding a duplicate appointment
    @Test
    public void testAddDuplicateAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60); //1 hour in the future
        Appointment appointment1 = new Appointment("69420", futureDate, "Description");
        Appointment appointment2 = new Appointment("69420", futureDate, "Another Description");

        assertTrue(service.addAppointment(appointment1)); //First add should succeed
        assertFalse(service.addAppointment(appointment2)); //Duplicate ID should fail
    }

    //Test deleting an existing appointment
    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60); //1 hour in the future
        Appointment appointment = new Appointment("69420", futureDate, "Description");

        service.addAppointment(appointment); 
        assertTrue(service.deleteAppointment("69420")); //Check successful delete
        assertNull(service.getAppointment("69420")); //Verify appointment is deleted
    }

    //Test deleting a non-existent appointment
    @Test
    public void testDeleteNonExistentAppointment() {
        AppointmentService service = new AppointmentService();
        assertFalse(service.deleteAppointment("69420")); //No appointment to delete, should fail
    }
}
