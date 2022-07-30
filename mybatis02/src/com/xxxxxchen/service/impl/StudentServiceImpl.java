package com.xxxxxchen.service.impl;

import com.xxxxxchen.bean.Student;
import com.xxxxxchen.mapper.StudentMapper;
import com.xxxxxchen.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author KevinWilliams
 */
public class StudentServiceImpl implements StudentService {

    /**查询全部*/
    @Override
    public List<Student> selectAll() {
        SqlSession sqlSession = null;
        List<Student> list = null;
        InputStream is = null;
        try {
            /*1.加载核心配置文件*/
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            /*2.获取sqlSession工厂对象*/
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            /*3.通过sqlSession工厂对象获取sqlSession对象*/
            sqlSession = sqlSessionFactory.openSession(true);
            /*4.获取StudentMapper接口实现类的对象*/
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            /*5.通过实现类对象调用方法，接受结果*/
            list = mapper.selectAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            /*6.释放资源*/
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
        /*7.返回结果*/
        return list;
    }

    /**根据id查询*/
    @Override
    public Student selectById(Integer id) {
        SqlSession sqlSession = null;
        Student stu = null;
        InputStream is = null;
        try {
            /*1.加载核心配置文件*/
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            /*2.获取sqlSession工厂对象*/
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            /*3.通过sqlSession工厂对象获取sqlSession对象*/
            sqlSession = sqlSessionFactory.openSession(true);
            /*4.获取StudentMapper接口实现类的对象*/
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            /*5.通过实现类对象调用方法，接受结果*/
            stu = mapper.selectById(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            /*6.释放资源*/
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
        /*7.返回结果*/
        return stu;
    }

    /**新增数据*/
    @Override
    public Integer insert(Student stu) {
        SqlSession sqlSession = null;
        Integer result = null;
        InputStream is = null;
        try {
            /*1.加载核心配置文件*/
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            /*2.获取sqlSession工厂对象*/
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            /*3.通过sqlSession工厂对象获取sqlSession对象*/
            sqlSession = sqlSessionFactory.openSession(true);
            /*4.获取StudentMapper接口实现类的对象*/
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            /*5.通过实现类对象调用方法，接受结果*/
            result = mapper.insert(stu);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            /*6.释放资源*/
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
        /*7.返回结果*/
        return result;
    }

    /**修改数据*/
    @Override
    public Integer update(Student stu) {
        SqlSession sqlSession = null;
        Integer result = null;
        InputStream is = null;
        try {
            /*1.加载核心配置文件*/
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            /*2.获取sqlSession工厂对象*/
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            /*3.通过sqlSession工厂对象获取sqlSession对象*/
            sqlSession = sqlSessionFactory.openSession(true);
            /*4.获取StudentMapper接口实现类的对象*/
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            /*5.通过实现类对象调用方法，接受结果*/
            result = mapper.update(stu);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            /*6.释放资源*/
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
        /*7.返回结果*/
        return result;
    }

    /**删除数据*/
    @Override
    public Integer delete(Integer id) {
        SqlSession sqlSession = null;
        Integer result = null;
        InputStream is = null;
        try {
            /*1.加载核心配置文件*/
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            /*2.获取sqlSession工厂对象*/
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            /*3.通过sqlSession工厂对象获取sqlSession对象*/
            sqlSession = sqlSessionFactory.openSession(true);
            /*4.获取StudentMapper接口实现类的对象*/
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            /*5.通过实现类对象调用方法，接受结果*/
            result = mapper.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            /*6.释放资源*/
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
        /*7.返回结果*/
        return result;
    }
}
