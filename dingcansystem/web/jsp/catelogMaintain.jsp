<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/23
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>菜品管理</title>
</head>
<link rel="stylesheet" href="../css/table1.css">
<body>
<div class="wrap">
    <table class="main_tb" border="" id="adminMaintain">
        <tr>
            <td class="tb_title" colspan="10" bgcolor="#aecce0">菜品类别维护</td>
        </tr>
        <tr>
            <td align="center">ID</td>
            <td align="center">分类名称</td>
            <td align="center">分类描述</td>
            <td align="center">操作</td>
        </tr>
    </table>
</div>
<script>
    $(function () {
        $.ajax({
            url:"../goodList",
            type:"get",
            data:{},
            datatype:"json/text",
            success:function (result) {
                var jsonStr = eval('('+result+')');
                console.log(jsonStr);
                var html = "";
                for (var i = 0;i<jsonStr.length;i++){
                    html += " <tr id='jsonStr[i].catelog_id'>\n" +
                        "<td align=\"center\">"+jsonStr[i].catelog_id+"</td>\n" +
                        "<td align=\"center\">"+jsonStr[i].catelog_name+"</td>\n" +
                        "<td align=\"center\">"+jsonStr[i].catelog_miaoshu+"</td>\n" +
                        "<td align=\"center\"><a href=\"javascript:void(0);\" class=\"catelogDelete\" onclick=\"catelogDelete("+jsonStr[i].catelog_id+")\">删除</a></td>\n" +
                        "</tr>";
                }
                $("#adminMaintain").append(html);
            },error:function () {
                alert("1111111111111");
            }
        })
    })
</script>
</body>
</html>
