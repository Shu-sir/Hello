<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/2
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员管理页面</title>
    <script src="../js/jquery-3.4.1.min.js"></script>

    <link rel="stylesheet" type="text/css" href="../css/adminManager.css">
    <link rel="stylesheet" href="../css/normalize.css">
    <link rel="stylesheet" href="../css/style.css" media="screen" type="text/css"/>
    <link rel="stylesheet" href="../css/buttonStyle.css">

    <%--<base href="http://localhost:8080/dingcansystem_war_exploded/">--%>

</head>
<body>
<div class="outside">
    <div class="top">
        <span class="textView">网络订餐系统后台管理</span>
    </div>
    <div class="leftMenu">
        <div class="container">

            <ul id="tianChong">
                <li class="dropdown">
                    <a href="javascript:;" data-toggle="dropdown">First Menu <i class="icon-arrow"></i></a>
                    <ul class="dropdown-menu">
                        <li><a href="Home.html">Home</a></li>
                        <li><a href="Home.html">About Us</a></li>
                        <li><a href="Home.html">Services</a></li>
                        <li><a href="Home.html">Contact</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="javascript:;" data-toggle="dropdown">Second Menu <i class="icon-arrow"></i></a>
                    <ul class="dropdown-menu">
                        <li><a href="Home.html">Home</a></li>
                        <li><a href="Home.html">About Us</a></li>
                        <li><a href="Home.html">Services</a></li>
                        <li><a href="Home.html">Contact</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="javascript:;" data-toggle="dropdown">Third Menu <i class="icon-arrow"></i></a>
                    <ul class="dropdown-menu">
                        <li><a href="Home.html">Home</a></li>
                        <li><a href="Home.html">About Us</a></li>
                        <li><a href="Home.html">Services</a></li>
                        <li><a href="Home.html">Contact</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

    <div id="aa" class="rightContext"></div>
</div>

<script type="text/javascript">
    $(function () {
        $.ajax({
            url: "../Navigation",
            type: "get",
            data: {},
            datatype: "json/text",
            success: function (list) {
                var json = eval(list);
                console.log(json);
                console.log("json总长度：" + json.length);
                navigation();
                haha();

                function navigation() {
                    // alert("导航栏");
                    var html = "";
                    var j = 0;
                    //判断json是否为空
                    if (json.length > 0) {
                        for (var i = 0; i < json.length; i++) {
                            if (json[i].menu_class == "dropdown") {
                                html += "<li class=\"dropdown\">\n" +
                                    "<a href=\"javascript:void(0);\" onclick='' data-toggle=\"dropdown\">" + json[i].menu_name + "<i class=\"icon-arrow\"></i></a>\n" +
                                    "<ul class=\"dropdown-menu\">";
                                console.log("子节点长度：" + json[i].childNum);
                                if (json[i].childNum > 0) {
                                    for (var j = i + 1; j <= json[i].childNum + i; j++) {
                                        html += "<li><a href=\"" + json[j].url + "\" class=\"childMenu\">" + json[j].menu_name + "</a></li>";
                                    }
                                }
                                html += "</ul>";
                                i = i + json[i].childNum;
                            }
                            html += "</li>";
                            /*else {
                                html+="<li><a href=\""+json[i].url+"\">"+json[i].name+"</a></li>";
                                j++;
                                if(j==json[i].childNum){
                                    html+="</ul></li>";
                                    j=0;
                                }
                            }*/
                        }
                    }
                    $("#tianChong").html(html);
                }

                $(".childMenu").click(function () {
                /*$("a").click(function () {*/
                    //得到a标签的连接地址 attr方法就是获取href的属性值
                    var attr = $(this).attr("href");
                    $("#aa").load(attr);
                    //页面不刷新,实现局部刷新
                    return false;
                });

                function haha() {
                    // Dropdown Menu
                    var dropdown = document.querySelectorAll('.dropdown');
                    var dropdownArray = Array.prototype.slice.call(dropdown, 0);
                    dropdownArray.forEach(function (el) {
                        var button = el.querySelector('a[data-toggle="dropdown"]'),
                            menu = el.querySelector('.dropdown-menu'),
                            arrow = button.querySelector('i.icon-arrow');

                        button.onclick = function (event) {
                            if (!menu.hasClass('show')) {
                                menu.classList.add('show');
                                menu.classList.remove('hide');
                                arrow.classList.add('open');
                                arrow.classList.remove('close');
                                event.preventDefault();
                            } else {
                                menu.classList.remove('show');
                                menu.classList.add('hide');
                                arrow.classList.remove('open');
                                arrow.classList.add('close');
                                event.preventDefault();
                            }
                        };
                    });

                    Element.prototype.hasClass = function (className) {
                        return this.className && new RegExp("(^|\\s)" + className + "(\\s|$)").test(this.className);
                    };
                }
            },
            error: function () {
                alert("数据错误！！！！！！");
            }

        });
        /*$("a").click(function () {
            //得到a标签的连接地址 attr方法就是获取href的属性值
            var url = this.href;
            var args = {"time":new Date()};
            $("#aa").load(url,args);
            //页面不刷新,实现局部刷新
            return false;
        });*/

    })
</script>
<%--<script>
    <!--文档就绪事件$(document.ready(function(){}));-->
    $(function () {

    })
</script>--%>

<%--/*menu();
// bb();
function menu(daoHang) {
    /!*var daoHang = "[{\n" +
        "\t'name': '系统属性1',\n" +
        "\t'url': 'javascript:void(0)',\n" +
        "\t'childNum': 1,\n" +
        "\t'class': 'dropdown'\n" +
        "}, {\n" +
        "\t'name': '系统属性',\n" +
        "\t'url': 'Home.html',\n" +
        "\t'childNum': 0,\n" +
        "\t'class': 'dropdown-menu'\n" +
        "},{\n" +
        "\t'name': '基本操作1',\n" +
        "\t'url': 'javascript:void(0)',\n" +
        "\t'childNum': 2,\n" +
        "\t'class': 'dropdown'\n" +
        "},{\n" +
        "\t'name': '密码修改',\n" +
        "\t'url': 'Home.html',\n" +
        "\t'childNum': 0,\n" +
        "\t'class': 'dropdown-menu'\n" +
        "},{\n" +
        "\t'name': '管理员修改',\n" +
        "\t'url': 'Home.html',\n" +
        "\t'childNum': 0,\n" +
        "\t'class': 'dropdown-menu'\n" +
        "}]";*!/
    // var daoHang="[{'name':'系统属性','url':'javascript:void(0)','class':'dropdown'},{'name':'系统属性','url':'Home.html','class':'dropdown-menu'}]";
    // var json = JSON.parse(daoHang);
    var json = eval(daoHang);
    console.log(json);

    console.log("json总长度：" + json.length);
    navigation();

    function navigation() {
        // alert("导航栏");
        var html = "";
        var j = 0;
        //判断json是否为空
        if (json.length > 0) {
            for (var i = 0; i < json.length; i++) {
                if (json[i].class == "dropdown") {
                    html += "<li class=\"dropdown\">\n" +
                        "<a href=\"javascript:void(0);\" data-toggle=\"dropdown\">" + json[i].name + "<i class=\"icon-arrow\"></i></a>\n" +
                        "<ul class=\"dropdown-menu\">";
                    console.log("子节点长度：" + json[i].childNum);
                    if (json[i].childNum > 0) {
                        for (var j = i+1; j <= json[i].childNum + i; j++) {
                            html += "<li><a href=\"" + json[j].url + "\">" + json[j].name + "</a></li>";
                        }
                    }
                    html += "</ul>";
                    i=i+json[i].childNum;
                }
                html += "</li>";
                /!*else {
                    html+="<li><a href=\""+json[i].url+"\">"+json[i].name+"</a></li>";
                    j++;
                    if(j==json[i].childNum){
                        html+="</ul></li>";
                        j=0;
                    }
                }*!/
            }
        }
        $("#tianChong").html(html);
    }

}*/--%>

<script src="../js/index.js"></script>

</body>
</html>

