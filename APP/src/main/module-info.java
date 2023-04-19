module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires MaterialFX;

    opens com.study.journey to javafx.fxml;
    exports com.study.journey;
    exports com.study.journey.controller;
    opens com.study.journey.controller to javafx.fxml;
    exports com.study.journey.model;
}