package io.microservice.userservice.Service;

import io.microservice.userservice.Service.interfaces.ICommentService;
import io.microservice.userservice.configuration.SessionService;
import io.microservice.userservice.entities.Blog;
import io.microservice.userservice.entities.Comment;
import io.microservice.userservice.entities.Images;
import io.microservice.userservice.entities.User;
import io.microservice.userservice.repositories.BlogRepository;
import io.microservice.userservice.repositories.CommentRepository;
import io.microservice.userservice.repositories.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class CommentService implements ICommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    ImagesRepository imagesRepository;

    @Autowired
    SessionService sessionService;

    private static final String FILE_DIRECTORY = "C:/Users/ADMIN/OneDrive/Bureau/TYM/TYM_B2C_Front/src/assets/uploads";

    @Override
    public void createComment(Long blogId, String msj, MultipartFile file) throws IOException {
        User user = sessionService.getUserBySession();

        Blog blog = blogRepository.findById(blogId).orElse(null);
        if (blog != null) {
            Comment comment1 = new Comment();

            // Check if a file was uploaded
            if (file != null && !file.isEmpty()) {
                // Save the image and set the URL
                Path filePath1 = Paths.get(FILE_DIRECTORY + "/" + file.getOriginalFilename());
                Files.copy(file.getInputStream(), filePath1, StandardCopyOption.REPLACE_EXISTING);

                Images images = new Images();
                images.setUrl(FILE_DIRECTORY + "/" + file.getOriginalFilename());
                images = imagesRepository.save(images);

                comment1.setImages(images);
            }

            // Set other properties
            comment1.setUser(user);
            comment1.setBlog(blog);
            comment1.setMessage(msj);

            // Save the comment1 object to the repository
            commentRepository.save(comment1);
        }
    }



    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }


}