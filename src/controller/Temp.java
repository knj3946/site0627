package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;

public class Temp extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		how(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		how(request,response);
	}
	
	private void how(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("txt/html;charset=utf-8");
		try {
			PrintWriter out=response.getWriter();
			request.setCharacterEncoding("utf-8");
			String user=request.getParameter("user");
			String phone=request.getParameter("phone");
			User dto=new User();
			dto.setUser(user);
			dto.setPhone(phone);

			//request 객체가 죽지 않는 동안에는 데이터를 꺼내 쓸 수 있다.
			request.setAttribute("dto",dto);
			RequestDispatcher dp=request.getRequestDispatcher("/scope2/result.jsp");
			dp.forward(request,response);

			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
