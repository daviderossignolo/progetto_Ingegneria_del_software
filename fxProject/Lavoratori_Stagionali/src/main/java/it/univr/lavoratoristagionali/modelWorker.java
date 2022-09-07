package it.univr.lavoratoristagionali;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class modelWorker {
    private String nome;
    private String cognome;
    private String dataDiNascita;
    private String luogoDiNascita;
    private String indirizzo;
    private String telefono;
    private String nazionalita;
    private String email;
    private String lingueParlate;
    private boolean automunito;
    private String licences;

    public modelWorker(){
        this.nome = null;
        this.cognome = null;
        this.dataDiNascita = null;
        this.luogoDiNascita = null;
        this.indirizzo = null;
        this.telefono = null;
        this.nazionalita = null;
        this.email = null;
        lingueParlate = null;
    }

    public modelWorker(String nome, String cognome, String dataDiNascita, String luogoDiNascita, String indirizzo,
                       String telefono, String nazionalita, String email, String lingueParlate){
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.luogoDiNascita = luogoDiNascita;
        this.indirizzo = indirizzo;
        this.telefono = telefono;
        this.nazionalita = nazionalita;
        this.email = email;
        this.lingueParlate = lingueParlate;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public String getTelefono(){
        return telefono;
    }

    public String getDataDiNascita(){
        return dataDiNascita;
    }

    public String getLuogoDiNascita(){
        return luogoDiNascita;
    }

    public String getIndirizzo(){
        return indirizzo;
    }

    public String getNazionalita(){
        return nazionalita;
    }

    public String getEmail() {
        return email;
    }

    public String getLingueParlate() {
        return lingueParlate;
    }

    public boolean isAutomunito() {
        return automunito;
    }

    public String getLicences() {
        return licences;
    }

    public void setAutomunito(boolean automunito) {
        this.automunito = automunito;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setLingueParlate(String lingueParlate) {
        this.lingueParlate = lingueParlate;
    }

    public void setLuogoDiNascita(String luogoDiNascita) {
        this.luogoDiNascita = luogoDiNascita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setLicences(String licences) {
        this.licences = licences;
    }

    @Override
    public String toString() {
        return "modelWorker{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita='" + dataDiNascita + '\'' +
                ", luogoDiNascita='" + luogoDiNascita + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nazionalita='" + nazionalita + '\'' +
                ", email='" + email + '\'' +
                ", lingueParlate=" + lingueParlate +
                '}';
    }

    public void writeInFile(){
        CSVWriter writer = null;

        try {
            //out = new PrintWriter("D:\\Lavoratori_Stagionali\\src\\main\\java\\it\\univr\\data\\workers.csv");
            writer = new CSVWriter(new FileWriter("D:\\Lavoratori_Stagionali\\src\\main\\java\\it\\univr\\data\\workers.csv", true));
            // stampa nel file
            String automunito = isAutomunito() ? "si" : "no";
            String res [] = {this.getNome(), this.getCognome(), this.getDataDiNascita(), this.getLuogoDiNascita(), this.getIndirizzo(),
                    this.getTelefono(), this.getNazionalita(), this.getEmail(), this.getLingueParlate(), this.getLicences(), automunito};

            //Writing data to the csv file
            writer.writeNext(res);

            //Flushing data from writer to file
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
