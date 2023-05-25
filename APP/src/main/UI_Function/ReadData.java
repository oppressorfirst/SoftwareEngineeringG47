package UI_Function;

import java.io.*;
/**
 * Title: ReadData.java
 * Description: Core function for reading user input data.
 * Copyright: Copyright (c) 2023/5/25
 * @author Zhongxu Si
 * @version 5.0
 */
public class ReadData {

    /**
     * Reads a string input from the user.
     *
     * @return The string input entered by the user.
     */
    // 这个函数用来读取用户输入的数据，返回值为string类型
    protected static String readString() {
        // 当前等待读取控制台输入的数据，此函数可根据UI界面的不同输入更改
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        // 当前读取字符串
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

}
