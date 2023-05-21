package com.study.journey.controller;

import com.study.journey.entity.Course;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class StudentInformationController {
    public MFXButton backHome;
    public MFXTextField account;
    public MFXPasswordField nowPassword;
    public MFXPasswordField newPassword;
    public MFXPasswordField repeatPassword;
    Boolean temp = true; // 防止多次点击
    public void toHome(MouseEvent mouseEvent) throws IOException {

        if(temp) {
            PageController controller = new PageController();
            controller.changePage(backHome);
            temp = false;
        }
    }
}
