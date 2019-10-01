package com.cn.action;

import com.cn.model.Navigation;
import com.cn.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
*@Description 导航栏生成——从数据库读取
*@Param
*@Return
*@Author Mr.Shu
*/
public class AdminMenu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Navigation> list = new ArrayList<>();
        list = MenuService.SelectAll();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        for (Navigation n:list) {
//            System.out.println(n.toString());
        }
//        System.out.println(list);
        resp.getWriter().println(list);
    }
}
