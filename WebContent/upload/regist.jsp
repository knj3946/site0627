<%@ page import="java.io.File"%>
<%@ page import="util.FileManager"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.InputStream"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%
//파일 업로드란? 클라이언트가 전송한 파일 데이터를 서버의 특정 위치에
//저장하는 것(네트워크 + 스트림 등 많은 기술이 필요)
//우리가 선택한 라이브러리는 oreilly 사에서 제작한 책의 예제였던 cos.jar를
//사용해본다!!

//request.setCharacterEncoding("utf-8");
//String title=request.getParameter("title");

//out.print("전송한 제목은 "+title);

//아래의 코드는 윈도우에서만 실행되므로 환경에 지배를 받음...
//해결책) 모든 플랫폼에서 실행되려면 예)리눅스,유닉스,맥 등...
//경로를 수정해야한다..
//방법)개발자가 경로를 하드코딩하지 말자!!
//jsp의 내장객체 중 application 내장객체를 이용하면 웹어플리케이션 내의 전역적
//정보를 가지고 있으므로, 특정 디렉토리의 하드디스크상 풀 경로로 구해준다!!
//application 내장객체의 자료형은 ? ServletContext
//String saveDirectory=application.getRealPath("/data");
ServletContext context=request.getServletContext();
String saveDirectory=context.getRealPath("/data/");
out.print(saveDirectory);

//생성자에서 업로드가 수행됨
int maxSize=5*1024*1024;
String encoding="UTF-8";
MultipartRequest multi=new MultipartRequest(request,saveDirectory,maxSize,encoding);

//방금 올려진 이미지명을 현재날자를 이용하여 바꾸기!!
File file=(File)multi.getFile("myfile");
long time=System.currentTimeMillis();

String ext=FileManager.getExt(file.getName());
String d=saveDirectory+Long.toString(time,10)+"."+ext;

File n_file=new File(d);
if( file.exists()){ file.renameTo(n_file);}

//제목받기
String title=multi.getParameter("title");
out.print("<br> 제목은 :"+title);

%>