module it.univr.lavoratoristagionali {
    requires javafx.controls;
    requires javafx.fxml;


    requires opencsv;

    opens it.univr.lavoratoristagionali to javafx.fxml;
    exports it.univr.lavoratoristagionali;
}