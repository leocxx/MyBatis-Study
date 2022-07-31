package com.xxxxxchen.table02;

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

        OneToManyMapper mapper = sqlSession.getMapper(OneToManyMapper.class);

        List<Classes> classes = mapper.selectAll();

        for (Classes cls : classes) {
            System.out.println(cls.getId() + "," + cls.getName());
            List<Student> students = cls.getStudents();
            System.out.println("\t" + students);
        }

        sqlSession.close();
        is.close();
    }
}
