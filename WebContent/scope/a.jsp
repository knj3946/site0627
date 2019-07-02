<%@ page import="shop.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	//정보를 담고 유지할 수 있는 내장객체는??
	//request<session<application
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
	function send(){
		var form=document.querySelector("form");
		form.action="b.jsp"
		form.method="post";
		form.submit();
	}
</script>
</head>
<body>
	<%=member.getUname()%>님 로그인 중!!
	<form>
	<input name="name" type="text" placeholder="제품명"/>
	<input name="ea" type="text" placeholder="갯수"/>
	<input name="price" type="text" placeholder="가격"/>
	<button onClick="send();">전송</button>
	</form>
</body>
</html>