module it.univr.lavoratori_stagionali {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.opencsv;

    opens it.univr.lavoratori_stagionali to javafx.fxml;
    exports it.univr.lavoratori_stagionali;
    exports it.univr.lavoratori_stagionali.model;
    opens it.univr.lavoratori_stagionali.model to javafx.fxml;
    exports it.univr.lavoratori_stagionali.controllers;
    opens it.univr.lavoratori_stagionali.controllers to javafx.fxml;

}