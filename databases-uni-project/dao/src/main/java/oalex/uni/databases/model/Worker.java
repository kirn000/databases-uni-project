package oalex.uni.databases.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Worker extends BaseObject{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private int age;

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

    public Worker() {}

    public Worker(String firstName, String lastName, int age, String tel, String email, String address, String city, String country, String description, User user){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.description = description;
        this.user = user;
    }

    //Getters and setters ----------------------------------------------------------


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
