package it.univr.lavoratoristagionali;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AddWorkerView implements Initializable {

    @FXML
    private Spinner<Integer> counterAge;
    int currValue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 70);
        valueFactory.setValue(1);
        counterAge.setValueFactory(valueFactory);
    }
}
