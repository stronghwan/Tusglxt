<%--
  Created by IntelliJ IDEA.
  User: 81248
  Date: 2020/1/9
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="js/bootstrap.min.js" ></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <title>搜索结果</title>
    <style type="text/css">
        body{
            /*navbar-fixed-top会覆盖掉页面其他得内容 默认得navbar得高度是 50px*/
            padding-top: 70px;
        }
        #toAddBookButton{
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <%@include file="head.jsp"%>
    <div class="container">
        <!--bookId搜索-->
        <form action="/findBookByIdServlet" method="post" class="form-horizontal">
            <div class="form-group">
                <label class=" col-sm-offset-9 col-sm-1 control-label" for="searchBookInput">书籍编号:</label>
                <div class="input-group col-sm-2">
                    <input type="text" name="keyword" id="searchBookInput" class="form-control" placeholder="Search for..." />
                    <span class="input-group-btn">
								<button type="submit" class="btn btn-default">搜索</button>
							</span>
                </div>
            </div>
            <div class="row">
                <button id="toAddBookButton" type="button" class="btn btn-default col-sm-offset-11 col-sm-1">
                    <a href="/add.jsp" style="text-decoration: none;" ><span class="glyphicon glyphicon-plus"></span>添加</a>
                </button>
            </div>
        </form>
        <!--图书信息-->
        <table class="table table-striped table-bordered table-hover">
            <tr>
                <th>书名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>ISBN</th>
                <th>图书类别</th>
                <th>单价</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>

            <c:if test="${bookList != null}">
                <c:forEach var="book" items="${bookList}">
                    <tr>
                        <td>${book.bookName}</td>
                        <td>${book.author}</td>
                        <td>${book.press}</td>
                        <td>${book.isbn}</td>
                        <td>${book.category}</td>
                        <td>${book.price}</td>
                        <td><a href="/updateBookServlet?id=${book.id}" style="text-decoration: none;"><span class="glyphicon glyphicon-tag" aria-hidden="true"></span></a></td>
                        <td><a onclick="confirm('确定要删除吗？')" href="/delete?id=${book.id}"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
        </div>
</body>
</html>
