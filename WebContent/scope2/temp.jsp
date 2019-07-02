<%@ page import="domain.User"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String user=request.getParameter("user");
String phone=request.getParameter("phone");

User dto=new User();
dto.setUser(user);
dto.setPhone(phone);

//request 객체가 죽지 않는 동안에는 데이터를 꺼내 쓸 수 있다.
request.setAttribute("dto",dto);
RequestDispatcher dp=request.getRequestDispatcher("result.jsp");
dp.forward(request,response);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgColor="yellow">
<p> 
 유저는 <%=user%>
 폰번호는 <%=phone%>
 
 <a href="result.jsp">결과보기</a>
</body>
</html>