package com.study.journey.controller;

import com.study.journey.Main;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Title: AdminScoreManagementController.java
 * Description: Controller class for the Admin Score Management page. This class handles the functionality of navigating to different pages from the Admin Score Management page.
 * Copyright  : Copyright (c) 2023/5/25
 * @author      Jialun Zhang
 * @version     5.0
 */
public class AdminScoreManagementController {
    public MFXButton toAdministratorHome;
    public MFXButton toStudentInformation;
    public MFXButton toAdminInformation;
    public MFXButton toCourse;
    Boolean temp = true;


    /**
     * Navigates to the administrator home page.
     * This method is used to navigate to the administrator home page if the condition 'temp' is true.
     * It uses a PageController instance to change the current page to the administrator home page.
     * After navigating, the 'temp' flag is set to false to prevent multiple navigations.
     *
     * @throws IOException if an I/O error occurs while navigating to the administrator home page.
     */
    @FXML
    private void ToAdminHome() throws IOException {
        if(temp) {
            Main.controller.changePage(toAdministratorHome);
            temp = false;
        }

    }

    /**
     * Navigates to the student information page.
     * This method is used to navigate to the student information page if the condition 'temp' is true.
     * It uses a PageController instance to change the current page to the student information page.
     * After navigating, the 'temp' flag is set to false to prevent multiple navigations.
     *
     * @throws IOException if an I/O error occurs while navigating to the student information page.
     */
    @FXML
    private void ToStudentInformation() throws IOException {
        if(temp) {
            Main.controller.changePage(toStudentInformation);
            temp = false;
        }

    }

    /**
     * Navigates to the course page.
     * This method is used to navigate to the course page if the condition 'temp' is true.
     * It uses a PageController instance to change the current page to the course page.
     * After navigating, the 'temp' flag is set to false to prevent multiple navigations.
     *
     * @throws IOException if an I/O error occurs while navigating to the course page.
     */
    @FXML
    private void ToCourse() throws IOException {
        if(temp) {

            Main.controller.changePage(toCourse);
            temp = false;
        }

    }

    /**
     * Navigates to the information page.
     * This method is used to navigate to the information page if the condition 'temp' is true.
     * It uses a PageController instance to change the current page to the admin information page.
     * After navigating, the 'temp' flag is set to false to prevent multiple navigations.
     *
     * @throws IOException if an I/O error occurs while navigating to the information page.
     */
    @FXML
    private void ToInformation() throws IOException {
        if(temp) {
            Main.controller.changePage(toAdminInformation);
            temp = false;
        }

    }
}
