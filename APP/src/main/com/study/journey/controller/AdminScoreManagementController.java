package com.study.journey.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class AdminScoreManagementController {
    public MFXButton toAdministratorHome;
    public MFXButton toStudentInformation;
    public MFXButton toAdminInformation;
    public MFXButton toCourse;
    Boolean temp = true;

    @FXML
    private void ToAdminHome() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toAdministratorHome);
            temp = false;
        }

    }

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
    private void ToInformation() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toAdminInformation);
            temp = false;
        }

    }
}
