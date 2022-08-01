package com.xxxxxchen.many_to_many;

import com.xxxxxchen.bean.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author KevinWilliams
 */
public interface CourseMapper {

    @Select("SELECT c.id,c.name FROM stu_cr sc,course c WHERE sc.cid=c.id AND sc.sid=#{id}")
    public abstract List<Course> selectBySid(Integer id);
}
