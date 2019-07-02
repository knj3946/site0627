<%@ page import="domain.User"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
User dto=(User)request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgColor="pink">
최종적인 결과 출력
<p>
<%=dto.getUser()%>
<%=dto.getPhone()%>
</body>
</html>