package com.study.journey.controller;

import com.study.journey.entity.Course;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/**
 * Title: StudentCourseSelectionController.java
 * Description: Controller class for the Student Course Selection page.
 * Copyright  : Copyright (c) 2023/5/25
 * @author      Jialun Zhang
 * @version     5.0
 */
public class StudentCourseSelectionController {
    public MFXButton backHome;
    Boolean temp = true; // 防止多次点击

    /**
     * Represents a table to display achievements.
     * The `table` variable is an instance of the `MFXTableView` class.
     * To initialize the table and populate it with data, you can create a sample table by adding dummy data.
     */
    public MFXTableView<Course> table;
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
            PageController controller = new PageController();
            controller.changePage(backHome);
            temp = false;
        }
    }
}
