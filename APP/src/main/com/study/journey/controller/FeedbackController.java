package com.study.journey.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.awt.*;
import java.net.URI;
/**
 * The FeedbackController class extends the PopUpPageController.
 * It represents the controller for the feedback user interface, and includes
 * a method to open a specified URL in the system's default web browser.
 * copyright  : Copyright (c) 2023/5/26
 * @author Jialun Zhang
 * @version 5.0
 */
public class FeedbackController extends PopUpPageController {

    public Text web;


    public void openWeb(MouseEvent mouseEvent) {
        String url="https://github.com/oppressorfirst/SoftwareEngineeringG47";
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
