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
import java.util.Date;
import java.util.ResourceBundle;

public class StudentAchievementsController implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        setupTable();
        table.autosizeColumnsOnInitialization();
    }
    
    private void setupTable() {
        //represent the creation of the four column in the table
        //Comparator.comparing(Grade::getName)方法用于对这个"Grade"对象进行排序
        MFXTableColumn<Achievement> nameColumn = new MFXTableColumn<>("Name", true, Comparator.comparing(Achievement::getName));
        MFXTableColumn<Achievement> levelColumn = new MFXTableColumn<>("Level", true, Comparator.comparing(Achievement::getLevel));
        MFXTableColumn<Achievement> dayColumn = new MFXTableColumn<>("Year", true, Comparator.comparing(Achievement::getYear));

        //setRowCellFactory方法的作用是用于创建每个单元格的外观和行为。
        nameColumn.setRowCellFactory(achievement -> new MFXTableRowCell<>(Achievement::getName));
        levelColumn.setRowCellFactory(achievement -> new MFXTableRowCell<>(Achievement::getLevel));
        dayColumn.setRowCellFactory(achievement -> new MFXTableRowCell<>(Achievement::getYear));


        table.getTableColumns().addAll(nameColumn, levelColumn, dayColumn);

        //设置表格的过滤器，以便用户可以根据不同的列和属性来筛选和查找表格中的数据。
        table.getFilters().addAll(
                new StringFilter<>("Name", Achievement::getName),
                new StringFilter<>("Level", Achievement::getLevel),
                new StringFilter<>("Date", Achievement::getYear)
        );
    }


}
