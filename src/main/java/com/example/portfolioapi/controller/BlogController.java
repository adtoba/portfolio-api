package com.example.portfolioapi.controller;

import com.example.portfolioapi.model.ApiResponse;
import com.example.portfolioapi.model.BlogPost;
import com.example.portfolioapi.model.ErrorResponse;
import com.example.portfolioapi.service.BlogService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping(path = "blog/post")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody BlogPost blogPost) {
        if(blogPost.getTitle() == null || blogPost.getTitle().isEmpty()) {
            var errorResponse = ErrorResponse
                    .builder()
                    .status(false)
                    .message("Title cannot be null")
                    .data(null).build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        if(blogPost.getContent() == null || blogPost.getContent().isEmpty()) {
            var errorResponse = ErrorResponse
                    .builder()
                    .status(false)
                    .message("Content cannot be null")
                    .data(null).build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        var result = blogService.createPost(blogPost);
        var response = ApiResponse
                .builder()
                .status(true)
                .message("Post Created Successfully")
                .data(result)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        var result = blogService.getAllPosts();
        var response = ApiResponse
                .builder()
                .status(true)
                .message("All posts fetched successfully")
                .data(result)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getPost(@PathVariable String id) {
        var result = blogService.getPost(id);
        var response = ApiResponse
                .builder()
                .status(true)
                .message("Post fetched successfully")
                .data(result)
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updatePost(@PathVariable String id, @RequestBody BlogPost blogPost) {
        var result = blogService.editPost(id, blogPost);
        var response = ApiResponse
                .builder()
                .status(true)
                .message("Post updated successfully")
                .data(result)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePost(@PathVariable String id) {
        blogService.deletePost(id);
        var response = ApiResponse
                .builder()
                .status(true)
                .message("Post deleted successfully")
                .data(null)
                .build();
        return ResponseEntity.ok(response);
    }

}
