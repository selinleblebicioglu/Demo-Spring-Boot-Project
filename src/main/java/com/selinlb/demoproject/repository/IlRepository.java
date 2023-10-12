package com.selinlb.demoproject.repository;

import com.selinlb.demoproject.model.Il;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IlRepository extends MongoRepository<Il, String> {

    List<Il> findByName(String name);
}
