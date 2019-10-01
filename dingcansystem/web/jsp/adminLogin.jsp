<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/30
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
<link rel="stylesheet" href="css/adminLogin.css">
</head>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<body>
<div class="adminLogin">
    <div class="head">网络订餐系统</div>
    <div class="userName">
        <div class="user1">用户名：</div><div class="user2"><input type="text" id="adminName" value=""></div>
    </div>
    <div class="passWord">
        <div class="pass1">密&nbsp;&nbsp;&nbsp;码：</div><div class="pass2"><input type="password" id="passWd" value=""></div>
    </div>
    <div class="tijiao"><div class="tijiaoLeft"><button onclick="login()">登录</button></div><div class="tijiaoRight"><input type="reset"></div></div>
</div>
</body>
<script>
    function login(){
        $.ajax({
            url:"adminLogin",
            type:"get",
            data:{
                "name":$("#adminName").val(),
                "password":$("#passWd").val()
            },
            datatype:"json",
            success:function (result) {
                // alert(result);
                // 解析json字符串
                var aa = JSON.parse(result);
                // var aa = eval('('+result+')');
                // alert(flag);
                if (aa.name != null&&aa.password != null){
                    // alert("跳转到后端页面");
                    sessionStorage.setItem("adminName",aa.name);
                    window.location.href='jsp/adminManager.jsp';
                }else {
                    alert("密码错误");
                }
            },
            error:function () {
                alert("警告");
            }
        })
    }
</script>
</html>
