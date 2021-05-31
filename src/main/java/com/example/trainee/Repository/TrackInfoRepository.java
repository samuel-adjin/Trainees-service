package com.example.trainee.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trainee.Entity.TrackInfo;

@Repository
public interface TrackInfoRepository extends JpaRepository<TrackInfo,Integer> {

}
