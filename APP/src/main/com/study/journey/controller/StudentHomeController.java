package com.study.journey.controller;

import com.study.journey.entity.Grade;
import com.study.journey.entity.Info;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import static com.study.journey.controller.AdministratorStudentInformationController.CSVtoList1;
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
    public String ID;
    public Info info;
    public MFXButton quitSystem;
    public MFXButton toAchievement;
    public MFXButton toCourseSelection;
    public MFXButton toClassSchedule;
    public MFXButton toInformation;
    Boolean temp = true; // 防止多次点击

    @FXML
    public void initialize() {
        System.out.println(ID);
        updateLearningTopicText();
        updatePersonInfoText();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    // 其他代码

    public void quit() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(quitSystem);
            temp = false;
            //System.out.println(loginController.name);
        }
    }

    @FXML
    private void toLearning(MouseEvent event) throws IOException {
        if(temp) {
            System.out.println(event.getButton().name());
            PageController controller = new PageController();
            controller.changePage(toLearning);
            temp = false;
            System.out.println(loginController.name);
        }
    }

    @FXML
    private void toCourseSelection(MouseEvent event) throws IOException {
        if(temp) {
            System.out.println(event.getButton().name());
            PageController controller = new PageController();
            controller.changePage(toCourseSelection);
            temp = false;
        }
    }

    @FXML
    private void toClassSchedule(MouseEvent event) throws IOException {
        if(temp) {
            System.out.println(event.getButton().name());
            PageController controller = new PageController();
            controller.changePage(toClassSchedule);
            temp = false;
        }
    }
    @FXML
    private void toInformation(MouseEvent event) throws IOException {
        if(temp) {
            System.out.println(event.getButton().name());
            PageController controller = new PageController();
            controller.changePage(toInformation);
            temp = false;
        }
    }

    @FXML
    private void toAchievement(MouseEvent event) throws IOException {
        if(temp) {
            //System.out.println(event.getButton().name());
            PageController controller = new PageController();
            controller.changePage(toAchievement);
            temp = false;
        }
    }

    @FXML
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

        this.info = null;


        for (Info element : infos) {
            if (element.getID().equals(ID)) { // 根据特定值进行匹配
                this.info = element; // 找到匹配的元素
            }
        }

        return this.info;
    }


    public void updatePersonInfoText() {
        this.info = getInfoFromCsvByID();
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

    public void openWeb(ActionEvent actionEvent) {
        String url;
        if(actionEvent.getSource().equals(toEmail)) {
            url = "https://mail.qmul.ac.uk"; // 指定要打开的网页URL
        }
        else {
            url = "https://scholar.google.com"; // 指定要打开的网页URL
        }
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
