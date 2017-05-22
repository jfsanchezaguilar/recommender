package com.uniandes.tallertres.repository;

import com.uniandes.tallertres.entity.R3;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jfsan on 18/05/2017.
 */
@Repository
public interface R3Repository extends CassandraRepository<R3> {
    @Query("SELECT * FROM r3 WHERE readyid = ?0 ALLOW FILTERING")
    List<R3> findByReadyId(int readyId);
}
