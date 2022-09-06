package it.univr.lavoratoristagionali;

public class modelUtente {
    private String username;
    private String password;
    private String telefono;
    private String nome;
    private String cognome;
    private String dataNascita;

    public modelUtente(String utente, String pwd){
        this.username = utente;
        this.password = pwd;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public void setUsername(String newUsr){
        username = newUsr;
    }
    public void setPassword(String newPwd){
        password = newPwd;
    }

    public void setTelefono(String newTelefono) {
        this.telefono = newTelefono;
    }
}
