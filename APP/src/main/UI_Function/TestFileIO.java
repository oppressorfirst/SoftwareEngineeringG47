package UI_Function;

/**
 * Title: TestFileIO.java
 * Description:Core function for testing class fileIO
 * Copyright: Copyright (c) 2023/5/25
 * @author Zhongxu Si
 * @version 5.0
 */

public class TestFileIO {
    public void test_file_io() {
        String[][] student_info = FileIO.Readfile("./src/main/Student_info.csv");
        String[][] object_info = Search.keyword_search(student_info, "2020213332",
                FileIO.line_number, FileIO.row_number);

        for (int i = 0; i < Search.object_number; i++) {
            for (int j = 0; j < Search.row_number; j++) {
                System.out.println(object_info[i][j]);
            }
        }
        FileIO.student_CourseScore_write("100", "Art", "Tom");
        FileIO.student_CourseScore_write("95", "Math", "Tom");
    }

}
