package com.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class AppointmentTest {
    
    //Test creating a valid appointment
    @Test
    public void testValidAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60); // 1 hour from now
        Appointment appointment = new Appointment("69420", futureDate, "Valid Description");
        assertEquals("69420", appointment.getAppointmentID()); // Check ID
        assertEquals(futureDate, appointment.getAppointmentDate()); // Check date
        assertEquals("Valid Description", appointment.getDescription()); // Check description
    }

    //Test invalid appointment ID
    @Test
    public void testInvalidAppointmentID() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, futureDate, "Valid Description")); // Null ID
        assertThrows(IllegalArgumentException.class, () -> new Appointment("69420678901", futureDate, "Valid Description")); // ID too long
    }

    //Test invalid appointment date
    @Test
    public void testInvalidAppointmentDate() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("69420", new Date(0), "Valid Description")); // Past date
        assertThrows(IllegalArgumentException.class, () -> new Appointment("69420", null, "Valid Description")); // Null date
    }

    //Test invalid description
    @Test
    public void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        assertThrows(IllegalArgumentException.class, () -> new Appointment("69420", futureDate, null)); // Null description
        assertThrows(IllegalArgumentException.class, () -> new Appointment("69420", futureDate, "a".repeat(51))); // Description too long
    }
}
