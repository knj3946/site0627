<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
<script>
	window.addEventListener("load", function() {
		//var dan=document.getElementById("dan");
		var dan = document.querySelector("select");
		dan.addEventListener("change", function() {
			if(this.value!="0"){//0이 아니면
				send();
			}else{
				alert("단을 선택하세요!!");
			}
			send();
		});
	});

	function send() {
		form1.action="list.jsp";
		form1.method="post";//디폴트는 get
		form1.submit();
	}
</script>
</head>
<body>
	<form name="form1">
		<select name="dan">
			<option value="0">단 선택</option>
			<%
				request.setCharacterEncoding("utf-8");
				String dan = request.getParameter("dan");
				if (dan == null) {
					dan = "2";
				}
				for (int i = 2; i <= 9; i++) {
					if(Integer.parseInt(dan)==i){
						out.print("<option value='"+i+"' selected>"+i+"단</option>");
					}else{
					out.print("<option value='" + i +"'>"+i+"단</option>");
					}
				}
			%>
		</select>
		<p>
			<%
				for (int i = 1; i <= 9; i++) {
					out.print(dan + "×" + i + "=" + (2 * i) + "<br>");
				}
			%>
		
	</form>
</body>
</html>