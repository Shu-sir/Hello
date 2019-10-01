package com.cn.dao;

import com.cn.model.UserModel;

import java.util.ArrayList;

public interface UserListDao {
    /*查询所有会员列表的接口*/
    ArrayList<UserModel> getUserList();
    int deleteUser(int id);
}
