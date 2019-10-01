package com.cn.service;

import com.cn.dao.MenuDao;
import com.cn.dao.impl.MenuDaoimpl;
import com.cn.model.Navigation;

import java.awt.*;
import java.util.ArrayList;

public class MenuService {
    public static ArrayList<Navigation> SelectAll(){
        MenuDao menuDao = new MenuDaoimpl();
        return menuDao.SelectMenu();
    }
}
