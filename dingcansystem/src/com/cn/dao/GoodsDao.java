package com.cn.dao;

import com.cn.model.GoodsModel;

import java.util.ArrayList;

public interface GoodsDao {
    int GoodsDelete(int id);
    int goodsAdd(GoodsModel goodsModel);
}
