package com.xxxxxchen.one_to_one;

import com.xxxxxchen.bean.Card;
import com.xxxxxchen.bean.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author KevinWilliams
 */
public interface CardMapper {

    @Select("SELECT * FROM card")
    @Results({
            @Result(column = "id", property = "id"),

            @Result(column = "number", property = "number"),

            @Result(property = "p",   //被包含对象变量名称
                    javaType = Person.class,  //被包含对象实际数据类型
                    column = "pid", //根据查询出来的card表中的pid字段来查询person表
                    /*
                    * one = @One 一对一的固定写法
                    * select属性指定调用哪个接口中的哪个方法
                    * */
                    one = @One(select = "com.xxxxxchen.one_to_one.PersonMapper.selectById")
            )
    })
    public abstract List<Card> selectAll();
}
