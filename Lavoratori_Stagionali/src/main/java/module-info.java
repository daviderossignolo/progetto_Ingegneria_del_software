module it.univr.lavoratoristagionali {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens it.univr.lavoratoristagionali to javafx.fxml;
    exports it.univr.lavoratoristagionali;
}