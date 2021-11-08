package com.qiuqian.Controller;

import com.qiuqian.dao.NewsMapperOne;
import com.qiuqian.dao.UserMapper;
import com.qiuqian.domain.Name;
import com.qiuqian.domain.News;
import com.qiuqian.domain.Season;
import com.qiuqian.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class NewsMapper {
    //构建sqlSessionfactory
    public static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) throws IOException {
        String resource="MybatisConfig.xml";
        //资源的导入
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 1. 创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2. 打开SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //打开Sqlsession获取sqlsesion执行sql语句

        KeepNews(sqlSession);


    }
    public static void saveNews( SqlSession sqlSession){

        List<News> selectNews = sqlSession.selectList("selectNews");
       for (News news1:selectNews){
           System.out.println(news1.getId()+"---"+news1.getNews_title()+"------"+news1.getNews_content()+"-------"+news1.getHappenSeason());
       }
        sqlSession.commit();
       sqlSession.close();
    }
    public static void KeepNews(SqlSession sqlSession){
        News news=new News(null,"疯狂教育","疯狂java_WEB真棒", Season.SPRING);
        NewsMapperOne mapper = sqlSession.getMapper(NewsMapperOne.class);
        int i = mapper.saveNews(news);
        System.out.println("已经改变"+i+"数据");
        sqlSession.commit();
        sqlSession.close();

    }
    public static void findUsers(SqlSession sqlSession){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<?> users = mapper.findUsers(-1);

        System.out.println(users);
        sqlSession.commit();
        sqlSession.close();

    }
}
