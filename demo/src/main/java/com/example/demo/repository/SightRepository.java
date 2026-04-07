package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Sight;

@Repository
public interface SightRepository extends MongoRepository<Sight, String> {

    Sight[] findByZone(String zone);

}
