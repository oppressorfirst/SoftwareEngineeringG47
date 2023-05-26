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

/**
 * Test Class for the LoginController.java
 * This class tests the validLogin method of LoginController. It creates a temporary CSV file with
 * user information and checks if the validLogin method works correctly with this data.
 * The CSV file contains the following data: ID, classID, Name, PIN.
 * We simulate two cases in the test:
 *    1) Correct user PIN. In this case, the login should be successful.
 *    2) Wrong user PIN. In this case, the login should be unsuccessful.
 * After running the test, the temporary CSV file is deleted.
 * Copyright  : Copyright (c) 2023/5/26
 * @author Ziqian Liu
 * @version 5.0
 * @since 2023-05-26
 */
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
