package com.cn.service;

import com.cn.dao.UserListDao;
import com.cn.dao.impl.UserListDaoimpl;
import com.cn.model.UserModel;

import java.util.ArrayList;

public class UserListService {
    /*页面显示用户信息*/
    public ArrayList<UserModel> getUserList(){
        UserListDao userListDao = new UserListDaoimpl();
        return userListDao.getUserList();
    }
    /*加删除删除用户信息*/
    public int deleteUser(int id){
        UserListDao userListDao = new UserListDaoimpl();
        return userListDao.deleteUser(id);
    }
}
