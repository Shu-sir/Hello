<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/17
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员修改</title>
    <%--<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>--%>
    <script>
        $(function () {
            $.ajax({
                url: "../adminList",
                type: "get",
                data: {},
                datatype: "json/text",
                success: function (json_str) {
                    var data = JSON.parse(json_str);
                    var html = "";
                    for (var x in data) {
                        html += "<tr id="+data[x].userId+">\n" +
                            "<td align=\"center\">" + data[x].userId + "</td>\n" +
                            "<td align=\"center\">" + data[x].userName + "</td>\n" +
                            "<td align=\"center\">" + data[x].userPw + "</td>\n" +
                            "<td align=\"center\"><a href=\"javascript:void(0);\" class=\"adminDelete\" onclick=\"deleteAdmin("+data[x].userId+")\">删除</a></td>\n" +
                            "</tr>";
                    }
                    $("#adminMaintain").append(html);
                }
            })
        })
    </script>
    <script type="text/javascript">
        function deleteAdmin(id) {
            if (window.confirm("确定要删除吗？")){
                $.ajax({
                    url:"../adminDelete",
                    type:"post",
                    data:{
                        id:id
                    },
                    datatype:"json/text",
                    success:function (msg) {
                        if (msg=="success"){
                            alert("删除成功！");
                            $("#"+id).remove();
                        }else {
                            alert("数据删除失败！");
                        }
                    }
                });
                return true;
            }else {
                return false;
            }

        }
    </script>
    <script>
        $(function () {
            $('a').click(function () {
                var attr = $(this).attr("href");
                $("#adminMaintainA").load(attr);
                return false;
            });
        })
    </script>
</head>
<link rel="stylesheet" href="../css/table1.css">
<body>
<div class="wrap" id="adminMaintainA">
    <table class="main_tb" border="" id="adminMaintain">
        <tr>
            <td class="tb_title" colspan="4" bgcolor="#aecce0">管理员维护</td>
        </tr>
        <tr>
            <td align="center">ID</td>
            <td align="center">用户名</td>
            <td align="center">密码</td>
            <td align="center">操作</td>
        </tr>
    </table>
    <a href="../jsp/adminAdd.jsp"><button type="button" class="bt_Add">添加</button></a>
</div>
</body>
</html>
