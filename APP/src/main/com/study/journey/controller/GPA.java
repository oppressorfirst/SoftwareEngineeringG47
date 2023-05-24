package com.study.journey.controller;

import com.study.journey.entity.Grade;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GPA extends PopUpPageController implements Initializable {
    public Text gpa;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gpa.setText("3.42");
    }
}
