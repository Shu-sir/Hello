package com.cn.model;

/**
 * @autor Administrator
 * @date 2019/9/26 11:16
 */
public class GoodsModel {
    private int goods_id;
    private String goods_name;
    private String goods_miaoshu;
    private String goods_pic;
    private String goods_yanse;
    private float goods_shichangjia;
    private float goods_teijia;
    private String goods_isnotuijian;
    private int goods_catelog_id;
    private int goods_del;
    private String goods_renquen;

    public GoodsModel() {
    }

    public GoodsModel(int goods_id, String goods_name, String goods_miaoshu, String goods_pic, String goods_yanse, float goods_shichangjia, float goods_teijia, String goods_isnotuijian, int goods_catelog_id, int goods_del, String goods_renquen) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_miaoshu = goods_miaoshu;
        this.goods_pic = goods_pic;
        this.goods_yanse = goods_yanse;
        this.goods_shichangjia = goods_shichangjia;
        this.goods_teijia = goods_teijia;
        this.goods_isnotuijian = goods_isnotuijian;
        this.goods_catelog_id = goods_catelog_id;
        this.goods_del = goods_del;
        this.goods_renquen = goods_renquen;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    @Override
    public String toString() {
        return goods_id +
                ", " + goods_name +
                ", " + goods_miaoshu +
                ", " + goods_pic +
                ", " + goods_yanse +
                ", " + goods_shichangjia +
                ", " + goods_teijia +
                ", " + goods_isnotuijian +
                ", " + goods_catelog_id +
                ", " + goods_del +
                ", " + goods_renquen ;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public void setGoods_miaoshu(String goods_miaoshu) {
        this.goods_miaoshu = goods_miaoshu;
    }

    public void setGoods_pic(String goods_pic) {
        this.goods_pic = goods_pic;
    }

    public void setGoods_yanse(String goods_yanse) {
        this.goods_yanse = goods_yanse;
    }

    public void setGoods_shichangjia(float goods_shichangjia) {
        this.goods_shichangjia = goods_shichangjia;
    }

    public void setGoods_teijia(float goods_teijia) {
        this.goods_teijia = goods_teijia;
    }

    public void setGoods_isnotuijian(String goods_isnotuijian) {
        this.goods_isnotuijian = goods_isnotuijian;
    }

    public void setGoods_catelog_id(int goods_catelog_id) {
        this.goods_catelog_id = goods_catelog_id;
    }

    public void setGoods_del(int goods_del) {
        this.goods_del = goods_del;
    }

    public void setGoods_renquen(String goods_renquen) {
        this.goods_renquen = goods_renquen;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public String getGoods_miaoshu() {
        return goods_miaoshu;
    }

    public String getGoods_pic() {
        return goods_pic;
    }

    public String getGoods_yanse() {
        return goods_yanse;
    }

    public float getGoods_shichangjia() {
        return goods_shichangjia;
    }

    public float getGoods_teijia() {
        return goods_teijia;
    }

    public String getGoods_isnotuijian() {
        return goods_isnotuijian;
    }

    public int getGoods_catelog_id() {
        return goods_catelog_id;
    }

    public int getGoods_del() {
        return goods_del;
    }

    public String getGoods_renquen() {
        return goods_renquen;
    }
}
