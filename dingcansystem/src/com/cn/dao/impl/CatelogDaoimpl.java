package com.cn.dao.impl;

import com.cn.dao.CatelogDao;
import com.cn.model.CatelogModel;
import com.cn.util.DBUtilA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @autor Administrator
 * @date 2019/9/26 14:43
 */
public class CatelogDaoimpl implements CatelogDao {
    @Override
    public ArrayList<CatelogModel> catelogList() {
        String sql = "select * from t_catelog where catelog_del = 1";
        List<Map<String,Object>> list = new ArrayList<>();
        ArrayList<CatelogModel> list1 = new ArrayList<>();
        list = DBUtilA.executeQuery(sql);
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            CatelogModel catelogModel = new CatelogModel(list.get(i));
            list1.add(catelogModel);
        }
        return list1;
    }
}
