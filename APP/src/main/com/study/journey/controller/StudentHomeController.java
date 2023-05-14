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
    public Text StudentName;
    public Text StudentID;
    public Text StudentClass;
    Boolean temp = true; // 防止多次点击
    @FXML
    public void initialize() {
        updateLearningTopicText();
        updatePersonInfoText();
    }

    @FXML
    private void toLearning(MouseEvent event) throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toLearning);
            temp = false;
        }
    }


    public void toGrades(MouseEvent mouseEvent) throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toGrades);
            temp = false;
        }
    }

    public void updatePersonInfoText() {

        String csvFilePath = "./APP/src/main/Student_info.csv";
        ArrayList<Info> infos = CSVtoList1(csvFilePath); //直接调用AdministratorInformationController中的静态方法读文件并写入Arraylist中

        String ID = "2020213332"; // 要搜索的特定ID值
        Info info = null;


        for (Info element : infos) {
            if (element.getID().equals(ID)) { // 根据特定值进行匹配
                info = element; // 找到匹配的元素
            }
        }

        StudentName.setText(String.format("%s", info.getName()));
        StudentID.setText(String.format("%s", info.getID()));
        StudentClass.setText(String.format("%s", info.getClassID()));
    }
    public void updateLearningTopicText() {
        String csvFilePath = "./APP/src/main/CourseScore.csv";
        ArrayList<Grade> grades = CSVtoList(csvFilePath);
        int arrayListSize = grades.size();
        learningTopic.setText(String.format("%d", arrayListSize));
    }

}
