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

import com.example.trainee.Dto.BatchDto;
import com.example.trainee.Entity.Batch;
import com.example.trainee.Entity.Track;
import com.example.trainee.Service.BatchService;

@RestController
@RequestMapping("/batch")
public class BatchController {
	
	
	@Autowired
	BatchService batchService;
	
	@PostMapping
	public Batch createNewBatch(@RequestBody BatchDto batchDto) {
		return this.batchService.createNewBatch(batchDto);
	}
	@GetMapping
	public List<Batch> getAllBatch(){
		return this.batchService.getAllBatch();
	}
	
	@GetMapping("/{id}/tracks")
	public Page<Track> getAllExistTracksByBatch(@PathVariable("id") int id,@RequestParam int pageNumber,@RequestParam int pageSize){
		return this.batchService.getAllExistTracksByBatch(id,pageNumber,pageSize);
	}
	
	@DeleteMapping("/{id}/batch")
	public void deleteBatchById(@PathVariable("id") int id) {
		this.batchService.deleteBatchById(id);
	}
}
