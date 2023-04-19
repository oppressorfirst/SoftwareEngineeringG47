package UI_Function;

import java.util.ArrayList;
import java.util.Arrays;

public class ReArrange {
    protected String Course_name;
    protected String Score;

    public ReArrange(String Course_name, String Score) {
        this.Course_name = Course_name;
        this.Score = Score;
    }

    // 此方法用于某个学生课程成绩从大到小排列
    public static String[][] max_to_min(String[][] data, int line_number, int row_number) {
        String[][] New_data = new String[line_number][row_number];
        // 转int排列
        int[] int_array = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            int_array[i] = Integer.parseInt(data[i][1]);
        }
        // 从小到大排列
        Arrays.sort(int_array);
        // 转回String
        String[] string_array = new String[int_array.length];

        ArrayList<ReArrange> list_data = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            list_data.add(new ReArrange(data[i][0], data[i][1]));
        }

        for (int c = 0; c < New_data.length; c++) {
            for (int j = 0; j < list_data.size(); j++) {
                if (list_data.get(j).Score.equals(string_array[New_data.length - 1 - c])) {
                    New_data[c][0] = list_data.get(j).Course_name;
                    New_data[c][1] = list_data.get(j).Score;
                    list_data.remove(j);
                }
            }
        }
        list_data.clear();
        return New_data;
    }
}
