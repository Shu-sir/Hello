package com.cn.service;

import com.cn.dao.AdminDao;
import com.cn.dao.impl.AdminDaoImpl;
import com.cn.model.AdminModel;

public class UpdateService {
    public int UpdateAdminService(AdminModel adminModel){
        AdminDao adminDao = new AdminDaoImpl();
        return adminDao.updateAdmin(adminModel);
        /*UpdateAdmin updateAdmin = new UpdateAdminImpl();
        return updateAdmin.updateAdmin(adminModel);*/
    }
}
