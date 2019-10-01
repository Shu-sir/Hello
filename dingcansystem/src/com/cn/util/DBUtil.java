package com.cn.util;

/**
 * 数据库的增删改查操作
 */
public class DBUtil {
    public static void main(String[] args) {
        String list="[{\n" +
                "\t\"id\": \"系统操作系统:\",\n" +
                "\t\"value\":"+SysInfo.getOsName()+
                "}, {\n" +
                "\t\"id\": \"操作系统类型;\",\n" +
                "\t\"value\":"+SysInfo.getOsArch()+
                "}, {\n" +
                "\t\"id\": \"用户，目录，临时目录:\",\n" +
                "\t\"value\":"+SysInfo.getUserDir()+
                "}, {\n" +
                "\t\"id\": \"JDK版本:\",\n" +
                "\t\"value\":"+SysInfo.getJdkVersion()+
                "}, {\n" +
                "\t\"id\": \"JDK安装目录:\",\n" +
                "\t\"value\":"+SysInfo.getJdkHome()+
                "}, {\n" +
                "\t\"id\": \"总内存剩余内存\",\n" +
                "\t\"value\":"+"memory"+
                "}]";
        System.out.println(list);
    }
}
