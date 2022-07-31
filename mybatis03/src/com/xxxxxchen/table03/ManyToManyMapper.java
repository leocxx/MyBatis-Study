package com.xxxxxchen.table03;

import com.xxxxxchen.bean.Student;

import java.util.List;

/**
 * @author KevinWilliams
 */
public interface ManyToManyMapper {
    public abstract List<Student> selectAll();
}
