package it.univr.lavoratori_stagionali.model;

public class User {
    // campi descrittivi della classe
    private String username;
    private String password;
    private String phone;
    private String name;
    private String surname;
    private String birthDay;

    // costruttore con parametri
    public User(String usr, String pwd){
        this.username = usr;
        this.password = pwd;
    }

    // metodi GET
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getBirthDay() {
        return birthDay;
    }
    public String getPhone() {
        return phone;
    }

    // metodi SET
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return username + "," + password + "," + name + "," + surname + "," + birthDay + "," + phone;
    }
}
