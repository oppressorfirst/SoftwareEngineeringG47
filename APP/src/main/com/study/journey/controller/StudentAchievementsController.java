package com.study.journey.controller;

import com.study.journey.Main;
import com.study.journey.entity.Achievement;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.filter.StringFilter;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;

/**
 * Title: StudentAchievementsController.java
 * Description: The controller class for the Student Achievements page. This class handles the logic and functionality of the Student Achievements page. It initializes the table view, reads data from a CSV file, sets up the table columns and filters, and provides methods for navigating back to the home page.
 * Copyright  : Copyright (c) 2023/5/25
 * @author      Ruizhi Yang, Jialun Zhang
 * @version     5.0
 */
public class StudentAchievementsController implements Initializable {
    public MFXButton backHome;
    Boolean temp = true; // 防止多次点击
    /**
     * Represents a table to display achievements.
     * The `table` variable is an instance of the `MFXTableView` class.
     * To initialize the table and populate it with data, you can create a sample table by adding dummy data.
     */
    public MFXTableView<Achievement> table;
    /**
     * Redirects to the home page.
     * This method is called when the user clicks on a specific element (e.g., a button, link) to navigate to the home page.
     * It checks the value of the boolean variable 'temp' to determine if the redirection should occur.
     * If 'temp' is true, it creates an instance of the PageController class and calls the 'changePage' method,
     * passing the 'backHome' button as an argument.
     * After the redirection, it sets the value of 'temp' to false to prevent subsequent redirects.
     *
     * @param mouseEvent the mouse event triggered by the user's click.
     * @throws IOException if an I/O error occurs while redirecting to the home page.
     */
    public void toHome(MouseEvent mouseEvent) throws IOException {

            if(temp) {
                Main.controller.changePage(backHome);
                temp = false;
            }
    }


    /**
     * Reads data from a CSV file and converts it into a list of achievements.
     *
     * @param csvFilePath the path to the CSV file.
     * @return an ArrayList containing the achievements read from the CSV file.
     */
    public static ArrayList<Achievement> CSVtoList2(String csvFilePath) {
        ArrayList<Achievement> achievements = new ArrayList<>();
        String csvSplitBy = ",";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Skip the first line (header)
            while ((line = br.readLine()) != null) {

                String[] values = line.split(csvSplitBy);

                //String.trim()可以吧数据间的空格去掉
                String name = values[0].trim();
                String level = values[1].trim();
                String year = values[2].trim();

                Achievement achievementObj = new Achievement(name, level, year);
                achievements.add(achievementObj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return achievements;
    }


    /**
     * Initializes the controller.
     *
     * @param url the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle the resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String csvFilePath = "./APP/src/main/Achievement.csv";
        ArrayList<Achievement> achievements = CSVtoList2(csvFilePath);
        for (Achievement achievement : achievements) {
            System.out.println(achievement.getName() + " " + achievement.getLevel() + " " + achievement.getYear());
        }
        table.getItems().addAll(achievements);
        setupTable();
        table.autosizeColumnsOnInitialization();
    }


    /**
     * Sets up the table by creating the columns, cell factories, and filters.
     * This method is called during initialization to configure the table for displaying achievements.
     */
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
