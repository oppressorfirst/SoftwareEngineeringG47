package com.study.journey.controller;

import com.study.journey.entity.Grade;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.study.journey.controller.StudentGradesController.CSVtoList;

/**
 * Title      : GPA.java
 * Description: This class is used to control the page GPA.fxml and calculate the GPA.
 * Copyright  : Copyright (c) 2023/5/25
 * @author      Ruizhi Yang, Jialun Zhang
 * @version     5.0
 */
public class GPA extends PopUpPageController implements Initializable {
    public Text gpa;

    /**
     *Description: This is a function to calculate Grade point by BUPT algorithm.
     * @param grade the grade of one specific course.
     */
    public double GradePoints(String grade){
        double dblGrade = Double.parseDouble(grade);
        double gradePoints;
        gradePoints = 4-3*(100-dblGrade)*(100-dblGrade)/1600;
        return gradePoints;
    }


    /**
     *Description: This is a function that calculate GPA from a .csv file by BUPT algorithm, which calls the function GradePoint(String grade){}.
     * @param csvFilePath the CourseScore.csv that you want to input and read, which include all the student course grade information.
     */
    public double calcGPA(String csvFilePath){
        //String csvFilePath = "./APP/src/main/CourseScore.csv";
        ArrayList<Grade> grades = CSVtoList(csvFilePath);
        double sumCredit = 0;//总学分
        double sumGradePointsMultiCredits = 0;
        double GPA;
        //算总学分和总的（GradePoints * Credits）
        for (Grade grade : grades) {
            sumCredit += grade.getCredit();
            sumGradePointsMultiCredits += GradePoints(grade.getGrade())* grade.getCredit();
        }
        GPA = sumGradePointsMultiCredits/sumCredit;

        return GPA;
    }




    /**
     *Description: This is an override function to initialize the page and calculate the GPA by calling the calcGPA(String csvFilePath){}.
     * @param url an essential arguments in set up a page in page control class.
     * @param resourceBundle an essential arguments in set up a page in page control class.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String csvFilePath = "./APP/src/main/CourseScore.csv";
        double GPA = calcGPA(csvFilePath);
        //保留两位小数
        gpa.setText(String.format("%.2f", GPA));
    }
}
