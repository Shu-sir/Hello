package com.cn.util;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.util.Properties;

public class SysInfo {
    public static void testGetOSInfo() {
        Properties proper = System.getProperties();
        System.out.println(proper.getProperty("java.version"));//12.0.1 jdk版本
        System.out.println(proper.getProperty("java.home"));//C:\Program Files\Java\jdk-12.0.1 jdk安装路径
        System.out.println(proper.getProperty("os.name"));//Windows 7
        System.out.println(proper.getProperty("os.arch"));//操作系统类型 amd64
        System.out.println(proper.getProperty("user.dir"));//E:\IdeaProjects\dingcansystem 当前操作目录
    }
    /*
    内存
     */
    /*public static String getMemory() throws SigarException {
        Sigar sigar = new Sigar();
        return sigar.getMem().getTotal()/1024L/1024L+"MB" +"/"+ sigar.getMem().getFree()/1024L/1024L+"MB";
    }*/
    public static String getOsName(){
        return System.getProperty("os.name");
    }
    public static String getOsArch(){
        return System.getProperty("os.arch");
    }
    public static String getJdkVersion(){
        return System.getProperty("java.version");
    }
    public static String getUserDir(){
        return System.getProperty("user.dir");
    }
    public static String getJdkHome(){
        return System.getProperty("java.home");
    }
    public static void main(String[] args) throws SigarException {
//        System.out.println(SysInfo.getMemory());
        System.out.println(SysInfo.getOsArch());
        System.out.println(SysInfo.getOsName());
        System.out.println(SysInfo.getJdkHome());
        System.out.println(SysInfo.getJdkVersion());
        System.out.println(SysInfo.getUserDir());
    }
}
