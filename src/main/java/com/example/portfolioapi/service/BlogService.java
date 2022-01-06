package com.example.portfolioapi.service;

import com.example.portfolioapi.model.BlogPost;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BlogService {
    List<BlogPost> getAllPosts();
    BlogPost createPost(BlogPost blogPost);
    BlogPost editPost(String postId, BlogPost blogPost);
    Optional<BlogPost> getPost(String postId);
    void deletePost(String postId);
}
