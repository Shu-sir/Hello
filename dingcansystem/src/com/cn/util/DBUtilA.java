package com.cn.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtilA {
    /*
     * 注册驱动只需要加载一次
     * */
    private static final String url = "jdbc:mysql://localhost:3306/dingcan?serverTimezone=UTC";
    private static final String name = "com.mysql.cj.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "123456";

    private static CallableStatement callableStatement = null;//创建CallableStatement对象
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    static {
        try {
            Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 增删改的通用方法
     */
    public static int executeUpdate(String sql, Object... objects) {
        int temp = 0;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i + 1, objects[i]);
            }
            temp = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }
        return temp;
    }

    /**
     * 查询的方法
     */
    public static List<Map<String,Object>> executeQuery(String sql, Object...objects){
        conn = getConnection();
        try {
            ps = conn.prepareStatement(sql);
            /*参数*/
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i+1,objects[i]);
            }
            /*执行*/
            rs = ps.executeQuery();
            List<Map<String,Object>> list = new ArrayList<>();
            /*获取本次查询结果集有多少列*/
            int count = rs.getMetaData().getColumnCount();

            while (rs.next()){
                Map<String,Object> map = new HashMap<>();
                for (int i = 0; i < count; i++) {
                    String name = rs.getMetaData().getColumnLabel(i+1);
                    map.put(name,rs.getObject(name));
                }
                /*将每行的map存放到List中*/
                list.add(map);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn,ps,rs);
        }
        return null;
    }

    /***
     * 查询的通用方法，主要返回ResultSet
     * @param sql sql语句
     * @param objects 可变参数
     * @return ResultSet结果集合
     */
    public static ResultSet executeUpdateRS(String sql,Object...objects){
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (objects.length>0){
                for (int i = 0; i < objects.length; i++) {
                    ps.setObject(i+1,objects[i]);
                }
            }
            rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
//            close(conn,ps,null);
        return rs;

    }


    /***
     * 关闭资源
     * @param conn
     * @param ps
     * @param rs
     */
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
