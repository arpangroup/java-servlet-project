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


@WebServlet("/deleteTraining")
public class DeleteTraining extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String trainingName = req.getParameter("trainingOptions");
		new TrainingRepository().deleteTrainingByTrainingName(trainingName);
		
		List<TrainingInfo> trainings = new TrainingRepository().getAllTrainings();
		req.setAttribute("trainings", trainings);
		req.getRequestDispatcher("admin.jsp").forward(req, resp); 
	}
}

