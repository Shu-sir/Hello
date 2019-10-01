package com.cn.Test;

import com.cn.dao.AdminDao;
import com.cn.dao.impl.AdminDaoImpl;
import com.cn.model.AdminModel;
import org.junit.Test;

public class SelectAdd {
    @Test
    public void test(){
        AdminModel s = new AdminModel();
        String name = "admin";
        AdminDaoImpl adminDao = new AdminDaoImpl();
        System.out.println(adminDao.selectByUserName(name).toString());
    }
}
