package com.qiuqian.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    //依赖注入UserService组件
    private UserService userService;
    //@postMapping指定该方法处理login请求
    @GetMapping("/login")
    public  String login(String username, String pass, Model model){
        if( userService.userLogin(username,pass)>0){
            model.addAttribute("tip","登入成功");
            return "WEB-INF/success.jsp";
        }
        model.addAttribute("tip","登入失败");

        return "WEB-INF/fail.jsp";
    }
}
