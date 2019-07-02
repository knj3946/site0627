<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	for(int i=1;i<=9;i++){
		for(int j=2;j<=9;j++){
			%>
			<div style="width:100px;float:left;">
			<%=j%>×<%=i%>=<%=i*j%>
			</div>
			
			<%
		}
		%>
		<br>
		<%
	}
	%>
</body>
</html>