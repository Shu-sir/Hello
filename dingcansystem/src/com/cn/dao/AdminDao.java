package com.cn.dao;

import com.cn.model.AdminModel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminDao {
    AdminModel loginSelect(String userName,String userPw);
    AdminModel selectByUserName(String userName) throws SQLException;
    int AdminDeleteById(int id);
    ArrayList<AdminModel> AdminList();
    /*管理员添加*/
    int adminAdd(AdminModel adminModel);

    int updateAdmin(AdminModel adminModel);
}
