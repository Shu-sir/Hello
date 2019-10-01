package com.cn.action;

import com.cn.service.CatelogService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @autor Administrator
 * @date 2019/9/26 14:38
 */
public class CatelogList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CatelogService service = new CatelogService();
        JSONArray jsonArray = new JSONArray();
        if (service.catelogList()!=null){
            resp.setCharacterEncoding("utf-8");
            System.out.println(jsonArray.fromObject(service.catelogList()).toString());
            resp.getWriter().print(jsonArray.fromObject(service.catelogList()).toString());
        }
    }
}
