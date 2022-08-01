package com.xxxxxchen.one_to_many;

import com.xxxxxchen.bean.Classes;
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
public class Test02 {

    @Test
    public void selectAll() throws Exception{
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        ClassesMapper mapper = sqlSession.getMapper(ClassesMapper.class);

        List<Classes> list = mapper.selectAll();

        for (Classes cls : list) {
            System.out.println(cls.getId() + "," + cls.getName());
            List<Student> students = cls.getStudents();
            for (Student stu : students) {
                System.out.println("\t" + stu);
            }
        }

        sqlSession.close();
        is.close();
    }
}
