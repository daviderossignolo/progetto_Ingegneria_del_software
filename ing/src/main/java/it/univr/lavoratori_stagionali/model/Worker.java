package it.univr.lavoratori_stagionali.model;

import java.util.ArrayList;

public class Worker {
    // campi che identificano un lavoratore
    private int id;
    private String name;
    private String surname;
    private String birthday;
    private String birthplace;
    private String address;
    private String phone;
    private String nationality;
    private String email;
    private String languages;
    private boolean car;
    public String licences;
    public ArrayList<EmergencyInfo> contacts = new ArrayList<>();
    public ArrayList<Experience> experiences = new ArrayList<>();
    public ArrayList<Availabilities> periods = new ArrayList<>();

    // costruttori
    public Worker(){
        super();
    }

    // costruttore con parametri
    public Worker(int id, String name, String surname, String birthday, String birthplace, String address, String phone, String nationality, String email, String languages, Boolean car,
                  String licences){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.address = address;
        this.phone = phone;
        this.nationality = nationality;
        this.email = email;
        this.languages = languages;
        this.car = car;
        this.licences = licences;

    }

    // costruttore per visualizzazione tabella home
    public Worker(String name, String surname, String birthday,String address, String phone){
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
    }

    // Metodi GET
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getBirthplace() {
        return birthplace;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public String getNationality() {
        return nationality;
    }
    public String getEmail() {
        return email;
    }
    public String getLanguages() {
        return languages;
    }
    public String getLicences() {
        return licences;
    }
    public int getId() {
        return id;
    }
    public Boolean getCar() {
        return car;
    }
    public ArrayList<Experience> getExperiences() {
        return experiences;
    }
    public ArrayList<Availabilities> getPeriods() {
        return periods;
    }
    public ArrayList<EmergencyInfo> getContacts() {
        return contacts;
    }

    // Metodi SET
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setLanguages(String languages) {
        this.languages = languages;
    }
    public void setCar(boolean car) {
        this.car = car;
    }
    public void setLicences(String licences) {
        this.licences = licences;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setContacts(ArrayList<EmergencyInfo> contacts) {
        this.contacts = contacts;
    }
    public void setExperiences(ArrayList<Experience> experiences) {
        this.experiences = experiences;
    }
    public void setPeriods(ArrayList<Availabilities> periods) {
        this.periods = periods;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + surname  + "," + birthday + "," + birthplace  + "," + address  + "," + phone  + "," + nationality
                + "," + email  + "," + languages  + "," + licences +  "," + (car ? "si" : "no") + "\n";
    }
}
