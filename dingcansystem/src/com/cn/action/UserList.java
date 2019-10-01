package com.cn.action;

import com.cn.model.UserModel;
import com.cn.service.UserListService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
*@Description 查询会员数据的action
*@Param
*@Return List
*@Author Mr.Shu
*/
public class UserList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        List<UserModel> list = new UserListService().getUserList();
        JSONArray jsonArray = JSONArray.fromObject(list);
        resp.getWriter().print(jsonArray.toString());
    }
}
