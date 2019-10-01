<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/11
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员密码修改</title>
</head>
<%--<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>--%>
<link rel="stylesheet" href="../css/table1.css">
<body>
<div class="wrap">
    <table class="main_tb" border="">
        <tr>
            <td class="tb_title" colspan="2" bgcolor="#aecce0">系统基本信息</td>
        </tr>
        <tr>
            <td align="right" width="30%">登录名:</td>
            <td align="left" width="70%"><input type="text" id="admin" readonly>
            </td>
        </tr>
        <tr>
            <td align="right" width="30%">原密码:</td>
            <td align="left" width="70%"><input type="password" id="password01"></td>
        </tr>
        <tr>
            <td align="right" width="30%">新密码:</td>
            <td align="left" width="70%"><input type="password" id="password02"></td>
        </tr>
        <tr>
            <td align="right" width="30%">确认密码:</td>
            <td align="left" width="70%"><input type="password" id="password03"></td>
        </tr>
        <tr>
            <td align="right" width="30%"></td>
            <td align="left" width="70%">
                <button onclick="update()">提交</button>
                <span>&nbsp;&nbsp;&nbsp;&nbsp;</span><input
                    type="reset"></td>
        </tr>
    </table>
</div>
<script>
    $(function () {
        var str = sessionStorage.getItem("adminName");
        $("#admin").val(str);
    });

    function update() {
        $.ajax({
            url: "../adminLogin",
            type: "get",
            data: {
                "name": $("#admin").val(),
                "password": $("#password01").val()
            },
            datatype: "json/text",
            success: function (result) {
                var bb = JSON.parse(result);
                /*alert(bb);*/
                if (bb.name != null && bb.password != null) {
                    /*alert("开始判断新密码");*/
                    if ($("#password02").val() == $("#password03").val()){
                        $.ajax({
                            url:"../psUpdate",
                            type:"post",
                            data:{
                                "name":$("#admin").val(),
                                "password02":$("#password02").val()
                            },
                            datatype:"json/text",
                            success:function (jsonObject) {
                                var data = JSON.parse(jsonObject);
                                if (data.name != null && data.password02 != null){
                                    alert("密码修改成功");
                                    history.go(0);
                                }else{
                                    alert("密码修改错误");
                                }
                            },
                            error:function () {
                            }
                        })
                    }else {
                        alert("密码不同！")
                    }
                } else {
                    alert("密码错误！");
                }
            },
            error: function () {
                alert("数据错误！！");
            }
        })
    }
</script>
</body>
</html>
