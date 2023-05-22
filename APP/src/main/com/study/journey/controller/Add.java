package com.study.journey.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.css.themes.MFXThemeManager;
import io.github.palexdev.materialfx.css.themes.Themes;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Add extends PopUpPageController{


    public MFXTextField id;
    public MFXTextField name;
    public MFXTextField classId;
    public MFXPasswordField pin;

    public void add(ActionEvent actionEvent) {
        //写逻辑代码


        //关闭的代码
        super.closePage((MFXButton) actionEvent.getSource());
    }
}
