package com.cn.model;

public class Navigation {
    private int id;
    private String menu_name;
    private String url;
    private int childNum;
    private String menu_class;

    public Navigation(int id, String menu_name, String url, int childNum, String menu_class) {
        this.id = id;
        this.menu_name = menu_name;
        this.url = url;
        this.childNum = childNum;
        this.menu_class = menu_class;
    }

    public Navigation() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"menu_name\":\"" + menu_name + '\"' +
                ", \"url\":\"" + url + '\"' +
                ", \"childNum\":" + childNum +
                ", \"menu_class\":\"" + menu_class + '\"' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getChildNum() {
        return childNum;
    }

    public void setChildNum(int childNum) {
        this.childNum = childNum;
    }

    public String getMenu_class() {
        return menu_class;
    }

    public void setMenu_class(String menu_class) {
        this.menu_class = menu_class;
    }
}
