package com.cn.service;

import com.cn.dao.AdminDao;
import com.cn.dao.impl.AdminDaoImpl;
import com.cn.model.AdminModel;

import java.sql.SQLException;

public class LoginService {
    public static AdminModel loginVerify(String userName,String userPw){
        AdminDao adminDao = new AdminDaoImpl();
        return adminDao.loginSelect(userName,userPw);
    }
    /**
    *@Description 根据用户名查询我们插入的管理员是否重复
    *@Param
    *@Return
    *@Author Mr.Shu
    */
    public static AdminModel selectByUserName(String userName){
        AdminDao adminDao = new AdminDaoImpl();
        AdminModel adminModel = null;
        try {
            adminModel = adminDao.selectByUserName(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminModel;
    }
}