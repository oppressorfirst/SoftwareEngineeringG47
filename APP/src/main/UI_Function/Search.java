package UI_Function;

/**
 * Title:Search.java
 * Description: Core function for performing keyword searches on a 2D data array.
 * Copyright: Copyright (c) 2023/5/25
 * @author Zhongxu Si
 * @version 5.0
 */
public class Search {
    protected static int object_number = 0;
    protected static int row_number = 0;

    /**
     * Searches for rows in a 2D data array that contain a specific keyword.
     *
     * @param data_array The 2D array to search.
     * @param keyword The keyword to search for.
     * @param line_number The number of lines in the data array.
     * @param row_number The number of rows in the data array.
     * @return A new 2D array containing rows that match the keyword.
     */
    public static String[][] keyword_search(String[][] data_array, String keyword, int line_number, int row_number) {
        String[][] object_data;
        // 先遍历数组找到所有目标对象
        for (int i = 0; i < line_number - 1; i++) {
            for (int j = 0; j < row_number; j++) {
                if (data_array[i][j].equals(keyword)) {
                    object_number++;
                }
            }
        }
        // 获得目标数据
        object_data = new String[object_number][row_number];
        for (int c = 0; c < object_number; c++) {
            for (int i = 0; i < line_number; i++) {
                for (int j = 0; j < row_number; j++) {
                    if (data_array[i][j].equals(keyword)) {
                        object_data[c] = data_array[i];
                    }
                }
            }
        }
        Search.row_number = row_number;
        return object_data;
    }
}
