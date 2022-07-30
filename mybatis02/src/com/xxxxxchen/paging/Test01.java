package com.xxxxxchen.paging;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
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
 * 分页助手插件使用
 */
public class Test01 {
    @Test
    public void selectPage() throws Exception {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        /*采用分页助手*/
        PageHelper.startPage(1, 3);
        List<Student> students = mapper.selectAll();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
        is.close();
    }
}
