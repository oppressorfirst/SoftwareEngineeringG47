package com.study.journey.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

import java.io.IOException;

public class StudentLearningModuleController {
    public MFXButton backHome;
    Boolean temp = true; // 防止多次点击
    @FXML
    private void changePage() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(backHome);
            temp = false;
        }
    }

}
