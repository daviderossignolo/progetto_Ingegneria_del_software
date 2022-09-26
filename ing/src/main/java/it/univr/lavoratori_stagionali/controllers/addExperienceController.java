package it.univr.lavoratori_stagionali.controllers;

import it.univr.lavoratori_stagionali.model.Experience;
import it.univr.lavoratori_stagionali.model.Worker;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.Period;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class addExperienceController {
    // campi della view
    @FXML private TextField company;
    @FXML private DatePicker endDate;
    @FXML private TextField place;
    @FXML private DatePicker startDate;
    @FXML private TextArea tasks;
    @FXML private TextField wage;
    @FXML private Label error1;
    @FXML private Label error2;
    @FXML private Label error3;
    @FXML private Label error4;
    @FXML private Label error5;
    @FXML private Label error6;
    @FXML private Button saveAndClose;

    // variabili per il cambio di scena
    private Stage stage;
    private Scene scene;

    // variabile per l'id da scrivere
    private int id_index;

    // lavoratore corrente sul quale sto lavorando
    private Worker currentWorker;

    // variabile che rappresenta le esperienze di un lavoratore
    private ArrayList<Experience> experiences = new ArrayList<>();

    // inserisco una nuova esperienza
    @FXML
    void insertNew(MouseEvent event) throws IOException {
        if(!checkFields()) {
            // creo l'esperienza e setto i campi
            Experience exp = new Experience();
            exp.setCompany(company.getText());
            exp.setId(id_index);
            exp.setStartDate(startDate.getEditor().getText());
            exp.setEndDate(endDate.getEditor().getText());
            exp.setPlace(place.getText());
            exp.setTask(tasks.getText());
            exp.setWage(wage.getText());

            // aggiungo l'esperienza appena creata alla lista delle esperienze
            experiences.add(exp);

            // clear del form
            clearAll();

        }
    }

    // clear del form
    public void clearAll(){
        company.clear();
        startDate.getEditor().clear();
        endDate.getEditor().clear();
        wage.clear();
        tasks.clear();
        place.clear();
    }

    // salvo le esperienze del lavoratore
    @FXML
    void save(MouseEvent event) {
        // salvo i dati
        if(!checkFields()) {
            // creo la nuova esperienza e setto i dati
            Experience exp = new Experience();
            exp.setCompany(company.getText());
            exp.setId(id_index);
            exp.setStartDate(startDate.getValue().toString());
            exp.setEndDate(endDate.getValue().toString());
            exp.setPlace(place.getText());
            exp.setTask(tasks.getText());
            exp.setWage(wage.getText());

            // aggiungo l'esperienza alla lista
            experiences.add(exp);

            // Aggiungo la lista di esperienza al lavoratore
            currentWorker.setExperiences(experiences);

            // clear
            clearAll();

            // chiudo la view
            Stage stage = (Stage)saveAndClose.getScene().getWindow();
            stage.close();
        }
    }

    // metodo per settare l'id
    public void setId(int id) {
        id_index = id;
    }

    // metodo per recupere il lavoratore corrente
    public void saveWorker(Worker currentWorker) {
        this.currentWorker = currentWorker;
    }

    // controlli
    public boolean checkFields(){
        StringBuilder errors = new StringBuilder();

        // controlli
        if (company.getText().trim().isEmpty()) {
            errors.append("- Inserire il nome dell'azienda.\n");
            error1.setVisible(true);
        }
        else
            error1.setVisible(false);

        if (!checkPeriod()) {
            errors.append("- Il periodo NON deve essere più vecchio di 5 anni e NON può essere futuro.\n");
            error2.setVisible(true);
            error3.setVisible(true);
        }
        else {
            error2.setVisible(false);
            error3.setVisible(false);
        }

        if (place.getText().trim().isEmpty() && checkText(place.getText())) {
            errors.append("- Inserire il luogo.\n");
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
            errors.append("- Inserire almeno una masione, formato abc;abc;abc.\n");
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
            String regex = "^[[a-zA-Z]+;[a-zA-Z]+]*$";
            Pattern mailPat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = mailPat.matcher(tasks.getText());

            return matcher.find();
        }
        return false;
    }

    //controllo lo stipendio
    public Boolean checkWage(){
        if(!wage.getText().trim().isEmpty()) {
            String regex = "[0-9]*$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(wage.getText());
            return matcher.find();
        }
        return false;
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
        if(startDate.getValue() != null && endDate.getValue() != null &&
                Period.between(startDate.getValue(), java.time.LocalDate.now()).getYears() <= 5 &&
                endDate.getValue().compareTo(startDate.getValue()) > 0 && endDate.getValue().compareTo(java.time.LocalDate.now()) < 0)
            return true;
        return false;
    }
}
