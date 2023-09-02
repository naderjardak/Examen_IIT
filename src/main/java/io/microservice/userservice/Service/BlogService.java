package io.microservice.userservice.Service;

import io.microservice.userservice.Service.interfaces.IBlogService;
import io.microservice.userservice.configuration.SessionService;
import io.microservice.userservice.entities.Blog;
import io.microservice.userservice.entities.Images;
import io.microservice.userservice.entities.User;
import io.microservice.userservice.entities.enmus.BlogStatus;
import io.microservice.userservice.repositories.BlogRepository;
import io.microservice.userservice.repositories.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    SessionService sessionService;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ImagesRepository imagesRepository;

    @Override
    public Blog createBlog(Blog blog) {
        User user = sessionService.getUserBySession();
        blog.setUser(user);
        blog.setBlogStatus(BlogStatus.WAITING);
        blog.setCreationDate(new Date());
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        blog.setId(id);
        return blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public void addImageToBlog(Long blogId, Images image) {
        Blog blog = getBlogById(blogId);
        Images images=imagesRepository.save(image);

        if (blog != null) {
            blog.getImagesList().add(images);
            blogRepository.save(blog);
        }
    }

    @Override
    public void deleteImageFromBlog(Long blogId, Long imageId) {
        Blog blog = getBlogById(blogId);
        Images images=imagesRepository.findById(imageId).get();
        if (blog != null) {
            Images imageToRemove = blog.getImagesList()
                    .stream()
                    .filter(image -> image.getId().equals(imageId))
                    .findFirst()
                    .orElse(null);
            if (imageToRemove != null) {
                blog.getImagesList().remove(images);
                imagesRepository.deleteById(imageId);
                blogRepository.save(blog);
            }
        }
    }

    @Override
    public void updateBlogStatus(Long blogId, BlogStatus newStatus) {
        Blog blog = getBlogById(blogId);
        if (blog != null) {
            blog.setBlogStatus(newStatus);
            blogRepository.save(blog);
        }
    }
}
