package com.cn.action;

import com.cn.service.AdminListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
*@Description 管理员的删除
*@Return
*@Author Mr.Shu
*/
public class AdminDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        AdminListService al = new AdminListService();
        int decide = al.AdminDelete(id);
        String msg="";
        if (decide==1){
            msg = "success";
            resp.getWriter().print(msg);
        }else {
            msg = "error";
            resp.getWriter().print(msg);
        }
    }
}
