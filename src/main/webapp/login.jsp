<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() 
	+ ":" + request.getServerPort() + request.getContextPath() + "/";
%>

<!DOCTYPE html >
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<base href="<%=basePath%>">

<title>login page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body >
	<div style="position:fixed;left:50%;top:50%;width:400px;height:200px;transform:translate(-50%,-50%);">
		<form action="${pageContext.request.contextPath}/springBean.do?method=register" method="POST" >
			<p>编号<input type="text" name="code" /></p>
			<p>名称<input type="text" name="name"   /></p>
			<p>创建日期<input type="text" name="cretime" placeholder="xxxx-xx-xx" /></p>
			<p>住址<input type="text" name="address" placeholder="XXX市-XXX省" />
			<p><input type="reset" value="重置" />
			   <input type="submit" value="提交" /></p>
		</form>
	</div>
</body>
</html>