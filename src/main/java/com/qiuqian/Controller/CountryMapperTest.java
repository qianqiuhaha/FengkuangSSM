package com.qiuqian.Controller;

import com.qiuqian.entity.Country;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class CountryMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        init();
    }
    public static void init(){
        try{
            Reader reader = Resources.getResourceAsReader("MybatisConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{
         List<Country> selectAll = sqlSession.selectList("selectCountry");
         for (Country country:selectAll){
             System.out.println(country.getId()+"----"+country.getCountryname()+"-----"+country.getCountrycode());
         }
     }finally {
         sqlSession.close();
     }
    }
}
