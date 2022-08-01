package com.xxxxxchen.many_to_many;

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

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = mapper.selectAll();
        for (Student stu : students) {
            System.out.println(stu.getId() + "," + stu.getName() + "," + stu.getAge());
            List<Course> courses = stu.getCourses();
            for (Course cours : courses) {
                System.out.println("\t" + cours);
            }
        }
        sqlSession.close();
        is.close();
    }
}
