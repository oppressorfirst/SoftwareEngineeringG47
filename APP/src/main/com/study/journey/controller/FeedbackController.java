package com.study.journey.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.awt.*;
import java.net.URI;

public class FeedbackController extends PopUpPageController {

    public Text web;


    public void openWeb(MouseEvent mouseEvent) {
        String url="https://bupt.edu.cn";
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
