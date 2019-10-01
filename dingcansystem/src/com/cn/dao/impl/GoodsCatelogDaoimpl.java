package com.cn.dao.impl;

import com.cn.dao.GoodsCatelogDao;
import com.cn.model.GoodsCatelog;
import com.cn.util.DBUtilA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsCatelogDaoimpl implements GoodsCatelogDao {

    /**
     * 查询t_goods 和 t_catelog两个表的数据
     *
     * @return 返回一个ArrayList<GoodsCatelog>
     */
    @Override
    public ArrayList<GoodsCatelog> selectAllGC() {
        String sql = "select t_goods.goods_id,t_goods.goods_name,t_goods.goods_miaoshu,t_goods.goods_pic,t_goods.goods_shichangjia,t_goods.goods_renqun,t_catelog.catelog_name,t_goods.goods_del from t_goods join t_catelog on t_goods.goods_catelog_id=t_catelog.catelog_id AND goods_del = 1;";
        List<Map<String, Object>> list = new ArrayList<>();
        /*调用executeQuery，返回的是List<Map<String, Object>>类型的数据*/
        list = DBUtilA.executeQuery(sql);
        ArrayList<GoodsCatelog> lists = new ArrayList<>();
        /*判断List<Map<String, Object>>是否为空*/
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Map<String, Object> map = new HashMap<>();
                map = list.get(i);
//                GoodsCatelog goodsCatelog = new GoodsCatelog((int) map.get("goods_id"), (String) map.get("goods_name"), (String) map.get("goods_miaoshu"), (String) map.get("goods_pic"), (float) map.get("goods_shichangjia"), (String) map.get("goods_renqun"), (String) map.get("catelog_name"));
                GoodsCatelog goodsCatelog = new GoodsCatelog(map);
                /*将数据插入列表中*/
                lists.add(goodsCatelog);
            }
        }
        return lists;
    }
}
