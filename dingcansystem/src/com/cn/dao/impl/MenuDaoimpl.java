package com.cn.dao.impl;

import com.cn.dao.MenuDao;
import com.cn.model.Navigation;
import com.cn.util.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuDaoimpl implements MenuDao {
    @Override
    public ArrayList<Navigation> SelectMenu() {
        String sql = "select * from t_navigation";
        ArrayList <Navigation> list = new ArrayList<>();
        try {
            ResultSet resultSet = DBManager.getConnection().prepareStatement(sql).executeQuery();
            while (resultSet.next()){
                Navigation nav = new Navigation();
                nav.setId(Integer.parseInt(resultSet.getString("id")));
                nav.setMenu_name(resultSet.getString("menu_name"));
                nav.setUrl(resultSet.getString("url"));
                nav.setChildNum(Integer.parseInt(resultSet.getString("childNum")));
                nav.setMenu_class(resultSet.getString("menu_class"));
                list.add(nav);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
