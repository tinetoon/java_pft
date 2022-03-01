package ru.stqa.pft.addressbook.testData;

import java.util.Objects;

public class ContactData {

    private int inputId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String mobileFone;
    private String group;

    public ContactData(String firstName, String lastName, String address, String email, String mobilePhone) {
        this.inputId = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.mobileFone = mobilePhone;
    }

    public ContactData(String firstName, String lastName, String group) {
        this.inputId = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.address = null;
        this.email = null;
        this.mobileFone = null;
    }

    public ContactData(int inputId, String firstName, String lastName) {
        this.inputId = inputId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = null;
        this.address = null;
        this.email = null;
        this.mobileFone = null;
    }

    public int getInputId() {
        return inputId;
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

    @Override
    public String toString() {
        return "ContactData{" +
                "inputId=" + inputId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", mobileFone='" + mobileFone + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return inputId == that.inputId && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputId, firstName, lastName);
    }
}
