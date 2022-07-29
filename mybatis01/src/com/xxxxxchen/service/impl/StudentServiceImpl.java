package com.xxxxxchen.service.impl;

import com.xxxxxchen.bean.Student;
import com.xxxxxchen.mapper.StudentMapper;
import com.xxxxxchen.mapper.impl.StudentMapperImpl;
import com.xxxxxchen.service.StudentService;

import java.util.List;

/**
 * @author KevinWilliams
 */
public class StudentServiceImpl implements StudentService {

    /**创建持久层对象*/
    private StudentMapper mapper = new StudentMapperImpl();

    /**查询全部*/
    @Override
    public List<Student> selectAll() {
        return mapper.selectAll();
    }

    /**根据id查询*/
    @Override
    public Student selectById(Integer id) {
        return mapper.selectById(id);
    }

    /**新增数据*/
    @Override
    public Integer insert(Student stu) {
        return mapper.insert(stu);
    }

    /**修改数据*/
    @Override
    public Integer update(Student stu) {
        return mapper.update(stu);
    }

    /**删除数据*/
    @Override
    public Integer delete(Integer id) {
        return mapper.delete(id);
    }
}
