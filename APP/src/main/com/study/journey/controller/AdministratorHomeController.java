package com.study.journey.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * Title      : AdministratorHomeController.java
 * Description: This class is used to control the page administrator_home.fxml
 * Copyright  : Copyright (c) 2023/5/25
 * @author      Jialun Zhang
 * @version     5.0
 */
public class AdministratorHomeController {
    public SplitPane splitPane;
    public MFXButton quitSystem;
    public MFXButton toStudentInformation;
    public MFXButton toCourse;
    public MFXButton toScoreManagement;
    public MFXButton toAdminInformation;


    Boolean temp = true; // 防止多次点击
    /**
     * Description: This is a function to control changing page to StudentInformation page.
     */
    @FXML
    private void ToStudentInformation() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toStudentInformation);
            temp = false;
        }

    }

    /**
     * Description: This is a function to control changing page to Course page.
     */
    @FXML
    private void ToCourse() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toCourse);
            temp = false;
        }

    }

    /**
     * Description: This is a function to control changing page to ScoreManagement page.
     */
    @FXML
    private void ToScoreManagement() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toScoreManagement);
            temp = false;
        }

    }

    /**
     * Description: This is a function to control changing page to StudentInformation page.
     */
    @FXML
    private void ToInformation() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toAdminInformation);
            temp = false;
        }

    }
    /**
     * Description: This is the override actionPerformed function to quit this page.
     * @param mouseEvent the event to be processed
     */
    public void quit(MouseEvent mouseEvent) throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(quitSystem);
            temp = false;
            //System.out.println(loginController.name);
        }
    }
}
