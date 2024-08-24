public class Contact {
    // Variable Initialization
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Contact Object
    public Contact(String contactID, String firstName, String lastName, String phone, String address) { // Attribute Setup and Construction
        
        // Variable construction w requirements
        if (contactID == null || contactID.length() > 10) { // Validation for contactID
            throw new IllegalArgumentException("Contact ID cannot be longer than 10 characters.");
        }
        
        if (firstName == null || firstName.length() > 10) { // Validation for firstName
            throw new IllegalArgumentException("First name cannot be longer than 10 characters.");
        }
        
        if (lastName == null || lastName.length() > 10) { // Validation for lastName
            throw new IllegalArgumentException("Last name cannot be longer than 10 characters.");
        }
        
        if (phone == null || !phone.matches("\\d{10}")) { // Validation for phone
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        
        if (address == null || address.length() > 30) { // Validation for address
            throw new IllegalArgumentException("Address cannot be longer than 30 characters.");
        }

        // Return & Initialize 
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be longer than 10 characters.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be longer than 10 characters.");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be longer than 30 characters.");
        }
        this.address = address;
    }
}
