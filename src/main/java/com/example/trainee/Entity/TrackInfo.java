package com.example.trainee.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;





@Entity
@Table
public class TrackInfo {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int trackInfo_Id;
	
	@ManyToOne
	@JoinColumn(name="trainee_id")
	private Trainee trainee;
	
	@ManyToOne
	@JoinColumn(name="track_id")
	private Track track;

	@CreationTimestamp
	private LocalDate created;

	public TrackInfo(int trackInfo_Id, Trainee trainee, Track track, LocalDate created) {
		super();
		this.trackInfo_Id = trackInfo_Id;
		this.trainee = trainee;
		this.track = track;
		this.created = created;
	}

	public TrackInfo() {
		super();
	}

	public int getTrackInfo_Id() {
		return trackInfo_Id;
	}

	public void setTrackInfo_Id(int trackInfo_Id) {
		this.trackInfo_Id = trackInfo_Id;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}
	
	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "TrackInfo [trackInfo_Id=" + trackInfo_Id + ", trainee=" + trainee + ", track=" + track + ", created="
				+ created + "]";
	}
	
	
	
}
