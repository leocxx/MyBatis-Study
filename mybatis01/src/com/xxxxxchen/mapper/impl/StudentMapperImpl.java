package com.xxxxxchen.mapper.impl;

import com.xxxxxchen.bean.Student;
import com.xxxxxchen.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author KevinWilliams
 */
public class StudentMapperImpl implements StudentMapper {
    /**查询全部*/
    @Override
    public List<Student> selectAll() {
        List<Student> list = null;
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            /*1.加载核心配置文件*/
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            /*2.获取sqlSession工厂对象*/
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            /*3.通过sqlSession工厂对象获取sqlSession对象*/
            sqlSession = sqlSessionFactory.openSession(true);
            /*4.执行映射配置文件中的sql语句，并接受结果*/
            list = sqlSession.selectList("StudentMapper.selectAll");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            if(sqlSession != null){
                sqlSession.close();
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    /**根据id查询*/
    @Override
    public Student selectById(Integer id) {
        Student stu = null;
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            /*1.加载核心配置文件*/
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            /*2.获取sqlSession工厂对象*/
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            /*3.通过sqlSession工厂对象获取sqlSession对象*/
            sqlSession = sqlSessionFactory.openSession(true);
            /*4.执行映射配置文件中的sql语句，并接受结果*/
            stu = sqlSession.selectOne("StudentMapper.selectById", id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            if(sqlSession != null){
                sqlSession.close();
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stu;
    }

    /**新增数据*/
    @Override
    public Integer insert(Student stu) {
        Integer result = null;
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            /*1.加载核心配置文件*/
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            /*2.获取sqlSession工厂对象*/
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            /*3.通过sqlSession工厂对象获取sqlSession对象*/
            sqlSession = sqlSessionFactory.openSession(true);
            /*4.执行映射配置文件中的sql语句，并接受结果*/
            result = sqlSession.insert("StudentMapper.insert",stu);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            if(sqlSession != null){
                sqlSession.close();
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**修改数据*/
    @Override
    public Integer update(Student stu) {
        Integer result = null;
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            /*1.加载核心配置文件*/
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            /*2.获取sqlSession工厂对象*/
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            /*3.通过sqlSession工厂对象获取sqlSession对象*/
            sqlSession = sqlSessionFactory.openSession(true);
            /*4.执行映射配置文件中的sql语句，并接受结果*/
            result = sqlSession.update("StudentMapper.update",stu);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            if(sqlSession != null){
                sqlSession.close();
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**删除数据*/
    @Override
    public Integer delete(Integer id) {
        Integer result = null;
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            /*1.加载核心配置文件*/
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            /*2.获取sqlSession工厂对象*/
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            /*3.通过sqlSession工厂对象获取sqlSession对象*/
            sqlSession = sqlSessionFactory.openSession(true);
            /*4.执行映射配置文件中的sql语句，并接受结果*/
            result = sqlSession.delete("StudentMapper.delete",id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            if(sqlSession != null){
                sqlSession.close();
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
