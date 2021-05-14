package ru.job4j.collection;

import java.util.Objects;

public class Person {

    private String name;
    private String surname;
    private String phone;
    private String address;

    public Person(String aName, String aSurname, String aPhone, String aAddress) {
        name = aName;
        surname = aSurname;
        phone = aPhone;
        address = aAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return
                name.equals(person.name) && surname.equals(person.surname)
                && phone.equals(person.phone) && address.equals(person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phone, address);
    }
}
