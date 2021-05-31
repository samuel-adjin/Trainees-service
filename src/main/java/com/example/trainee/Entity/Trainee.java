package com.example.trainee.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.trainee.Enum.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Trainee {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int traineeId;
	
	
	private String name;
	private String surname;
	private LocalDate dob;
	
	
	@Enumerated(EnumType.STRING)
	private Status traineeStatus;
	
	
	@ManyToOne
	@JoinColumn(name ="traineeBatch_id")
	private Batch traineeeBatch;
	
	
	@JsonIgnore
	@OneToMany(mappedBy ="trainee", cascade = CascadeType.ALL)
	private List<TrackInfo> trackInfo;
	
	
	
	
	
	public Trainee(int traineeId, String name, String surname, LocalDate dob, Status traineeStatus,
			Batch traineeeBatch) {
		super();
		this.traineeId = traineeId;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.traineeStatus = traineeStatus;
		this.traineeeBatch = traineeeBatch;
	}



	public Trainee() {
		super();
	}



	public int getTraineeId() {
		return traineeId;
	}



	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public Status getTrainee_status() {
		return traineeStatus;
	}



	public void setTraineeStatus(Status traineeStatus) {
		this.traineeStatus = traineeStatus;
	}



	public Batch getTrainee_batch_id() {
		return traineeeBatch;
	}



	public void setTraineeeBatch(Batch traineeeBatch) {
		this.traineeeBatch = traineeeBatch;
	}



	public List<TrackInfo> getTrackInfo() {
		return trackInfo;
	}



	public void setTrackInfo(List<TrackInfo> trackInfo) {
		this.trackInfo = trackInfo;
	}



	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", name=" + name + ", surname=" + surname + ", dob=" + dob
				+ ", traineeStatus=" + traineeStatus + ", traineeeBatch=" + traineeeBatch + ", trackInfo=" + trackInfo
				+ "]";
	}





	
	
	
	
}
