<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/24
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang>
<head>
    <meta charset="UTF-8">
    <title>菜品添加</title>
</head>
<link rel="stylesheet" href="../css/table1.css">
<body>
<div class="wrap" id="catelogMaintainA">
    <table class="main_tb" border="" id="adminMaintain">
        <tr>
            <td class="tb_title" colspan="2" bgcolor="#aecce0">菜品添加</td>
        </tr>
        <tr>
            <td align="right">菜品类别：</td>
            <td align="left">
                <select id="goods_vatelog">
                    <option>1.主食</option>
                    <option>2.炒菜</option>
                    <option>3.盖浇饭</option>
                    <option>4.炒饭</option>
                    <option>5.炒面</option>
                    <option>6.面条</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right">菜品名称：</td>
            <td align="left"><input type="text" id="goods_name"></td>
        </tr>
        <tr>
            <td align="right">菜品介绍：</td>
            <td align="left"><textarea id="description" rows="8" cols="30"></textarea></td>
        </tr>
        <tr>
            <td align="right">菜品图片：</td>
            <td align="left"><%--<input type="text" id="goods_pic">--%>
                <form action="${pageContext.request.contextPath}/upload" id="saveReportForm" name="uploadForm"
                      method="post" enctype="multipart/form-data">
                    <input type="file" name="upfilejpg" id="upfilejpg" accept="image/gif,image/jpeg,image/x-png"/>
                    <input type="submit" class="bt_Add" name="bt_Add" value="上传" onclick="getPath()"/>
                </form>
                <%--<input type="file" name="upfilejpg"/>--%>
                <%--                <input type="submit" class="bt_Add" name="bt_Add" value="上传">--%>
            </td>
        </tr>
        <tr>
            <td align="right">单价：</td>
            <td align="left"><input type="text" id="goods_shichangjia"></td>
        </tr>
        <tr>
            <td align="right">适合人群：</td>
            <td align="left">
                <select id="renQuen">
                    <option>所有人</option>
                    <option>年轻人</option>
                    <option>中年人</option>
                    <option>小孩</option>
                    <option>孕妇</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right"></td>
            <td align="left">
                <button type="button" class="bt_Add" id="addGoods" onclick="addGoods()">提交</button>
            </td>
        </tr>
    </table>
    <!--  <a href="../jsp/adminAdd.jsp"><button type="button" class="bt_Add">添加</button></a>-->
</div>
<script>
    function getPath() {
        var path = $("#upfilejpg").val();
        var str = path.split("\\");
        var str1 = str[str.length - 1];
        return str1;
    }

    function addGoods() {
        var a = getPath();
        $.ajax({
            url: "../addGoods",
            type: "post",
            data: {
                "goods_vatelog": $("#goods_vatelog").val().split('.')[0],
                "goods_name": $("#goods_name").val(),
                "description": $("#description").val(),
                "upfilejpg": a,
                "goods_shichangjia": $("#goods_shichangjia").val(),
                "renQuen": $("#renQuen").val()
            },
            datatype: "json/text",
            success: function (result) {
                if (result == "1") {
                    /*$('#addGoods').click(function () {
                        $("#catelogMaintainA").load("goodsMaintain.jsp");
                        return false;
                    });*/
                    alert("添加成功");

                    fanHui();
                    function fanHui() {
                        var url = "goodsMaintain.jsp";
                        $("#catelogMaintainA").load(url);
                        return false;
                    }
                } else {
                    alert("失败");
                }
            }, error: function () {
                alert("数据错误");
            }

        })
    }
</script>
</body>
</html>
