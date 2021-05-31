package com.example.trainee.Api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainee.Dto.TrackInfoDto;
import com.example.trainee.Entity.TrackInfo;
import com.example.trainee.Service.TrackInfoService;

@RestController
@RequestMapping("/trackInfo")
public class TrackInfoController {
	
	@Autowired
	TrackInfoService trackInfoService;
	
	@PostMapping
	public TrackInfo createNewTrackInfo(@RequestBody TrackInfoDto trackInfoDto) {
		return this.trackInfoService.createNewTrackInfo(trackInfoDto);
	}
	
	@GetMapping
	public List<TrackInfo> getAllTrackInfo(){
		return this.trackInfoService.getAllTrackInfo();
	}
	
	

}
