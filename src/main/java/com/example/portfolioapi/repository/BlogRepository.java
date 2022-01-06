package com.example.portfolioapi.repository;

import com.example.portfolioapi.model.BlogPost;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends MongoRepository<BlogPost, String> {

}
