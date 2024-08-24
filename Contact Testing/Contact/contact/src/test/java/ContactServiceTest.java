import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    //Variables w values
    private ContactService contactService;
    private final String contactID = "ID1234567";
    private final String firstName = "Abraham";
    private final String lastName = "Lincoln";
    private final String phone = "1234567890";
    private final String address = "1600 Pennsylvania Avenue";

    //New service instance
    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    //Testing contact manipulations 
    @Test
    public void testAddContact() { //addContact test
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        contactService.addContact(contact);
        Contact retrievedContact = contactService.getContact(contactID);
        assertEquals(firstName, retrievedContact.getFirstName());
        assertEquals(lastName, retrievedContact.getLastName());
        assertEquals(phone, retrievedContact.getPhone());
        assertEquals(address, retrievedContact.getAddress());
    }

    @Test
    public void testAddDuplicateContactID() { //Dup test w a bull moose
        Contact contact1 = new Contact(contactID, firstName, lastName, phone, address);
        contactService.addContact(contact1);

        Contact contact2 = new Contact(contactID, "Theodore", "Roosevelt", "0987654321", "456 Elm St");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
        assertEquals("Contact ID must be unique.", exception.getMessage());
    }

    @Test
    public void testDeleteContact() { //deleteContact test
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        contactService.addContact(contact);
        contactService.deleteContact(contactID);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact(contactID);
        });
        assertEquals("Contact ID does not exist.", exception.getMessage());
    }

    //Testing contact field alterations w the GOAT 
    @Test
    public void testUpdateFirstName() { //updateFirstName 
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        contactService.addContact(contact);
        contactService.updateFirstName(contactID, "George");
        Contact updatedContact = contactService.getContact(contactID);
        assertEquals("George", updatedContact.getFirstName());
    }

    @Test
    public void testUpdateLastName() { //updateLastName
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        contactService.addContact(contact);
        contactService.updateLastName(contactID, "Washington");
        Contact updatedContact = contactService.getContact(contactID);
        assertEquals("Washington", updatedContact.getLastName());
    }

    @Test
    public void testUpdatePhone() { //updatePhone
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        contactService.addContact(contact);
        contactService.updatePhone(contactID, "0987654321");
        Contact updatedContact = contactService.getContact(contactID);
        assertEquals("0987654321", updatedContact.getPhone());
    }

    @Test
    public void testUpdateAddress() { //updateAddress
        Contact contact = new Contact(contactID, firstName, lastName, phone, address);
        contactService.addContact(contact);
        contactService.updateAddress(contactID, "500 New Address Rd");
        Contact updatedContact = contactService.getContact(contactID);
        assertEquals("500 New Address Rd", updatedContact.getAddress());
    }

    // No ID test
    @Test
    public void testUpdateNonExistentContact() { 
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("NonExistentID", "John");
        });
        assertEquals("Contact ID does not exist.", exception.getMessage());
    }
}
