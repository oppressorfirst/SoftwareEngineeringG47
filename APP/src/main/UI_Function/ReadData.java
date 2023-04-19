package UI_Function;

import java.io.*;

public class ReadData {

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
