package com.study.journey.entity;

import com.study.journey.controller.*;
import com.study.journey.controller.AdministratorStudentInformationController;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


/**
 * Title      : AdministratorStudentInformationControllerTest.java
 * Description: This class is used to control the page AdminCourseManagementController.java.
 * Copyright  : Copyright (c) 2023/5/25
 * @author      Ziqian Liu
 * @version     5.0
 */

class AdministratorStudentInformationControllerTest {
    @TempDir
    Path tempDir;


    @Test
    void CSVtoList() throws IOException {
        // 创建临时文件
        File tempFile = new File(tempDir.toFile(), "temp.csv");

        // 向临时文件中写入测试数据
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write("Name,Status,Credit,Grade\n");
        writer.write("Math,Passed,4,A\n");
        writer.close();

        // 调用 CSVtoList 方法读取临时文件
        ArrayList<Grade> grades = StudentGradesController.CSVtoList(tempFile.getPath());

        // 检查读取的结果
        assertEquals(1, grades.size());
        Grade grade = grades.get(0);
        assertEquals("Math", grade.getName());
        assertEquals("Passed", grade.getStatus());
        assertEquals(4, grade.getCredit());
        assertEquals("A", grade.getGrade());
    }

    @Test
    void CSVtoList1() throws IOException {
        // 创建临时文件
        File tempFile = new File(tempDir.toFile(), "temp.csv");

        // 向临时文件中写入测试数据
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write("ID,ClassID,Name,PIN\n");
        writer.write("1234,TestClass,Test,TestPin\n");
        writer.close();

        // 调用 CSVtoList1 方法读取临时文件
        ArrayList<Info> infos = AdministratorStudentInformationController.CSVtoList1(tempFile.getPath());

        // 检查读取的结果
        assertEquals(1, infos.size());
        Info info = infos.get(0);
        assertEquals("1234", info.getID());
        assertEquals("TestClass", info.getClassID());
        assertEquals("Test", info.getName());
        assertEquals("TestPin", info.getPIN());
    }


    @Test
    void CSVtoList2() throws IOException {
        // 创建临时文件
        File tempFile = new File(tempDir.toFile(), "temp.csv");

        // 向临时文件中写入测试数据
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write("Name,Level,Year\n");
        writer.write("Champion,Gold,2023\n");
        writer.close();

        // 调用 CSVtoList2 方法读取临时文件
        ArrayList<Achievement> achievements = StudentAchievementsController.CSVtoList2(tempFile.getPath());

        // 检查读取的结果
        assertEquals(1, achievements.size());
        Achievement achievement = achievements.get(0);
        assertEquals("Champion", achievement.getName());
        assertEquals("Gold", achievement.getLevel());
        assertEquals("2023", achievement.getYear());
    }



    @Test
    void CSVtoList3() throws IOException {
        // 创建临时文件
        File tempFile = new File(tempDir.toFile(), "temp.csv");

        // 向临时文件中写入测试数据
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write("Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday\n");
        writer.write("Math,English,Physics,Chemistry,Biology,History,Geography\n");
        writer.close();

        // 调用 CSVtoList3 方法读取临时文件
        ArrayList<Schedule> schedules = StudentScheduleController.CSVtoList3(tempFile.getPath());

        // 检查读取的结果
        assertEquals(1, schedules.size());
        Schedule schedule = schedules.get(0);
        assertEquals("Math", schedule.getMonday());
        assertEquals("English", schedule.getTuesday());
        assertEquals("Physics", schedule.getWednesday());
        assertEquals("Chemistry", schedule.getThursday());
        assertEquals("Biology", schedule.getFriday());
        assertEquals("History", schedule.getSaturday());
        assertEquals("Geography", schedule.getSunday());
    }



    @Test
    void addStudentInfo() throws IOException {

        // 创建空的 Info 列表
        ArrayList<Info> infos = new ArrayList<>();

        // 调用 addStudentInfo 方法添加新的 Info 对象
        String ID = "001";
        String classID = "Class1";
        String name = "Student1";
        String PIN = "123456";

        // Create a temporary file and path
        Path tempPath = Files.createTempFile("Student_info", ".csv");
        String tempFilePath = tempPath.toString();

        // Call the method to test
        AdministratorStudentInformationController.addStudentInfo(infos, tempFilePath, ID, classID, name, PIN);

        // 检查返回的列表
        assertEquals(1, infos.size());
        Info info = infos.get(0);
        assertEquals(ID, info.getID());
        assertEquals(classID, info.getClassID());
        assertEquals(name, info.getName());
        assertEquals(PIN, info.getPIN());

        // 检查 CSV 文件
        try {
            BufferedReader reader = new BufferedReader(new FileReader(tempFilePath));
            String line;
            String lastLine = "";
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }
            reader.close();
            String expectedLastLine = ID + "," + classID + "," + name + "," + PIN;
            assertEquals(expectedLastLine, lastLine);
        } catch (IOException e) {
            fail("Failed to read the CSV file: " + e.getMessage());
        }

        // Delete the temporary file
        Files.delete(tempPath);
    }

    @Test
    void removeStudentInfo() throws IOException {
        // 创建 Info 列表并添加两个 Info 对象
        ArrayList<Info> infos = new ArrayList<>();
        infos.add(new Info("2020213327", "2020215110", "zhang", "123456"));
        infos.add(new Info("2020213326", "2020215109", "sijin", "654321"));

        // 创建临时CSV文件并写入数据
        Path tempPath = Files.createTempFile("Student_info", ".csv");
        String tempFilePath = tempPath.toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFilePath))) {
            writer.write("2020213327,2020215110,zhang,123456\n");
            writer.write("2020213326,2020215109,sijin,654321\n");
        }

        // 调用 removeStudentInfo 方法删除一个 Info 对象
        String ID = "2020213327";
        AdministratorStudentInformationController.removeStudentInfo(infos, tempFilePath, ID);

        // 检查返回的列表
        assertEquals(1, infos.size());
        Info info = infos.get(0);
        assertEquals("2020213326", info.getID());

        // 检查 CSV 文件
        try {
            BufferedReader reader = new BufferedReader(new FileReader(tempFilePath));
            String line;
            String expectedLine = "2020213326,2020215109,sijin,654321";
            while ((line = reader.readLine()) != null) {
                assertEquals(expectedLine, line);
            }
            reader.close();
        } catch (IOException e) {
            fail("Failed to read the CSV file: " + e.getMessage());
        }

        // Delete the temporary file
        Files.delete(tempPath);
    }


    @Test
    void updateStudentInfo() throws IOException {
        // 创建 Info 列表并添加一个 Info 对象
        ArrayList<Info> infos = new ArrayList<>();
        infos.add(new Info("2020213327", "2020215110", "zhang", "123456"));

        // 创建临时CSV文件并写入数据
        Path tempPath = Files.createTempFile("Student_info", ".csv");
        String tempFilePath = tempPath.toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFilePath))) {
            writer.write("2020213327,2020215110,zhang,123456\n");
        }

        // 调用 updateStudentInfo 方法更新 Info 对象
        String ID = "2020213327";
        String newClassID = "2021215110"; //留级了
        String newName = "zhang";
        String newPIN = "654321"; //再改个密码
        AdministratorStudentInformationController.updateStudentInfo(infos, tempFilePath, ID, newClassID, newName, newPIN);

        // 检查返回的列表
        assertEquals(1, infos.size());
        Info info = infos.get(0);
        assertEquals(ID, info.getID());
        assertEquals(newClassID, info.getClassID());
        assertEquals(newName, info.getName());
        assertEquals(newPIN, info.getPIN());

        // 检查 CSV 文件
        try {
            BufferedReader reader = new BufferedReader(new FileReader(tempFilePath));
            String line;
            String expectedLine = ID + "," + newClassID + "," + newName + "," + newPIN;
            while ((line = reader.readLine()) != null) {
                assertEquals(expectedLine, line);
            }
            reader.close();
        } catch (IOException e) {
            fail("Failed to read the CSV file: " + e.getMessage());
        }

        // Delete the temporary file
        Files.delete(tempPath);
    }


    @Test
    void calcGPA() throws IOException {
        // 创建临时CSV文件并写入数据
        Path tempPath = Files.createTempFile("CourseScore", ".csv");
        String tempFilePath = tempPath.toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFilePath))) {
            writer.write("Math,1,5,90\n");
            writer.write("English,-1,4,80\n");
        }

        // 创建 GPA 对象并调用 calcGPA 方法
        GPA gpa = new GPA();
        double calculatedGPA = gpa.calcGPA(tempFilePath);

        // 计算期望的 GPA
        double expectedGPA = 3.25;

        // 比较计算的 GPA 和期望的 GPA
        assertEquals(expectedGPA, calculatedGPA, 0.01);

        // 删除临时文件
        Files.delete(tempPath);
    }


    @Test
    void testGetInfoFromCsvByID() throws IOException {
        // 创建临时CSV文件并写入数据
        Path tempPath = Files.createTempFile("Adm_info", ".csv");
        String tempFilePath = tempPath.toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFilePath))) {
            writer.write("2020213335,2020215110,zhou,1234\n");
            writer.write("2020213336,2020215111,zhuang,123455\n");
        }

        // 创建一个 AdministratorInformationController 对象并调用 getInfoFromCsvByID 方法
        AdminMyInformationController controller = new AdminMyInformationController();
        controller.getInfoFromCsvByID("2020213336", tempFilePath);

        // 检查返回的 Info 对象是否正确
        Info info = controller.getInfo();
        assertEquals("2020213336", info.getID());
        assertEquals("2020215111", info.getClassID());
        assertEquals("zhuang", info.getName());
        assertEquals("123455", info.getPIN());

        // 删除临时文件
        Files.delete(tempPath);
    }







}

