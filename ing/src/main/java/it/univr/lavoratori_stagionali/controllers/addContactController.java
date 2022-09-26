package it.univr.lavoratori_stagionali.controllers;

import it.univr.lavoratori_stagionali.model.EmergencyInfo;
import it.univr.lavoratori_stagionali.model.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class addContactController {
    // campi view
    @FXML private TextField cognome1;
    @FXML private TextField email1;
    @FXML private TextField nome1;
    @FXML private Button saveAndClose;
    @FXML private TextField telefono1;
    @FXML private Label error1;
    @FXML private Label error2;
    @FXML private Label error3;
    @FXML private Label error4;

    Boolean added = false;

    // id
    private int id_index;

    // lavoratore corrente
    private Worker currentWorker;

    // lista dei contatti
    private final ArrayList<EmergencyInfo> contatti = new ArrayList<>();

    // salvo i contatti inseriti
    @FXML void goBack() throws IOException {
        // controllo campi
        if(!checkFields()) {
            // creo il contatto di emergenza
            EmergencyInfo contact = new EmergencyInfo(id_index, nome1.getText(), cognome1.getText(), telefono1.getText(), email1.getText());

            // aggiungo i dati
            contatti.add(contact);
            currentWorker.setContacts(contatti);
            added = true;
            // pulisco il form
            clearAll();

            // chiudo la view
            Stage stage = (Stage)saveAndClose.getScene().getWindow();
            stage.close();
        }
        else
            added = false;

    }

    // clear del form
    public void clearAll(){
        cognome1.clear();
        nome1.clear();
        telefono1.clear();
        email1.clear();
    }

    // Metodo per inserire un nuovo lavoratore
    @FXML void insertNew() {
        if(!checkFields()){
            // Creo il nuovo contatto di emrgenza
            EmergencyInfo contact = new EmergencyInfo(id_index, nome1.getText(), cognome1.getText(), telefono1.getText(), email1.getText());
            // aggiungo il contatto alla lista
            contatti.add(contact);

            // clear del form
            clearAll();
        }
    }

    // controllo dei campi
    public boolean checkFields() {
        StringBuilder errors = new StringBuilder();

        if (nome1.getText().trim().isEmpty()|| !checkText(nome1.getText())) {
            errors.append("- Inserire il nome.\n");
            error1.setVisible(true);
        } else
            error1.setVisible(false);

        if (!checkMail()) {
            errors.append("- Formato mail non valido.\n");
            error4.setVisible(true);
        } else {
            error4.setVisible(false);
        }

        if (!checkPhone()) {
            errors.append("- Numero di telefono inserito non valido.\n");
            error3.setVisible(true);
        } else {
            error3.setVisible(false);
        }

        if (cognome1.getText().trim().isEmpty() || !checkText(cognome1.getText())) {
            errors.append("- Inserire il congnome.\n");
            error2.setVisible(true);
        } else
            error2.setVisible(false);

        // Display messagio di errore
        if (errors.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione");
            alert.setHeaderText("I seguenti campi sono vuoti");
            alert.setContentText(errors.toString());

            alert.showAndWait();
            return true;
        }

        return false;
    }

    // controllo della mail
    public Boolean checkMail(){
        if(!email1.getText().trim().isEmpty()) {
            String mailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
            Pattern mailPat = Pattern.compile(mailRegex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = mailPat.matcher(email1.getText());
            return matcher.find();
        }
        return false;
    }

    // controllo telefono
    public Boolean checkPhone() {
        if (!telefono1.getText().trim().isEmpty()) {
            String phoneRegex = "^(\\((00|\\+)39\\)|(00|\\+)39)?(38[890]|34[4-90]|36[680]|33[13-90]|32[89]|35[01]|37[019])(\\s?\\d{3}\\s?\\d{3,4}|\\d{6,7})$";
            Pattern mailPat = Pattern.compile(phoneRegex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = mailPat.matcher(telefono1.getText());
            return matcher.find();
        }
        return false;
    }

    //controllo che la stringa non contenga numeri
    public Boolean checkText(String text) {
        String regex = "^[a-zA-Z ]*$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    // set id
    public void setId(int id) {
        id_index = id;
    }

    // recupero il lavoratore corrente
    public void saveWorker(Worker currentWorker) {
        this.currentWorker = currentWorker;
    }
}
