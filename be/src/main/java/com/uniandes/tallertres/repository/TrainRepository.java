package com.uniandes.tallertres.repository;

import com.uniandes.tallertres.entity.R1;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
@Repository
public interface TrainRepository extends CassandraRepository<R1> {
    @Query("SELECT COUNT(*) FROM train WHERE movieid = ?0 ALLOW FILTERING")
    int countByMovieId(int movieid);
}
