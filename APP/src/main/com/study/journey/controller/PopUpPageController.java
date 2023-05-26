package com.study.journey.controller;

import com.study.journey.Main;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.css.themes.MFXThemeManager;
import io.github.palexdev.materialfx.css.themes.Themes;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

/**
 * Title: PopUpPageController.java
 * Description: Controller class for pop-up pages. This class handles the creation and closing of pop-up pages.
 * Copyright  : Copyright (c) 2023/5/25
 * @author      Jialun Zhang
 * @version     5.0
 */
public  class PopUpPageController {



    public PopUpPageController() {
    }
    /**
     * Creates a pop-up page based on the button clicked.
     * This method is called to create a pop-up page when a specific button is clicked.
     * It determines the type of pop-up page based on the button's ID and sets up the corresponding FXML file, CSS file,
     * and title for the pop-up page. It loads the FXML file, sets up the scene, creates a new stage, and shows the pop-up page.
     *
     * @param button the button that triggers the creation of the pop-up page.
     * @return the PopUpPageController instance associated with the created pop-up page.
     * @throws IOException if an I/O error occurs while loading the FXML file or setting up the scene.
     */
    public PopUpPageController makePopUpPage(MFXButton button) throws IOException {
        String Path = null;
        String title;
        String cssPath = null;
        PopUpPageController popUpPageController = null;

        if(button.getId().equals("add")) {
            Path = "add.fxml";
            cssPath = "add.css";
            title = "Add Student";
            System.out.println("121111111");
        } else if(button.getId().equals("edit")) {
            Path = "edit.fxml";
            cssPath = "edit.css";
            title = "Edit Student Information";
        } else if (button.getId().equals("remove")) {
            Path = "remove.fxml";
            cssPath = "remove.css";
            title = "Remove Student";
        } else if (button.getId().equals("calc")) {
            Path = "GPA.fxml";
            cssPath = "GPA.css";
            title = "Current GPA";
        } else if (button.getId().equals("feedback")) {
            Path = "feedback.fxml";
            cssPath = "feedback.css";
            title = "Feedback";
        }else {
            title = null;
        }





        assert Path != null;
        FXMLLoader root = new FXMLLoader(Main.class.getResource(Path));



        Scene scene = new Scene(root.load(),600, 400);
        popUpPageController = root.getController();
        scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource(cssPath)).toExternalForm());
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), event -> {
            Stage stage = new Stage();
            stage.setResizable(false);
            MFXThemeManager.addOn(scene, Themes.DEFAULT, Themes.LEGACY);
            stage.setTitle(title);
            Image icon = null;
            try {
                icon = new Image(Main.class.getResource("image/icon.png").openStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // 将图标添加到Stage对象的图标列表中
            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.show();
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play(); // 播放动画
        return popUpPageController;
    }

    /**
     * Closes the current page.
     * This method is called to close the current page when a specific button is clicked.
     * It retrieves the stage associated with the button's scene and closes the stage.
     *
     * @param button the button that triggers the closing of the current page.
     */
    public void closePage(MFXButton button){
        Stage PrimaryStage = (Stage)button.getScene().getWindow();
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), event -> {
            PrimaryStage.close();
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play(); // 播放动画
    }


}
