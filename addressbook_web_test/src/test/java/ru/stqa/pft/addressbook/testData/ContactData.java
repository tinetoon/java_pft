package ru.stqa.pft.addressbook.testData;

public class ContactData {
    private final String FIRST_NAME_XPATH = "firstname";
    private final String LAST_NAME_XPATH = "lastname";
    private final String ADDRESS_XPATH = "address";
    private final String EMAIL_XPATH = "email";
    private final String MOBILE_PHONE_XPATH = "mobile";
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String mobileFone;
    private String group;

    public ContactData(String firstName, String lastName, String address, String email, String mobilePhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.mobileFone = mobilePhone;
    }

    public ContactData(String firstName, String lastName, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public String getFIRST_NAME_XPATH() {
        return FIRST_NAME_XPATH;
    }

    public String getLAST_NAME_XPATH() {
        return LAST_NAME_XPATH;
    }

    public String getADDRESS_XPATH() {
        return ADDRESS_XPATH;
    }

    public String getEMAIL_XPATH() {
        return EMAIL_XPATH;
    }

    public String getMOBILE_PHONE_XPATH() {
        return MOBILE_PHONE_XPATH;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileFone() {
        return mobileFone;
    }

    public String getGroup() {
        return group;
    }
}
