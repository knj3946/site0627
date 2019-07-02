<%@ page import="shop.Member"%>
<%@ page import="shop.Cart"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
Cart cart=(Cart)session.getAttribute("cart");
%>
<%
	Member member=(Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgColor="green">
<%=member.getUname()%>님 로그인 중!!
장바구니에 담은 상품의 이름은 <%=cart.getName()%> 입니다.
장바구니에 담은 상품의 갯수는 <%=cart.getEa()%> 입니다.
장바구니에 담은 상품의 가격은 <%=cart.getPrice()%> 입니다.
</body>
</html>