<%@ page import="shop.Member"%>
<%@ page import="shop.Cart"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		int ea=Integer.parseInt(request.getParameter("ea"));
		int price=Integer.parseInt(request.getParameter("price"));
		
		Cart cart=new Cart();
		cart.setName(name);
		cart.setEa(ea);
		cart.setPrice(price);
		
		//현재 클라이언트가 사용가능한 세션에 cart를 담는다!!
		
		session.setAttribute("cart",cart);
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
<script>
</script>
</head>
<body bgColor="yellow">
<%=member.getUname()%>님 로그인 중!!
<form>
	당신이 입력한 상품은 <%=cart.getName()%> 입니다.
	갯수는 <%=cart.getEa()%> 입니다.
 	가격은 <%=cart.getPrice()%> 입니다.
	<p>
	<a href="c.jsp">장바구니 담기</a>
</form>	
</body>
</html>