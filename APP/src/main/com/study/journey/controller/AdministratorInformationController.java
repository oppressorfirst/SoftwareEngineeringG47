package com.study.journey.controller;

import UI_Function.FileIO;
import com.study.journey.model.Grade;
import com.study.journey.model.Info;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.IntegerFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.fxml.FXML;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.io.IOException;

public class AdministratorInformationController implements Initializable{
    public MFXButton toAdministratorHome;
    public MFXTableView<Info> tableInfo;

    Boolean temp = true; // 防止多次点击

    @FXML
    private void ToAdministratorHome() throws IOException {
        if(temp) {
            PageController controller = new PageController();
            controller.changePage(toAdministratorHome);
            temp = false;
        }

    }

    //妈的直接把文件写成List吧，不用数组了，烦死了！！！
    public static List<Info> CSVtoList1(String csvFilePath) {
        List<Info> infoList = new ArrayList<>();
        String csvSplitBy = ",";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Skip the first line (header)
            while ((line = br.readLine()) != null) {

                String[] values = line.split(csvSplitBy);

                //String.trim()可以吧数据间的空格去掉
                String ID = values[0].trim();
                String name = values[1].trim();
                String PIN = values[2].trim();

                Info infoObj = new Info(ID, name, PIN);
                infoList.add(infoObj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return infoList;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //String[][] studentData = FileIO.Readfile();
        //String[][] studentData = new String[1][2];
        //studentData[0][0] = "Art";
        //studentData[0][1] = "100";

        String csvFilePath = "./APP/src/main/Student_info.csv";
        List<Info> infoList = CSVtoList1(csvFilePath);

        //List<Grade> grades = parseGrades(studentData);
        tableInfo.getItems().addAll(infoList);

        setupTable();

        tableInfo.autosizeColumnsOnInitialization();
    }

    private void setupTable() {
        //represent the creation of the four column in the table
        //Comparator.comparing(Grade::getName)方法用于对这个"Grade"对象进行排序
        MFXTableColumn<Info> IDColumn = new MFXTableColumn<>("ID", true, Comparator.comparing(Info::getID));
        MFXTableColumn<Info> nameColumn = new MFXTableColumn<>("NAME", true, Comparator.comparing(Info::getName));
        MFXTableColumn<Info> PINColumn = new MFXTableColumn<>("PIN", true, Comparator.comparing(Info::getPIN));

        //setRowCellFactory方法的作用是用于创建每个单元格的外观和行为。
        IDColumn.setRowCellFactory(grade -> new MFXTableRowCell<>(Info::getID));
        nameColumn.setRowCellFactory(grade -> new MFXTableRowCell<>(Info::getName));
        PINColumn.setRowCellFactory(grade -> new MFXTableRowCell<>(Info::getPIN) {{
            setAlignment(Pos.CENTER_RIGHT);
        }});
        PINColumn.setAlignment(Pos.CENTER_RIGHT);

        tableInfo.getTableColumns().addAll(IDColumn, nameColumn, PINColumn);

        //设置表格的过滤器，以便用户可以根据不同的列和属性来筛选和查找表格中的数据。
        tableInfo.getFilters().addAll(
                new StringFilter<>("ID", Info::getID),
                new StringFilter<>("Name", Info::getName),
                new StringFilter<>("PIN", Info::getPIN)
        );
    }

}
