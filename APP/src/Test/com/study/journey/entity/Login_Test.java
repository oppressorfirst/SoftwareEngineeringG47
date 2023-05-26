package com.study.journey.entity;

import UI_Function.FileIO;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class Login_Test {
    @Test
    public void test_login(){
        //student login input
        String ID = "2020213332";
        String PIN = "1234567";
        boolean check = false;
        //data read from Student_info.csv
        String[][] student_info = FileIO.Readfile("./src/main/Student_info.csv");
        System.out.println(Arrays.deepToString(student_info));


        //verify user input
        for (String[] strings : student_info) {
            if (strings[0].equals(ID)&&strings[3].equals(PIN)) {
                System.out.println("User ID correct!");
                System.out.println("User PIN correct!");
                System.out.println("Login successfully!");
                check = true;
                break;
            }
        }

    }
}
