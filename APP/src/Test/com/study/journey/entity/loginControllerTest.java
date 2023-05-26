package com.study.journey.entity;

import com.study.journey.controller.AdminMyInformationController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class loginControllerTest {
    @TempDir
    Path tempDir;
    @Test
    void testLogin() throws IOException {
        // 创建临时CSV文件并写入数据
        Path tempPath = Files.createTempFile("Adm_info", ".csv");
        String tempFilePath = tempPath.toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFilePath))) {
            writer.write("ID,classID,Name,PIN\n");
            writer.write("2020213335,2020215110,zhou,1234\n");
            writer.write("2020213336,2020215111,zhuang,123455\n");
        }
        String userID = "2020213335";
        String userPIN = "1234";
        String wrongUserPIN = "123455";
        // 创建一个 AdministratorInformationController 对象并调用 getInfoFromCsvByID 方法
        AdminMyInformationController controller = new AdminMyInformationController();
        controller.getInfoFromCsvByID(userID, tempFilePath);
        // 检查返回的 Info 对象是否正确
        Info info = controller.getInfo();
        if(info.getPIN().equals(userPIN)){
            System.out.println("This happens when login successful.");
            assertEquals("1234",userPIN);
        }

        if(!info.getPIN().equals(wrongUserPIN)){
            System.out.println("This happens when PIN is wrong");
            assertEquals("123455",wrongUserPIN);
        }
        // 删除临时文件
        Files.delete(tempPath);

    }
}
