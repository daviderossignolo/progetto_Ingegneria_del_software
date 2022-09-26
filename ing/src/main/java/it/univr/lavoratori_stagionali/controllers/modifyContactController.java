package it.univr.lavoratori_stagionali.controllers;

import it.univr.lavoratori_stagionali.model.EmergencyInfo;
import it.univr.lavoratori_stagionali.model.Modello;
import it.univr.lavoratori_stagionali.model.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class modifyContactController {
    @FXML private TextField cognome;
    @FXML private TextField email;
    @FXML private TextField nome;
    @FXML private Button saveAndClose;
    @FXML private TextField telefono;
    @FXML private Label error1;
    @FXML private Label error2;
    @FXML private Label error3;
    @FXML private Label error4;
    private EmergencyInfo contact;
    private final Modello instance = Modello.getInstance();
    private ArrayList<Worker> listaW = new ArrayList<>();
    private Worker worker;
    @FXML
    void modify() {
        // trovo lavoratore selezionato
        findWorker();

        // creo la nuova esperienza
        EmergencyInfo newContact = new EmergencyInfo();
        newContact.setId(contact.getId());
        newContact.setPhone(contact.getPhone());
        newContact.setEmail(contact.getEmail());
        newContact.setSurname(contact.getSurname());
        newContact.setName(contact.getName());

        if(!checkNew()) {
            // setto i dati
            if (!nome.getText().equals(""))
                newContact.setName(nome.getText());
            if (!cognome.getText().equals(""))
                newContact.setSurname(cognome.getText());
            if (!telefono.getText().equals(""))
                newContact.setPhone(telefono.getText());
            if (!email.getText().equals(""))
                newContact.setEmail(email.getText());
            System.out.println(contact);
            // edit
            instance.editContact(worker, newContact, contact);

            // chiudo la view
            Stage stage = (Stage) saveAndClose.getScene().getWindow();
            stage.close();
        }
    }

    @FXML void setFields(){
        findWorker();
        if(contact.getName() != null) {
            nome.setPromptText(contact.getName());
            cognome.setPromptText(contact.getSurname());
            telefono.setPromptText(contact.getPhone());
            email.setPromptText(contact.getEmail());
        }
    }

    public boolean checkNew() {
        StringBuilder errors = new StringBuilder();

        if (!nome.getText().trim().isEmpty() && !checkText(nome.getText())) {
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

        if (!cognome.getText().trim().isEmpty() && !checkText(cognome.getText())) {
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
        if(!email.getText().trim().isEmpty()) {
            String mailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
            Pattern mailPat = Pattern.compile(mailRegex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = mailPat.matcher(email.getText());
            listaW = instance.getElencoLavoratori();

            for (Worker value : listaW) {
                for (int j = 0; j < value.contacts.size(); j++)
                    if (email.getText().equalsIgnoreCase(value.contacts.get(j).getEmail())
                            && !value.contacts.get(j).getPhone().equalsIgnoreCase(contact.getPhone()))
                        return false;
            }
            return matcher.find();
        }
        return true;
    }

    // controllo telefono
    public Boolean checkPhone() {
        if (!telefono.getText().trim().isEmpty()) {
            String phoneRegex = "^(\\((00|\\+)39\\)|(00|\\+)39)?(38[890]|34[4-90]|36[680]|33[13-90]|32[89]|35[01]|37[019])(\\s?\\d{3}\\s?\\d{3,4}|\\d{6,7})$";
            Pattern mailPat = Pattern.compile(phoneRegex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = mailPat.matcher(telefono.getText());

            listaW = instance.getElencoLavoratori();
            for (Worker value : listaW) {
                for (int j = 0; j < value.contacts.size(); j++)
                    if (telefono.getText().equalsIgnoreCase(value.contacts.get(j).getPhone())
                            && !value.contacts.get(j).getEmail().equalsIgnoreCase(contact.getEmail()))
                        return false;
            }

            return matcher.find();
        }
        return true;
    }

    //controllo che la stringa non contenga numeri
    public Boolean checkText(String text) {
        String regex = "^[a-zA-Z ]*$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public void passSelected(EmergencyInfo c) {
        contact = c;
    }

    public void findWorker() {
        for (Worker x : instance.getElencoLavoratori()){
            if (x.getId() == contact.getId()){
                worker = x;
                break;
            }
            else
                worker = null;
        }
    }
}
