package com.study.journey.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class AdministratorHomeController {
    public SplitPane splitPane;



    public MFXButton quitSystem;
    public MFXButton toStudentInformation;
    public MFXButton toCourse;
    public MFXButton toScoreManagement;
    public MFXButton toAdminInformation;

    Boolean temp = true; // 防止多次点击
    @FXML
    private void ToStudentInformation() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toStudentInformation);
            temp = false;
        }

    }

    @FXML
    private void ToCourse() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toCourse);
            temp = false;
        }

    }
    @FXML
    private void ToScoreManagement() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toScoreManagement);
            temp = false;
        }

    }
    @FXML
    private void ToInformation() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toAdminInformation);
            temp = false;
        }

    }

    public void quit(MouseEvent mouseEvent) throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(quitSystem);
            temp = false;
            //System.out.println(loginController.name);
        }
    }
}
