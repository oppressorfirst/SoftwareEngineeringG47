package com.study.journey.controller;

import com.study.journey.Main;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.css.themes.Themes;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.Objects;

import io.github.palexdev.materialfx.css.themes.MFXThemeManager;

/**
 * Title: PageController.java
 * Description: The PageController class handles the navigation between different pages in the application. It provides methods to change the current page based on the button clicked and user preferences.
 * Copyright  : Copyright (c) 2023/5/25
 * @author      Ruizhi Yang, Jialun Zhang
 * @version     5.0
 */
public class PageController {

    /**
     * Changes the current page to the specified page.
     * This method is called when a button is clicked to navigate to a different page.
     * It retrieves the ID of the button and determines the corresponding page to navigate to.
     * It loads the FXML file, sets up the scene with the corresponding CSS file,
     * creates a new stage, and shows the new page.
     *
     * @param Btu the button that triggers the page change.
     * @throws IOException if an I/O error occurs while loading the FXML file or setting up the scene.
     */

    public Stage studentHomePage;
    public void changePage(MFXButton Btu) throws IOException{
        Stage PrimaryStage = (Stage)Btu.getScene().getWindow();
        String Path = null;
        String title;
        String cssPath = null;

       // System.out.println(Btu.getId());

        if(Btu.getId().equals("toHome")){
            Path = "student_home.fxml";
            cssPath = "student_home.css";
            title = "Home";
        } else if (Btu.getId().equals("toLearning")) {
            Path = "student_learningmodule.fxml";
            cssPath = "student_learningmodule.css";
            title = "Learning Module";
        } else if (Btu.getId().equals("backHome")) {
            Path = "student_home.fxml";
            cssPath = "student_home.css";
            title = "Home";
        } else if (Btu.getId().equals("toGrades")) {
            Path = "student_grades.fxml";
            cssPath = "student_grades.css";
            title = "My Grades";
        } else if (Btu.getId().equals("toAdministratorHome")) {
            Path = "administrator_home.fxml";
            cssPath = "administrator_home.css";
            title = "Administrator Home";
        }
        else if  (Btu.getId().equals("toStudentInformation")){
            Path = "administrator_studentinformation.fxml";
            cssPath = "administrator_studentinformation.css";
            title = "Student Information";
        } else if (Btu.getId().equals("quit")) {
            Path = "log.fxml";
            cssPath = "log.css";
            title = "LOGIN";
        } else if (Btu.getId().equals("toCourseSelection")) {
            Path = "student_courseselection.fxml";
            cssPath = "student_courseselection.css";
            title = "Course Selection";
        } else if (Btu.getId().equals("toClassSchedule")) {
            Path = "student_schedule.fxml";
            cssPath = "student_schedule.css";
            title = "Schedule";
        }else if (Btu.getId().equals("toInformation")) {
            Path = "student_information.fxml";
            cssPath = "student_information.css";
            title = "Information";
        }else if (Btu.getId().equals("toAchievement")) {
            Path = "student_achievements.fxml";
            cssPath = "student_achievements.css";
            title = "Achievement";
        }else if (Btu.getId().equals("toCourse")) {
            Path = "admin_coursemanagement.fxml";
            cssPath = "admin_coursemanagement.css";
            title = "Course Management";
        }else if (Btu.getId().equals("toScoreManagement")) {
            Path = "admin_scoremanagement.fxml";
            cssPath = "admin_scoremanagement.css";
            title = "Score Management";
        }else if (Btu.getId().equals("toAdminInformation")) {
            Path = "admin_myinformation.fxml";
            cssPath = "admin_myinformation.css";
            title = "Information";
        }else {
            title = null;
        }

        assert Path != null;
        if(Path.equals("student_home.fxml")){
            Timeline timeline = new Timeline();
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), event -> {
                studentHomePage.show();
                PrimaryStage.hide();
            });
            timeline.getKeyFrames().add(keyFrame);
            timeline.play(); // 播放动画
        }else {
            FXMLLoader root = new FXMLLoader(Main.class.getResource(Path));
            Scene scene = new Scene(root.load(), 1000, 620);
            if (Path.equals("log.fxml"))
                scene.getProperties().put("FXMLLOADER", root);
            scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource(cssPath)).toExternalForm());
            Timeline timeline = new Timeline();
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), event -> {
                Stage stage = new Stage();
                stage.setResizable(false);
                MFXThemeManager.addOn(scene, Themes.DEFAULT, Themes.LEGACY);
                stage.setTitle(title);
                stage.setScene(scene);
                stage.show();
                PrimaryStage.close();
            });
            timeline.getKeyFrames().add(keyFrame);
            timeline.play(); // 播放动画
        }
    }

    /**
     * This method is particularly used in LoginController.java to make option to access to Administrator home or Student home
     * @param Btu the button that triggers the page change.
     * @param GoNum a specific int to call whether student page or administrator page.
     * @param userid user ID which is only used for pass the parameter to the next page
     * &#064;Overload  #changePage(MFXButton)
     */
    public void changePage(MFXButton Btu, int GoNum, String userid) throws IOException{
        Stage PrimaryStage = (Stage)Btu.getScene().getWindow();
        String Path = null;
        String title;
        String cssPath = null;

        System.out.println(Btu.getId());

        if(Btu.getId().equals("toHome")&&GoNum==1){
            Path = "student_home.fxml";
            cssPath = "student_home.css";
            title = "Home";
        } else if(Btu.getId().equals("toHome")&&GoNum==2){
            Path = "administrator_home.fxml";
            cssPath = "administrator_home.css";
            title = "Home";
        }else if (Btu.getId().equals("toLearning")) {
            Path = "student_learningmodule.fxml";
            cssPath = "student_learningmodule.css";
            title = "LearningModule";
        } else if (Btu.getId().equals("backHome")) {
            Path = "student_home.fxml";
            cssPath = "student_home.css";
            title = "Home";
        } else if (Btu.getId().equals("toGrades")) {
            Path = "student_grades.fxml";
            cssPath = "student_grades.css";
            title = "MyGrades";
        } else if (Btu.getId().equals("toAdministratorHome")) {
            Path = "administrator_home.fxml";
            cssPath = "administrator_home.css";
            title = "AdministratorHome";
        }
        else if  (Btu.getId().equals("toStudentInformation")){
            Path = "administrator_studentinformation.fxml";
            cssPath = "administrator_studentinformation.fxml";
            title = "StudentInformation";
        }
        else {
            title = null;
        }


        assert Path != null;
        FXMLLoader root = new FXMLLoader(Main.class.getResource(Path));

        Scene scene = new Scene(root.load(),1000, 620);
        //System.out.println(getController());
        if(Path.equals("student_home.fxml") && GoNum==1){
           // System.out.println((char[]) root.getController());
            StudentHomeController studentHomeController  = root.getController();

            FXMLLoader logLoader = (FXMLLoader) Btu.getScene().getProperties().get("FXMLLOADER");
            studentHomeController.loginController = logLoader.getController();

            studentHomeController.setID(userid);
            studentHomeController.initialize();
            System.out.println(studentHomeController.ID);
            //System.out.println(studentHomeController.name);
            //System.out.println(studentHomeController.loginController);
        }

       // System.out.println(Path);



        scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource(cssPath)).toExternalForm());
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), event -> {
            Stage stage = new Stage();
            stage.setResizable(false);
            MFXThemeManager.addOn(scene, Themes.DEFAULT, Themes.LEGACY);

            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
            studentHomePage = stage;
            PrimaryStage.close();
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play(); // 播放动画
    }

}
