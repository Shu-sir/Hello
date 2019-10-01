package com.cn.action;

import com.cn.model.GoodsModel;
import com.cn.service.GoodsCatelogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @autor Administrator
 * @date 2019/9/26 9:09
 */
public class GoodsAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println(req.getParameter("goods_vatelog"));
        System.out.println(req.getParameter("goods_name"));
        System.out.println(req.getParameter("description"));
        System.out.println(req.getParameter("upfilejpg"));
        System.out.println(req.getParameter("goods_shichangjia"));
        System.out.println(req.getParameter("renQuen"));
        GoodsModel goods = new GoodsModel();
        goods.setGoods_del(1);
        goods.setGoods_name(req.getParameter("goods_name"));
        goods.setGoods_miaoshu(req.getParameter("description"));
        goods.setGoods_catelog_id(Integer.parseInt(req.getParameter("goods_vatelog")));
        goods.setGoods_pic(req.getParameter("upfilejpg"));
        goods.setGoods_renquen(req.getParameter("renQuen"));
        goods.setGoods_shichangjia(Float.parseFloat(req.getParameter("goods_shichangjia")));
//        System.out.println(goods.toString());
        GoodsCatelogService service = new GoodsCatelogService();
        int i = 0;
        if (service.addGoods(goods)==1){
            resp.getWriter().print("1");
        }else {
            resp.getWriter().print("0");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
