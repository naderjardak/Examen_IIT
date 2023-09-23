package io.microservice.userservice.Service;

import io.microservice.userservice.Service.interfaces.IBlogService;
import io.microservice.userservice.repositories.ImagesRepository;
import io.microservice.userservice.configuration.SessionService;
import io.microservice.userservice.entities.Blog;
import io.microservice.userservice.entities.Images;
import io.microservice.userservice.entities.User;
import io.microservice.userservice.entities.enmus.BlogStatus;
import io.microservice.userservice.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
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

    private static final String FILE_DIRECTORY = "C:/Users/ADMIN/OneDrive/Bureau/TYM/TYM_B2C_Front/src/assets/uploads";


    @Override
    public Blog createBlog(String msg, MultipartFile file) throws IOException {
        User user = sessionService.getUserBySession();
        Blog blog=new Blog();
        blog.setDescription(msg);
        blog.setUser(user);
        blog.setBlogStatus(BlogStatus.WAITING);
        blog.setCreationDate(new Date());
        if (file != null && !file.isEmpty()) {
            // Save the image and set the URL
            Path filePath1 = Paths.get(FILE_DIRECTORY + "/" + file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath1, StandardCopyOption.REPLACE_EXISTING);

            Images images = new Images();
            images.setUrl(file.getOriginalFilename());
            images = imagesRepository.save(images);
            blog.setImagesList(new ArrayList<>());
            blog.getImagesList().add(images);
        }

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
