<%--
  Created by IntelliJ IDEA.
  User: 94993
  Date: 2017/2/26
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="basePath.jsp"%>
<html>
<head>
    <title>左侧导航</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>bootstrap/css/bootstrap.css">
    <script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath%>bootstrap/js/bootstrap.js"></script>
    <style>
        .accordion {
            width: 100%;
            max-width: 250px;
            margin: 30px 30px 30px;
            /*background: #FFF;*/
            background: #444359;
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            border-radius: 4px;
            list-style-type: none;
            padding: 5px 0px 10px;
        }

        .accordion .link {
            cursor: pointer;
            display: block;
            padding: 15px 15px 15px 42px;
            /*color: #4D4D4D;*/
            color: white;
            font-size: 14px;
            font-weight: 700;
            border-bottom: 1px solid #CCC;
            position: relative;
            -webkit-transition: all 0.4s ease;
            -o-transition: all 0.4s ease;
            transition: all 0.4s ease;
        }

        .accordion li:last-child .link {
            border-bottom: 0;
        }

        .accordion li i {
            position: absolute;
            top: 16px;
            left: 12px;
            font-size: 18px;
            color: #595959;
            -webkit-transition: all 0.4s ease;
            -o-transition: all 0.4s ease;
            transition: all 0.4s ease;
        }

        .accordion li i.fa-chevron-down {
            right: 12px;
            left: auto;
            font-size: 16px;
        }

        .accordion li.open .link {
            color: #b63b4d;
        }

        .accordion li.open i {
            color: #b63b4d;
        }
        .accordion li.open i.fa-chevron-down {
            -webkit-transform: rotate(180deg);
            -ms-transform: rotate(180deg);
            -o-transform: rotate(180deg);
            transform: rotate(180deg);
        }

        /**
         * Submenu
         -----------------------------*/
        .submenu {
            display: none;
            background: #444359;
            font-size: 14px;
            list-style-type: none;
            border-radius: 4px;
            margin: 0px;
        }

        .submenu li {
            border-bottom: 1px solid #4b4a5e;
        }

        .submenu a {
            display: block;
            text-decoration: none;
            color: #d9d9d9;
            padding: 12px;
            padding-left: 18px;
            -webkit-transition: all 0.25s ease;
            -o-transition: all 0.25s ease;
            transition: all 0.25s ease;
            border-radius: 4px;
        }

        .submenu a:hover {
            background: #b63b4d;
            color: #FFF;
        }
        body{
            background-color: #4A374A;
        }
    </style>
</head>
<body>
    <img src="<%=basePath%>img/ha.jpg" class="img-circle" style="width:200px;height: 200px;margin-left: 50px">
    <ul id="accordion" class="accordion">
        <%--<li>--%>
            <%--<div class="link"><i class="fa fa-paint-brush"></i>消费统计<i class="fa fa-chevron-down"></i></div>--%>
            <%--<ul class="submenu">--%>
                <%--<li><a href="<%=basePath%>report/personalReport" target="mainFrame">Personal</a></li>--%>
                <%--<li><a href="<%=basePath%>report/teamReport" target="mainFrame">Team</a></li>--%>
            <%--</ul>--%>
        <%--</li>--%>
        <%--<li>--%>
            <%--<div class="link"><i class="fa fa-code"></i>消费记录<i class="fa fa-chevron-down"></i></div>--%>
            <%--<ul class="submenu">--%>
                <%--<li><a href="<%=basePath%>record/personalRecord" target="mainFrame">Personal</a></li>--%>
                <%--<li><a href="<%=basePath%>record/teamRecord" target="mainFrame">Team</a></li>--%>
            <%--</ul>--%>
        <%--</li>--%>
        <%--<li>--%>
            <%--<div class="link"><i class="fa fa-mobile"></i>设置<i class="fa fa-chevron-down"></i></div>--%>
            <%--<ul class="submenu">--%>
                <%--<li><a href="<%=basePath%>user/index" target="mainFrame">人员管理</a></li>--%>
                <%--<li><a href="<%=basePath%>role/index" target="mainFrame">角色管理</a></li>--%>
                <%--<li><a href="<%=basePath%>menu/index" target="mainFrame">菜单管理</a></li>--%>
            <%--</ul>--%>
        <%--</li>--%>
            <c:forEach items="${menus}" var="m">

                <c:if test="${fn:length(m.childrenMenu)>0}">

                    <li>
                        <div class="link"><i class="fa fa-paint-brush"></i>${m.menuName}<i class="fa fa-chevron-down"></i></div>
                        <ul class="submenu">
                            <c:forEach items="${m.childrenMenu}" var="c">
                                <li><a href="<%=basePath%>${c.menuUrl}" target="mainFrame">${c.menuName}</a></li>
                            </c:forEach>
                        </ul>
                    </li>

                </c:if>

            </c:forEach>
    </ul>



    <%--<ul id="accordion" class="accordion">--%>

        <%--<li class="">--%>
            <%--<div class="link"><i class="fa fa-paint-brush"></i>设置<i class="fa fa-chevron-down"></i></div>--%>
            <%--<ul class="submenu" style="display: none;">--%>

                <%--<li><a href="http://localhost:8080/user/index" target="mainFrame">人员管理</a></li>--%>

                <%--<li><a href="http://localhost:8080/role/index" target="mainFrame">角色管理</a></li>--%>

                <%--<li><a href="http://localhost:8080/menu/index" target="mainFrame">菜单管理</a></li>--%>

            <%--</ul>--%>
        <%--</li>--%>

        <%--<li class="">--%>
            <%--<div class="link"><i class="fa fa-paint-brush"></i>消费记录<i class="fa fa-chevron-down"></i></div>--%>
            <%--<ul class="submenu" style="display: none;">--%>

                <%--<li><a href="http://localhost:8080/record/personalRecord" target="mainFrame">Personal</a></li>--%>

                <%--<li><a href="http://localhost:8080/record/teamRecord" target="mainFrame">Team</a></li>--%>

            <%--</ul>--%>
        <%--</li>--%>


        <%--<li class="">--%>
            <%--<div class="link"><i class="fa fa-paint-brush"></i>消费统计<i class="fa fa-chevron-down"></i></div>--%>
            <%--<ul class="submenu" style="display: none;">--%>

                <%--<li><a href="http://localhost:8080/report/personalReport" target="mainFrame">Personal</a></li>--%>

                <%--<li><a href="http://localhost:8080/report/teamReport" target="mainFrame">Team</a></li>--%>

            <%--</ul>--%>
        <%--</li>--%>

    </ul>
</body>
</html>
<script>
    $(function() {
        var Accordion = function(el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;

            // Variables privadas
            var links = this.el.find('.link');
            // Evento
            links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
        }

        Accordion.prototype.dropdown = function(e) {
            var $el = e.data.el;
            $this = $(this),
                $next = $this.next();

            $next.slideToggle();
            $this.parent().toggleClass('open');

            if (!e.data.multiple) {
                $el.find('.submenu').not($next).slideUp().parent().removeClass('open');
            };
        }

        var accordion = new Accordion($('#accordion'), false);
    });
</script>
