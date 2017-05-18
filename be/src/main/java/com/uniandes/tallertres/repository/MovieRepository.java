package com.uniandes.tallertres.repository;

import com.uniandes.tallertres.entity.Movie;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by jfsan on 17/05/2017.
 */
@Repository
public interface MovieRepository extends CassandraRepository<Movie> {

    @Query("SELECT * FROM movies WHERE movieid = ?0 ALLOW FILTERING")
    List<Movie> findByMovieId(int movieId);
}
