package com.arpangroup.db;

import java.util.Date;

public class TrainingInfo {
	private Integer trainingId;
	private String trainingName;
	private String startDate;
	private String endDate;	
	private String trainingMode;
	private String businessUnit;	
	private String contactPersonId;	

	public TrainingInfo() {
	}
	
	
	public TrainingInfo(String trainingName, String trainingMode) {
		super();
		this.trainingName = trainingName;
		this.trainingMode = trainingMode;
		this.startDate = new Date().toString();
	}



	public Integer getTrainingId() {
		return trainingId;
	}

	public TrainingInfo setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
		return this;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public TrainingInfo setTrainingName(String trainingName) {
		this.trainingName = trainingName;
		return this;
	}

	public String getStartDate() {
		return startDate;
	}

	public TrainingInfo setStartDate(String startDate) {
		this.startDate = startDate;
		return this;
	}

	public String getEndDate() {
		return endDate;
	}

	public TrainingInfo setEndDate(String endDate) {
		this.endDate = endDate;
		return this;
	}

	public String getTrainingMode() {
		return trainingMode;
	}

	public TrainingInfo setTrainingMode(String trainingMode) {
		this.trainingMode = trainingMode;
		return this;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public TrainingInfo setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
		return this;
	}

	public String getContactPersonId() {
		return contactPersonId;
	}

	public TrainingInfo setContactPersonId(String contactPersonId) {
		this.contactPersonId = contactPersonId;
		return this;
	}

	@Override
	public String toString() {
		return "{trainingId=" + trainingId + ", trainingName=" + trainingName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", trainingMode=" + trainingMode + ", businessUnit=" + businessUnit
				+ ", contactPersonId=" + contactPersonId + "}";
	}
	
	
	
	
	

}
