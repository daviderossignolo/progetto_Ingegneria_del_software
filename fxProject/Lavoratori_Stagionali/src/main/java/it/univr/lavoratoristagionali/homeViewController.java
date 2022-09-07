package it.univr.lavoratoristagionali;

import com.opencsv.CSVReader;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

public class homeViewController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void toAddWorker(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addWorkerView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goToSearch(MouseEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("searchView.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ricerca");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<modelWorker> readFromFile(){
        ArrayList<modelWorker> lavoratori = new ArrayList<>();
        modelWorker lavoratore = new modelWorker();
        int i = 0;
        try {

            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader("D:\\Lavoratori_Stagionali\\src\\main\\java\\it\\univr\\data\\workers.csv");

            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    if (i == 0)
                        lavoratore.setNome(cell);
                    if(i == 1)
                        lavoratore.setCognome(cell);
                    if(i == 2)
                        lavoratore.setDataDiNascita(cell);
                    if(i == 3)
                        lavoratore.setIndirizzo(cell);
                    if(i == 5)
                        lavoratore.setTelefono(cell);
                    i++;
                }
                lavoratori.add(lavoratore);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return lavoratori;
    }

    @FXML
    void switchBackToLogin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}

