package it.univr.lavoratori_stagionali.controllers;

import it.univr.lavoratori_stagionali.MainApplication;
import it.univr.lavoratori_stagionali.model.Modello;
import it.univr.lavoratori_stagionali.model.Worker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class viewInfoController implements Initializable {
    // campi fxml
    @FXML private TableView<Worker> infoTable;
    @FXML private TableColumn<Worker, String> address;
    @FXML private TableColumn<Worker, String> birthday;
    @FXML private TableColumn<Worker, String> birthplae;
    @FXML private TableColumn<Worker, String> car;
    @FXML private TableColumn<Worker, String> email;
    @FXML private TableColumn<Worker, String> languages;
    @FXML private TableColumn<Worker, String> licences;
    @FXML private TableColumn<Worker, String> name;
    @FXML private TableColumn<Worker, String> nationality;
    @FXML private TableColumn<Worker, String> phone;
    @FXML private TableColumn<Worker, String> surname;
    @FXML private Button deleteBtn;

    // Istanza del modello
    private final Modello instance = Modello.getInstance();

    // elimino il lavoratore selzionato
    @FXML void delete() {
        // recupero lavoratore selezionato
        worker = infoTable.getSelectionModel().getSelectedItem();

        if(worker == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione");
            alert.setHeaderText("Selezionare una voce");
            alert.showAndWait();
        }
        else{
            // elimino lavoratore
            instance.cancelLavoratore(worker);

            // clear selection
            infoTable.getSelectionModel().clearSelection();

            // chiudo la view
            Stage stage = (Stage)deleteBtn.getScene().getWindow();
            stage.close();
        }
    }

    // update dati tabella
    @FXML void updateData() {
        infoTable.refresh();
    }

    // modifica anagrafica lavoratore
    @FXML void modify() {
        try {
            // apro view modifica
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("modify.fxml"));
            Parent root = fxmlLoader.load();

            // chiamo il controller
            modifyController controller = fxmlLoader.getController();

            // lavoratore selezionato
            Worker selected_worker = infoTable.getSelectionModel().getSelectedItem();

            if(selected_worker == null){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Attenzione");
                alert.setHeaderText("Selezionare una voce");
                alert.showAndWait();
            }
            else{
                // passo il lavoratore
                controller.passWorker(selected_worker);

                // clear selezione
                infoTable.getSelectionModel().clearSelection();

                // apro view
                Stage stage = new Stage();
                stage.setTitle("Modifica Dati");
                stage.setScene(new Scene(root));
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // recupero il lavoratore dalla view precedente
    Worker worker = new Worker();
    public void passWorker(Worker selected_worker) {
        infoTable.refresh();
        this.worker = selected_worker;
        infoTable.getItems().setAll(worker);
    }

    // popolo la table
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        birthplae.setCellValueFactory(new PropertyValueFactory<>("birthplace"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        nationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        languages.setCellValueFactory(new PropertyValueFactory<>("languages"));
        licences.setCellValueFactory(new PropertyValueFactory<>("licences"));
        car.setCellValueFactory(new PropertyValueFactory<>("car"));
    }
}
