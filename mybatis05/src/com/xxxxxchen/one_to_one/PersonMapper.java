package com.xxxxxchen.one_to_one;

import com.xxxxxchen.bean.Person;
import org.apache.ibatis.annotations.Select;

/**
 * @author KevinWilliams
 */
public interface PersonMapper {

    @Select("SELECT * FROM person WHERE id=#{id}")
    public abstract Person selectById(Integer id);
}
