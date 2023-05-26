package com.study.journey.controller;

import com.study.journey.entity.Info;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.ArrayList;

import static com.study.journey.controller.AdministratorStudentInformationController.CSVtoList1;
import static com.study.journey.controller.AdministratorStudentInformationController.addStudentInfo;


/**
 * Title      : Add.java
 * Description: This class is used to control the page add.fxml and add the user information into an arraylist and write into a .csv file.
 * Copyright  : Copyright (c) 2023/5/25
 * @author      Jialun Zhang, Ruizhi Yang
 * @version     5.0
 */
public class Add extends PopUpPageController{

    @FXML
    public MFXTextField id;
    @FXML
    public MFXTextField name;
    @FXML
    public MFXTextField classId;
    @FXML
    public MFXPasswordField pin;


    /**
     *Description: This is a function to control the add operation.
     * @param actionEvent the action event to be processed.
     */
    public void add(ActionEvent actionEvent) {
        //写逻辑代码
        String csvFilePath = "./APP/src/main/Student_info.csv";
        ArrayList<Info> infos = CSVtoList1(csvFilePath);
        String strID = this.id.getText();
        String strClassID = this.classId.getText();
        String strName = this.name.getText();
        String strPin = this.pin.getText();
        if(strID.isEmpty()||strClassID.isEmpty()||strName.isEmpty()||strPin.isEmpty()){
            System.out.println("别输入空的东西！请重新输！");
        }else{
            addStudentInfo(infos,csvFilePath,strID,strClassID,strName,strPin);
            //关闭的代码
            super.closePage((MFXButton) actionEvent.getSource());
        }
    }
}
