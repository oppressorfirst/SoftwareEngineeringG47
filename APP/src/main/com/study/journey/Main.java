package com.study.journey;

import com.study.journey.controller.PageController;
import io.github.palexdev.materialfx.css.themes.MFXThemeManager;
import io.github.palexdev.materialfx.css.themes.Themes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


/**
 * Title: Main.java
 * Description: The Main class serves as the entry point for the StudyJourney application. It launches the JavaFX application and sets up the initial scene.
 * Copyright: Copyright (c) 2023/5/25
 * @author Jialun Zhang
 * @version 5.0
 */
public class Main extends Application {

    public static PageController controller;
    /**
     * The start() method is called when the JavaFX application is launched.
     * It loads the FXML file, creates the scene, and displays the stage.
     *
     * @param stage the primary stage for the application.
     * @throws IOException if an I/O error occurs while loading the FXML file.
     */

    @Override
    public void start(Stage stage) throws IOException {
        controller = new PageController();
        FXMLLoader logPage = new FXMLLoader(Main.class.getResource("log.fxml"));
        Scene logScene = new Scene(logPage.load(), 1000, 620);
        logScene.getProperties().put("FXMLLOADER", logPage);
        stage.setResizable(false);
        MFXThemeManager.addOn(logScene, Themes.DEFAULT, Themes.LEGACY);
        logScene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("log.css")).toExternalForm());
        stage.setTitle("StudyJourney");
        stage.setScene(logScene);
        stage.show();
    }

    /**
     * The main() method is the entry point of the StudyJourney application.
     * It launches the JavaFX application.
     *
     * @param args command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        launch();
    }
}