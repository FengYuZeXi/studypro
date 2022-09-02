<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "test!" %>
</h1>
<br/>
<%
    Object user = session.getAttribute("user");
    //如果等于null，说明还没有登录
    if(user == null){
        request.getRequestDispatcher("/admin/login.jsp").forward(request,response);
        return;
    }
%>
<a >我是b.jsp文件</a>
</body>
</html>