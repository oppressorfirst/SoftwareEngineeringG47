package com.study.journey.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;

import java.io.IOException;

public class AdminMyInformationController {
    public MFXButton toAdministratorHome;
    public MFXButton toScoreManagement;
    public MFXButton toCourse;
    public MFXButton toStudentInformation;
    public MFXTextField account;
    public MFXPasswordField repeatPassword;
    public MFXPasswordField newPassword;
    public MFXPasswordField nowPassword;
    public MFXButton submit;
    Boolean temp = true; // 防止多次点击


    @FXML
    private void ToCourse() throws IOException {
        if (temp) {
            PageController controller = new PageController();
            controller.changePage(toCourse);
            temp = false;
        }

    }

    @FXML
    private void ToScoreManagement() throws IOException {
        if (temp) {
            PageController controller = new PageController();
            controller.changePage(toScoreManagement);
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
    private void ToAdministratorHome() throws IOException {
        if (temp) {
            PageController controller = new PageController();
            controller.changePage(toAdministratorHome);
            temp = false;
        }
    }
}
