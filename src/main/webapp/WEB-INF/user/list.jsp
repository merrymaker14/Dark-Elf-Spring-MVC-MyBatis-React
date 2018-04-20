<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Пользователи</title>
</head>
    <body>
        Пользователи:
        <c:forEach var="user" items="${users}">
		    <div>
		        <c:out value="${user.userName}" />
		    </div>
		    <br />
		</c:forEach>
    </body>
</html>