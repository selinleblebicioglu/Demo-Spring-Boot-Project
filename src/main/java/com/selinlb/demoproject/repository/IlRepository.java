package com.selinlb.demoproject.repository;

import com.selinlb.demoproject.model.Il;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IlRepository extends MongoRepository<Il, String> {

}
