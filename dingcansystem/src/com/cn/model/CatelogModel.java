package com.cn.model;

import java.util.Map;

/**
 * @autor Administrator
 * @date 2019/9/26 14:44
 */
public class CatelogModel {
    private int catelog_id;
    private String catelog_name;
    private String catelog_miaoshu;
    private int catelog_del;

    @Override
    public String toString() {
        return "CatelogModel{" +
                "catelog_id=" + catelog_id +
                ", catelog_name='" + catelog_name + '\'' +
                ", catelog_miaoshu='" + catelog_miaoshu + '\'' +
                ", catelog_del=" + catelog_del +
                '}';
    }

    public CatelogModel() {
    }
    public CatelogModel(Map<String,Object> map) {
        this.catelog_id = (int)map.get("catelog_id");
        this.catelog_name = (String)map.get("catelog_name");
        this.catelog_miaoshu = (String)map.get("catelog_miaoshu");
        this.catelog_del = (int)map.get("catelog_del");
    }

    public CatelogModel(int catelog_id, String catelog_name, String catelog_miaoshu, int catelog_del) {
        this.catelog_id = catelog_id;
        this.catelog_name = catelog_name;
        this.catelog_miaoshu = catelog_miaoshu;
        this.catelog_del = catelog_del;
    }

    public int getCatelog_id() {
        return catelog_id;
    }

    public void setCatelog_id(int catelog_id) {
        this.catelog_id = catelog_id;
    }

    public String getCatelog_name() {
        return catelog_name;
    }

    public void setCatelog_name(String catelog_name) {
        this.catelog_name = catelog_name;
    }

    public String getCatelog_miaoshu() {
        return catelog_miaoshu;
    }

    public void setCatelog_miaoshu(String catelog_miaoshu) {
        this.catelog_miaoshu = catelog_miaoshu;
    }

    public int getCatelog_del() {
        return catelog_del;
    }

    public void setCatelog_del(int catelog_del) {
        this.catelog_del = catelog_del;
    }
}
