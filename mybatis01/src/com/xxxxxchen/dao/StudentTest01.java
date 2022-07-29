package com.xxxxxchen.dao;

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
public class StudentTest01 {

    /**删除数据*/
    @Test
    public void delete() throws Exception{
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int result = sqlSession.update("StudentMapper.delete", 5);
        sqlSession.commit();
        if (result != 0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
        sqlSession.close();
        is.close();
    }
    /**修改数据*/
    @Test
    public void update() throws Exception{
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student stu = new Student(5,"周七",47);
        int result = sqlSession.update("StudentMapper.update", stu);
        sqlSession.commit();
        if (result != 0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
        sqlSession.close();
        is.close();
    }
    /**添加数据*/
    @Test
    public void insert() throws Exception{
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student stu = new Student(5,"周七",27);
        int result = sqlSession.insert("StudentMapper.insert", stu);
        //注意：在openSession()里没有开启事务，默认关闭，需要手动提交，这样才能添加到数据库中
        sqlSession.commit();
        if (result != 0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        sqlSession.close();
        is.close();
    }
    /**根据id查询*/
    @Test
    public void selectById() throws Exception{
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student stu = sqlSession.selectOne("StudentMapper.selectById", 3);
        System.out.println(stu);
        sqlSession.close();
        is.close();
    }
    /**查询全部*/
    @Test
    public void selectAll() throws Exception{
        /*1.加载核心配置文件*/
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        /*2.获取sqlSession工厂对象*/
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        /*3.通过sqlSession工厂对象获取sqlSession对象*/
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /*4.执行映射配置文件中的sql语句，并接受结果*/
        List<Student> list = sqlSession.selectList("StudentMapper.selectAll");
        /*5.处理结果*/
        for (Student stu : list) {
            System.out.println(stu);
        }
        /*6.释放资源*/
        sqlSession.close();
        is.close();
    }}
