package com.study.journey.controller;

import com.study.journey.entity.Achievement;
import com.study.journey.entity.Grade;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.IntegerFilter;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;

public class StudentAchievementsController  {
    public MFXButton backHome;
    Boolean temp = true; // 防止多次点击

    public MFXTableView<Achievement> table; //成就表格，需要构建一下，可以弄个死表格。
    public void toHome(MouseEvent mouseEvent) throws IOException {

            if(temp) {
                PageController controller = new PageController();
                controller.changePage(backHome);
                temp = false;
            }
    }



}
