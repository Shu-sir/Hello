package com.cn.action;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * @autor Administrator
 * @date 2019/9/25 11:01
 */
public class MyServlet_6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        if (!ServletFileUpload.isMultipartContent(req)) {
//            resp.getWriter().print("失败");
            throw new RuntimeException("不支持该文件上传！");
        }
        try {
            System.out.println("++++++");
            //为基于磁盘的文件项创建工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //上传文件核心组件
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解析请求,获取左右item
            List<FileItem> list = upload.parseRequest(req);
            for (FileItem fileItem : list) {
                if (fileItem.isFormField()) { //普通表单项
                    String filedName = fileItem.getFieldName();
                    String filedValue = fileItem.getString();
                } else { //文件表单项
                    String fileName = fileItem.getName();
                    InputStream inputStream = fileItem.getInputStream();
                    String path = req.getServletContext().getRealPath("/images");
                    File file = new File(path, fileName);
                    System.out.println(file.getParent() + "\\" + fileName);
                    //文件输出流
                    OutputStream os = new FileOutputStream(file);
                    int len = -1;
                    byte[] buf = new byte[1024];
                    while ((len = inputStream.read(buf)) != -1) {
                        os.write(buf, 0, len);
                    }
                    //关闭流
                    os.close();
                    inputStream.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("javascript:void(0);");
//        System.out.println(req.getParameter("goods_vatelog"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
    /*private long lMaxFileLength = 400 * 1024 * 1024;//允许的最大文件大小

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
// response.setContentType("text/html");
        response.setContentType("text/html;charset=GB2312");
        response.addHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Expires", "0");
        PrintWriter pw = response.getWriter();
        pw.println("<html><head><title>myservlet_6_title</title></head><body>");
        pw.println("开始处理上传文件！<br>");
        try {
            DiskFileItemFactory dfit = new DiskFileItemFactory();
            dfit.setSizeThreshold(4096);//设置缓冲区大小
            String strFolderPath = getServletContext().getRealPath("/TempFile");
            dfit.setRepository(new File(strFolderPath));
            ServletFileUpload upload = new ServletFileUpload(dfit);
            upload.setSizeMax(lMaxFileLength);//设置最大允许上传的文件大小  如果上传的文件超过这个大小，下面的代码会抛异常
            List items = upload.parseRequest(request);
            Iterator itor = items.iterator();
            while (itor.hasNext()) {
                pw.println("处理一个新item<br>");
                FileItem fi = (FileItem) itor.next();//如果上传的文件大小大于上面设定的文件大小，则本行代码会抛异常 the request was rejected because its size (157453870) exceeds the configured maximum (104857600)
                if (fi.isFormField())
                    processFormField(fi, pw);
                else
                    processUploadFile(fi, pw);
            }
        } catch (Exception e) {
            pw.println("发现异常，信息是： " + e.getMessage() + "<br>");
        }
        pw.println("</body></html>");
        pw.close();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        doGet(request, response);
    }

    private void processFormField(FileItem fi, PrintWriter pr) {
        String strName = fi.getFieldName();
        String strValue = fi.getString();
        pr.println(strName + ": " + strValue + "<br>");
    }

    private void processUploadFile(FileItem fi, PrintWriter pr) {
        try {
            String strFileName = fi.getName();
            strFileName = strFileName.substring(strFileName.lastIndexOf('\\') + 1, strFileName.length());
            long lFileSize = fi.getSize();
// if(lFileSize>lMaxFileLength){
// pr.println("【文件上传失败提示】： "+strFileName+" is large than "+lMaxFileLength+"B, upload failed !<br>");
// return;
// }
            if (lFileSize == 0 || strFileName == null || strFileName.trim().length() == 0)
                return;
            File flUpload = new File(getServletContext().getRealPath("/UploadFile") + "/" + strFileName);//这里竟然是正斜杠
            fi.write(flUpload);
            pr.println("【文件上传成功提示】： " + strFileName + " is saved. " + "Its size is " + lFileSize + "<br>");
        } catch (Exception e) {
            pr.println("保存上传文件时发现异常，信息是： " + e.getMessage() + "<br>");
            System.out.println("发现异常： " + e.getMessage());
        }
    }
}*/