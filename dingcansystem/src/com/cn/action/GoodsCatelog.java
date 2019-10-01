package com.cn.action;

import com.cn.service.GoodsCatelogService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoodsCatelog extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsCatelogService GC = new GoodsCatelogService();//初始化一个GoodsCatelogService对象
        List<com.cn.model.GoodsCatelog> list = new ArrayList<>();
        //调用GoodsCatelogService获取List<GoodsCatelog>
        resp.setCharacterEncoding("utf-8");
        list = GC.selectAllDC();
        String jsonStr = "";
        if(list != null){
            JSONArray jsonArray = JSONArray.fromObject(list);
            jsonStr = jsonArray.toString();
        }
        System.out.println(jsonStr);
        resp.getWriter().print(jsonStr);
    }
}
