package com.study.journey.entity;

import com.study.journey.controller.AdministratorStudentInformationController;
import com.study.journey.controller.StudentHomeController;
import com.study.journey.controller.StudentGradesController;
import com.study.journey.controller.StudentInformationController;
import com.study.journey.entity.Grade;
import com.study.journey.entity.Info;
import com.study.journey.entity.Student;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfoTests {
    ArrayList<Info> infos = new ArrayList<Info>();
    Info student1 = new Info("11", "2020213333", "Liu", "123456");
    Info student2 = new Info("12", "2020213334", "Si", "234567");
    ArrayList<Grade> grades = new ArrayList<Grade>();
    @Test
    public void test_CSVtoList1(){
        String csvFilePath = "./APP/src/main/Student_info.csv";
        ArrayList<Info> infos = AdministratorStudentInformationController.CSVtoList1(csvFilePath);
        // Test if infos equal to the student.csv
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
            String line = null;
            if ((line = reader.readLine()) != null) {
                while ((line = reader.readLine()) != null) {
                    String[] item = line.split(",");
                    int i = 0;
                    for (Info info : infos) {
                        if (info.getID().equals(item[0])) {
                            i++;
                            assertEquals(item[1], info.getClassID());
                            assertEquals(item[2], info.getName());
                            assertEquals(item[3], info.getPIN());
                        }
                    }

                    assertEquals(1, i);


                }
            }
        }
        catch(IOException e) {
            System.out.println("1");
        }
    }


    @Test
    public void test_CSVtoList(){
        String csvFilePath = "./APP/src/main/CourseScore.csv";
        this.grades = StudentGradesController.CSVtoList(csvFilePath);
        // Test if grades equal to the grades.csv
        try{
            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
            String line = null;
            int i = 0;
            if ((line = reader.readLine()) != null){
                while((line = reader.readLine()) != null){
                    String[] item = line.split(",");
                    int credit = Integer.parseInt(item[2]);
                    assertEquals(item[0], grades.get(i).getName());
                    assertEquals(item[1], grades.get(i).getStatus());
                    assertEquals(credit, grades.get(i).getCredit());
                    assertEquals(item[3], grades.get(i).getGrade());

                    i++;
                }
            }
        }
        catch(IOException e){
            System.out.println("1");
        }


    }
    //Test the method getInfoFromCsvByID(), getInfoFromCsvByName() in class StudentHomeController
//    @Test
//    public void test_GetInfoFromCsvByName(){
//        StudentHomeController Controller = new StudentHomeController();
//        Controller.name = "sizhongxu";
//        Info student = Controller.getInfoFromCsvByID();
//        assertEquals("2020213332", student.getID());
//        assertEquals("2020215110", student.getClassID());
//        assertEquals("sizhongxu", student.getName());
//        assertEquals("12345678", student.getPIN());
//    }
    //Test the method getInfoFromCsvByID(String ID), updateCsvFile(String accountId, String newPin) in class StudentInformationController
    // @Test
    // public void testGetInfoFromCsvByID(){
    //     String csvFilePath = "APP\\src\\main\\com\\study\\journey\\data\\student.csv";
    //     List<String[]> list = StudentInformationController.getInfoFromCsvByID(csvFilePath, "2020213333");
    //     assertEquals(1, list.size());
    // }
    @Test
    public void test_UpdateCsvFile(){

        StudentInformationController Controller = new StudentInformationController();
        Controller.updateCsvFile("2020213332", "123456");
        // Test if D:\air\java\ruangonglab\SoftwareEngineeringG47-1\APP\src\main\Student_info.csv includes the newPin
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./APP/src/main/Student_info.csv"));
            String line = null;
            int i = 0;
            if ((line = reader.readLine()) != null) {
                while ((line = reader.readLine()) != null) {
                    String[] item = line.split(",");
                    if (item[0].equals("2020213332")) {
                        assertEquals(item[3], "123456");
                    }

                    i++;
                }
            }
            Controller.updateCsvFile("2020213332", "12345678");
        }
        catch(IOException e) {
            System.out.println("1");
        }
    }
}



