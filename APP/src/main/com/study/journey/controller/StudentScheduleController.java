package com.study.journey.controller;

import com.study.journey.entity.Course;
import com.study.journey.entity.Schedule;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class StudentScheduleController {
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
}
