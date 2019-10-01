package com.cn.action;

import com.cn.service.GoodsCatelogService;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @autor Administrator
 * @date 2019/9/24 18:05
 */
public class GoodsDelete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("id");
        int id = 0;
        if (str != null){
            id = Integer.parseInt(str);
            System.out.println(id);
        }
        GoodsCatelogService goods = new GoodsCatelogService();
        int result = goods.deleteGoods(id);
        JSONObject json = new JSONObject();
        if (result == 1){
            json.put("type",result);
        }else {
            json.put("type",0);
        }
        System.out.println(json.toString());
        resp.getWriter().print(json.toString());
    }
}
