package io.microservice.userservice.Service.interfaces;

import io.microservice.userservice.entities.Blog;
import io.microservice.userservice.entities.Images;
import io.microservice.userservice.entities.enmus.BlogStatus;

import java.util.List;

public interface IBlogService {

    Blog createBlog(Blog blog);
    Blog updateBlog(Long id, Blog blog);
    void deleteBlog(Long id);
    Blog getBlogById(Long id);
    List<Blog> getAllBlogs();
    void addImageToBlog(Long blogId, Images image);
    void deleteImageFromBlog(Long blogId, Long imageId);
    void updateBlogStatus(Long blogId, BlogStatus newStatus);

}
