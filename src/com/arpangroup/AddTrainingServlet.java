package com.arpangroup;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arpangroup.db.TrainingInfo;
import com.arpangroup.db.repository.TrainingRepository;


@WebServlet("/addTraining")
public class AddTrainingServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String trainingName = req.getParameter("trainingName");
	    String startDate = req.getParameter("startDate");
	    String endDate = req.getParameter("endDate");
	    String trainingMode = req.getParameter("trainingMode");
	    String businessUnit = req.getParameter("businessUnit");
	    String contactPersonId = req.getParameter("contactPersonId");
	    
	    TrainingInfo trainingInfo = new TrainingInfo()
				 .setTrainingName(trainingName)
				 //.setStartDate(rs.getDate("StartDate"))
				 //.setEndDate(rs.getDate("EndDate"))
				 .setTrainingMode(trainingMode)
				 .setBusinessUnit(businessUnit)
				 .setContactPersonId(contactPersonId);
	    try {
	    	new TrainingRepository().addTrainingInfo(trainingInfo);
	    	List<TrainingInfo> trainings = new TrainingRepository().getAllTrainings();
	    	req.setAttribute("trainings", trainings);
	    	req.getRequestDispatcher("admin.jsp").forward(req, resp); 
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	req.getSession().setAttribute("errorMessae", e.getMessage());
			resp.sendRedirect(req.getContextPath() + "/error.jsp");
	    }

	}
}

