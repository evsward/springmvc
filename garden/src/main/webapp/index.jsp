<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试页</title>
</head>
<body>
	<h2>Add Book</h2>
	<form method="post"
		action="<%=request.getContextPath()%>/add.do">
		书名:<input type="text" name="name" id="name"> 作者:<input
			type="text" name="author" id="author"> <input type="submit"
			value="Add">
	</form>
</body>
</html>
