package com.study.journey.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

import java.io.IOException;


/**
 * Title: StudentLearningModuleController.java
 * Description: The controller class for the Student information page.
 * Copyright  : Copyright (c) 2023/5/25
 * @author Ruizhi Yang, Jialun Zhang
 * @version 5.0
 */
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
