package it.univr.lavoratoristagionali;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class homeViewController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void goToAddWorker(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addWorkerView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void goToSearch(MouseEvent event) {
        System.out.println("ciao");
    }


}
