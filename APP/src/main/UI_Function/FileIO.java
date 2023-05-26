package UI_Function;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Title: FileIO.java
 * Description: The core function of file input/output operations. Connect UI with back-end file.
 * Copyright: Copyright (c) 2023/5/25
 * @author Zhongxu Si
 * @version 5.0
 */
public class FileIO {
    protected static int line_number = -1;
    protected static int row_number = 0;

    // 这个函数用来将学生单科课程成绩以csv格式保存下来，输入为：课程名；课程分数；学生姓名
    /**
     * Writes the course score for a student to a CSV file.
     *
     * @param CourseScore The course score to be written.
     * @param CourseName The name of the course.
     * @param Student The name of the student.
     */
    protected static void student_CourseScore_write(String CourseScore, String CourseName, String Student) {
        // 每个学生的课程成绩储存文件统一命名为：姓名+CourseScore.csv
        File writefile = new File("./UI_Function/" + Student + "_CourseScore.csv");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(writefile, true));
            writer.newLine();
            writer.write(CourseName + "," + CourseScore);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("no such file");
        } catch (IOException e) {
            System.out.println("file reading break up");
        }
    }

    // 这个函数用来将学生信息以csv格式保存下来，输入为：学号；姓名；密码
    /**
     * Writes student information to a file.
     *
     * @param ID The ID of the student.
     * @param Name The name of the student.
     * @param PIN The PIN of the student.
     */
    protected static void Write_file(String ID, String Name, String PIN) {
        // 读取文件的相对路径
        File writerfile = new File("Student_info.csv");
        // 写入位置和格式根据不同UI界面的功能要求做更改
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(writerfile, true));
            writer.newLine();
            writer.write(ID + "," + Name + "," + PIN);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("no such file");
        } catch (IOException e) {
            System.out.println("file reading break up");
        }
    }

    // 这个函数用来读取存入csv格式文件的信息，返回值为包含文件的所有信息的二维数组
    /**
     * Reads data from a CSV file and returns it as a 2D array of strings.
     *
     * @return A 2D array of strings containing the data from the CSV file.
     */
    public static String[][] Readfile(String file_path) {
//        String csvFilePath = "./src/main/Student_info.csv";
        File readFile = new File(file_path);
        String csvSplitBy = ",";
        String[][] student_data;
        // 读取文件总行数
        try {
            LineNumberReader read_line = new LineNumberReader(new FileReader(readFile));
            while (read_line.readLine() != null) {
                line_number++;
            }
            read_line.mark((int) readFile.length() + 1);
            read_line.reset();
            read_line.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 读取文件总列数
        try {
            BufferedReader reader = new BufferedReader(new FileReader(readFile));
            String linedata = "";
            reader.readLine();
            linedata = reader.readLine();
            String[] line_data = linedata.split(csvSplitBy);
            row_number = line_data.length;
            reader.mark((int) readFile.length() + 1);
            reader.reset();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        student_data = new String[line_number][row_number];
        // 接下来将文件中数据读取到一个二位数组中
        try {
            BufferedReader reader = new BufferedReader(new FileReader(readFile));
            String linedata = "";
            // 跳过第一行数据名称
            reader.readLine();
            // 按行读取数据
            for (int i = 0; i < line_number; i++) {
                if ((linedata = reader.readLine()) != null) {
                    String[] line_data = linedata.split(csvSplitBy);
                    for (int j = 0; j < line_data.length; j++) {
                        student_data[i][j] = line_data[j];
                    }
                }
            }
            reader.mark((int) readFile.length() + 1);
            reader.reset();
            reader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("No such file");
        } catch (IOException exception) {
            System.out.println("File reading break up");
        }

        return student_data;

    }

}
