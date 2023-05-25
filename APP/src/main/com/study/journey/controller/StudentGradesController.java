package com.study.journey.controller;

import com.study.journey.entity.Grade;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.IntegerFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;


/**
 * Title: StudentGradesController.java
 * Description: The controller class for the Student Grades view.
 * Copyright  : Copyright (c) 2023/5/25
 * @author      Jialun Zhang
 * @version     5.0
 */
public class StudentGradesController implements Initializable {

    public MFXButton backHome;
    public MFXTableView<Grade> table;
    public MFXButton calc;
    PopUpPageController popUpPageController;

    Boolean temp = true; // 防止多次点击

    /**
     * Changes the page to the home page.
     * This method is called to navigate to the home page when a specific condition is met.
     * It checks the value of the boolean variable 'temp' to determine if the page change should occur.
     * If 'temp' is true, it creates an instance of the PageController class and calls the 'changePage' method,
     * passing the 'backHome' button as an argument.
     * After the page change, it sets the value of 'temp' to false to prevent subsequent page changes.
     *
     * @throws IOException if an I/O error occurs while changing the page.
     */
    @FXML
    private void changePage() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(backHome);
            temp = false;
        }
    }


    /**
     * Parses a 2D array of student data and creates a list of grades.
     *
     * @param studentData the 2D array containing the student data.
     * @return an ArrayList containing the parsed grades.
     */
    public static ArrayList<Grade> parseGrades(String[][] studentData) {
        ArrayList<Grade> grades = new ArrayList<>();
        for (int i = 0; i < studentData.length; i++) {
            String name = studentData[i][0];
            String grade = studentData[i][1];
            //String status = studentData[i][1];
            //int credit = Integer.parseInt(studentData[i][2]);
            //String grade = studentData[i][3];
            Grade gradeObj = new Grade(name, grade);
            grades.add(gradeObj);
        }
        return grades;
    }

    /**
     * Parses a CSV file containing grade data and creates a list of grades.
     *
     * @param csvFilePath the path to the CSV file.
     * @return an ArrayList containing the parsed grades.
     */
    public static ArrayList<Grade> CSVtoList(String csvFilePath) {
        ArrayList<Grade> grades = new ArrayList<>();
        String csvSplitBy = ",";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Skip the first line (header)
            while ((line = br.readLine()) != null) {

                String[] values = line.split(csvSplitBy);

                //String.trim()可以吧数据间的空格去掉
                String name = values[0].trim();
                String status = values[1].trim();
                int credit = Integer.parseInt(values[2].trim());
                String grade = values[3].trim();

                Grade gradeObj = new Grade(name, status, credit, grade);
                grades.add(gradeObj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return grades;
    }



    /**
     * Initializes the controller and sets up the table with grade data.
     * @param url            the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle the resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //String[][] studentData = FileIO.Readfile();
        //String[][] studentData = new String[1][2];
        //studentData[0][0] = "Art";
        //studentData[0][1] = "100";

        String csvFilePath = "./APP/src/main/CourseScore.csv";
        ArrayList<Grade> grades = CSVtoList(csvFilePath);
        for (Grade grade : grades) {
            System.out.println(grade.getName() + " " + grade.getStatus() + " " + grade.getCredit() + " " + grade.getGrade());
        }

        //List<Grade> grades = parseGrades(studentData);
        table.getItems().addAll(grades);

        setupTable();

        table.autosizeColumnsOnInitialization();
    }

    /**
     * Sets up the table by creating the columns, cell factories, and filters.
     * This method is called during initialization to configure the table for displaying grades.
     */
    private void setupTable() {
        //represent the creation of the four column in the table
        //Comparator.comparing(Grade::getName)方法用于对这个"Grade"对象进行排序
        MFXTableColumn<Grade> nameColumn = new MFXTableColumn<>("Name", true, Comparator.comparing(Grade::getName));
        MFXTableColumn<Grade> statusColumn = new MFXTableColumn<>("Status", true, Comparator.comparing(Grade::getStatus));
        MFXTableColumn<Grade> creditColumn = new MFXTableColumn<>("Credit", true, Comparator.comparing(Grade::getCredit));
        MFXTableColumn<Grade> gradeColumn = new MFXTableColumn<>("Grade", true, Comparator.comparing(Grade::getGrade));

        //setRowCellFactory方法的作用是用于创建每个单元格的外观和行为。
        nameColumn.setRowCellFactory(grade -> new MFXTableRowCell<>(Grade::getName));
        statusColumn.setRowCellFactory(grade -> new MFXTableRowCell<>(Grade::getStatus));
        gradeColumn.setRowCellFactory(grade -> new MFXTableRowCell<>(Grade::getGrade));
        creditColumn.setRowCellFactory(grade -> new MFXTableRowCell<>(Grade::getCredit) {{
            setAlignment(Pos.CENTER_RIGHT);
        }});
        creditColumn.setAlignment(Pos.CENTER_RIGHT);

        table.getTableColumns().addAll(nameColumn, statusColumn, creditColumn, gradeColumn);

        //设置表格的过滤器，以便用户可以根据不同的列和属性来筛选和查找表格中的数据。
        table.getFilters().addAll(
                new StringFilter<>("Name", Grade::getName),
                new StringFilter<>("Status", Grade::getStatus),
                new IntegerFilter<>("Credit", Grade::getCredit),
                new StringFilter<>("Grade", Grade::getGrade)
        );
    }


    /**
     * Opens the GPA pop-up page.
     * This method is called when the user clicks on the "GPA" button to open the GPA pop-up page.
     * It retrieves the source of the event, creates an instance of the PopUpPageController, and calls the 'makePopUpPage' method,
     * passing the source button as an argument.
     * The PopUpPageController is responsible for creating and displaying the GPA pop-up page.
     *
     * @param e the action event triggered by the user's click on the "GPA" button.
     * @throws IOException if an I/O error occurs while creating or displaying the pop-up page.
     */
    @FXML
    private void openGPA(ActionEvent e) throws IOException {
        System.out.println(e.getSource());
        popUpPageController = new PopUpPageController().makePopUpPage((MFXButton) e.getSource());
        System.out.println(popUpPageController);
    }
}
