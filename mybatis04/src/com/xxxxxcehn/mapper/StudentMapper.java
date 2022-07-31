package com.xxxxxcehn.mapper;

import com.xxxxxcehn.bean.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author KevinWilliams
 */
public interface StudentMapper {

    @Select("SELECT * FROM student")
    public abstract List<Student> selectAll();

    @Insert("INSERT INTO student VALUES (#{id},#{name},#{age})")
    public abstract Integer insert(Student stu);

    @Update("UPDATE  student SET name=#{name},age=#{age} WHERE id=#{id}")
    public abstract Integer update(Student stu);

    @Delete("DELETE FROM student WHERE id=#{id}")
    public abstract Integer delete(Integer id);
}
