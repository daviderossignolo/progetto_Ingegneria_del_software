package it.univr.lavoratori_stagionali.controllers;

import it.univr.lavoratori_stagionali.MainApplication;
import it.univr.lavoratori_stagionali.model.Experience;
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

public class viewExperienceController implements Initializable {
    // campi fxml
    @FXML private Button deleteBtn;
    @FXML private TableView<Experience> expTable;
    @FXML private TableColumn<Experience, String> end;
    @FXML private TableColumn<Experience, String> company;
    @FXML private TableColumn<Experience, String> place;
    @FXML private TableColumn<Experience, String> start;
    @FXML private TableColumn<Experience, String> task;
    @FXML private TableColumn<Experience, String> wage;

    // Istanza del modello
    private final Modello instance = Modello.getInstance();

    // Esperienza selezionata
    // recupero lavoratore selezionato
    Experience exp;
    // metodo per eliminare una esperienza TO DO
    @FXML void delete() {
        exp = expTable.getSelectionModel().getSelectedItem();
        if(exp == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione");
            alert.setHeaderText("Selezionare una voce");
            alert.showAndWait();
        }
        else{
            instance.deleteEsperienza(exp);
            // chiudo la view
            Stage stage = (Stage)deleteBtn.getScene().getWindow();
            stage.close();
        }
    }

    // metodo per modificare una esperienza TO DO
    @FXML void modify(MouseEvent event) throws IOException {
        exp = expTable.getSelectionModel().getSelectedItem();
        if(exp == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione");
            alert.setHeaderText("Selezionare una voce");
            alert.showAndWait();
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("modifyExperience.fxml"));
            Parent root = fxmlLoader.load();
            modifyExperienceController controller = fxmlLoader.getController();
            controller.passSelected(exp);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    // recupero lavoratore da view precedente
    Worker worker = new Worker();
    public void passWorker(Worker selected_worker) {
        if(selected_worker == null)
            this.worker = new Worker();
        else{
            this.worker = selected_worker;
        }
        expTable.getItems().setAll(worker.getExperiences());
    }

    // popolo tabella
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        company.setCellValueFactory(new PropertyValueFactory<>("company"));
        start.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        end.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        task.setCellValueFactory(new PropertyValueFactory<>("task"));
        wage.setCellValueFactory(new PropertyValueFactory<>("wage"));
        place.setCellValueFactory(new PropertyValueFactory<>("place"));
        worker = new Worker();
    }
}
