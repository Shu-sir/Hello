package com.cn.action;

import com.cn.service.UserListService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDelete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        JSONObject jsonObject = new JSONObject();
        int id = 0;
        if (req.getParameter("id")!=null){
            id = Integer.parseInt(req.getParameter("id"));
        }
        int result = new UserListService().deleteUser(id);
        jsonObject.put("type",result);
        resp.getWriter().print(jsonObject.toString());
    }
}
