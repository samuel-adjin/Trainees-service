package com.example.trainee.Api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainee.Dto.TrackDto;
import com.example.trainee.Entity.Track;
import com.example.trainee.Projection.TrackProjection;
import com.example.trainee.Service.TrackService;



@RestController
@RequestMapping("/track")
public class TrackController {
	
	
	@Autowired
	TrackService trackService;
	
	@PostMapping
	public Track createNewTrack(@RequestBody TrackDto trackDto) {
		return this.trackService.createNewTrack(trackDto);
	}
	
	@GetMapping
	public List<Track> getAllTracks(){
		return this.trackService.getAllTracks();
	}
	
//	@GetMapping("/{id}/batch")
//	public List<Batch> getAllExistTracksInBatch(@PathVariable("id") int id){
//		return this.trackService.getAllExistTracksInBatch(id);
//	}
	
	@GetMapping("/{id}/trainee")
	public Page<TrackProjection> getTraineeByTrack(@PathVariable("id") int id,@RequestParam int pageNumber,@RequestParam int pageSize){
		return this.trackService.getTraineeByTracks(id,pageNumber,pageSize);
	}
	
	@GetMapping("/{id}/traine")
	public List<TrackProjection> getTraineeByTrack(@PathVariable("id") int id){
		return this.trackService.getTraineeByTracks(id);
	}
	
	@DeleteMapping("{id}/track")
	public void deleteTrackById(@PathVariable("id") int id) {
		this.trackService.deleteTrack(id);
	}
}
