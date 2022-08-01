package com.xxxxxchen.many_to_many;

import com.xxxxxchen.bean.Student;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author KevinWilliams
 */
public interface StudentMapper {

    @Select("SELECT DISTINCT s.id,s.name,s.age FROM student s,stu_cr sc WHERE sc.sid=s.id")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "age",property = "age"),
            @Result(
                    property = "courses",
                    javaType = List.class,
                    column = "id",
                    many = @Many(select = "com.xxxxxchen.many_to_many.CourseMapper.selectBySid")
            )
    })
    public abstract List<Student> selectAll();
}
