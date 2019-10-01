package com.cn.Test;

import com.cn.dao.GoodsDao;
import com.cn.dao.impl.GoodsDaoimpl;
import com.cn.model.GoodsModel;
import org.junit.Test;

/**
 * @autor Administrator
 * @date 2019/9/26 13:05
 */
public class AddGoods {
    @Test
    public void test(){
        GoodsDao goodsDao = new GoodsDaoimpl();
        GoodsModel goodsModel = new GoodsModel(0, "阿斯顿发送到","阿斯顿法国", "4_07.jpg", "null", (float)12.0, (float)0.0, null, 4, 1, "年轻人");
        System.out.println(goodsDao.goodsAdd(goodsModel));
    }
}
