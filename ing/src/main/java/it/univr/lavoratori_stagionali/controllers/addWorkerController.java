package it.univr.lavoratori_stagionali.controllers;

import it.univr.lavoratori_stagionali.MainApplication;
import it.univr.lavoratori_stagionali.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.Period;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class addWorkerController implements Initializable {
    // personal information
    @FXML private TextField name;
    @FXML private TextField surname;
    @FXML private TextField address;
    @FXML private TextField birthplace;
    @FXML private DatePicker birthday;
    @FXML private TextField email;
    @FXML private TextField languages;
    @FXML private TextField nationality;
    @FXML private TextField phone;

    // licenses
    @FXML private CheckBox licenseA;
    @FXML private CheckBox licenseA2;
    @FXML private CheckBox licenseA1;
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
    @FXML private RadioButton car;
    @FXML private RadioButton noCar;

    // errori
    @FXML private Label error1;
    @FXML private Label error2;
    @FXML private Label error3;
    @FXML private Label error4;
    @FXML private Label error5;
    @FXML private Label error6;
    @FXML private Label error7;
    @FXML private Label error8;
    @FXML private Label error9;
    @FXML private Label error11;
    @FXML private CheckBox boxAv;
    @FXML private CheckBox boxEm;

    // save Button
    @FXML private Button saveBtn;


    // path utili
    String id_file = "src/main/java/it/univr/lavoratori_stagionali/data/id.txt";

    // Istanza del programma
    private final Modello instance = Modello.getInstance();
    private ArrayList<Worker> listaW = new ArrayList<>();

    // variabili per i cambi di view
    private Stage stage;
    private Scene scene;

    // ID
    private int id_index;

    //Flag per abilitare salva
    private Boolean em = false;
    private Boolean av = false;

    // lavoratore corrente
    private Worker currentWorker;

    // Torno alla pagina del login
    @FXML void switchBackToLogin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("login.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Inserisco un lavoratore
    @FXML void insertWorker() {

            // controllo dei campi
        if (!isEmpty()) {
            // assegno i valori al lavoratore
            currentWorker.setId(id_index);
            currentWorker.setName(name.getText());
            currentWorker.setSurname(surname.getText());
            currentWorker.setBirthday(birthday.getValue().toString());
            currentWorker.setBirthplace(birthplace.getText());
            currentWorker.setAddress(address.getText());
            currentWorker.setPhone(phone.getText());
            currentWorker.setNationality(nationality.getText());
            currentWorker.setEmail(email.getText());
            currentWorker.setLanguages(languages.getText());
            currentWorker.setCar(car.isSelected());
            currentWorker.setLicences(writeLicenses());

            // aggiungo il lavoratore alla lista dei lavoratori
            instance.addLavoratore(currentWorker);

            // incremento l'id
            id_index++;

            // pulisco tutti i campi del form
            clearAll();

            // inizializzo a vuoto il lavoratore
            currentWorker = new Worker();
            currentWorker.setExperiences(new ArrayList<>());
            currentWorker.setContacts(new ArrayList<>());
            currentWorker.setPeriods(new ArrayList<>());

            // scrivo l'id a cui sono arrivato nel file
            try {
                FileWriter fr = new FileWriter(id_file);
                fr.write(String.valueOf(id_index));
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            av = false;
            boxAv.setSelected(false);
            em = false;
            boxEm.setSelected(false);
        }
    }
    //se sono stati compilati disponibilità e contatti di emergenze abilito salva
    @FXML void addedEmAV(){
        saveBtn.setDisable(!av || !em);
    }


    // controllo correttezza dei campi
    public boolean isEmpty(){
        StringBuilder errors = new StringBuilder();

        // controlli e display errori
        if (name.getText().trim().isEmpty() || !checkText(name.getText())) {
            errors.append("- Inserire il nome.\n");
            error1.setVisible(true);
        }
        else
            error1.setVisible(false);

        if (surname.getText().trim().isEmpty() || !checkText(surname.getText())) {
            errors.append("- Inserire il congnome.\n");
            error2.setVisible(true);
        }
        else
            error2.setVisible(false);

        if (birthplace.getText().trim().isEmpty()) {
            errors.append("- Inserire la luogo di nascita.\n");
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

        if (address.getText().trim().isEmpty()) {
            errors.append("- Inserire l'indirizzo di residenza.\n");
            error5.setVisible(true);
        }
        else
            error5.setVisible(false);

        if(!checkPhone()){
            errors.append("- Il numero inserito gia presente o errato.\n");
            error6.setVisible(true);
        }
        else
            error6.setVisible(false);

        if (nationality.getText().trim().isEmpty() || !checkText(nationality.getText())) {
            errors.append("- Inserire la nazionalità.\n");
            error7.setVisible(true);
        }
        else
            error7.setVisible(false);

        if (!checkMail()) {
            errors.append("- Formato della email errato o già presente nel sistema.\n");
            error8.setVisible(true);
        }
        else
            error8.setVisible(false);

        if (!checkLanguages()) {
            errors.append("- Inserire le lingue parlate, formato corretto = abc;abc;abc.\n");
            error9.setVisible(true);
        }
        else
            error9.setVisible(false);

        if (carButNoLicence()) {
            errors.append("- Automunito ma senza patente?.\n");
            error11.setVisible(true);
            //error12.setVisible(true);
        }
        else {
            error11.setVisible(false);
            //error12.setVisible(false);
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

    //controlla che le lingue non abbiano numeri e siano nel formato "abc;abc;abc..."
    public Boolean checkLanguages(){
        if (!languages.getText().trim().isEmpty()) {
            String regex = "^[a-zA-Z]+;[a-zA-Z]+]*$";
            Pattern mailPat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = mailPat.matcher(languages.getText());
            //System.out.println(matcher.find());
            return matcher.find();
        }
        return false;
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
            for (Worker worker : listaW) {
                if (phone.getText().equals(worker.getPhone()))
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
            for (Worker worker : listaW) {
                if (email.getText().equals(worker.getEmail()))
                    return false;
            }
            return matcher.find();
        }
        return false;
    }

    // controllo maggiore età
    public Boolean olderThan18(){
        return birthday.getValue() != null && Period.between(birthday.getValue(), java.time.LocalDate.now()).getYears() >= 18;
    }

    // metodo per aprire la view di inserimento contatti di emergenza
    @FXML void insertEmergencyInfo() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("addContact.fxml"));
            Parent root = fxmlLoader.load();
            addContactController controller = fxmlLoader.getController();

            // passo alla prossima view l'id e il lavoratore corrente
            controller.saveWorker(currentWorker);
            controller.setId(id_index);
            // apro nuova vie
            Stage stage = new Stage();
            stage.setTitle("Contatti d'emergenza");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            if(controller.added) {
                em = true;
                boxEm.setSelected(true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo per scrivere le patenti
    private String writeLicenses(){
        String res = "";
        if(licenseAM.isSelected())
            res += "AM ";
        if(licenseA1.isSelected())
            res += "A1 ";
        if(licenseA2.isSelected())
            res += "A2 ";
        if(licenseA.isSelected())
            res += "A3 ";
        if(licenseB1.isSelected())
            res += "B1 ";
        if(licenseB.isSelected())
            res += "B ";
        if(licenseC1.isSelected())
            res += "C1 ";
        if(licenseC.isSelected())
            res += "C ";
        if(licenseD1.isSelected())
            res += "D1 ";
        if(licenseD.isSelected())
            res += "D ";
        if(licenseCE.isSelected())
            res += "CE ";
        if(licenseDE.isSelected())
            res += "DE ";
        if(licenseBE.isSelected())
            res += "BE ";
        return res;
    }

    // Metodo per tornare alla HomePage
    @FXML void switchBacktoHome(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("home.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Clear del form
    private void clearAll(){
        name.clear();
        surname.clear();
        birthday.getEditor().clear();
        birthplace.clear();
        address.clear();
        phone.clear();
        nationality.clear();
        email.clear();
        languages.clear();
        licenseA.setSelected(false);
        licenseA1.setSelected(false);
        licenseA2.setSelected(false);
        licenseAM.setSelected(false);
        licenseB.setSelected(false);
        licenseB1.setSelected(false);
        licenseBE.setSelected(false);
        licenseC.setSelected(false);
        licenseC1.setSelected(false);
        licenseCE.setSelected(false);
        licenseD.setSelected(false);
        licenseD1.setSelected(false);
        licenseDE.setSelected(false);
        car.setSelected(false);
        noCar.setSelected(false);
    }

    // Metodo per aprire la view delle esperienze
    @FXML void openEsperienze() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("addExperience.fxml"));
            Parent root = fxmlLoader.load();
            addExperienceController controller = fxmlLoader.getController();

            // passo alla view l'id e il lavoratore corrente
            controller.setId(id_index);
            controller.saveWorker(currentWorker);

            // apro nuova view
            Stage stage = new Stage();
            stage.setTitle("Inserimento Esperienze lavorative");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // on loading set ID
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // leggo l'ID a cui ero arrivato
        try {
            FileReader fr = new FileReader(id_file);
            BufferedReader inStream = new BufferedReader(fr);
            id_index = Integer.parseInt(inStream.readLine());
            System.out.println(id_index);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // inizializzo un lavoratore vuoto
        currentWorker = new Worker();
        currentWorker.setExperiences(new ArrayList<>());
        currentWorker.setContacts(new ArrayList<>());
        currentWorker.setPeriods(new ArrayList<>());

    }

    // apro finestra per settare i periodi di disponibilità
    @FXML void openAvailabilities() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("addAv.fxml"));
            Parent root = fxmlLoader.load();
            addAvController controller = fxmlLoader.getController();

            // passo alla view l'id e il lavoratore corrente
            controller.setId(id_index);
            controller.saveWorker(currentWorker);

            // apro nuova view
            Stage stage = new Stage();
            stage.setTitle("Inserimento disponibilità");
            stage.setScene(new Scene(root));
            stage.showAndWait();
            if(controller.added) {
                av = true;
                boxAv.setSelected(true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
