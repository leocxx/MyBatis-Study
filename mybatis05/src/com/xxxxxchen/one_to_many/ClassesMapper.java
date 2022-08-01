package com.xxxxxchen.one_to_many;

import com.xxxxxchen.bean.Classes;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author KevinWilliams
 */
public interface ClassesMapper {

    @Select("SELECT * FROM classes")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(
                    property = "students",
                    javaType = List.class,
                    column = "id",
                    many = @Many(select = "com.xxxxxchen.one_to_many.StudentMapper.selectByCid")
            )
    })
    public abstract List<Classes> selectAll();
}
