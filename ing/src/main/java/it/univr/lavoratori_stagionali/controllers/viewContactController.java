package it.univr.lavoratori_stagionali.controllers;

import it.univr.lavoratori_stagionali.MainApplication;
import it.univr.lavoratori_stagionali.model.EmergencyInfo;
import it.univr.lavoratori_stagionali.model.Modello;
import it.univr.lavoratori_stagionali.model.Worker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class viewContactController implements Initializable {
    // campi fxml
    @FXML private TableView<EmergencyInfo> contactTable;
    @FXML private TableColumn<EmergencyInfo, String> email;
    @FXML private TableColumn<EmergencyInfo, String> name;
    @FXML private TableColumn<EmergencyInfo, String> phone;
    @FXML private TableColumn<EmergencyInfo, String> surname;
    @FXML private Button deleteBtn;

    // Istanza del modello
    private final Modello instance = Modello.getInstance();

    // Contatto selezionato
    EmergencyInfo contact;

    // elimino contatto
    @FXML void delete() {
        contact = contactTable.getSelectionModel().getSelectedItem();
        if(contact == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione");
            alert.setHeaderText("Selezionare una voce");
            alert.showAndWait();
        }
        else{
            instance.deleteContact(contact);
            // chiudo la view
            Stage stage = (Stage)deleteBtn.getScene().getWindow();
            stage.close();
        }
    }

    // TO DO
    // modifica di un contatto
    @FXML void modify(MouseEvent event) throws IOException {
        contact = contactTable.getSelectionModel().getSelectedItem();
        if(contact == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione");
            alert.setHeaderText("Selezionare una voce");
            alert.showAndWait();
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("modifyContact.fxml"));
            Parent root = fxmlLoader.load();
            modifyContactController controller = fxmlLoader.getController();
            controller.passSelected(contact);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    // popolo la tabella
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    // recuupero lavoratore da view precedente
    Worker worker = new Worker();
    public void passWorker(Worker selected_worker) {
        if(selected_worker == null)
            this.worker = new Worker();
        else{
            this.worker = selected_worker;
        }
        contactTable.getItems().setAll(worker.getContacts());
    }

}