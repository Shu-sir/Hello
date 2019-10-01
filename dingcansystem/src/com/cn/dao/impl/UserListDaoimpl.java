package com.cn.dao.impl;

import com.cn.dao.UserListDao;
import com.cn.model.UserModel;
import com.cn.util.DBManager;
import com.cn.util.DBUtilA;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserListDaoimpl implements UserListDao {
    @Override
    public ArrayList<UserModel> getUserList() {
        String sql = "SELECT * FROM t_user where user_del = 1";
        PreparedStatement ps = new DBManager().getPreparedStatement(sql);
        ArrayList<UserModel> list = new ArrayList<>();
        try {
            ResultSet result = ps.executeQuery();
            while (result.next()){
                UserModel userModel = new UserModel(Integer.parseInt(result.getString("user_id")),
                        result.getString("user_name"),
                        result.getString("user_pw"),
                        Integer.parseInt(result.getString("user_type")),
                        result.getString("user_realname"),
                        result.getString("user_address"),
                        result.getString("user_tel"),
                        result.getString("user_sex"),
                        result.getString("user_email"),
                        result.getString("user_qq"),
                        result.getString("user_age"),
                        result.getString("user_birthday"),
                        Integer.parseInt(result.getString("user_del")));
                list.add(userModel);
            }
            DBManager.release(ps,result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int deleteUser(int id) {
        String sql = "update t_user set user_del = 0  where user_id = ?";
        return DBUtilA.executeUpdate(sql,id);
        /*PreparedStatement ps = new DBManager().getPreparedStatement(sql);
        int a = 0;
        try {
            ps.setInt(1,id);
            a = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }
}
