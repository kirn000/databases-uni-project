package oalex.uni.databases.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employer extends BaseObject{

    @Column
    private String name;

    @Column (name = "contact_person")
    private String contactPerson;

    @Column
    private String tel;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String description;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Employer() {}

    public Employer(String contactPerson, String tel, String email, String address, String city, String country, String description, User user){
        this.contactPerson = contactPerson;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.description = description;
        this.user = user;
    }

    //Getters and setters ----------------------------------------------------------


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
