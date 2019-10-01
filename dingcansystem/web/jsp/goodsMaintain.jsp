<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/19
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>菜品管理</title>
    <style type="text/css">
        .wrap {
            position: relative;
        }

        .picture {
            position: absolute;
            top: 150px;
        }
    </style>
</head>
<link rel="stylesheet" href="../css/table1.css">
<link rel="stylesheet" href="../css/buttonStyle.css">
<body>
<div class="wrap">
    <table class="main_tb" border="" id="adminMaintain">
        <tr>
            <td class="tb_title" colspan="10" bgcolor="#aecce0">会员管理</td>
        </tr>
        <tr>
            <td align="center">ID</td>
            <td align="center">菜品名称</td>
            <td align="center">菜品描述</td>
            <td align="center">分类</td>
            <td align="center">菜品图片</td>
            <td align="center">单价</td>
            <td align="center">适合人群</td>
            <td align="center">操作</td>
        </tr>
        <%--<tr>
            <td align="center">1</td>
            <td align="center">米饭</td>
            <td align="center">非常好吃</td>
            <td align="center">主食</td>
            <td align="center"><a href="javascript:void(0);" onclick="viewPic('http://localhost:8080/dingcansystem_war_exploded/images/67ba550585e4c1ebbdf91ef579ab5f41.jpg')">查看图片</a></td>
            <td align="center">1</td>
            <td align="center">所有人</td>
            <td align="center"><a href="javascript:void(0);" onclick="">删除</a>&nbsp;&nbsp;<a href="javascript:void(0);"
                                                                                             onclick="">编辑</a></td>
        </tr>--%>
    </table>
</div>
<div class="picture" id="picDiv" style="display: none"><img src="../images/1.png" height="108" width="108"/></div>
<a href="../jsp/goodsAdd.jsp" class="biaoShi"><button type="button" class="bt_Add" onclick="">添加</button></a>
<a href="javascript:void(0);"><button type="button" class="bt_Add" onclick="">批量添加</button></a>
<a href="javascript:void(0);"><button type="button" class="bt_Add" onclick="">导出</button></a>
<script>
        $(".biaoShi").click(function () {
        //得到a标签的连接地址 attr方法就是获取href的属性值
        var attr = $(this).attr("href");
        $("#aa").load(attr);
        //页面不刷新,实现局部刷新
        return false;
    })
</script>
</body>
<script>
    $(function () {
        $.ajax({
            url: "../goodsCatelog",
            type: "get",
            data: {},
            datatype: "json/text",
            success: function (result) {
                // var json = JSON.parse(result);
                var json = eval('(' + result + ')');
                console.log(json);
                var html = "";
                for (var i = 0; i < json.length; i++){
                    html += "<tr id='"+json[i].goods_id+"'>\n" +
                        "<td align=\"center\">"+json[i].goods_id+"</td>\n" +
                        "<td align=\"center\">"+json[i].goods_name+"</td>\n" +
                        "<td align=\"center\">"+json[i].goods_miaoshu+"</td>\n" +
                        "<td align=\"center\">"+json[i].catelog_name+"</td>\n" +
                        "<td align=\"center\"><a href=\"javascript:void(0);\" onclick=\"viewPic(\'http://localhost:8080/dingcansystem_war_exploded/images/"+json[i].goods_pic+"\')\">查看图片</a></td>\n" +
                        "<td align=\"center\">"+json[i].goods_shichangjia+"</td>\n" +
                        "<td align=\"center\">"+json[i].goods_renqun+"</td>\n" +
                        "<td align=\"center\"><a href=\"javascript:void(0);\" onclick=\"deleteById("+json[i].goods_id+")\">删除</a>&nbsp;&nbsp;<a href=\"javascript:void(0);\"\n" +
                        "                                                                                             onclick=\""+""+"\">编辑</a></td>\n" +
                        "</tr>";

                }
                $("#adminMaintain").append(html);
                    }, error: function () {
                alert("数据错误");
            }
        });
    })
</script>
<script type="text/javascript">
    function viewPic(picPath) {
        $('div img').attr("src", picPath);
        // var display = $('#picDiv').css('display') ;
        $('#picDiv').attr("style", "display: block");
    }

    $('img').click(function () {
        $('#picDiv').attr("style", "display: none");
    })
</script>
<script>
    function deleteById(id) {
        $.ajax({
            url: "../deleteGood",
            type: "post",
            data: {"id":id},
            datatype: "json/text",
            success:function (jsonStr) {
                var json = eval('('+jsonStr+')');
                if (json.type == "1"){
                    $("#"+id).remove();
                }
            },error:function () {
                alert("数据错误123");
            }
        })
    }
</script>
</html>
