package com.study.journey.controller;

import com.study.journey.entity.Course;
import com.study.journey.entity.Grade;
import com.study.journey.entity.Schedule;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.IntegerFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;

public class StudentScheduleController implements Initializable {
    public MFXButton backHome;
    public TableView<Schedule> schedule;
    public TableColumn<Schedule, Integer> Num;
    public TableColumn<Schedule, String> Monday;
    public TableColumn<Schedule, String> Tuesday;
    public TableColumn<Schedule, String> Wednesday;
    public TableColumn<Schedule, String> Thursday;
    public TableColumn<Schedule, String> Friday;
    public TableColumn<Schedule, String> Saturday;
    public TableColumn<Schedule, String> Sunday;
    Boolean temp = true; // 防止多次点击
    
    public void toHome(MouseEvent mouseEvent) throws IOException {

        if(temp) {
            PageController controller = new PageController();
            controller.changePage(backHome);
            temp = false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //String[][] studentData = FileIO.Readfile();
        //String[][] studentData = new String[1][2];
        //studentData[0][0] = "Art";
        //studentData[0][1] = "100";

        String csvFilePath = "./APP/src/main/Schedule.csv";

        ArrayList<Schedule> schedules = CSVtoList3(csvFilePath);

        for (Schedule schedule : schedules) {
            System.out.println(schedule.getMonday() + " " + schedule.getTuesday() + " " + schedule.getWednesday() + " " + schedule.getThursday() + " " + schedule.getFriday() + " " + schedule.getSaturday() + " " + schedule.getSunday());
        }

        //List<Grade> grades = parseGrades(studentData);
        schedule.getItems().addAll(schedules);

        setupTable();

        //schedule.autosizeColumnsOnInitialization();
        schedule.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

    public static ArrayList<Schedule> CSVtoList3(String csvFilePath) {
        ArrayList<Schedule> schedules = new ArrayList<>();
        String csvSplitBy = ",";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Skip the first line (header)
            while ((line = br.readLine()) != null) {

                String[] values = line.split(csvSplitBy);

                //String.trim()可以吧数据间的空格去掉
                String monday = values[0].trim();
                String tuesday = values[1].trim();
                String wednesday = values[2].trim();
                String thursday = values[3].trim();
                String friday = values[4].trim();
                String saturday = values[5].trim();
                //System.out.println("OK");
                String sunday = values[6].trim();

                Schedule scheduleObj = new Schedule(monday, tuesday, wednesday, thursday, friday, saturday, sunday);

                schedules.add(scheduleObj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return schedules;
    }



    private void setupTable() {
        //represent the creation of the four column in the table
        //Comparator.comparing(Grade::getName)方法用于对这个"Grade"对象进行排序
        TableColumn<Schedule, String> MondayColumn = new TableColumn<>("Monday");
        TableColumn<Schedule, String> TuesdayColumn = new TableColumn<>("Tuesday");
        TableColumn<Schedule, String> WednesdayColumn = new TableColumn<>("Wednesday");
        TableColumn<Schedule, String> ThursdayColumn = new TableColumn<>("Thursday");
        TableColumn<Schedule, String> FridayColumn = new TableColumn<>("Friday");
        TableColumn<Schedule, String> SaturdayColumn = new TableColumn<>("Saturday");
        TableColumn<Schedule, String> SundayColumn = new TableColumn<>("Sunday");



        MondayColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMonday()));
        TuesdayColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTuesday()));
        WednesdayColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getWednesday()));
        ThursdayColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getThursday()));
        FridayColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFriday()));
        SaturdayColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSaturday()));
        SundayColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSunday()));

        schedule.getColumns().clear(); // 清空表格视图的列
        schedule.getColumns().addAll(MondayColumn,TuesdayColumn, WednesdayColumn, ThursdayColumn, FridayColumn, SaturdayColumn, SundayColumn);


    }
}
