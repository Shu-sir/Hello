package com.cn.util;

import java.sql.*;

public class DBManager {
    private static final String url="jdbc:mysql://localhost:3306/dingcan?serverTimezone=UTC";
    private static final String name="com.mysql.cj.jdbc.Driver";
    private static final String username="root";
    private static final String password="123456";

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    //连接
    public PreparedStatement getPreparedStatement(String sql){
        try {
            Class.forName(name);
            connection = DriverManager.getConnection(url,username,password);
            preparedStatement = connection.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
    public static Connection getConnection(){
        try {
            Class.forName(name);
            return DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("找不到驱动包");
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException("数据库连接失败");
        }
    }
    /**
     *资源释放
     */
    public static void release(Connection conn, PreparedStatement ps, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
//                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("结果集资源释放失败");
            }
        }
        if(ps != null){
            try {
                ps.close();
//                ps = null;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("sql会话资源释放失败");
            }
        }
        if(conn != null){
            try {
                conn.close();
//                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("数据库连接资源释放失败");
            }
        }
    }
    public static void release(Connection conn, PreparedStatement ps){
        if(conn != null){
            try {
                conn.close();
//                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("数据库连接资源释放失败");
            }
        }
        if(ps != null){
            try {
                ps.close();
//                ps = null;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("sql会话资源释放失败");
            }
        }
    }
    public static void release(PreparedStatement ps){
        if(ps != null){
            try {
                ps.close();
//                ps = null;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("sql会话资源释放失败");
            }
        }
    }
    public static void release(PreparedStatement ps,ResultSet rs){
        if(ps != null){
            try {
                ps.close();
//                ps = null;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("sql会话资源释放失败");
            }
        }
        if(rs != null){
            try {
                rs.close();
//                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("结果集资源释放失败");
            }
        }
    }
}
