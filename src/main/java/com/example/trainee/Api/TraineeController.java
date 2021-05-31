package com.example.trainee.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainee.Dto.TraineeDto;
import com.example.trainee.Entity.Trainee;
import com.example.trainee.Projection.TraineeProjection;
import com.example.trainee.Service.TraineeService;

@RestController
@RequestMapping("/trainee")
@CrossOrigin(origins = "*")
public class TraineeController {

	@Autowired
	TraineeService traineeService;
	
	@PostMapping
	public Trainee createNewTrainee(@RequestBody TraineeDto traineeDto) {
		return this.traineeService.createNewTrainee(traineeDto);
	}

	
	@GetMapping("/{id}/tracks")
	public List<TraineeProjection> getUserTracks(@PathVariable("id") int id){
		return this.traineeService.getUserTracks(id);
	}
	
	@GetMapping("/{id}/batch")
	public Page<Trainee> getTraineeByBatch(@PathVariable("id") int id ,@RequestParam int pageNumber,@RequestParam int pageSize){
		return this.traineeService.getTraineeByBatch(id, pageNumber,pageSize);
		
	}
	
	@GetMapping("/{status}/status")
	public Page<Trainee> getTraineeByStatus(@PathVariable("status") String status, @RequestParam int pageNumber, @RequestParam int pageSize){
		return this.traineeService.getTraineebyStatus(status,pageNumber,pageSize);
	}
	
	@DeleteMapping("/{id}/delete")
	public void deleteTraineesById(@PathVariable("id") int id) {
		this.traineeService.deleteTrainees(id);
	}
	
	@GetMapping("/allTrainees")
	public List<Trainee> getAllTrainees(){
		return this.traineeService.getAllTrainees();
	}
}

