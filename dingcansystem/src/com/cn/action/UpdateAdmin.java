package com.cn.action;

import com.cn.model.AdminModel;
import com.cn.service.UpdateService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
*@Description 更新管理员密码
*@Param
*@Return
*@Author Mr.Shu
*/
public class UpdateAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password02");
        System.out.println(name+"============="+password);
        AdminModel adminModel = new AdminModel(name,password);
        UpdateService service = new UpdateService();
        JSONObject jsonObject = new JSONObject();
        if (service.UpdateAdminService(adminModel)==1){
            System.out.println("修改正确");
            jsonObject.put("name",name);
            jsonObject.put("password02",password);
        }else {
            jsonObject.put("name",null);
            jsonObject.put("password02",null);
        }
        resp.getWriter().print(jsonObject);
    }

}
