package com.study.journey.entity;

import com.study.journey.controller.AdministratorStudentInformationController;
import com.study.journey.controller.StudentGradesController;
import com.study.journey.entity.Grade;
import com.study.journey.entity.Info;
//import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AddUpdateRemoveTest {
    ArrayList<Info> infos = new ArrayList<Info>();
    Info student1 = new Info("11", "2020213333", "Liu", "123456");
    Info student2 = new Info("12", "2020213334", "Si", "234567");
    ArrayList<Grade> grades = new ArrayList<Grade>();

    @Test
    public void test_ParseGrades(){


        String[][] studentData = new String[2][2];
        studentData[0][0] = "Math";
        studentData[0][1] = "99";
        studentData[1][0] = "English";
        studentData[1][1] = "100";
        this.grades = StudentGradesController.parseGrades(studentData);
        Assertions.assertEquals(2, this.grades.size());
        Assertions.assertEquals("Math", this.grades.get(0).getName());
        Assertions.assertEquals("99", this.grades.get(0).getGrade());
        Assertions.assertEquals("English", this.grades.get(1).getName());
        Assertions.assertEquals("100", this.grades.get(1).getGrade());

    }
    @Test
    public void testAddStudentInfo(){
        ArrayList<Info> infos = this.infos;
        infos.add(this.student1);
        AdministratorStudentInformationController.addStudentInfo(infos, "12", "2020213334", "Si", "234567");
        // Test if infos includes the new studentinfo
        Assertions.assertEquals(2, infos.size());

        Assertions.assertEquals("12", infos.get(1).getID());
        Assertions.assertEquals("2020213334", infos.get(1).getClassID());
        Assertions.assertEquals("Si", infos.get(1).getName());
        Assertions.assertEquals("234567", infos.get(1).getPIN());



    }


    @Test
    public void testUpdateStudentInfo(){
        ArrayList<Info> infos = this.infos;
        infos.add(this.student1);
        AdministratorStudentInformationController.updateStudentInfo(infos, "11", "2020213330", "Liuin", "1234567");
        // Test if infos includes the new studentinfo
        Assertions.assertEquals(1, infos.size());
        Assertions.assertEquals("11", infos.get(0).getID());
        Assertions.assertEquals("2020213330", infos.get(0).getClassID());
        Assertions.assertEquals("Liuin", infos.get(0).getName());
        Assertions.assertEquals("1234567", infos.get(0).getPIN());
    }
    @Test
    public void testRemoveStudentInfo(){
        ArrayList<Info> infos = this.infos;

        infos.add(this.student1);
        infos.add(this.student2);
        AdministratorStudentInformationController.removeStudentInfo(this.infos, "11");
        // Test if infos includes the new studentinfo
        Assertions.assertEquals(1, infos.size());
        Assertions.assertEquals("12", infos.get(0).getID());
        Assertions.assertFalse(infos.contains(this.student1));

    }
}
