package com.uniandes.tallertres.repository;

import com.uniandes.tallertres.entity.R2;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
@Repository
public interface R2Repository extends CassandraRepository<R2> {
    @Query("SELECT * FROM r2 WHERE readyid = ?0 ALLOW FILTERING")
    List<R2> findByReadyId(int readyId);
}
