package com.study.journey.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;

import java.io.IOException;

public class AdministratorHomeController {
    public SplitPane splitPane;


    public MFXButton toStudentInformation;

    Boolean temp = true; // 防止多次点击
    @FXML
    private void ToStudentInformation() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toStudentInformation);
            temp = false;
        }

    }
}
