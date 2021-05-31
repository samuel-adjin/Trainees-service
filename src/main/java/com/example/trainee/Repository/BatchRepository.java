package com.example.trainee.Repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.trainee.Entity.Batch;
import com.example.trainee.Entity.Track;

@Repository
public interface BatchRepository extends JpaRepository<Batch,Integer> {

	@Query("select track from Batch b where b.id =?1")
	Page<Track> getAllExistTrack(int id,PageRequest page);
	
	

}
