package com.arpangroup.db.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.arpangroup.config.Constants;
import com.arpangroup.db.ConnectionFactory;
import com.arpangroup.db.DbUtil;
import com.arpangroup.db.TrainingInfo;
import com.arpangroup.db.UserInfo;

public class TrainingRepository {	
	private Connection con;
    private PreparedStatement st;
    
	public TrainingInfo getTrainingInfoById(Integer trainingId){
		ResultSet rs = null;
		try {
			con = ConnectionFactory.getConnection();
			st = con.prepareStatement(Constants.QUERY_GET_TRAININGS_BY_ID);			
			st.setInt(1, trainingId);
			rs = st.executeQuery();
			if(rs.next()) {
			     return mapTo(rs);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(con);
			DbUtil.close(st);
		}
		return null;
	}
	
	public TrainingInfo addTrainingInfo(TrainingInfo training){
		try {
			con = ConnectionFactory.getConnection();
			st = con.prepareStatement(Constants.QUERY_ADD_TRAINING);
			st.setString(1, training.getTrainingName());
			st.setString(2, null);
			st.setString(3, null);
			st.setString(4, training.getTrainingMode());
			st.setString(5, training.getBusinessUnit());
			st.setString(6, training.getContactPersonId());
			
			st.executeUpdate();
	        return training;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(con);
			DbUtil.close(st);
		}
		return null;
	}
	
	public List<TrainingInfo> addTrainings(List<TrainingInfo> trainings){
		trainings.forEach(t -> addTrainingInfo(t));
		return trainings;
	}
	

	public List<TrainingInfo> getAllTrainings(){
		List<TrainingInfo> trainings = new ArrayList<TrainingInfo>();
		ResultSet rs = null;
		try {
			con = ConnectionFactory.getConnection();
			st = con.prepareStatement(Constants.QUERY_GET_ALL_TRAININGS);
			rs = st.executeQuery();
			while(rs.next()) {
				trainings.add(mapTo(rs));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(con);
			DbUtil.close(st);
		}
		return trainings;
	}
	
	public void deleteTrainingByTrainingName(String trainingName){
		try {
			con = ConnectionFactory.getConnection();
			st = con.prepareStatement(Constants.QUERY_DELETE_TRAINING_BY_TRAINING_NAME);
			st.setString(1, trainingName);
			
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(con);
			DbUtil.close(st);
		}
	}
	
	private TrainingInfo mapTo(ResultSet rs) throws SQLException{
		//rs.getDate("StartDate"); rs.getDate("EndDate")
		return new TrainingInfo()
				.setTrainingId(rs.getInt("TrainingID"))
				 .setTrainingName(rs.getString("TrainingName"))
				 //.setStartDate(rs.getDate("StartDate"))
				 //.setEndDate(rs.getDate("EndDate"))
				 .setTrainingMode(rs.getString("TrainingMode"))
				 .setBusinessUnit(rs.getString("BusinessUnit"))
				 .setContactPersonId(rs.getString("ContactPersonID"));
	}

}
