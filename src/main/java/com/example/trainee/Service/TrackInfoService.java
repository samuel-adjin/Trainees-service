package com.example.trainee.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trainee.Dto.TrackInfoDto;
import com.example.trainee.Entity.Track;
import com.example.trainee.Entity.TrackInfo;
import com.example.trainee.Entity.Trainee;
import com.example.trainee.Repository.TrackInfoRepository;
import com.example.trainee.Repository.TrackRepository;
import com.example.trainee.Repository.TraineeRepository;

@Service
public class TrackInfoService {

	
	@Autowired
	TrackInfoRepository trackInfoRepository;
	@Autowired
	TrackRepository trackRepository; 
	@Autowired
	TraineeRepository traineeRepository;
	
	public TrackInfo createNewTrackInfo(TrackInfoDto trackInfoDto) {
		Trainee trainee = this.traineeRepository.findById(trackInfoDto.trainee_Id).get();
		Track track = this.trackRepository.findById(trackInfoDto.track_Id).get();
		TrackInfo trackInfo = new TrackInfo(trackInfoDto.track_Id,trainee,track,trackInfoDto.created);
		return this.trackInfoRepository.save(trackInfo);
	}
	
	public List<TrackInfo> getAllTrackInfo(){
		return this.trackInfoRepository.findAll();
	}
	
	
}

