package com.study.journey;

import io.github.palexdev.materialfx.css.themes.MFXThemeManager;
import io.github.palexdev.materialfx.css.themes.Themes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader logPage = new FXMLLoader(Main.class.getResource("log.fxml"));
        Scene logScene = new Scene(logPage.load(), 1000, 620);
        stage.setResizable(false);
        MFXThemeManager.addOn(logScene, Themes.DEFAULT, Themes.LEGACY);
        logScene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("log.css")).toExternalForm());
        stage.setTitle("StudyJourney");
        stage.setScene(logScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}