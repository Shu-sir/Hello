package com.cn.Test;

import com.cn.dao.GoodsCatelogDao;
import com.cn.dao.impl.GoodsCatelogDaoimpl;
import com.cn.model.GoodsCatelog;
import com.cn.service.CatelogService;
import org.junit.Test;

import java.util.ArrayList;

public class SeletctAllGC {
    @Test
    public void test(){
        /*GoodsCatelogDaoimpl goodsCatelogDaoimpl = new GoodsCatelogDaoimpl();
        ArrayList<GoodsCatelog> list = new ArrayList<>();
        list = goodsCatelogDaoimpl.selectAllGC();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }*/
        CatelogService service = new CatelogService();
        System.out.println(service.catelogList().toString());
    }
}
