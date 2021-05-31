package com.example.trainee.Entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.trainee.Enum.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Track {

	
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int trackId;
	
	private String code;
	private String trackName;
	
	@Enumerated(EnumType.STRING)
	private Status trackStatus;
	

	@JsonIgnore
	@OneToMany(mappedBy ="track", cascade = CascadeType.ALL)
	private List<TrackInfo> trackInfo;
	
	@ManyToOne
//	@JoinColumn(name ="trackBatch_id")
	private Batch batch;


	

	


	public Track(int trackId, String code, String trackName, Status trackStatus, Batch batch) {
		super();
		this.trackId = trackId;
		this.code = code;
		this.trackName = trackName;
		this.trackStatus = trackStatus;
		this.batch = batch;
	}


	public Track(int trackId, String code, String trackName, Status trackStatus) {
		super();
		this.trackId = trackId;
		this.code = code;
		this.trackName = trackName;
		this.trackStatus = trackStatus;
	}


	public Track() {
		super();
	}


	public int getTrackId() {
		return trackId;
	}


	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	

	

	public String getTrack_name() {
		return trackName;
	}


	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}


	public Status getTrackStatus() {
		return trackStatus;
	}


	public void setTrackStatus(Status trackStatus) {
		this.trackStatus = trackStatus;
	}


	public List<TrackInfo> getTrackInfo() {
		return trackInfo;
	}


	public void setTrackInfo(List<TrackInfo> trackInfo) {
		this.trackInfo = trackInfo;
	}


	public Batch getBatch() {
		return batch;
	}


	public void setBatch(Batch batch) {
		this.batch = batch;
	}


	public String getTrackName() {
		return trackName;
	}

	


	
	
	
}
