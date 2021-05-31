package com.example.trainee.Entity;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.trainee.Enum.Status;



@Entity
@Table
public class Batch {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int batchId;
	private String batchName;
	private LocalDate beginDate;
	private LocalDate endDate;
	
	@Enumerated(EnumType.STRING)
	private Status batchStatus;
	
	@OneToMany(mappedBy = "batch")
	private List<Track> track;
	
//	@JsonIgnore
//	@OneToMany
//	@JoinColumn(name ="trainee_id")
//	private List<Trainee> trainee;

	public Batch() {
		super();
	}

	
	public Batch(int batchId, String batchName, LocalDate beginDate, LocalDate endDate, Status batchStatus) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.batchStatus = batchStatus;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public LocalDate getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(LocalDate beginDate) {
		this.beginDate = beginDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Status getBatchStatus() {
		return batchStatus;
	}

	public void setBatchStatus(Status batchStatus) {
		this.batchStatus = batchStatus;
	}

	
	
}
