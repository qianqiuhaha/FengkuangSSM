package com.qiuqian.Controller;

public class UserServiceImpl implements UserService{
    public Integer userLogin(String name,String pass){
        if (name.equals("crazyit.org")&&pass.equals("123456")){
            return 19;
        }
        return -1;
    }
}
