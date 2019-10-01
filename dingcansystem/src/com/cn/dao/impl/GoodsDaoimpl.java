package com.cn.dao.impl;

import com.cn.dao.GoodsDao;
import com.cn.model.GoodsModel;
import com.cn.util.DBUtilA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsDaoimpl implements GoodsDao {
    @Override
    public int GoodsDelete(int id) {
        String sql = "update t_goods set goods_del = 0 where goods_id = ?";
        return DBUtilA.executeUpdate(sql,id);
    }

    @Override
    public int goodsAdd(GoodsModel goodsModel) {
        String sql = "INSERT INTO `t_goods` (goods_name,goods_miaoshu,goods_pic,goods_shichangjia,goods_catelog_id,goods_del,goods_renqun) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return DBUtilA.executeUpdate(sql,goodsModel.getGoods_name(),goodsModel.getGoods_miaoshu(),goodsModel.getGoods_pic(),goodsModel.getGoods_shichangjia(),goodsModel.getGoods_catelog_id(),goodsModel.getGoods_del(),goodsModel.getGoods_renquen());
    }
}
