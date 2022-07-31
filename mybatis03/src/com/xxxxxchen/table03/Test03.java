package com.xxxxxchen.table03;

import com.xxxxxchen.bean.Course;
import com.xxxxxchen.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author KevinWilliams
 */
public class Test03 {

    @Test
    public void selectAll() throws Exception{
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        ManyToManyMapper mapper = sqlSession.getMapper(ManyToManyMapper.class);

        List<Student> students = mapper.selectAll();

        for (Student student : students) {
            System.out.println(student.getId() + "," + student.getName() + "," + student.getAge());
            List<Course> courses = student.getCourses();
            for (Course cours : courses) {
                System.out.println("\t" + cours);
            }
        }

        sqlSession.close();
        is.close();
    }
}
