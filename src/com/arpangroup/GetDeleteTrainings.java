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


@WebServlet("/GetDeleteTrainings")
public class GetDeleteTrainings extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TrainingInfo> trainings = new TrainingRepository().getAllTrainings();
		req.setAttribute("trainings", trainings);
    	req.getRequestDispatcher("deleteTraining.jsp").forward(req, resp); 
    	req.setAttribute("trainings", trainings);
	}
}

