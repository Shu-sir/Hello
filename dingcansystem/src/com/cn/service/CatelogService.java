package com.cn.service;

import com.cn.dao.CatelogDao;
import com.cn.dao.impl.CatelogDaoimpl;
import com.cn.model.CatelogModel;

import java.util.ArrayList;

/**
 * @autor Administrator
 * @date 2019/9/26 14:42
 */
public class CatelogService {
    public ArrayList<CatelogModel> catelogList(){
        CatelogDao catelogDao = new CatelogDaoimpl();
        return catelogDao.catelogList();
    }
}
