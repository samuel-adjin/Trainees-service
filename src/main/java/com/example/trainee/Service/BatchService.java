package com.example.trainee.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.trainee.Dto.BatchDto;
import com.example.trainee.Entity.Batch;
import com.example.trainee.Entity.Track;
import com.example.trainee.Repository.BatchRepository;
import com.example.trainee.Repository.TraineeRepository;

@Service
public class BatchService {
	
	@Autowired
	BatchRepository batchRepository;
	@Autowired
	TraineeRepository traineeRepository;
	
	public Batch createNewBatch(BatchDto batchDto) {
//		List<Trainee> trainee = this.traineeRepository.findAllById(batchDto.trainee);
		Batch  batch = new Batch(batchDto.batch_id,batchDto.batchName,batchDto.startDate,batchDto.finishDate,batchDto.batchStatus);
		return this.batchRepository.save(batch);
	}
	
	public List<Batch> getAllBatch(){
		return this.batchRepository.findAll();
	}
	

	public Page<Track> getAllExistTracksByBatch(int id,int pageNumber,int pageSize){
		 PageRequest page = PageRequest.of(pageNumber, pageSize);
		return  this.batchRepository.getAllExistTrack(id,page);
	}
	
	public void deleteBatchById(int id) {
		this.batchRepository.deleteById(id);
	}
}
