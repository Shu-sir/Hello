package com.cn.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
*@Description 解决关闭tomcat服务器报错
*@Param
*@Return
*@Author Mr.Shu
*/
public class userServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name=request.getParameter("name");
        boolean used=false;
        if("ajax".equals(name)){
            used=true;
        }else{
            used=false;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.print(used);
        out.flush();
        out.close();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }
}
