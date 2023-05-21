package com.study.journey.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class AdministratorHomeController {
    public SplitPane splitPane;


    public MFXButton toStudentInformation;
    public MFXButton quitSystem;

    Boolean temp = true; // 防止多次点击
    @FXML
    private void ToStudentInformation() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toStudentInformation);
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
