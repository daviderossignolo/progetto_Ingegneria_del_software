package it.univr.lavoratoristagionali;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class contattoEmergenza {
    private String nome;
    private String cognome;
    private String telefono;
    private String email;

    public contattoEmergenza() {
        this.nome = null;
        this.cognome = null;
        this.telefono = null;
        this.email = email;
    }

    public contattoEmergenza(String nome, String cognome, String telefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "contattoEmergenza{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public void writeInFile(){
        CSVWriter writer = null;

        try {
            //out = new PrintWriter("D:\\Lavoratori_Stagionali\\src\\main\\java\\it\\univr\\data\\workers.csv");
            writer = new CSVWriter(new FileWriter("D:\\Lavoratori_Stagionali\\src\\main\\java\\it\\univr\\data\\workers.csv"));
            // stampa nel file
            String res [] = {this.getNome(), this.getCognome(), this.getTelefono(), this.getEmail()};

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
