package com.study.journey.controller;

import com.study.journey.Main;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.css.themes.MFXThemeManager;
import io.github.palexdev.materialfx.css.themes.Themes;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public  class PopUpPageController {



    public PopUpPageController() {
    }
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
        } else {
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
            stage.setScene(scene);
            stage.show();
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play(); // 播放动画
        return popUpPageController;
    }

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
