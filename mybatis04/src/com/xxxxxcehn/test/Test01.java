package com.xxxxxcehn.test;

import com.xxxxxcehn.bean.Student;
import com.xxxxxcehn.mapper.StudentMapper;
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
public class Test01 {

    @Test
    public void selectAll() throws Exception{
        /*加载核心配置文件*/
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        /*获取sqlSession工厂对象*/
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        /*通过工厂对象获取sqlSession对象*/
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        /*获取StudentMapper接口的实现类对象*/
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        /*调用接口实现类里的方法 接受结果*/
        List<Student> students = mapper.selectAll();

        /*处理结果*/
        for (Student student : students) {
            System.out.println(student);
        }

        /*释放资源*/
        sqlSession.close();
        is.close();
    }

    @Test
    public void insert() throws Exception{
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student stu = new Student(10,"星星",18);

        Integer result = mapper.insert(stu);

        if(result != 0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }

        sqlSession.close();
        is.close();
    }

    @Test
    public void update() throws Exception{
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student stu = new Student(10,"星星帅哥",19);

        Integer result = mapper.update(stu);

        if(result != 0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

        sqlSession.close();
        is.close();
    }

    @Test
    public void delete() throws Exception{
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Integer result = mapper.delete(10);

        if(result != 0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        sqlSession.close();
        is.close();
    }
}
