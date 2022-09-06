package it.univr.lavoratoristagionali;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class emergencyInfoController {
    @FXML private TextField cognome1;
    @FXML private TextField cognome2;
    @FXML private Label cognome2label;
    @FXML private TextField cognome3;
    @FXML private Label cognome3label;
    @FXML private TextField email1;
    @FXML private TextField email2;
    @FXML private Label email2label;
    @FXML private TextField email3;
    @FXML private Label email3label;
    @FXML private TextField nome1;
    @FXML private TextField nome2;
    @FXML private Label nome2label;
    @FXML private TextField nome3;
    @FXML private Label nome3label;
    @FXML private TextField telefono1;
    @FXML private TextField telefono2;
    @FXML private Label telefono2label;
    @FXML private TextField telefono3;
    @FXML private Label telefono3label;

    @FXML
    void enableContact2(MouseEvent event) {
        nome2label.setDisable(false);
        nome2.setDisable(false);
        cognome2label.setDisable(false);
        cognome2.setDisable(false);
        telefono2.setDisable(false);
        telefono2label.setDisable(false);
        email2label.setDisable(false);
        email2.setDisable(false);
    }

    @FXML
    void enableContact3(MouseEvent event) {
        nome3label.setDisable(false);
        nome3.setDisable(false);
        cognome3label.setDisable(false);
        cognome3.setDisable(false);
        telefono3.setDisable(false);
        telefono3label.setDisable(false);
        email3label.setDisable(false);
        email3.setDisable(false);
    }

    private Stage stage;
    @FXML
    void insertEmergencyInfo(MouseEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }
}
