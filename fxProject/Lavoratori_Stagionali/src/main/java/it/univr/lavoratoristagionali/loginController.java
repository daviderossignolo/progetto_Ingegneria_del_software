package it.univr.lavoratoristagionali;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class loginController {
    
    @FXML
    private AnchorPane loginview;
    @FXML
    private ImageView loginImage;
    @FXML
    private Pane mainPane;
    @FXML
    private PasswordField password;
    @FXML
    private Button submitBtn;
    @FXML
    private TextField usrname;
    @FXML
    private TextField errorMsg;

    @FXML
    void checkCredentials(KeyEvent event) {

    }

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void checkCredentialsMouse(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        if(controllo(usrname.getText(), password.getText())){
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
    private boolean controllo(String usr, String pass) {
        String path = "D:\\Lavoratori_Stagionali\\src\\main\\java\\it\\univr\\data\\credentials.csv";

        // creo la struttura che conterrà i dati
        ArrayList<modelUtente> utenti = new ArrayList<modelUtente>();
        // path del file che contiene i dati
        Path pathToFile = Paths.get(path);

        // provo a leggere dal file
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            // leggo la linea dal file
            String line = br.readLine();

            // finchè la linea non è vuota continuo a leggere
            int j = 0;
            while (line != null) {
                String letto []= line.split(";");
                // separo gli usrname dalle password
                for(int i = 0; i < letto.length; i++) {
                    //credentials.put(letto[i], letto[++i]);
                    utenti.add(new modelUtente(letto[i], letto[++i]));

                }
                j++;
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        boolean trovato = false;
        for(modelUtente x : utenti){
            if(x.getUsername().equals(usr) && x.getPassword().equals(pass))
                trovato = true;
        }
        return trovato;
    }



}
