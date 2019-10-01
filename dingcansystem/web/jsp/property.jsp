<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/11
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>基本属性</title>
</head>
<%--<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>--%>
<link rel="stylesheet" href="../css/table1.css">
<script type="text/javascript">
    $(function () {
        $.ajax({
            url:"../property",
            type:"get",
            data:{},
            datatype:"json/text",
            success:function (list) {
                var json = eval(list);
                console.log(json);
                var html = "";
                for(var i = 0 ; i<json.length;i++){
                    html+="<tr>\n" +
                        "<td align=\"right\" width=\"30%\">"+json[i].id+"</td>\n" +
                        "<td align=\"left\" width=\"70%\">"+json[i].value+"</td>\n" +
                        "</tr>"
                }
                $("#tableProperty").append(html);
            },
            error:function () {
                alert(2222222222);
            }
        });
    })
</script>
<body>
<div class="wrap">
    <table class="main_tb" border="" id="tableProperty">
        <tr>
            <td class="tb_title" colspan="2" bgcolor="#aecce0">系统基本信息</td>
        </tr>
    </table>
</div>
<%--
系统操作系统：
操作系统类型：
用户，目录，临时目录：
JDK版本：
JDK安装目录：
总内存剩余内存：
--%>
</body>
</html>
