package com.example.trainee.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.trainee.Entity.Trainee;
import com.example.trainee.Projection.TraineeProjection;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee,Integer> {

	@Query(value ="SELECT * FROM trainee", nativeQuery= true)
	List<TraineeProjection> getUser();

	@Query(value = "select track_name, code,created from trainee t, track tr, track_info ti where t.trainee_id=?1 and t.trainee_id = ti.trainee_id and tr.track_id=ti.track_id", nativeQuery = true)
	List<TraineeProjection> getUserTracks(int id);

	@Query(value ="select * from trainee where trainee_batch_id = ?1", nativeQuery=true)
	Page<Trainee> getTraineeByBatch(int id, PageRequest page);

	@Query(value="select * from trainee where trainee_status=?1",nativeQuery=true)
	Page<Trainee> getTraineeByStatus(String status,PageRequest page);
}
