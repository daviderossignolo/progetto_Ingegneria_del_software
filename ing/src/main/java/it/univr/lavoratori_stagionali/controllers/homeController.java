package it.univr.lavoratori_stagionali.controllers;

import it.univr.lavoratori_stagionali.MainApplication;
import it.univr.lavoratori_stagionali.model.Modello;
import it.univr.lavoratori_stagionali.model.Worker;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class homeController implements Initializable{
    // campi della tableview
    @FXML private TableView<Worker> tableWorkers;
    @FXML private TableColumn <Worker, Integer> idCol;
    @FXML private TableColumn <Worker, String> nomeCol;
    @FXML private TableColumn <Worker, String> cognomeCol;
    @FXML private TableColumn <Worker, String> dataCol;
    @FXML private TableColumn <Worker, String> addressCol;
    @FXML private TableColumn<Worker, String> phoneCol;
    @FXML private Button f4Refresh;

    // variabili per il cambio della view
    private Stage stage;
    private Scene scene;

    // Istanza del modello
    private final Modello instance = Modello.getInstance();
    private final ArrayList<Worker> searhedWorkers = new ArrayList<>();

    // lavoratore selezionato nella tabella
    private Worker selected_worker;

    // costruttore senza parametri
    public homeController(){super();}

    // setto valori colonne tabelle
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // setto valori della tabella
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        cognomeCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        dataCol.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tableWorkers.getItems().setAll(instance.getElencoLavoratori());
    }

    // apertura pagina aggiunta lavoratori
    @FXML void toAddWorker(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("addWorker.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // apro finestra search
    @FXML void goToSearch() {
        try {
            //pulisco l'ArrayList in caso si abbia già cercato una volta
            searhedWorkers.clear();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("search.fxml"));
            Parent root = fxmlLoader.load();
            searchController controller = fxmlLoader.getController();

            Stage stage = new Stage();
            stage.setTitle("Anagrafica lavoratore");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            //se l'ArrayList di ritorno non è vuota visualizzo i nuovi dati nella tabella
            if(!controller.result.isEmpty()) {
                searhedWorkers.addAll(controller.result);
                tableWorkers.getItems().setAll(searhedWorkers);
                tableWorkers.refresh();
            }
            else{
                tableWorkers.getItems().clear();
                tableWorkers.refresh();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // torno a pagina del login
    @FXML
    void switchBackToLogin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource("login.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // apertura pagina disponibilità
    @FXML void openAvailabilities() {
        try {
            // prossima view da aprire
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("viewAv.fxml"));
            Parent root = fxmlLoader.load();

            // recupero controler prossima view
            viewAvController controller = fxmlLoader.getController();

            // trovo lavoratore selezionato
            findSelected();

            // passo lavoratore alla prossima view
            controller.passWorker(selected_worker);

            // clear selezione
            tableWorkers.getSelectionModel().clearSelection();

            // apro nuova view
            Stage stage = new Stage();
            stage.setTitle("Disponibilità");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage main = (Stage) f4Refresh.getScene().getWindow();
        main.setOnCloseRequest(event -> Platform.exit());
    }

    // apro pagina contatti emergenza
    @FXML void openContacts() {
        try {
            // prossima view da aprire
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("viewContacts.fxml"));
            Parent root = fxmlLoader.load();

            // recupero controler prossima view
            viewContactController controller = fxmlLoader.getController();

            // trovo lavoratore selezionato
            findSelected();

            // passo lavoratore alla prossima view
            controller.passWorker(selected_worker);

            // clear selezione
            tableWorkers.getSelectionModel().clearSelection();

            // apro nuova view
            Stage stage = new Stage();
            stage.setTitle("Contatti d'emergenza");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage main = (Stage) f4Refresh.getScene().getWindow();
        main.setOnCloseRequest(event -> Platform.exit());
    }

    // apro pagina esperienze
    @FXML void openExperiences() {
        try {
            // prossima view da aprire
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("viewExperience.fxml"));
            Parent root = fxmlLoader.load();

            // recupero controler prossima view
            viewExperienceController controller = fxmlLoader.getController();

            // trovo lavoratore selezionato
            findSelected();

            // passo lavoratore alla prossima view
            controller.passWorker(selected_worker);

            // clear selezione
            tableWorkers.getSelectionModel().clearSelection();

            // carico nuova view
            Stage stage = new Stage();
            stage.setTitle("Esperienze");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage main = (Stage) f4Refresh.getScene().getWindow();
        main.setOnCloseRequest(event -> Platform.exit());
    }

    // apertura pagina delle info
    @FXML void openInfo() {
        try {
            // prossima view da aprire
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("viewInfo.fxml"));
            Parent root = fxmlLoader.load();

            // chiamo il controller della prossima view
            viewInfoController controller = fxmlLoader.getController();

            // trovo lavoratore selezionato
            findSelected();

            // passo il lavoratore alla prossima view
            controller.passWorker(selected_worker);

            // clear della selezione
            tableWorkers.getSelectionModel().clearSelection();

            // apro nuova view
            Stage stage = new Stage();
            stage.setTitle("Anagrafica lavoratore");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

            Stage main = (Stage) f4Refresh.getScene().getWindow();
            main.setOnCloseRequest(event -> Platform.exit());
        }
    }

    // trova la corrispondenza tra il lavoratore selezionato e il lavoratore nel database
    private void findSelected(){
        // lavoratore selezionato
        selected_worker = tableWorkers.getSelectionModel().getSelectedItem();

        if(selected_worker == null){
            selected_worker = new Worker(); // imposto lavoratore vuoto
        }
        else{
            // trovo corrispondenza
            for(Worker w : instance.getElencoLavoratori()){
                if(w.getId() == selected_worker.getId()){
                    selected_worker = w;
                }
            }
        }
    }

    // modifica del lavoratore corrente
    @FXML void modifyCurrent() {
        try {
            // View da aprire
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("modify.fxml"));
            Parent root = fxmlLoader.load();

            // carico il controller della prossima view
            modifyController controller = fxmlLoader.getController();

            // metodo per trovare la corrispondenza con il lavoratore selezionato
            findSelected();

            // passo il lavoratore alla prossima view
            controller.passWorker(selected_worker);

            // clear dell'elemento selezionato
            tableWorkers.getSelectionModel().clearSelection();

            // apro la nova view
            Stage stage = new Stage();
            stage.setTitle("Modifica dati");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage main = (Stage) f4Refresh.getScene().getWindow();
        main.setOnCloseRequest(event -> Platform.exit());
    }

    // aggiorna i dati della tabella principale premendo il bottone
    @FXML void updateDataClick() {
        tableWorkers.getItems().setAll(instance.getElencoLavoratori());

        tableWorkers.refresh();
    }

    // aggiorna i dati della tabella principale premendo F4
    @FXML void updateDataF4(KeyEvent event){
        if(event.getCode().equals(KeyCode.F4))
            tableWorkers.getItems().setAll(instance.getElencoLavoratori());

        tableWorkers.refresh();
    }

    //ritorna la visualizzazione di tutti i lavoratori
    @FXML void clearData() {
        tableWorkers.getItems().setAll(instance.getElencoLavoratori());
        tableWorkers.refresh();
    }

    // elimina il lavoratore selezionato
    @FXML void deleteCurr() {
        selected_worker = tableWorkers.getSelectionModel().getSelectedItem();
        instance.cancelLavoratore(selected_worker);
        tableWorkers.getItems().setAll(instance.getElencoLavoratori());
        tableWorkers.refresh();
    }

}