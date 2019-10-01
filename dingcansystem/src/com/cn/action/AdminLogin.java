package com.cn.action;

import com.cn.model.AdminModel;
import com.cn.service.LoginService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
*@Description 管理员登录
*@Param
*@Return
*@Author Mr.Shu
*/
public class AdminLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取得前端数据
        String userName = req.getParameter("name");
        String userPw = req.getParameter("password");
        System.out.println(userName);
        System.out.println(userPw);
        AdminModel adminModel = new AdminModel();
        adminModel = LoginService.loginVerify(userName,userPw);
//        System.out.println(adminModel.toString());
        JSONObject jsonObject = new JSONObject();
        if (adminModel.getUserName()!= null && adminModel.getUserPw() != null){
            jsonObject.put("name",userName);
            jsonObject.put("password",userPw);
        }
        else {
            jsonObject.put("name",null);
            jsonObject.put("password",null);
        }
        //将厚端的json对象返还给前端页面
//        resp.getWriter().print();
        resp.getWriter().print(jsonObject);
    }
}