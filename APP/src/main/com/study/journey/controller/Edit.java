package com.study.journey.controller;

import com.study.journey.entity.Info;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;

import java.util.ArrayList;

import static com.study.journey.controller.AdministratorStudentInformationController.CSVtoList1;
import static com.study.journey.controller.AdministratorStudentInformationController.updateStudentInfo;

public class Edit extends PopUpPageController{

    public MFXTextField id;
    public MFXTextField newClassId;
    public MFXTextField newName;
    public MFXPasswordField newPin;

    public void edit(ActionEvent actionEvent) {
        //方法体
        String csvFilePath = "./APP/src/main/Student_info.csv";
        ArrayList<Info> infos = CSVtoList1(csvFilePath);
        String strID = this.id.getText();
        String strNewClassID = this.newClassId.getText();
        String strNewName = this.newName.getText();
        String strNewPin = this.newPin.getText();
        if(strID.isEmpty()||strNewClassID.isEmpty()||strNewName.isEmpty()||strNewPin.isEmpty()){
            System.out.println("别输入空的东西！请重新输！");
        }else {
            updateStudentInfo(infos,strID,strNewClassID,strNewName,strNewPin);
            //关闭
            super.closePage((MFXButton) actionEvent.getSource());
        }

    }
}
