package com.qiuqian.reflect.ObjectFactory;

import com.qiuqian.domain.User;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserFactory extends DefaultObjectFactory {
    private String author;
    public Object create(Class type){
        //调用父类的方法创建对象
        Object o = super.create(type);
        return processObject(o);
    }
    //Mybatis使用有参数的构造器创建对象,调用该方法
    public <T> T crate(Class<T> type, List<Class<?>> constructorArgType,List<Object> constructorArgs){
        //调用父类的方法创建对象
        T  ob=super.create(type,constructorArgType,constructorArgs);
        //调用processObject对于调用的方法进行额外的处理
        return (T)processObject(ob);
    }
    //用于接受对象的配置信息
    public void setProperties(Properties properties){
        //调用父类的方法
        super.setProperties(properties);
        //为对象工厂设置属性
        this.author=properties.getProperty("author");
    }
    //mybatis使用无参的构造器创建对象工厂
    public Object processObject(Object ob){
        if(ob instanceof User){
            User user=(User)ob;
            Map<String, Object> meta = user.getMeta();
            user.getMeta().put("author",author);
            user.getMeta().put("viewDate",new Date());
            return user;
        }else{
            return ob;
        }
    }

}
