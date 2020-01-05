<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--导航条-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>

            </button>
            <a href="/pageList?currentPage=1" class="navbar-brand">图书管理系统</a>
        </div>

        <div class="collapse navbar-collapse" id="#bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        文件 </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">新建文件</a></li>
                        <li><a href="#">找到文件</a></li>
                        <li><a href="#">更新文件</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">导入</a></li>
                        <li><a href="#">导出</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        编辑
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">撤消</a>
                        </li>
                        <li>
                            <a href="#">重做</a>
                        </li>
                        <li>
                            <a href="#">更新</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="#">裁剪</a>
                        </li>
                        <li>
                            <a href="#">复制</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        查看
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">撤消</a>
                        </li>
                        <li>
                            <a href="#">重做</a>
                        </li>
                        <li>
                            <a href="#">更新</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="#">裁剪</a>
                        </li>
                        <li>
                            <a href="#">复制</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        收藏夹
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">撤消</a>
                        </li>
                        <li>
                            <a href="#">重做</a>
                        </li>
                        <li>
                            <a href="#">更新</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="#">裁剪</a>
                        </li>
                        <li>
                            <a href="#">复制</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        工具
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">撤消</a>
                        </li>
                        <li>
                            <a href="#">重做</a>
                        </li>
                        <li>
                            <a href="#">更新</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="#">裁剪</a>
                        </li>
                        <li>
                            <a href="#">复制</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        帮助
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">撤消</a>
                        </li>
                        <li>
                            <a href="#">重做</a>
                        </li>
                        <li>
                            <a href="#">更新</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="#">裁剪</a>
                        </li>
                        <li>
                            <a href="#">复制</a>
                        </li>
                    </ul>
                </li>


            </ul>
            <div class="navbar-right">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            <span class="glyphicon glyphicon-user"></span>个人信息
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><%=request.getSession().getAttribute("username")%></a></li>
                            <li><a href="/login.jsp">退出</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>