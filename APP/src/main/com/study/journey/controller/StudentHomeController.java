package com.study.journey.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class StudentHomeController {

    public MFXButton toLearning;
    public MFXButton toGrades;
    public MFXButton toEmail;
    public MFXButton toIndex;
    Boolean temp = true; // 防止多次点击
    @FXML
    private void toLearning(MouseEvent event) throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toLearning);
            temp = false;
        }
    }


    public void toGrades(MouseEvent mouseEvent) throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toGrades);
            temp = false;
        }
    }
}
