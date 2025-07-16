package src.main.java.pim.Records;

public class Contact extends Record {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private static final long serialVersionUID = 2L;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact {" +
                "First Name :'" + firstName + '\'' +
                ", LastName :" + lastName +
                ", Phone Number :" + phoneNumber +
                '}';
    }
}