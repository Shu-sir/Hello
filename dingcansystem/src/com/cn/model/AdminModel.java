package com.cn.model;

public class AdminModel {
    int userId;
    String userName;
    String userPw;

    public AdminModel() {
    }
    public AdminModel(int userId, String userName, String userPw) {
        this.userId = userId;
        this.userName = userName;
        this.userPw = userPw;
    }

    public AdminModel(String userName, String userPw) {
        this.userName = userName;
        this.userPw = userPw;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    @Override
    public String toString() {
        return "AdminModel{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPw='" + userPw + '\'' +
                '}';
    }
}
