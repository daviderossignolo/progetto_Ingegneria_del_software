package it.univr.lavoratori_stagionali.controllers;

import it.univr.lavoratori_stagionali.model.Availabilities;
import it.univr.lavoratori_stagionali.model.Experience;
import it.univr.lavoratori_stagionali.model.Modello;
import it.univr.lavoratori_stagionali.model.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class modifyAvController {
    @FXML
    private DatePicker endAv;

    @FXML
    private Button saveAndClose;

    @FXML
    private DatePicker startAv;

    @FXML
    private TextField towns;
    @FXML private Label error1;
    @FXML private Label error2;
    @FXML private Label error3;


    private Availabilities availabilities;

    private Modello instance = Modello.getInstance();
    private Worker worker;

    @FXML
    void modify(MouseEvent event) {
        // trovo lavoratore selezionato
        findWorker();

        // creo la nuova esperienza
        Availabilities newAv = new Availabilities();
        newAv.setId(availabilities.getId());
        newAv.setComuni(availabilities.getComuni());
        newAv.setStartDate(availabilities.getStartDate());
        newAv.setEndDate(availabilities.getEndDate());

        if(!checkFields()) {
            // setto i dati
            if (!startAv.getEditor().getText().equals(""))
                newAv.setStartDate(startAv.getValue().toString());
            if (!endAv.getEditor().getText().equals(""))
                newAv.setEndDate(endAv.getValue().toString());
            if (!towns.getText().equals(""))
                newAv.setComuni(towns.getText());

            // edit
            instance.editPeriod(worker, newAv, availabilities);

            // chiudo la view
            Stage stage = (Stage) saveAndClose.getScene().getWindow();
            stage.close();
        }
    }

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
        return true;
    }

    // controllo del periodo
    private boolean checkPeriod() {
        if(startAv.getValue() != null && endAv.getValue() != null)
            return endAv.getValue().compareTo(startAv.getValue()) > 0 && endAv.getValue().compareTo(java.time.LocalDate.now()) > 0;
        if(startAv.getValue() != null && endAv.getValue() == null)
            return LocalDate.parse(availabilities.getStartDate()).compareTo(startAv.getValue()) > 0;
        if(startAv.getValue() == null && endAv.getValue() != null)
            return endAv.getValue().compareTo(LocalDate.parse(availabilities.getEndDate())) > 0;
        return true;
    }

    @FXML void setFields(){
        findWorker();
        if(availabilities.getComuni() != null) {
            towns.setPromptText(availabilities.getComuni());
            startAv.setPromptText(availabilities.getStartDate());
            endAv.setPromptText(availabilities.getEndDate());
        }
    }

    public void passSelected(Availabilities av) {
        availabilities = av;
    }

    public void findWorker() {
        for (Worker x : instance.getElencoLavoratori()){
            if (x.getId() == availabilities.getId()){
                worker = x;
                break;
            }
            else
                worker = null;
        }
    }
}
