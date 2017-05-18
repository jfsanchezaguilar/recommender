package com.uniandes.tallertres.repository;

import com.uniandes.tallertres.entity.Rating;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jfsan on 17/05/2017.
 */
@Repository
public interface RatingRepository extends CassandraRepository<Rating> {

    @Query("SELECT * FROM ratings WHERE userid = ?0 ALLOW FILTERING")
    List<Rating> findByUserId(int userId);
}
