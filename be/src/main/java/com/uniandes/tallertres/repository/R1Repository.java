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
public interface R1Repository extends CassandraRepository<R1> {
    @Query("SELECT * FROM ratings WHERE readyid = ?0 ALLOW FILTERING")
    List<R1> findByReadyId(int readyId);
}
