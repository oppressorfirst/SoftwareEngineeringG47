package com.study.journey.controller;

import com.study.journey.entity.Info;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;

import java.util.ArrayList;

import static com.study.journey.controller.AdministratorStudentInformationController.CSVtoList1;
import static com.study.journey.controller.AdministratorStudentInformationController.removeStudentInfo;

public class Remove extends PopUpPageController{

    public MFXTextField id;
    public MFXTextField confirmID;

    public void remove(ActionEvent actionEvent) {
        //具体方法
        String csvFilePath = "./APP/src/main/Student_info.csv";
        ArrayList<Info> infos = CSVtoList1(csvFilePath);
        String strID = this.id.getText();
        String strConfirmID = this.confirmID.getText();
        if(strID.isEmpty()||strConfirmID.isEmpty()){
            System.out.println("别输入空的东西！请重新输！");
        } else if (strID.equals(strConfirmID)) {
            removeStudentInfo(infos,strConfirmID);
            //关闭的代码
            super.closePage((MFXButton) actionEvent.getSource());
        } else {
            System.out.println("两次输入 ID 不相同！请修改！");
        }



    }
}
