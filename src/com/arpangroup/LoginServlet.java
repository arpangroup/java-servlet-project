package com.arpangroup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arpangroup.config.Constants;
import com.arpangroup.db.TrainingInfo;
import com.arpangroup.db.UserInfo;
import com.arpangroup.db.repository.TrainingRepository;
import com.arpangroup.db.repository.UserRepository;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			UserInfo userInfo = authenticate(req);
			if (userInfo.getUserType().contentEquals("A")) {
				List<TrainingInfo> trainings = new TrainingRepository().getAllTrainings();
				req.setAttribute("trainings", trainings);
				//resp.sendRedirect(req.getContextPath() + "/admin.jsp");
				req.getRequestDispatcher("admin.jsp").forward(req, resp); 
			} else {
				resp.sendRedirect(req.getContextPath() + "/employee.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("errorMessae", e.getMessage());
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
		}
		
	}
	
	private UserInfo authenticate(HttpServletRequest req) throws Exception{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username == null || username.length() <4) 
			throw new Exception("username should not be null or empty and it should be atleast 4 character long");
		if (password == null || password.length() <4) 
			throw new Exception("password should not be null or empty and it should be atleast 4 character long");
		UserInfo userInfo = new UserRepository().getUserInfoByUsernameAndPasword(username, password);
		if (userInfo == null) {
			throw new Exception("user not found!! <br/>invalid username or password");	
		} else {
			HttpSession session = req.getSession();		
			session.setAttribute("username", userInfo.getUsername());
			session.setAttribute("userType", userInfo.getUserType());
			return userInfo;
		}
	}
	
//	private String generateTable(List<TrainingInfo> trainings) {
//		String rows = "";
//		return rows;
//	}
	
}
