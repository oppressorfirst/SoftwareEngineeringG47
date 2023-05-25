package com.study.journey.controller;

import com.study.journey.entity.Info;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.util.ArrayList;

import static com.study.journey.controller.AdministratorStudentInformationController.CSVtoList1;

public class LoginController {
    public MFXRadioButton AdminRadioBtu;
    public MFXRadioButton StudentRadioBtu;
    @FXML
    private MFXButton toHome;

    @FXML
    public MFXTextField userID;
    @FXML
    private MFXTextField passWord;
    boolean rejectDoubleCheck = true;
    public String name;
    public String ID;


    public Info info;

    public Info getInfoFromCsvByID() { // 这个方法根据 ID 返回一个特定的学生信息
        String csvFilePath = "./APP/src/main/Student_info.csv";
        ArrayList<Info> infos = CSVtoList1(csvFilePath); //直接调用AdministratorInformationController中的静态方法读文件并写入Arraylist中

        if(userID!=null)
            ID = userID.getText(); // 要搜索的特定ID值
        Info info = null;


        for (Info element : infos) {
            if (element.getID().equals(ID)) { // 根据特定值进行匹配
                info = element; // 找到匹配的元素
            }
        }

        return info;
    }

    public Info getAdmInfoFromCsvByID() { // 这个方法根据 Name 返回一个特定的学生信息
        String csvFilePath = "./APP/src/main/Adm_info.csv";
        ArrayList<Info> infos = CSVtoList1(csvFilePath); //直接调用AdministratorInformationController中的静态方法读文件并写入Arraylist中

        if(userID!=null)
            ID = userID.getText(); // 要搜索的特定名字值
        Info info = null;


        for (Info element : infos) {
            if (element.getID().equals(ID)) { // 根据特定值进行匹配
                info = element; // 找到匹配的元素
            }
        }

        return info;
    }

    // 用于判断用户是否有权利登录 （nicolas Yang）
    private int validLogin(String userID, String password){

        // 真正的判断函数
        //对学生端的判断
        if (StudentRadioBtu.isSelected()) {
            this.info = getInfoFromCsvByID();
            // 预定义的用户名和密码,之后删，并换成csv.文件的形式（nicolas）
            String validUsername_stu = this.info.getID();
            String validPassword_stu = this.info.getPIN();
            if (userID.equals(validUsername_stu) && password.equals(validPassword_stu) && rejectDoubleCheck) {
                    rejectDoubleCheck = false;
                    return 1;
            }else if (userID.isEmpty()) {
                return 2;
            } else if (password.isEmpty()) {
                return 2;
            }else {
                return 3;
            }
            //对管理员端的判断
        } else if (AdminRadioBtu.isSelected()) {
            this.info = getAdmInfoFromCsvByID();
            // 预定义的用户名和密码,之后删，并换成csv.文件的形式（nicolas）
            String validUsername_adm = this.info.getID();
            String validPassword_adm = this.info.getPIN();
            if (userID.equals(validUsername_adm) && password.equals(validPassword_adm) && rejectDoubleCheck) {
                    rejectDoubleCheck = false;
                    return 5;

            }else if (userID.isEmpty()) {
                return 2;
            } else if (password.isEmpty()) {
                return 2;
            }else {
                return 3;
            }
        } else {
            return 4;
        }
    }


    @FXML
    private void Login() throws IOException {
            int goStuNum = 1;
            int goAdmNum = 2;

            String userid;
            String password;
            userid = userID.getText();
            password = passWord.getText();
            //this.info = getInfoFromCsvByName();

            PageController controller = new PageController();
            switch (validLogin(userid, password)) { // 开始匹配
                case 1:
                    controller.changePage(toHome,goStuNum,userid);
                    System.out.println("登录学生端成功");
                    break;
                case 2:
                    System.out.println("别输空的东西或者是乱输东西！！");
                    break;
                case 3:
                    /* exit(Stage stage);*/
                    System.out.println("用户名密码不匹配或用户不存在");
                    break;
                case 4:
                    System.out.println("请选择是要adm还是stu");
                    break;
                case 5:
                    controller.changePage(toHome,goAdmNum,userid); //之后改
                    System.out.println("登录管理员端成功");
                    break;
            }
            /*temp = false;*/


    }

    public void onlyOneChecked() {
        ToggleGroup toggleGroup = new ToggleGroup();    //单选组
        AdminRadioBtu.setToggleGroup(toggleGroup);  //将两个选项放入同一个组
        StudentRadioBtu.setToggleGroup(toggleGroup);
        toggleGroup.selectToggle(StudentRadioBtu);  //默认选择
    }
}
