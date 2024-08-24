import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // Field setup w hash map
    private final Map<String, Contact> contacts = new HashMap<>();

    
    public void addContact(Contact contact) { //Add a contact to the service
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }
        contacts.put(contact.getContactID(), contact);
    }

    
    public void deleteContact(String contactID) {  //Delete a contact w ID
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        contacts.remove(contactID);
    }

   
    public void updateFirstName(String contactID, String firstName) { //Update the first name of an existing contact
        Contact contact = getContact(contactID);
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be longer than 10 characters.");
        }
        contact.setFirstName(firstName);
    }

   
    public void updateLastName(String contactID, String lastName) { //Update the last name of an existing contact
        Contact contact = getContact(contactID);
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be longer than 10 characters.");
        }
        contact.setLastName(lastName);
    }

   
    public void updatePhone(String contactID, String phone) { //Update the phone number of an existing contact
        Contact contact = getContact(contactID);
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        contact.setPhone(phone);
    }

    
    public void updateAddress(String contactID, String address) { //Update the address of an existing contact
        Contact contact = getContact(contactID);
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be longer than 30 characters.");
        }
        contact.setAddress(address);
    }

    // Contact retrieval w contactID
    public Contact getContact(String contactID) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        return contact;
    }
}
