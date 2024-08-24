
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    //Variables w values
    private final String contactID = "ID1234567";
    private final String firstName = "Abraham";
    private final String lastName = "Lincoln";
    private final String phone = "1234567890";
    private final String address = "1600 Pennsylvania Avenue";

    
    @Test
    public void testContactCreation() { //Testing contactCreation
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        assertEquals(contactID, contact.getContactID());
        assertEquals(firstName, contact.getFirstName());
        assertEquals(lastName, contact.getLastName());
        assertEquals(phone, contact.getPhone());
        assertEquals(address, contact.getAddress());
    }

    @Test
    public void testInvalidContactID() { //Invalid ID test
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, firstName, lastName, phone, address);
        });
        assertEquals("Contact ID cannot be longer than 10 characters.", exception.getMessage());
    }


    //Invalid contact attribute testing
    @Test
    public void testInvalidFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactID, null, lastName, phone, address);
        });
        assertEquals("First name cannot be longer than 10 characters.", exception.getMessage());
    }

    @Test
    public void testInvalidLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactID, firstName, null, phone, address);
        });
        assertEquals("Last name cannot be longer than 10 characters.", exception.getMessage());
    }

    @Test
    public void testInvalidPhone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactID, firstName, lastName, "123", address);
        });
        assertEquals("Phone number must be exactly 10 digits.", exception.getMessage());
    }

    @Test
    public void testInvalidAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(contactID, firstName, lastName, phone, "A very long address that exceeds thirty characters");
        });
        assertEquals("Address cannot be longer than 30 characters.", exception.getMessage());
    }

    //Setters test
    @Test
    public void testSetFirstName() {
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        contact.setFirstName("George");
        assertEquals("George", contact.getFirstName());
    }

    @Test
    public void testSetLastName() {
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        contact.setLastName("Washington");
        assertEquals("Washington", contact.getLastName());
    }

    @Test
    public void testSetPhone() {
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testSetAddress() {
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        contact.setAddress("500 New Address");
        assertEquals("500 New Address", contact.getAddress());
    }

    //Invalid setters test
    @Test
    public void testInvalidSetFirstName() {
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
        assertEquals("First name cannot be longer than 10 characters.", exception.getMessage());
    }

    @Test
    public void testInvalidSetLastName() {
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
        assertEquals("Last name cannot be longer than 10 characters.", exception.getMessage());
    }

    @Test
    public void testInvalidSetPhone() {
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123");
        });
        assertEquals("Phone number must be exactly 10 digits.", exception.getMessage());
    }

    @Test
    public void testInvalidSetAddress() {
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("A very long address that exceeds thirty characters");
        });
        assertEquals("Address cannot be longer than 30 characters.", exception.getMessage());
    }
}
