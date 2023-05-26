package com.study.journey.controller;

import com.study.journey.entity.Info;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;

import java.util.ArrayList;

import static com.study.journey.controller.AdministratorStudentInformationController.CSVtoList1;
import static com.study.journey.controller.AdministratorStudentInformationController.updateStudentInfo;


/**
 * Title: Edit.java
 * Description:  Controller class for the Edit popup page. This class handles the functionality of editing student information.* Copyright  : Copyright (c) 2023/5/25
 * Copyright  : Copyright (c) 2023/5/25
 * @author      Ruizhi Yang, Jialun Zhang
 * @version     5.0
 */
public class Edit extends PopUpPageController{

    public MFXTextField id;
    public MFXTextField newClassId;
    public MFXTextField newName;
    public MFXPasswordField newPin;


    /**
     * Performs the edit operation.
     * This method is called when the edit button is clicked.
     * It retrieves the input values for student information from the UI fields.
     * It validates the input values and updates the student information in the CSV file.
     * If any of the input fields is empty, it prints an error message.
     * After updating the student information, it closes the page.
     *
     * @param actionEvent the action event triggered by the edit button.
     */
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
            updateStudentInfo(infos,csvFilePath,strID,strNewClassID,strNewName,strNewPin);
            //关闭
            super.closePage((MFXButton) actionEvent.getSource());
        }

    }
}
