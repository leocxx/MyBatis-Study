package com.xxxxxchen.mapper;

import com.xxxxxchen.bean.Student;
import com.xxxxxchen.sql.ReturnSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author KevinWilliams
 */
public interface StudentMapper {

    @SelectProvider(type = ReturnSql.class , method = "getSelectAll")
    public abstract List<Student> selectAll();

    @InsertProvider(type = ReturnSql.class, method = "getInsert")
    public abstract Integer insert(Student stu);

    @UpdateProvider(type = ReturnSql.class,method = "getUpdate")
    public abstract Integer update(Student stu);

    @DeleteProvider(type = ReturnSql.class,method = "getDelete")
    public abstract Integer delete(Integer id);
}
