package com.study.journey.controller;

import com.study.journey.entity.Info;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;

import java.util.ArrayList;

import static com.study.journey.controller.AdministratorStudentInformationController.CSVtoList1;
import static com.study.journey.controller.AdministratorStudentInformationController.removeStudentInfo;

/**
 * Title: Remove.java
 * Description: The Remove class is a controller that handles the removal of student information. It extends the PopUpPageController class.
 * Copyright  : Copyright (c) 2023/5/25
 * @author      Ruizhi Yang, Jialun Zhang
 * @version     5.0
 */
public class Remove extends PopUpPageController{

    public MFXTextField id;
    public MFXTextField confirmID;

    /**
     * Removes the student information.
     * This method is called when the remove button is clicked.
     * It retrieves the path of the CSV file containing the student information.
     * It then retrieves the ID and confirm ID entered by the user.
     * If either field is empty, it displays an error message.
     * If the IDs match, it removes the corresponding student information from the CSV file.
     * If the IDs do not match, it displays an error message.
     * Finally, it calls the closePage method to close the pop-up page.
     *
     * @param actionEvent the action event triggered by the remove button click.
     */
    public void remove(ActionEvent actionEvent) {
        //具体方法
        String csvFilePath = "./APP/src/main/Student_info.csv";
        ArrayList<Info> infos = CSVtoList1(csvFilePath);
        String strID = this.id.getText();
        String strConfirmID = this.confirmID.getText();
        if(strID.isEmpty()||strConfirmID.isEmpty()){
            System.out.println("别输入空的东西！请重新输！");
        } else if (strID.equals(strConfirmID)) {
            removeStudentInfo(infos,csvFilePath,strConfirmID);
            //关闭的代码
            super.closePage((MFXButton) actionEvent.getSource());
        } else {
            System.out.println("两次输入 ID 不相同！请修改！");
        }



    }
}
