<%@ page import="com.stronghwan.entity.Book" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<title>编辑图书</title>
		<style type="text/css">
			body{
				padding-top: 150px;
			}
			#buttons{
				margin-top: 80px;
			}
			#a{
				text-decoration: none;
			}
			#resetInput{
				margin-left: 10px;
				margin-right: 10px;
			}
			
		</style>
	</head>
	<body>
		<%@include file="head.jsp"%>
		
		<div class="container">
			<%
				Book book = (Book)request.getAttribute("book");
			%>
			<form action="/update" method="post" class="form-horizontal">
				<fieldset id="">
					<legend>编辑图书</legend>
					<input type="hidden" value="${book.id}" name="id">
					<div class="form-group">
						<label for="bookNameInput" class="col-sm-2 control-label">书名:</label>
						<div class="col-sm-10">
							<input type="text" name="bookName" id="bookNameInput" class="form-control" value="${book.bookName}" />
						</div>
					</div>
					<div class="form-group">
						<label for="authorInput" class="col-sm-2 control-label">作者:</label>
						<div class="col-sm-10">
							<input type="text" name="author" id="authorInput" class="form-control" value="${book.author}" />
						</div>
					</div>
					<div class="form-group">
						<label for="pressInput" class="col-sm-2 control-label">出版社:</label>
						<div class="col-sm-10">
							<input type="text" name="press" id="pressInput" class="form-control"  value="${book.press}"/>
						</div>
					</div>
					<div class="form-group" >
						<label for="isbnInput" class="col-sm-2 control-label">ISBN:</label>
						<div class="col-sm-10">
							<input type="text" name="isbn" id="isbnInput" class="form-control" value="${book.isbn}" />
						</div>
					</div>
					<div class="form-group">
						<label for="categorySelect" class="col-sm-2 control-label">图书类别:</label>
						<div class="col-sm-10">
							<select name="category" id="categorySelect" class="form-control"  value="${book.category}" />
								<option value="default" selected="selected">图书类别</option>
								<option value="chengxusheji">程序设计</option>
								<option value="shujuku">数据库</option>
								<option value="tuxiangchuli">图像处理</option>
							</select>
						</div>
					</div>
					
					<div class="form-group" >
						<label for="priceInput" class="col-sm-2 control-label">单价:</label>
						<div class="col-sm-10">
							<input type="text" name="price" id="priceInput" class="form-control" value="${book.price}" />
						</div>
					</div>
					<div id="buttons" class="row">
						<input type="submit" class="btn btn-primary col-lg-offset-5 col-sm-1" value="确认">
						<%--<button type="button" >确认</button>--%>
						<%--<button type="button" class="btn btn-warning col-sm-1">重置</button>--%>
						<input id="resetInput" type="reset" class="btn btn-warning col-sm-1" value="重置" />
						<button id="rendirect" type="button" class="btn btn-info col-sm-1"><a id="a" href="/findBooksServlet">返回</a></button>
					</div>
					
				</div>
					
				</fieldset>
			</form>
		</div>
	</body>
</html>
