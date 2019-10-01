package com.cn.Test;

import com.cn.service.GoodsCatelogService;
import org.junit.Test;

/**
 * @autor Administrator
 * @date 2019/9/24 18:23
 */
public class DeleteGoods {
    @Test
    public void test(){
        GoodsCatelogService service = new GoodsCatelogService();
        System.out.println(service.deleteGoods(1));
    }
}
