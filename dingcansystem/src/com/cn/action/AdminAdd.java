package com.cn.action;

import com.cn.model.AdminModel;
import com.cn.service.AdminListService;
import com.cn.service.LoginService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminAdd extends HttpServlet {
    /**
     * @Description 添加管理员
     * @Return
     * @Author Mr.Shu
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminName = req.getParameter("adminName");
        String adminPw = req.getParameter("adminPw");
        AdminModel adminModelA = LoginService.selectByUserName(adminName);
        /*当为空时，可能会包异常*/
//        System.out.println(adminModelA.toString());
        JSONObject jsonObject = new JSONObject();
        if (adminModelA == null) {
            //将前端数据封装在实体类里面
            AdminModel adminModel = new AdminModel(adminName, adminPw);
            if (new AdminListService().adminAdd(adminModel) == 1) {
                jsonObject.put("type", "添加成功!");
            } else {
                jsonObject.put("type", null);
            }
        } else {
            jsonObject.put("type", "用户名重复!");
        }
        resp.setContentType("text/html;charset=utf-8");
        String jsonStr = jsonObject.toString();
        System.out.println(jsonStr);
        resp.getWriter().print(jsonStr);
    }
}
