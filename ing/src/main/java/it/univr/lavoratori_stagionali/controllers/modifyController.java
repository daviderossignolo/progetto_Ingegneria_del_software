package it.univr.lavoratori_stagionali.controllers;

import it.univr.lavoratori_stagionali.MainApplication;
import it.univr.lavoratori_stagionali.model.Modello;
import it.univr.lavoratori_stagionali.model.Worker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class modifyController {
    @FXML private TextField address;
    @FXML private DatePicker birthday;
    @FXML private TextField birthplace;
    @FXML private RadioButton car;
    @FXML private TextField email;
    @FXML private TextField languages;
    @FXML private CheckBox licenseA;
    @FXML private CheckBox licenseA1;
    @FXML private CheckBox licenseA2;
    @FXML private CheckBox licenseAM;
    @FXML private CheckBox licenseB;
    @FXML private CheckBox licenseB1;
    @FXML private CheckBox licenseBE;
    @FXML private CheckBox licenseC;
    @FXML private CheckBox licenseC1;
    @FXML private CheckBox licenseCE;
    @FXML private CheckBox licenseD;
    @FXML private CheckBox licenseD1;
    @FXML private CheckBox licenseDE;
    @FXML private TextField name;
    @FXML private TextField nationality;
    @FXML private RadioButton noCar;
    @FXML private TextField phone;
    @FXML private TextField surname;
    @FXML private Button saveAndClose;

    @FXML private Label error1;
    @FXML private Label error2;
    @FXML private Label error3;
    @FXML private Label error4;
    @FXML private Label error6;
    @FXML private Label error7;
    @FXML private Label error8;
    @FXML private Label error9;
    @FXML private Label error10;


    // Istanza del modello
    private final Modello instance = Modello.getInstance();
    private ArrayList<Worker> listaW = new ArrayList<>();

    // lavoratore selezionato nella tabella
    private Worker worker;

    // inserisci/modifica/elimina TO DO
    @FXML void insertEmergencyInfo(){
        try {
            // prossima view da aprire
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("viewContacts.fxml"));
            Parent root = fxmlLoader.load();

            // recupero controler prossima view
            viewContactController controller = fxmlLoader.getController();

            // passo lavoratore alla prossima view
            controller.passWorker(old);

            // apro nuova view
            Stage stage = new Stage();
            stage.setTitle("Disponibilità");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML void setFields(){
        if(old.getName() != null) {
            name.setPromptText(old.getName());
            surname.setPromptText(old.getSurname());
            address.setPromptText(old.getAddress());
            birthplace.setPromptText(old.getBirthplace());
            birthday.setPromptText(LocalDate.parse(old.getBirthday()).toString());
            phone.setPromptText(old.getPhone());
            nationality.setPromptText(old.getNationality());
            email.setPromptText(old.getEmail());
            languages.setPromptText(old.getLanguages());
            if (old.getCar())
                car.setSelected(true);
            else
                car.setSelected(true);
            setOldLicenses(old.getLicences());
        }
    }

    public void setOldLicenses(String all){
        if(all.contains("AM"))
            licenseAM.setSelected(true);
        if(all.contains("A1"))
            licenseA1.setSelected(true);
        if(all.contains("A2"))
            licenseA2.setSelected(true);
        if(all.contains("A3"))
            licenseA.setSelected(true);
        if(all.contains("B1"))
            licenseB1.setSelected(true);
        if(all.contains("B"))
            licenseB.setSelected(true);
        if(all.contains("C1"))
            licenseC1.setSelected(true);
        if(all.contains("C"))
            licenseC.setSelected(true);
        if(all.contains("D1"))
            licenseD1.setSelected(true);
        if(all.contains("D"))
            licenseD.setSelected(true);
        if(all.contains("CE"))
            licenseCE.setSelected(true);
        if(all.contains("BE"))
            licenseBE.setSelected(true);
        if(all.contains("DE"))
            licenseDE.setSelected(true);
    }

    // salvataggio nuovi dati inseriti
    @FXML
    void save() {
        if(!checkNew()) {
            if (!name.getText().equals(""))
                worker.setName(name.getText());
            if (!surname.getText().equals(""))
                worker.setSurname(surname.getText());
            if (!birthday.getEditor().getText().equals(""))
                worker.setBirthday(birthday.getValue().toString());
            if (!birthplace.getText().equals(""))
                worker.setBirthplace(birthplace.getText());
            if (!address.getText().equals(""))
                worker.setAddress(address.getText());
            if (!phone.getText().equals(""))
                worker.setPhone(phone.getText());
            if (!nationality.getText().equals(""))
                worker.setNationality(nationality.getText());
            if (!email.getText().equals(""))
                worker.setEmail(email.getText());
            if (!languages.getText().equals(""))
                worker.setLanguages(languages.getText());
            if (car.isSelected())
                worker.setCar(true);
            if (noCar.isSelected())
                worker.setCar(false);

            // modifico il lavoratore
            instance.editLavoratore(worker, old);

            // chiudo la view
            Stage stage = (Stage) saveAndClose.getScene().getWindow();
            stage.close();
        }
    }



    // inserisci/modifica/elimina disponiblità TO DO
    @FXML void openAvailabilities() {
        try {
            // prossima view da aprire
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("viewAv.fxml"));
            Parent root = fxmlLoader.load();

            // recupero controler prossima view
            viewAvController controller = fxmlLoader.getController();

            // passo lavoratore alla prossima view
            controller.passWorker(worker);

            // apro nuova view
            Stage stage = new Stage();
            stage.setTitle("Disponibilità");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkNew(){
        StringBuilder errors = new StringBuilder();

        // controlli e display errori
        if (!checkText(name.getText()) && !name.getText().trim().isEmpty()) {
            errors.append("- Formato del nome errato.\n");
            error1.setVisible(true);
        }
        else
            error1.setVisible(false);

        if (!surname.getText().trim().isEmpty() && !checkText(surname.getText())) {
            errors.append("- Formato del congnome errato.\n");
            error2.setVisible(true);
        }
        else
            error2.setVisible(false);

        if (!birthplace.getText().trim().isEmpty() && !checkText(birthplace.getText())) {
            errors.append("- Luogo di nascita errato.\n");
            error3.setVisible(true);
        }
        else
            error3.setVisible(false);

        if (!olderThan18()) {
            errors.append("- Deve essere maggiore di 18 anni.\n");
            error4.setVisible(true);
        }
        else
            error4.setVisible(false);

        if(!checkPhone()){
            errors.append("- Il numero inserito gia presente (altro lavoratore) o errato.\n");
            error6.setVisible(true);
        }
        else
            error6.setVisible(false);

        if (!nationality.getText().trim().isEmpty() && !checkText(nationality.getText())) {
            errors.append("- Formato nazionalità errato.\n");
            error7.setVisible(true);
        }
        else
            error7.setVisible(false);

        if (!checkMail()) {
            errors.append("- Formato della email errato o già presente nel sistema (altro lavoratore).\n");
            error8.setVisible(true);
        }
        else
            error8.setVisible(false);

        if (!checkLanguages()) {
            errors.append("- Formato corretto = abc;abc;abc.\n");
            error9.setVisible(true);
        }
        else
            error9.setVisible(false);

        if (carButNoLicence()) {
            errors.append("- Automunito ma senza patente?.\n");
            error10.setVisible(true);
            //error12.setVisible(true);
        }
        else {
            error10.setVisible(false);
            //error12.setVisible(false);
        }


        // Display errore
        if (errors.length() > 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione");
            alert.setHeaderText("I seguenti campi sono errati");
            alert.setContentText(errors.toString());
            alert.showAndWait();
            return true;
        }

        return false;
    }

    //controlla che le lingue non abbiano numeri e siano nel formato "abc;abc;abc..."
    public Boolean checkLanguages(){
        if (!languages.getText().trim().isEmpty()) {
            String regex = "^[a-zA-Z]+;[a-zA-Z]+]*$";
            Pattern pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pat.matcher(languages.getText());
            //System.out.println(matcher.find());
            return matcher.find();
        }
        return true;
    }

    //controlla che la stringa non contegna numeri
    public Boolean checkText(String text) {
        String regex = "^[a-zA-Z ]*$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    //controlla se il numero inserito è valido e non già presente nel database, se non inserito non fa nulla
    public Boolean checkPhone() {
        if (!phone.getText().trim().isEmpty()) {
            String phoneRegex = "^(\\((00|\\+)39\\)|(00|\\+)39)?(38[890]|34[4-90]|36[680]|33[13-90]|32[89]|35[01]|37[019])(\\s?\\d{3}\\s?\\d{3,4}|\\d{6,7})$";
            Pattern mailPat = Pattern.compile(phoneRegex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = mailPat.matcher(phone.getText());

            listaW = instance.getElencoLavoratori();
            for (Worker value : listaW) {
                if (phone.getText().equalsIgnoreCase(value.getPhone()) && value.getId() != old.getId())
                    return false;
            }
            return matcher.find();
        }
        return true;
    }

    // controllo inserimento veicolo e patente
    public Boolean carButNoLicence(){
        return car.isSelected() && !licenseB.isSelected();
    }

    // controllo la mail
    public Boolean checkMail(){
        if(!email.getText().trim().isEmpty()) {
            String mailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
            Pattern mailPat = Pattern.compile(mailRegex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = mailPat.matcher(email.getText());

            listaW = instance.getElencoLavoratori();
            for (Worker value : listaW) {
                if (email.getText().equalsIgnoreCase(value.getEmail()) && value.getId() != old.getId())
                    return false;
            }
            return matcher.find();
        }
        return true;
    }

    // controllo maggiore età
    public Boolean olderThan18(){
        if(birthday.getValue() == null)
            return true;
        return Period.between(birthday.getValue(), java.time.LocalDate.now()).getYears() >= 18;
    }

    // inserisci/modifica/elimina esperienze
    @FXML void openEsperienze(){
        try {
            // prossima view da aprire
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("viewExperience.fxml"));
            Parent root = fxmlLoader.load();

            // recupero controler prossima view
            viewExperienceController controller = fxmlLoader.getController();

            // passo lavoratore alla prossima view
            System.out.println(old);
            controller.passWorker(old);

            // apro nuova view
            Stage stage = new Stage();
            stage.setTitle("Disponibilità");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // recupero worker da view precedente
    private Worker old;
    public void passWorker(Worker selected_worker) {
        worker = selected_worker;
        old = selected_worker;
    }

}