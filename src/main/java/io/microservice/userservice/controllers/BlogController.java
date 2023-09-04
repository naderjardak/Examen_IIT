package io.microservice.userservice.controllers;

import io.microservice.userservice.Service.interfaces.IBlogService;
import io.microservice.userservice.entities.Blog;
import io.microservice.userservice.entities.Images;
import io.microservice.userservice.entities.enmus.BlogStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    @PutMapping("/updateBlog")
    public Blog updateBlog(@RequestParam Long id, @RequestBody Blog blog) {
        return blogService.updateBlog(id, blog);
    }

    @DeleteMapping("/deleteBlog")
    public void deleteBlog(@RequestParam Long id) {
        blogService.deleteBlog(id);
    }

    @GetMapping("/getBlogById")
    public Blog getBlogById(@RequestParam Long id) {
        return blogService.getBlogById(id);
    }

    @GetMapping("getAllBlogs")
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }




    @PostMapping("/addImageToBlog")
    public ResponseEntity<?> addImageToBlog(
            @RequestParam Long blogId,
            @RequestBody Images image
    ) {
        try {
            blogService.addImageToBlog(blogId, image);
            return ResponseEntity.ok("Image added to the blog successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add image to the blog.");
        }
    }

    @DeleteMapping("/deleteImageFromBlog")
    public ResponseEntity<?> deleteImageFromBlog(
            @RequestParam Long blogId,
            @RequestParam Long imageId
    ) {
        try {
            blogService.deleteImageFromBlog(blogId, imageId);
            return ResponseEntity.ok("Image deleted from the blog successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete image from the blog.");
        }
    }

    @PatchMapping("/updateBlogStatus")
    public ResponseEntity<?> updateBlogStatus(
            @RequestParam Long blogId,
            @RequestParam BlogStatus newStatus
    ) {
        try {
            blogService.updateBlogStatus(blogId, newStatus);
            return ResponseEntity.ok("Blog status updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update blog status.");
        }
    }
}
