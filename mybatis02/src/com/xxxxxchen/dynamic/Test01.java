package com.xxxxxchen.dynamic;

import com.xxxxxchen.bean.Student;
import com.xxxxxchen.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author KevinWilliams
 * 动态sql多条件查询
 */
public class Test01 {

    @Test
    public void selectByIds() throws Exception {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);

        List<Student> students = mapper.selectByIds(ids);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
        is.close();
    }

    @Test
    public void selectCondition() throws Exception {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student stu = new Student();
        stu.setId(2);
        stu.setName("李四");
        //stu.setAge(24);

        List<Student> list = mapper.selectCondition(stu);
        for (Student student : list) {
            System.out.println(student);
        }
        sqlSession.close();
        is.close();
    }
}
