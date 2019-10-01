<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/19
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>会员管理</title>
</head>
<link rel="stylesheet" href="../css/table1.css">
<body>
<div class="wrap">
    <table class="main_tb" border="" id="userMaintain">
        <tr>
            <td class="tb_title" colspan="10" bgcolor="#aecce0">会员管理</td>
        </tr>
        <tr>
            <td align="center">ID</td>
            <td align="center">用户名</td>
            <td align="center">密码</td>
            <td align="center">真实姓名</td>
            <td align="center">住址</td>
            <td align="center">性别</td>
            <td align="center">联系方式</td>
            <td align="center">E-mail</td>
            <td align="center">QQ</td>
            <td align="center">操作</td>
        </tr>
    </table>
</div>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url:"../userList",
            type:"get",
            data:{},
            datatype:"json/text",
            success:function (result) {
                var json = eval('('+result+')');
                var html = "";
                for (var i in json) {
                    html += "<tr id="+json[i].userId+">\n=" +
                        "<td align=\"center\">"+json[i].userId+"</td>\n" +
                        "<td align=\"center\">"+json[i].userName+"</td>\n" +
                        "<td align=\"center\">"+json[i].userPw+"</td>\n" +
                        "<td align=\"center\">"+json[i].userRealname+"</td>\n" +
                        "<td align=\"center\">"+json[i].userAddress+"</td>\n" +
                        "<td align=\"center\">"+json[i].userSex+"</td>\n" +
                        "<td align=\"center\">"+json[i].userTel+"</td>\n" +
                        "<td align=\"center\">"+json[i].userEmail+"</td>\n" +
                        "<td align=\"center\">"+json[i].userQq+"</td>\n" +
                        "<td align=\"center\"><a href=\"javascript:void(0);\" onclick=\"deleteUser("+json[i].userId+")\">删除</a></td>\n" +
                        "</tr>";
                }
                $("#userMaintain").append(html);
            },error:function () {
                alert(111);
            }
        })
    })
</script>
<script>
    function deleteUser(id) {
        $.ajax({
            url:"../userDelete",
            type:"post",
            data:{"id":id},
            datatype:"json/text",
            success:function (jsonstr) {
                var data = eval('('+jsonstr+')');
                if (data.type == 1){
                    alert("删除成功！！");
                    $("#"+id+"").remove();
                }else {
                    alert("失败！！");
                }
            }
        })
    }
</script>
</body>

