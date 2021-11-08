package com.qiuqian.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取得结果集参数
        String method=req.getParameter("method");
        if (method.equals("add")){
            req.getSession().setAttribute("msg","执行add方法");
        }
        if (method.equals("delete")){
            req.getSession().setAttribute("msg","执行delete方法");
        }
        //逻辑试图进行业务跳转
        req.getRequestDispatcher("/WEB-INF/success.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
