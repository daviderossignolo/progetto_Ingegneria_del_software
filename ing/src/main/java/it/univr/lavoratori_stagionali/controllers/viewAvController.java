package it.univr.lavoratori_stagionali.controllers;

import it.univr.lavoratori_stagionali.MainApplication;
import it.univr.lavoratori_stagionali.model.Availabilities;
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

public class viewAvController implements Initializable {
    // campi della view
    @FXML private Button deleteBtn;
    @FXML private TableView<Availabilities> avTable;
    @FXML private TableColumn<Availabilities, String> end;
    @FXML private TableColumn<Availabilities, String> place;
    @FXML private TableColumn<Availabilities, String> start;

    // Istanza del modello
    private final Modello instance = Modello.getInstance();

    // Disponibilità scelta
    Availabilities av;

    // elimino una disponibilità TO DO
    @FXML void delete() {
        av = avTable.getSelectionModel().getSelectedItem();
        if(av == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione");
            alert.setHeaderText("Selezionare una voce");
            alert.showAndWait();
        }
        else{
            instance.deleteAvailabilities(av);
            // chiudo la view
            Stage stage = (Stage)deleteBtn.getScene().getWindow();
            stage.close();
        }
    }

    // modifico disponibilità TO DO
    @FXML void modify(MouseEvent event) throws IOException {
        av = avTable.getSelectionModel().getSelectedItem();
        if(av == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione");
            alert.setHeaderText("Selezionare una voce");
            alert.showAndWait();
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("modifyAv.fxml"));
            Parent root = fxmlLoader.load();
            modifyAvController controller = fxmlLoader.getController();
            controller.passSelected(av);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    //recupero worker passato da view precedente
    Worker worker = new Worker();
    public void passWorker(Worker selected_worker) {
        if(selected_worker == null)
            this.worker = new Worker();
        else{
            this.worker = selected_worker;
        }
        avTable.getItems().setAll(worker.getPeriods());
    }

    // riempio tabella
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        start.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        end.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        place.setCellValueFactory(new PropertyValueFactory<>("comuni"));
    }
}