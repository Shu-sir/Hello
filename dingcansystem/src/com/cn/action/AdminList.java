package com.cn.action;

import com.cn.model.AdminModel;
import com.cn.service.AdminListService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
*@Description 管理员列表
*@Param
 *@Return
*@Author Mr.Shu
*/
public class AdminList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        AdminListService adminListService = new AdminListService();
        List<AdminModel> list = adminListService.AdminList();
        resp.setCharacterEncoding("utf-8");
        JSONArray jsonArray = JSONArray.fromObject(list);
        String json_str = jsonArray.toString();
        resp.getWriter().print(json_str);
    }
}
