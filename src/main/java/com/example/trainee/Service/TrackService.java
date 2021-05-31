package com.example.trainee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.trainee.Dto.TrackDto;
import com.example.trainee.Entity.Batch;
import com.example.trainee.Entity.Track;
import com.example.trainee.Projection.TrackProjection;
import com.example.trainee.Repository.BatchRepository;
import com.example.trainee.Repository.TrackRepository;

@Service
public class TrackService {
	
	@Autowired
	TrackRepository trackRepository; 
	@Autowired
	BatchRepository batchRepository;
	
	
	public Track createNewTrack(TrackDto trackDto) {
		Batch batch = this.batchRepository.findById(trackDto.trackBatch).get();
		Track track = new Track(trackDto.trackId,trackDto.trackCode,trackDto.trackName,trackDto.trackStatus,batch);
		return this.trackRepository.save(track);
	}
	

	public List<Track> getAllTracks(){
		return this.trackRepository.findAll();
	}
	
//	public List<Batch> getAllExistTracksInBatch(int id){
//		return this.trackRepository.getAllExistTracks(id);
//	}
	
	public Page<TrackProjection> getTraineeByTracks(int id,int pageNumber, int pageSize){
		 PageRequest page = PageRequest.of(pageNumber, pageSize);
		return this.trackRepository.getTraineeByTrack(id, page);
	}
	
	public List<TrackProjection> getTraineeByTracks(int id){
		return this.trackRepository.getTraineeByTrack(id);
	}
	
	public void deleteTrack(int id) {
		this.trackRepository.deleteById(id);
	}
}
