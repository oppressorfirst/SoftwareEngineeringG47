package com.study.journey.controller;

import com.study.journey.entity.Grade;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.IntegerFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;



public class StudentGradesController implements Initializable {

    public MFXButton backHome;
    public MFXTableView<Grade> table;

    Boolean temp = true; // 防止多次点击
    @FXML
    private void changePage() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(backHome);
            temp = false;
        }
    }

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
}
