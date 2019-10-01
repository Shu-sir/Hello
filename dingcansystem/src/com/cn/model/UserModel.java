package com.cn.model;

public class UserModel {
    private int userId;
    private String userName;
    private String userPw;
    private int userType;
    private String userRealname;
    private String userAddress;
    private String userSex;
    private String userTel;
    private String userEmail;
    private String userQq;
    private String userAge;
    private String userBirthday;
    private int userDel;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", userPw='" + userPw + '\'' +
                ", userType=" + userType +
                ", userRealname='" + userRealname + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userQq='" + userQq + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userDel=" + userDel +
                '}';
    }

    public UserModel() {
    }

    public UserModel(int userId, String userName, String userPw, int userType, String userRealname, String userAddress, String userSex, String userTel, String userEmail, String userQq, String userAge, String userBirthday, int userDel) {
        this.userId = userId;
        this.userName = userName;
        this.userPw = userPw;
        this.userType = userType;
        this.userRealname = userRealname;
        this.userAddress = userAddress;
        this.userSex = userSex;
        this.userTel = userTel;
        this.userEmail = userEmail;
        this.userQq = userQq;
        this.userAge = userAge;
        this.userBirthday = userBirthday;
        this.userDel = userDel;
    }

    public UserModel(int userId, String userName, String userPw, String userRealname, String userAddress, String userSex, String userTel, String userEmail, String userQq, int userDel) {
        this.userId = userId;
        this.userName = userName;
        this.userPw = userPw;
        this.userRealname = userRealname;
        this.userAddress = userAddress;
        this.userSex = userSex;
        this.userTel = userTel;
        this.userEmail = userEmail;
        this.userQq = userQq;
        this.userDel = userDel;
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

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public int getUserDel() {
        return userDel;
    }

    public void setUserDel(int userDel) {
        this.userDel = userDel;
    }
}
