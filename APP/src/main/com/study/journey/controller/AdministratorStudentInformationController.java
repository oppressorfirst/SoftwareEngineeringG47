package com.study.journey.controller;

import com.study.journey.Main;
import com.study.journey.entity.Info;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Title      : AdministratorStudentInformationController.java
 * Description: This class is used to control the page admin_studentinformation.fxml.
 * Copyright  : Copyright (c) 2023/5/25
 * @author      Ruizhi Yang, Jialun Zhang
 * @version     5.0
 */
public class AdministratorStudentInformationController implements Initializable{
    public MFXButton toAdministratorHome;
    public MFXButton toStudentInformation;
    public MFXTableView<Info> tableInfo;
    public MFXButton add;
    public MFXButton edit;
    public MFXButton remove;
    public PopUpPageController popUpPageController;

    Boolean temp = true; // 防止多次点击
    public MFXButton toCourse;
    public MFXButton toScoreManagement;
    public MFXButton toAdminInformation;



    /**
     *Description: This is the change page function to call a pop-up page.
     * @param e the event to be processed
     */
    @FXML
    private void callPopUpPage(ActionEvent e) throws IOException {
            System.out.println(e.getSource());
            popUpPageController = new PopUpPageController().makePopUpPage((MFXButton) e.getSource());
        System.out.println(popUpPageController);

    }

    /**
     *Description: This is the change page function to student information page.
     */
    @FXML
    private void ToStudentInformation() throws IOException {
        if(temp) {
            Main.controller.changePage(toStudentInformation);
            temp = false;
        }

    }

    /**
     *Description: This is the change page function to course page.
     */
    @FXML
    private void ToCourse() throws IOException {
        if(temp) {
            Main.controller.changePage(toCourse);
            temp = false;
        }

    }

    /**
     *Description: This is the change page function to score management page.
     */
    @FXML
    private void ToScoreManagement() throws IOException {
        if(temp) {
            Main.controller.changePage(toScoreManagement);
            temp = false;
        }

    }

    /**
     *Description: This is the change page function to information page.
     */
    @FXML
    private void ToInformation() throws IOException {
        if(temp) {
            Main.controller.changePage(toAdminInformation);
            temp = false;
        }

    }


    /**
     *Description: This is the change page function to administrator home page.
     */
    @FXML
    private void ToAdministratorHome() throws IOException {
        if(temp) {
            Main.controller.changePage(toAdministratorHome);
            temp = false;
        }

    }

    /**
     *Description: This is the function to read a file in csv format and change it to an info arraylist and return it.
     * @param csvFilePath the file path of the .csv file
     */
    public static ArrayList<Info> CSVtoList1(String csvFilePath) {
        ArrayList<Info> infos = new ArrayList<>();
        String csvSplitBy = ",";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Skip the first line (header)
            while ((line = br.readLine()) != null) {

                String[] values = line.split(csvSplitBy);

                //String.trim()可以吧数据间的空格去掉
                String ID = values[0].trim();
                String classID = values[1].trim();
                String name = values[2].trim();
                String PIN = values[3].trim();

                Info infoObj = new Info(ID, classID, name, PIN);
                infos.add(infoObj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return infos;
    }

    /**
     * Description: This method is for adding student in arraylist and write it into the csv file
     * @param infos the arraylist which store all the information inside.
     * @param csvFilePath the file path of the csv file that you want to change
     * @param ID student identification number, which is one of the import attribute inside an element of info arraylist.
     * @param classID student class ID number, which is one of the import attribute inside an element of info arraylist.
     * @param name student name which is one of the import attribute inside an element of info arraylist.
     * @param PIN student password to log in, which is one of the import attribute inside an element of info arraylist.
     */
    public static void addStudentInfo(ArrayList<Info> infos, String csvFilePath, String ID, String classID, String name, String PIN) {
        Info infoObj = new Info(ID, classID, name, PIN);
        infos.add(infoObj);

        try {
            //String csvFilePath = "./APP/src/main/Student_info.csv";

            // 构建要添加的新行
            String newLine = ID + "," + classID + "," + name + "," + PIN;

            // 将新行追加到 CSV 文件末尾
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath, true));
            writer.write(newLine);
            writer.newLine();
            writer.close();
            System.out.println("CSV 文件修改成功");
        } catch (IOException e) {
            System.out.println("CSV 文件修改失败：" + e.getMessage());
        }
    }


    /**
     *Description: This method is for removing student in arraylist, just by his/her ID
     * @param infos the arraylist which store all the information inside.
     * @param csvFilePath the file path of the csv file that you want to change
     * @param ID student identification number. It is used to search in all the elements in info arraylist and do the match.
     */
    public static void removeStudentInfo(ArrayList<Info> infos, String csvFilePath, String ID) {
        Info studentToRemove = null;
        for (Info info : infos) {
            if (info.getID().equals(ID)) {
                studentToRemove = info;
                break;
            }
        }
        if (studentToRemove != null) {
            infos.remove(studentToRemove);
        }

        try {
            //String csvFilePath = "./APP/src/main/Student_info.csv";
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
                if (data.length >= 2 && data[0].equals(ID)) {
                    // 跳过要删除的行
                    continue;
                }
                // 构建更新后的行
                updatedLines.add(csvLine);
            }

            // 写入更新后的内容到CSV文件
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath));
            for (String csvLine : updatedLines) {
                writer.write(csvLine);
                writer.newLine();
            }
            writer.close();

            System.out.println("CSV文件删除成功");
        } catch (IOException e) {
            System.out.println("CSV文件删除失败：" + e.getMessage());
        }
    }

    /**
     * Description: This method is for updating student in arraylist, first of all we search student by ID, then update all the attributes inside.
     * @param infos the arraylist which store all the information inside.
     * @param csvFilePath the file path of the csv file that you want to change
     * @param ID the student ID number that you want to update.
     * @param newClassID the updated class ID
     * @param newName the updated name
     * @param newPIN the updated password
     */
    public static void updateStudentInfo(ArrayList<Info> infos, String csvFilePath, String ID, String newClassID, String newName, String newPIN) {
        for (Info info : infos) {
            if (info.getID().equals(ID)) {
                info.setClassID(newClassID);
                info.setName(newName);
                info.setPIN(newPIN);
                break;
            }
        }

        try {
            //String csvFilePath = "./APP/src/main/Student_info.csv";
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
                if (data.length >= 2 && data[0].equals(ID)) {
                    // 更新班级ID、姓名和PIN
                    data[1] = newClassID;
                    data[2] = newName;
                    data[3] = newPIN;
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
     * Description: This method is for setup and initialize this page.
     * @param url one of the essential arguments
     * @param resourceBundle one of the essential arguments
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //String[][] studentData = FileIO.Readfile();
        //String[][] studentData = new String[1][2];
        //studentData[0][0] = "Art";
        //studentData[0][1] = "100";

        String csvFilePath = "./APP/src/main/Student_info.csv";
        ArrayList<Info> infos = CSVtoList1(csvFilePath);

        //List<Grade> grades = parseGrades(studentData);
        tableInfo.getItems().addAll(infos);

        setupTable();

        tableInfo.autosizeColumnsOnInitialization();
    }


    /**
     * Description: This method is for setup and initialize the table in this page.
     */
    private void setupTable() {
        //represent the creation of the four column in the table
        //Comparator.comparing(Grade::getName)方法用于对这个"Grade"对象进行排序
        MFXTableColumn<Info> IDColumn = new MFXTableColumn<>("ID", true, Comparator.comparing(Info::getID));
        MFXTableColumn<Info> classIDColumn = new MFXTableColumn<>("classID", true, Comparator.comparing(Info::getClassID));
        MFXTableColumn<Info> nameColumn = new MFXTableColumn<>("NAME", true, Comparator.comparing(Info::getName));
        MFXTableColumn<Info> PINColumn = new MFXTableColumn<>("PIN", true, Comparator.comparing(Info::getPIN));

        //setRowCellFactory方法的作用是用于创建每个单元格的外观和行为。
        IDColumn.setRowCellFactory(grade -> new MFXTableRowCell<>(Info::getID));
        classIDColumn.setRowCellFactory(grade -> new MFXTableRowCell<>(Info::getClassID));
        nameColumn.setRowCellFactory(grade -> new MFXTableRowCell<>(Info::getName));

        PINColumn.setRowCellFactory(grade -> new MFXTableRowCell<>(Info::getPIN) {{
            setAlignment(Pos.CENTER_RIGHT);
        }});
        PINColumn.setAlignment(Pos.CENTER_RIGHT);

        tableInfo.getTableColumns().addAll(IDColumn, classIDColumn, nameColumn, PINColumn);

        //设置表格的过滤器，以便用户可以根据不同的列和属性来筛选和查找表格中的数据。
        tableInfo.getFilters().addAll(
                new StringFilter<>("ID", Info::getID),
                new StringFilter<>("classID",Info::getClassID),
                new StringFilter<>("Name", Info::getName),
                new StringFilter<>("PIN", Info::getPIN)
        );
    }

}
