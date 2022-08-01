package com.xxxxxchen.one_to_many;

import com.xxxxxchen.bean.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author KevinWilliams
 */
public interface StudentMapper {

    @Select("SELECT * FROM student WHERE cid=#{cid}")
    public abstract List<Student> selectByCid(Integer cid);
}
