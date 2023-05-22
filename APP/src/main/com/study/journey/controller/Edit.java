package com.study.journey.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;

public class Edit extends PopUpPageController{

    public MFXTextField id;
    public MFXTextField newClassId;
    public MFXTextField newName;
    public MFXPasswordField newPin;

    public void edit(ActionEvent actionEvent) {
        //方法体
        
        //关闭
        super.closePage((MFXButton) actionEvent.getSource());
    }
}
