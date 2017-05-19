package com.uniandes.tallertres.repository;

import com.uniandes.tallertres.entity.Ready;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jfsan on 18/05/2017.
 */
@Repository
public interface ReadyRepository extends CassandraRepository<Ready> {
}
