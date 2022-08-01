package com.xxxxxchen.one_to_one;

import com.xxxxxchen.bean.Card;
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
    public void selectAll () throws Exception{
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        CardMapper mapper = sqlSession.getMapper(CardMapper.class);

        List<Card> cards = mapper.selectAll();
        for (Card card : cards) {
            System.out.println(card);
        }

        sqlSession.close();
        is.close();
    }
}
