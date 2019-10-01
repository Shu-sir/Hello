package com.cn.service;

import com.cn.dao.GoodsCatelogDao;
import com.cn.dao.GoodsDao;
import com.cn.dao.impl.GoodsCatelogDaoimpl;
import com.cn.dao.impl.GoodsDaoimpl;
import com.cn.model.GoodsCatelog;
import com.cn.model.GoodsModel;

import java.util.ArrayList;

public class GoodsCatelogService {
    /**返货多表查询的列表
     * @author Mr.Shu
     * @date 2019-09-24 18.15
     * @param
     * @return
    */
    public ArrayList<GoodsCatelog> selectAllDC(){
        GoodsCatelogDao goodsCatelogDao = new GoodsCatelogDaoimpl();
        return goodsCatelogDao.selectAllGC();
    }

    /**
     * 通过id修改good_del为0，实现假
     * @param id
     * @return
     */
    public int deleteGoods(int id){
        GoodsDao goodsDao = new GoodsDaoimpl();
        return goodsDao.GoodsDelete(id);
    }

    /**
     * 添加Goods
     * @param goodsModel
     * @return
     */
    public int addGoods(GoodsModel goodsModel){
        GoodsDao goodsDao = new GoodsDaoimpl();
        return goodsDao.goodsAdd(goodsModel);
    }
}
