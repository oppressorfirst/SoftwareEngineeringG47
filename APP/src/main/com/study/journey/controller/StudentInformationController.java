package com.study.journey.controller;

import com.study.journey.Main;
import com.study.journey.entity.Info;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.List;

import static com.study.journey.controller.AdministratorStudentInformationController.CSVtoList1;

/**
 * Title: StudentInformationController.java
 * Description: The controller class for the Student information page.
 * Copyright  : Copyright (c) 2023/5/25
 * @author Ruizhi Yang, Jialun Zhang
 * @version 5.0
 */
public class StudentInformationController {
    public MFXButton backHome;
    @FXML
    public MFXTextField account;
    @FXML
    public MFXPasswordField nowPassword;
    @FXML
    public MFXPasswordField newPassword;
    @FXML
    public MFXPasswordField repeatPassword;
    @FXML
    public MFXButton Submit;
    Boolean temp = true; // 防止多次点击
    private Info info;

    public void toHome(MouseEvent mouseEvent) throws IOException {

        if(temp) {
            Main.controller.changePage(backHome);
            temp = false;
        }
    }


    /**
     * Retrieves a specific student information based on the ID.
     * Match the right information and return a right student element by student's ID
     * @param ID the ID of the student.
     */
    public void getInfoFromCsvByID(String ID) { // 这个方法根据 ID 返回一个特定的学生信息

        String csvFilePath = "./APP/src/main/Student_info.csv";
        ArrayList<Info> infos = CSVtoList1(csvFilePath); //直接调用AdministratorInformationController中的静态方法读文件并写入Arraylist中

        this.info = null;


        for (Info element : infos) {
            if (element.getID().equals(ID)) { // 根据特定值进行匹配
                this.info = element; // 找到匹配的元素
            }
        }
    }


    /**
     * Updates the CSV file with the new PIN for the specified account ID.
     * @param accountId the account ID for which the PIN should be updated.
     * @param newPin the new PIN to be set for the account.
     */
    public void updateCsvFile(String accountId, String newPin) {
        try {
            String csvFilePath = "./APP/src/main/Student_info.csv";
            // 读取原始CSV文件内容
            List<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            // 构建更新后的CSV内容
            List<String> updatedLines = new ArrayList<>();
            for (String csvLine : lines) {
                String[] data = csvLine.split(",");
                if (data.length >= 2 && data[0].equals(accountId)) {
                    // 更新密码
                    data[3] = newPin;
                }
                // 构建更新后的行
                updatedLines.add(String.join(",", data));
            }

            // 写入更新后的内容到CSV文件
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath));
            for (String csvLine : updatedLines) {
                writer.write(csvLine);
                writer.newLine();
            }
            writer.close();

            System.out.println("CSV文件修改成功");
        } catch (IOException e) {
            System.out.println("CSV文件修改失败：" + e.getMessage());
        }
    }




    /**
     * Submits the password change request.
     * @param mouseEvent the mouse event triggered by the user's action.
     */
    @FXML
    public void Submit(MouseEvent mouseEvent) {
        getInfoFromCsvByID(this.account.getText());
        String strNowPassword = this.nowPassword.getText();
        String strNewPassword = this.newPassword.getText();
        String strRepeatPassword = this.repeatPassword.getText();
        if(strNowPassword.isEmpty()||strNewPassword.isEmpty()||strRepeatPassword.isEmpty()){
            System.out.println("别输空的，请重新输");
        }else {
            if (strNowPassword.equals(info.getPIN())) {
                if (strNewPassword.equals(strRepeatPassword)) {
                    this.info.setPIN(strNewPassword);
                    System.out.println("密码修改成功");
                    updateCsvFile(this.info.getID(), strNewPassword);
                    try {
                        toHome(mouseEvent);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("两边密码输入不一致");
                }
            } else {
                System.out.println("密码不正确！");
            }
            System.out.println(this.info.getName());
            System.out.println(this.info.getPIN());
        }
    }
}
