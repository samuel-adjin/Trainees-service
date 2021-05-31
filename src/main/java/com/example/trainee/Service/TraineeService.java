package com.example.trainee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.trainee.Dto.TraineeDto;
import com.example.trainee.Entity.Batch;
import com.example.trainee.Entity.Trainee;
import com.example.trainee.Projection.TraineeProjection;
import com.example.trainee.Repository.BatchRepository;
import com.example.trainee.Repository.TraineeRepository;



@Service
public class TraineeService {

	
	@Autowired
	TraineeRepository traineeRepository;
	@Autowired
	BatchRepository batchRepository;
	
	public Trainee createNewTrainee(TraineeDto traineeDto) {
		Batch batch = this.batchRepository.findById(traineeDto.traineeBatchId).get();
		Trainee trainee = new Trainee(traineeDto.trainee_Id,traineeDto.firstName,traineeDto.lastName,traineeDto.dateOfBirth,traineeDto.traineeStatus,batch);
		return this.traineeRepository.save(trainee);
	}
	
//	public List<TraineeProjection> getUsername(){
//		return this.traineeRepository.getUser();
//	}
	
	public List<TraineeProjection> getUserTracks(int id ){
		return this.traineeRepository.getUserTracks(id);
	}
	
//	public List<Trainee> getTraineeByBatch(int id){
//		return this.traineeRepository.getTraineeByBatch(id);
	
	public Page<Trainee> getTraineeByBatch(int id, int pageNumber,int pageSize){
		 PageRequest page = PageRequest.of(pageNumber, pageSize);
		return this.traineeRepository.getTraineeByBatch(id, page);
		
	}
	
	public Page<Trainee> getTraineebyStatus(String status,int pageNumber,int pageSize){
		 PageRequest page = PageRequest.of(pageNumber, pageSize);
		return this.traineeRepository.getTraineeByStatus(status,page);
	}
	
	public void deleteTrainees(int id) {
		this.traineeRepository.deleteById(id);
	}
	
	public List<Trainee> getAllTrainees(){
		return this.traineeRepository.findAll();
	}
}
