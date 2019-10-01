package com.cn.service;

import com.cn.dao.AdminDao;
import com.cn.dao.impl.AdminDaoImpl;
import com.cn.model.AdminModel;

import java.util.ArrayList;

public class AdminListService {
    public ArrayList<AdminModel> AdminList() {
        AdminDao adminDao = new AdminDaoImpl();
        return adminDao.AdminList();
    }
    public int AdminDelete(int id){
        AdminDao adminDao = new AdminDaoImpl();
        return adminDao.AdminDeleteById(id);
    }
    public int adminAdd(AdminModel adminModel){
        AdminDao adminDao = new AdminDaoImpl();
        return adminDao.adminAdd(adminModel);
    }
}
