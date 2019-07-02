<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
<script>
	function send(){
		form1.action="test.jsp";
		form1.submit();
	}
</script>
</head>
<% 
	String sel=request.getParameter("sel");
%>
<%
	if(sel==null){
		%>
		<body bgColor="yellow">
		<%
	}else{
		%>
		<body bgColor=<%=sel%>>
		<%
		}
%>
	<form name="form1">
		<select name="sel">
			<option value="red">빨간색</option>
			<option value="blue">파란색</option>
			<option value="green">초록색</option>
		</select>
		<button onClick="send()">색상변경</button>
	</form>
</body>
</html>