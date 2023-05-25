package com.study.journey.controller;

import com.study.journey.Main;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import java.io.IOException;

/**
 * Title      : AdminCourseManagementController.java
 * Description: This class is used to control the page AdminCourseManagementController.java.
 * Copyright  : Copyright (c) 2023/5/25
 * @author      Jialun Zhang
 * @version     5.0
 */
public class AdminCourseManagementController {
    public MFXButton toAdministratorHome;
    public MFXButton toStudentInformation;
    public MFXButton toScoreManagement;
    public MFXButton toAdminInformation;
    Boolean temp = true; // 防止多次点击

    /**
     *Description: This is a function to control changing page to adminHome page.
     */
    @FXML
    private void ToAdminHome() throws IOException {
        if(temp) {
            Main.controller.changePage(toAdministratorHome);
            temp = false;
        }

    }

    /**
     *Description: This is a function to control changing page to StudentInformation page.
     */
    @FXML
    private void ToStudentInformation() throws IOException {
        if(temp) {
            Main.controller.changePage(toStudentInformation);
            temp = false;
        }

    }

    /**
     *Description: This is a function to control changing page to ScoreManagement page.
     */
    @FXML
    private void ToScoreManagement() throws IOException {
        if(temp) {
            Main.controller.changePage(toScoreManagement);
            temp = false;
        }

    }

    /**
     *Description: This is a function to control changing page to Information page.
     */
    @FXML
    private void ToInformation() throws IOException {
        if(temp) {
            Main.controller.changePage(toAdminInformation);
            temp = false;
        }

    }
}
