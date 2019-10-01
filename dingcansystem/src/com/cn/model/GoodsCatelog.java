package com.cn.model;

import java.util.HashMap;
import java.util.Map;

public class GoodsCatelog {
    private int goods_id;
    private String goods_name;
    private String goods_miaoshu;
    private String goods_pic;
    private float goods_shichangjia;
    private String goods_renqun;
    private String catelog_name;
    private int goods_del;


    public GoodsCatelog(Map<String, Object> map) {
        this.goods_id = (int)map.get("goods_id");
        this.goods_name = (String)map.get("goods_name");
        this.goods_miaoshu = (String) map.get("goods_miaoshu");
        this.goods_pic = (String) map.get("goods_pic");
        this.goods_shichangjia = (float) map.get("goods_shichangjia");
        this.goods_renqun = (String) map.get("goods_renqun");
        this.catelog_name = (String) map.get("catelog_name");
        this.goods_del = (int) map.get("goods_del");
    }


    public GoodsCatelog(int goods_id, String goods_name, String goods_miaoshu, String goods_pic, float goods_shichangjia, String goods_renqun, String catelog_name, int goods_del) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_miaoshu = goods_miaoshu;
        this.goods_pic = goods_pic;
        this.goods_shichangjia = goods_shichangjia;
        this.goods_renqun = goods_renqun;
        this.catelog_name = catelog_name;
        this.goods_del = goods_del;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_miaoshu() {
        return goods_miaoshu;
    }

    public void setGoods_miaoshu(String goods_miaoshu) {
        this.goods_miaoshu = goods_miaoshu;
    }

    public String getGoods_pic() {
        return goods_pic;
    }

    public void setGoods_pic(String goods_pic) {
        this.goods_pic = goods_pic;
    }

    public float getGoods_shichangjia() {
        return goods_shichangjia;
    }

    public void setGoods_shichangjia(float goods_shichangjia) {
        this.goods_shichangjia = goods_shichangjia;
    }

    public String getGoods_renqun() {
        return goods_renqun;
    }

    public void setGoods_renqun(String goods_renqun) {
        this.goods_renqun = goods_renqun;
    }

    public String getCatelog_name() {
        return catelog_name;
    }

    public void setCatelog_name(String catelog_name) {
        this.catelog_name = catelog_name;
    }

    public int getGoods_del() {
        return goods_del;
    }

    public void setGoods_del(int goods_del) {
        this.goods_del = goods_del;
    }

    @Override
    public String toString() {
        return "GoodsCatelog{" +
                "goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_miaoshu='" + goods_miaoshu + '\'' +
                ", goods_pic='" + goods_pic + '\'' +
                ", goods_shichangjia=" + goods_shichangjia +
                ", goods_renqun='" + goods_renqun + '\'' +
                ", catelog_name='" + catelog_name + '\'' +
                ", goods_del='" + goods_del + '\'' +
                '}';
    }
}
