package com.xxxxxchen.controller;

import com.xxxxxchen.bean.Student;
import com.xxxxxchen.service.StudentService;
import com.xxxxxchen.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author KevinWilliams
 * 控制层测试类
 */
public class StudentController {

    /**
     * 创建业务层对象
     */
    private StudentService service = new StudentServiceImpl();

    /**
     * 查询全部
     */
    @Test
    public void selectAll() {
        List<Student> students = service.selectAll();
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    /**
     * 根据id查询
     */
    @Test
    public void selectById() {
        Student stu = service.selectById(3);
        System.out.println(stu);
    }

    /**
     * 新增数据
     */
    @Test
    public void insert() {
        Student stu = new Student(9,"翠翠",17);
        Integer result = service.insert(stu);
        System.out.println(result);
    }

    /**修改数据*/
    @Test
    public void update(){
        Student stu = new Student(5,"周七",98);
        Integer result = service.update(stu);
        System.out.println(result);
    }

    /**删除数据*/
    @Test
    public void delete(){
        Integer result = service.delete(5);
        System.out.println(result);
    }
}
