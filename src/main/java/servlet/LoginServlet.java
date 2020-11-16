package servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	
	private final UserValidationService userValidationService = new UserValidationService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			if (userValidationService.isValid(name, password)) {
				request.setAttribute("name", name);
				
				request.getRequestDispatcher("/WEB-INF/views/landing.jsp")
					.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Invalid Credentials");
				
				request.getRequestDispatcher("/WEB-INF/views/login.jsp")
				.forward(request, response);
			}
			
			
		}
	
}