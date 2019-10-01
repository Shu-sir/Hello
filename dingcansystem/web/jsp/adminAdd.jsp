<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/18
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员添加</title>
</head>
<link rel="stylesheet" href="../css/table1.css">
<body>
<div class="wrap">
    <table class="main_tb" border="">
        <tr>
            <td class="tb_title" colspan="2" bgcolor="#aecce0">管理员添加</td>
        </tr>
        <tr>
            <td align="right" width="30%">用户名:</td>
            <td align="left" width="70%"><input type="text" id="userName"></td>
        </tr>
        <tr>
            <td align="right" width="30%">密码:</td>
            <td align="left" width="70%"><input type="text" id="adminPw"></td>
        </tr>
        <tr>
            <td align="right" width="30%">确认密码:</td>
            <td align="left" width="70%"><input type="text" id="reAdminPw"></td>
        </tr>
        <tr>
            <td align="right" width="30%"></td>
            <td align="left" width="70%">
                <button onclick="addAdmin()">添加</button>
            </td>
        </tr>
    </table>
</div>
<script type="text/javascript">
    function addAdmin() {
        var pW = $("#adminPw").val();
        var rePw = $("#reAdminPw").val();
        if (pW == rePw) {
            /*添加管理员*/
            $.ajax({
                url: "../addAdmin",
                type: "post",
                data: {
                    "adminName": $("#userName").val(),
                    "adminPw": $("#adminPw").val()
                },
                datatype: "json/text",
                success: function (jsonStr) {
                    var json = eval('(' + jsonStr + ')');
                    var str = json.type;
                    if (str == "添加成功!") {
                        alert("管理员添加成功!");
                        fanHui();
                        function fanHui() {
                            var url = "adminMaintain.jsp";
                            $("#adminMaintainA").load(url);
                            return false;
                        }
                    } else if (str == "用户名重复!"){
                            alert("用户名重复,添加失败！")
                    }else {
                        alert("添加失败！");
                    }
                }, error: function () {
                    alert("数据错误！");
                }
            })
        } else {
            alert("密码不一致");
        }
    }

</script>
</body>
</html>
