package com.study.journey.controller;

import com.study.journey.entity.Achievement;
import com.study.journey.entity.Course;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class StudentCourseSelectionController {
    public MFXButton backHome;
    Boolean temp = true; // 防止多次点击

    public MFXTableView<Course> table; //课程表格，需要构建一下，可以弄个死表格。选课可以将课绑定到学生头上
    public void toHome(MouseEvent mouseEvent) throws IOException {

        if(temp) {
            PageController controller = new PageController();
            controller.changePage(backHome);
            temp = false;
        }
    }
}
