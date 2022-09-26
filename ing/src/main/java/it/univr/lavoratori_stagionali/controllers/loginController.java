package it.univr.lavoratori_stagionali.controllers;


import it.univr.lavoratori_stagionali.MainApplication;
import it.univr.lavoratori_stagionali.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class loginController {
    // campi fxml
    @FXML private PasswordField password;
    @FXML private TextField usrname;

    //log in on enter
    @FXML void checkCredentials(KeyEvent event) throws IOException {
        if(event.getCode().equals(KeyCode.ENTER)) {
            if (controllo(usrname.getText(), password.getText())) {
                Parent root = FXMLLoader.load(MainApplication.class.getResource("home.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                usrname.clear();
                password.clear();
                Alert a1 = new Alert(Alert.AlertType.NONE, "Le credenziali inserite sono errate o non esistono", ButtonType.OK);

                // show the dialog
                a1.showAndWait();
            }
        }
    }

    // variabili per le view
    private Stage stage;
    private Scene scene;

    // log in on click
    @FXML void checkCredentialsMouse(MouseEvent event) throws IOException {
        if(controllo(usrname.getText(), password.getText())){
            Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("home.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            usrname.clear();
            password.clear();
            Alert a1 = new Alert(Alert.AlertType.NONE,
                    "Errore Credenziali",ButtonType.OK);

            // show the dialog
            a1.show();

        }

    }

    // controllo correttezza credenziali
    private boolean controllo(String usr, String pass) {
        String path = "src/main/java/it/univr/lavoratori_stagionali/data/credentials.csv";

        // creo la struttura che conterrà i dati
        ArrayList<User> utenti = new ArrayList<>();
        // path del file che contiene i dati
        Path pathToFile = Paths.get(path);

        // provo a leggere dal file
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            // leggo la linea dal file
            String line = br.readLine();

            // finchè la linea non è vuota continuo a leggere
            while (line != null) {
                String[] letto = line.split(";");
                // separo gli usrname dalle password
                for(int i = 0; i < letto.length; i++) {
                    utenti.add(new User(letto[i], letto[++i]));
                }
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        boolean trovato = false;
        for(User x : utenti){
            if (x.getUsername().equals(usr) && x.getPassword().equals(pass)) {
                trovato = true;
                break;
            }
        }
        return trovato;
    }

}