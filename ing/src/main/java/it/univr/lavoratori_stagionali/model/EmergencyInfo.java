package it.univr.lavoratori_stagionali.model;

public class EmergencyInfo {
    // campi descrittivi del contatto di emergenza
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;

    // costruttore vuoto
    public EmergencyInfo(){
        super();
    }

    // costruttore con parametri
    public EmergencyInfo(int id, String name, String surname, String phone, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    // Metodi GET
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }

    // Metodi SET
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + surname + "," + phone + "," + email + "\n";
    }
}
