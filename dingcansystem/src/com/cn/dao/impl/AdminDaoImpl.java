package com.cn.dao.impl;

import com.cn.dao.AdminDao;
import com.cn.model.AdminModel;
import com.cn.util.DBManager;
import com.cn.util.DBUtilA;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminDaoImpl implements AdminDao {
    //override重写 overlode重载
    AdminModel adminModel = new AdminModel();

    @Override
    public AdminModel loginSelect(String userName, String PassWd) {
        String sql = "select * from t_admin where userName = ? and userPw = ?";
        PreparedStatement ps = new DBManager().getPreparedStatement(sql);
        try {
            ps.setString(1, userName);
            ps.setString(2, PassWd);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                adminModel.setUserName(result.getString("userName"));
                adminModel.setUserPw(result.getString("userPw"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminModel;
    }

    @Override
    public AdminModel selectByUserName(String userName) {
        String sql = "select * from t_admin where userName = ?";
        /*ResultSet rs = DBUtilA.executeUpdateRS(sql, userName);*/
        List<Map<String, Object>> list = new ArrayList<>();
        list = DBUtilA.executeQuery(sql, userName);
        if (list.size() == 1) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = new HashMap<>();
                map = list.get(i);
                AdminModel adminModel = new AdminModel((Integer)map.get("userId"), (String) map.get("userName"), (String) map.get("userPw"));
                return adminModel;
            }
        }/*else {
        List<AdminModel> lists = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = new HashMap<>();
                map = list.get(i);
                AdminModel adminModel = new AdminModel(Integer.parseInt((String) map.get("userId")), (String) map.get("userName"), (String) map.get("userPw"));
                lists.add(adminModel);
            }
            return lists;
        }*/
        return null;


        /*try {
            while (rs.next()) {
                adminModel.setUserName(rs.getString("userName"));
                adminModel.setUserPw(rs.getString("userPw"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtilA.close(null,null,rs);
        }*/

        /*PreparedStatement ps = new DBManager().getPreparedStatement(sql);
        try {
            ps.setString(1,userName);
            ResultSet result = ps.executeQuery();
            while (result.next()){
                adminModel.setUserName(result.getString("userName"));
                adminModel.setUserPw(result.getString("userPw"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminModel;*/
    }

    @Override
    public int AdminDeleteById(int id) {
        String sql = "delete from t_admin where userId = ?";
        return DBUtilA.executeUpdate(sql,id);
        /*PreparedStatement ps = new DBManager().getPreparedStatement(sql);
        int a = 0;
        try {
            ps.setInt(1,id);
            a = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;*/
    }

    @Override
    public ArrayList<AdminModel> AdminList() {
        String sql = "select * from t_admin";
        PreparedStatement ps = new DBManager().getPreparedStatement(sql);
        ArrayList<AdminModel> list = new ArrayList<>();
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AdminModel adminModel = new AdminModel(Integer.parseInt(rs.getString("userId")), rs.getString("userName"), rs.getString("userPw"));
                list.add(adminModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int adminAdd(AdminModel adminModel) {
        String sql = "insert into t_admin (userName,userPw) values (?,?)";
        String[] str=new String[2];
        for (int i = 0; i < str.length; i++) {
            str[i] = adminModel.getUserName();
        }
        return DBUtilA.executeUpdate(sql,str);
        /*PreparedStatement ps = new DBManager().getPreparedStatement(sql);
        int a = 0;
        try {
            ps.setString(1, adminModel.getUserName());
            ps.setString(2, adminModel.getUserPw());
            a = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public int updateAdmin(AdminModel adminModel) {
        String sql = "update t_admin set userPw = ? where userName = ?";
        return DBUtilA.executeUpdate(sql,adminModel.getUserPw(),adminModel.getUserName());
        /*PreparedStatement ps = new DBManager().getPreparedStatement(sql);
        int a = 0;
        try {
            ps.setString(1,adminModel.getUserPw());
            ps.setString(2,adminModel.getUserName());
            a = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
