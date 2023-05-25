package com.study.journey.controller;

import com.study.journey.Main;
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


/**
 * Title: StudentHomeController.java
 * Description: The controller class for the Student Home page.
 * Copyright  : Copyright (c) 2023/5/25
 * @author Ruizhi Yang, Jialun Zhang
 * @version 5.0
 */
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


    /**
     * Initializes the controller after the FXML file has been loaded.
     * This method is automatically called by the JavaFX framework.
     * It prints the value of the 'ID' variable and calls the 'updateLearningTopicText()' and 'updatePersonInfoText()' methods.
     * The 'ID' variable represents the identifier of the controller.
     */
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

        Main.controller.changePage(quitSystem);
    }

    @FXML
    private void toLearning(MouseEvent event) throws IOException {

            System.out.println(event.getButton().name());
            Main.controller.changePage(toLearning);

            System.out.println(loginController.name);

    }

    @FXML
    private void toCourseSelection(MouseEvent event) throws IOException {

            System.out.println(event.getButton().name());
            Main.controller.changePage(toCourseSelection);

    }

    @FXML
    private void toClassSchedule(MouseEvent event) throws IOException {

            System.out.println(event.getButton().name());
            Main.controller.changePage(toClassSchedule);

    }
    @FXML
    private void toInformation(MouseEvent event) throws IOException {

            System.out.println(event.getButton().name());
            Main.controller.changePage(toInformation);

    }

    @FXML
    private void toAchievement(MouseEvent event) throws IOException {

        //System.out.println(event.getButton().name());
        Main.controller.changePage(toAchievement);
    }

    @FXML
    public void toGrades(MouseEvent mouseEvent) throws IOException {

            Main.controller.changePage(toGrades);

    }


    /**
     * Retrieves a specific student information based on the ID.
     *
     * @return the student information object matching the ID, or null if no match is found.
     */
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

    /**
     * Updates the person information text fields with the student's information.
     * It retrieves the student's information using the getInfoFromCsvByID() method and updates the relevant text fields.
     * If the student's information is available, it sets the text fields with the corresponding values.
     * If the student's information is not available, the text fields remain unchanged.
     */
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

    /**
     * Updates the learning topic text field with the number of grades.
     * It reads the grades from the "CourseScore.csv" file using the CSVtoList() method and counts the number of grades.
     * It then sets the learning topic text field with the count of grades.
     */
    public void updateLearningTopicText() {
        String csvFilePath = "./APP/src/main/CourseScore.csv";
        ArrayList<Grade> grades = CSVtoList(csvFilePath);
        int arrayListSize = grades.size();
        learningTopic.setText(String.format("%d", arrayListSize));
    }


    /**
     * Opens a web page based on the source of the action event.
     * If the source is the "toEmail" button, it opens the QMUL email login page.
     * If the source is any other button, it opens the Google Scholar page.
     *
     * @param actionEvent the action event triggered by the user's click on a button.
     */
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
