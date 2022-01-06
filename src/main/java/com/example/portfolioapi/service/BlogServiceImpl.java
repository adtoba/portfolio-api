package com.example.portfolioapi.service;

import com.example.portfolioapi.model.BlogPost;
import com.example.portfolioapi.repository.BlogRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<BlogPost> getAllPosts() {
        return blogRepository.findAll();
    }

    @Override
    public BlogPost createPost(BlogPost blogPost) {
        return blogRepository.save(blogPost);
    }

    @Override
    public BlogPost editPost(ObjectId postId, BlogPost blogPost) {
        return null;
    }

    @Override
    public Optional<BlogPost> getPost(ObjectId postId) {
        return blogRepository.findById(postId);
    }

    @Override
    public void deletePost(ObjectId postId) {
        blogRepository.deleteById(postId);
    }
}
