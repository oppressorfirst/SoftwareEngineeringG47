package com.study.journey.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;

public class Remove extends PopUpPageController{

    public MFXTextField id;
    public MFXTextField confirmID;

    public void remove(ActionEvent actionEvent) {
        //具体方法

        //关闭的代码
        super.closePage((MFXButton) actionEvent.getSource());
    }
}
