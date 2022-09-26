package it.univr.lavoratori_stagionali.controllers;

import it.univr.lavoratori_stagionali.model.Experience;
import it.univr.lavoratori_stagionali.model.Modello;
import it.univr.lavoratori_stagionali.model.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class modifyExperienceController {
    @FXML private TextField company;
    @FXML private DatePicker endDate;
    @FXML private TextField place;
    @FXML private Button saveAndClose;
    @FXML private DatePicker startDate;
    @FXML private TextArea tasks;
    @FXML private TextField wage;
    @FXML private Label error2;
    @FXML private Label error3;
    @FXML private Label error4;
    @FXML private Label error5;
    @FXML private Label error6;


    private final Modello instance = Modello.getInstance();
    private Experience experience;
    private Worker worker = new Worker();

    @FXML
    void modify() {
        // trovo lavoratore selezionato
        findWorker();

        // creo la nuova esperienza
        Experience newExp = new Experience();
        newExp.setId(experience.getId());
        newExp.setCompany(experience.getCompany());
        newExp.setStartDate(experience.getStartDate());
        newExp.setEndDate(experience.getEndDate());
        newExp.setTask(experience.getTask());
        newExp.setWage(experience.getWage());
        newExp.setPlace(experience.getPlace());

        if(!checkFields()) {
            // setto i dati
            if (!company.getText().equals(""))
                newExp.setCompany(company.getText());
            if (!startDate.getEditor().getText().equals(""))
                newExp.setStartDate(startDate.getValue().toString());
            if (!endDate.getEditor().getText().equals(""))
                newExp.setEndDate(endDate.getValue().toString());
            if (!tasks.getText().equals(""))
                newExp.setTask(tasks.getText());
            if (!wage.getText().equals(""))
                newExp.setWage(wage.getText());
            if (!place.getText().equals(""))
                newExp.setPlace(place.getText());

            // edit
            instance.editEsperienza(worker, newExp, experience);

            // chiudo la view
            Stage stage = (Stage) saveAndClose.getScene().getWindow();
            stage.close();
        }
    }

    @FXML void setFields(){
        findWorker();
        if(experience.getTask() != null) {
            company.setPromptText(experience.getCompany());
            tasks.setPromptText(experience.getTask());
            wage.setPromptText(experience.getWage());
            place.setPromptText(experience.getPlace());
            startDate.setPromptText(LocalDate.parse(experience.getStartDate()).toString());
            endDate.setPromptText(LocalDate.parse(experience.getEndDate()).toString());
        }
    }

    public boolean checkFields(){
        StringBuilder errors = new StringBuilder();

        if (!checkPeriod()) {
            errors.append("- Il periodo NON deve essere più vecchio di 5 anni e NON può essere futuro.\n");
            error2.setVisible(true);
            error3.setVisible(true);
        }
        else {
            error2.setVisible(false);
            error3.setVisible(false);
        }

        if (!place.getText().trim().isEmpty() && !checkText(place.getText())) {
            errors.append("- Formato non corretto del luogo.\n");
            error4.setVisible(true);
        }
        else
            error4.setVisible(false);

        if (!checkWage()) {
            errors.append("- Inserire uno stipendio valido, solo numeri.\n");
            error5.setVisible(true);
        }
        else
            error5.setVisible(false);

        if (!checkTasks()) {
            errors.append("- Formato masione non valido, formato valido: abc;abc;abc.\n");
            error6.setVisible(true);
        }
        else
            error6.setVisible(false);

        // Display Errore
        if (errors.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione");
            alert.setHeaderText("I seguenti campi sono vuoti");
            alert.setContentText(errors.toString());

            alert.showAndWait();
            return true;
        }

        // No errors
        return false;
    }

    //controllo che non ci siano numeri e il formato sia "abc;abc;abc...."
    public Boolean checkTasks(){
        if (!tasks.getText().trim().isEmpty()) {
            String regex = "^[a-zA-Z]+;a-zA-Z]]*$";
            Pattern mailPat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = mailPat.matcher(tasks.getText());

            return matcher.find();
        }
        return true;
    }

    //controllo lo stipendio
    public Boolean checkWage(){
        if(!wage.getText().trim().isEmpty()) {
            String regex = "[0-9]*$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(wage.getText());
            return matcher.find();
        }
        return true;
    }

    //controllo che il testo non abbia numeri
    public Boolean checkText(String text) {
        String regex = "^[a-zA-Z ]*$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    // controllo periodo
    private boolean checkPeriod() {
        if(startDate.getValue() != null && endDate.getValue() != null)
            return Period.between(startDate.getValue(), java.time.LocalDate.now()).getYears() <= 5
                    && endDate.getValue().compareTo(startDate.getValue()) > 0 && endDate.getValue().compareTo(java.time.LocalDate.now()) < 0;
        if(startDate.getValue() == null && endDate.getValue() != null)
            return endDate.getValue().toString().compareTo(experience.getStartDate()) > 0 && endDate.getValue().compareTo(java.time.LocalDate.now()) < 0;
        if(startDate.getValue() != null && endDate.getValue() == null)
            return experience.getEndDate().compareTo(startDate.getValue().toString()) > 0 && Period.between(startDate.getValue(), java.time.LocalDate.now()).getYears() <= 5;
        return true;
    }

    public void passSelected(Experience exp) {
        experience = exp;
    }

    public void findWorker() {
        for (Worker x : instance.getElencoLavoratori()){
            if (x.getId() == experience.getId()){
                worker = x;
                break;
            }
            else
                worker = null;
        }
    }
}
