package it.univr.lavoratori_stagionali.controllers;

import it.univr.lavoratori_stagionali.model.Availabilities;
import it.univr.lavoratori_stagionali.model.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class addAvController {
    // campi della view
    @FXML private DatePicker endAv;
    @FXML private DatePicker startAv;
    @FXML private TextField towns;
    @FXML private Button saveAndClose;
    @FXML private Label error1;
    @FXML private Label error2;
    @FXML private Label error3;

    // id
    int id_index;
    Boolean added = false;

    // lavoratore corrente
    private Worker currentWorker;

    // lista delle disponibilità
    private final ArrayList<Availabilities> availabilities = new ArrayList<>();

    // torno indietro a schermata aggiunta lavoratore
    @FXML void backToAdd() throws IOException {
        if(!checkFields()) {
            // creo una disponibilità
            Availabilities period = new Availabilities();

            // setto i dati
            period.setStartDate(startAv.getEditor().getText());
            period.setEndDate(endAv.getEditor().getText());
            period.setComuni(towns.getText());
            period.setId(id_index);

            // aggiungo alla lista
            availabilities.add(period);
            // lego le disponibilità al lavoratore
            currentWorker.setPeriods(availabilities);
            added = true;

            // clear del form
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
        startAv.getEditor().clear();
        endAv.getEditor().clear();
        towns.clear();
    }

    @FXML
    void insertNew() {
        if(!checkFields()) {
            // creo disponibilità
            Availabilities period = new Availabilities();

            // setto i dati
            period.setStartDate(startAv.getValue().toString());
            period.setEndDate(endAv.getValue().toString());
            period.setComuni(towns.getText());
            period.setId(id_index);

            // aggiungo alla lista
            availabilities.add(period);

            // clear del form
            clearAll();
        }
    }

    // set id
    public void setId(int id) {
        id_index = id;
    }

    // recuper il lavoratore corrente
    public void saveWorker(Worker currentWorker) {
        this.currentWorker = currentWorker;
    }

    // controllo dei campi
    public boolean checkFields() {
        StringBuilder errors = new StringBuilder();

        // controlli
        if (!checkTowns()) {
            errors.append("- Inserire dei comuni, formato = abc;abc;abc.\n");
            error3.setVisible(true);
        } else
            error3.setVisible(false);

        if (!checkPeriod()) {
            errors.append("- Inserire un periodo valido.\n");
            error2.setVisible(true);
            error1.setVisible(true);
        } else {
            error2.setVisible(false);
            error1.setVisible(false);
        }

        // Display errore
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

    public Boolean checkTowns(){
        if (!towns.getText().trim().isEmpty()) {
            String regex = "^[[a-zA-Z]+;[a-zA-Z]+]*$";
            Pattern mailPat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = mailPat.matcher(towns.getText());

            return matcher.find();
        }
        return false;
    }

    // controllo del periodo
    private boolean checkPeriod() {
        return startAv.getValue() != null && endAv.getValue() != null &&
                endAv.getValue().compareTo(startAv.getValue()) > 0 && endAv.getValue().compareTo(java.time.LocalDate.now()) > 0;
    }
}