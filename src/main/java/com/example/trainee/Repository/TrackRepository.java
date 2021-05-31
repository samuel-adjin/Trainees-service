package com.example.trainee.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.trainee.Entity.Batch;
import com.example.trainee.Entity.Track;
import com.example.trainee.Projection.TrackProjection;

@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {

	@Query("select batch from Track t where t.id = ?1")
	List<Batch> getAllExistTracks(int id);

	@Query(value = "select name, surname,dob from trainee t, track tr, track_info ti where tr.track_id=?1 and t.trainee_id = ti.trainee_id and tr.track_id=ti.track_id", nativeQuery = true)
	Page<TrackProjection> getTraineeByTrack(int id,PageRequest page);
	@Query(value = "select name, surname,dob from trainee t, track tr, track_info ti where tr.track_id=?1 and t.trainee_id = ti.trainee_id and tr.track_id=ti.track_id", nativeQuery = true)
	List<TrackProjection> getTraineeByTrack(int id);

	

}
