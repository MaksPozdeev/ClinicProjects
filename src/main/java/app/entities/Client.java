package app.entities;

import java.util.*;

public class Client {

    private Integer client_id;
    private String name;
    private String phone;
    private String city;

// Constructors
    public Client(){
    }

    public Client(Integer client_id, String name, String phone, String city){
        this.client_id = client_id;
        this.name = name;
        this.phone = phone;
        this.city = city;
    }

// GET's and SET's

    public Integer getId() {
        return client_id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

// Methods

    @Override
    public String toString() {
        return "Theater{" +
                "client_id=" + client_id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client zacazchik = (Client) o;
        return Objects.equals(client_id, zacazchik.client_id) &&
                Objects.equals(name, zacazchik.name) &&
                Objects.equals(phone, zacazchik.phone) &&
                Objects.equals(city, zacazchik.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(client_id, name, city, phone);
    }



}
