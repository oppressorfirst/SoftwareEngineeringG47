package com.study.journey.controller;

import com.study.journey.entity.Grade;
import com.study.journey.entity.Info;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

import static com.study.journey.controller.AdministratorInformationController.CSVtoList1;
import static com.study.journey.controller.StudentGradesController.CSVtoList;

public class StudentHomeController {

    public MFXButton toLearning;
    public MFXButton toGrades;
    public MFXButton toEmail;
    public MFXButton toIndex;
    @FXML
    public Text learningTopic;
    @FXML
    public Text StudentName;
    @FXML
    public Text StudentID;
    @FXML
    public Text StudentClass;
    public LoginController loginController;

    //给别的controller类用来传参
    public String name ;
    public Info info;
    Boolean temp = true; // 防止多次点击

    @FXML
    public void initialize() {
        System.out.println(name);
        updateLearningTopicText();
        updatePersonInfoText();
    }

    public void setName(String name) {
        this.name = name;
    }
        // 其他代码


    @FXML
    private void toLearning(MouseEvent event) throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toLearning);
            temp = false;
            System.out.println(loginController.name);
        }
    }


    public void toGrades(MouseEvent mouseEvent) throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toGrades);
            temp = false;
        }
    }

    public Info getInfoFromCsvByID() { // 这个方法根据 ID 返回一个特定的学生信息

        String csvFilePath = "./APP/src/main/Student_info.csv";
        ArrayList<Info> infos = CSVtoList1(csvFilePath); //直接调用AdministratorInformationController中的静态方法读文件并写入Arraylist中

        String ID = "2020213332"; // 要搜索的特定ID值
        this.info = null;


        for (Info element : infos) {
            if (element.getID().equals(ID)) { // 根据特定值进行匹配
                this.info = element; // 找到匹配的元素
            }
        }

        return this.info;
    }

    public Info getInfoFromCsvByName() { // 这个方法根据 name 返回一个特定的学生信息

        String csvFilePath = "./APP/src/main/Student_info.csv";
        ArrayList<Info> infos = CSVtoList1(csvFilePath); //直接调用AdministratorInformationController中的静态方法读文件并写入Arraylist中

        this.info = null;


        for (Info element : infos) {
            if (element.getName().equals(this.name)) { // 根据特定值进行匹配
                this.info = element; // 找到匹配的元素
            }
        }

        return this.info;
    }

    public void updatePersonInfoText() {
        this.info = getInfoFromCsvByName();
        //System.out.println("info: " + info);  // 调试语句

        if (info != null) {
           // System.out.println("info.getName(): " + info.getName());  // 调试语句

            StudentName.setText(String.format("%s", info.getName()));
            StudentID.setText(String.format("%s", info.getID()));
            StudentClass.setText(String.format("%s", info.getClassID()));
        } else {
            //System.out.println("info is null");  // 调试语句
        }
    }
    public void updateLearningTopicText() {
        String csvFilePath = "./APP/src/main/CourseScore.csv";
        ArrayList<Grade> grades = CSVtoList(csvFilePath);
        int arrayListSize = grades.size();
        learningTopic.setText(String.format("%d", arrayListSize));
    }

}
