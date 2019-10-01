package com.cn.action;

import com.cn.util.SysInfo;
import net.sf.json.JSONArray;
import org.hyperic.sigar.SigarException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
*@Description 读取本机配置信息
*@Param
*@Return
*@Author Mr.Shu
*/
public class Property extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String osName = SysInfo.getOsName();
        String osArch = SysInfo.getOsArch();
        String userDir = SysInfo.getUserDir();
        String jdkVersion = SysInfo.getJdkVersion();
        String jdkHome = SysInfo.getJdkHome();
        String memory = "";
        /*try {
            memory = SysInfo.getMemory();
        } catch (SigarException e) {
            e.printStackTrace();
        }*/
        resp.setCharacterEncoding("utf-8");
        String list = "[{" +
                "\t\"id\": \"系统操作系统:\",\n" +
                "\t\"value\":\"" + osName +
                "\"}, {\n" +
                "\t\"id\": \"操作系统类型;\",\n" +
                "\t\"value\":\"" + osArch +
                "\"}, {\n" +
                "\t\"id\": \"用户，目录，临时目录:\",\n" +
                "\t\"value\":\"" + Property.getEscape(userDir) +
                "\"}, {\n" +
                "\t\"id\": \"JDK版本:\",\n" +
                "\t\"value\":\"" + jdkVersion +
                "\"}, {\n" +
                "\t\"id\": \"JDK安装目录:\",\n" +
                "\t\"value\":\"" + Property.getEscape(jdkHome) +
                "\"}, {\n" +
                "\t\"id\": \"总内存剩余内存:\",\n" +
                "\t\"value\":\"" + memory +
                "\"}]";
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println(jsonArray);
        resp.getWriter().println(jsonArray);
    }

    public static String getEscape(String str) {
        String[] strings = str.split("");
        String temp = "";
        for (String a : strings
        ) {
            if (a.equals("\\")) {
                temp = temp + a + "\\";
            } else {
                temp = temp + a;
            }
        }
        return temp;
    }
}
