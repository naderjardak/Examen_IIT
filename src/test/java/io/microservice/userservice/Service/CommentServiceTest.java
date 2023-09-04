package io.microservice.userservice.Service;

import io.microservice.userservice.configuration.SessionService;
import io.microservice.userservice.entities.Blog;
import io.microservice.userservice.entities.Comment;
import io.microservice.userservice.entities.Images;
import io.microservice.userservice.entities.User;
import io.microservice.userservice.repositories.BlogRepository;
import io.microservice.userservice.repositories.CommentRepository;
import io.microservice.userservice.repositories.ImagesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CommentServiceTest {

    @InjectMocks
    private CommentService commentService;

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private BlogRepository blogRepository;

    @Mock
    private ImagesRepository imagesRepository;

    @Mock
    private SessionService sessionService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCommentWhenValidBlogIdCommentAndFileThenCommentIsCreated() throws IOException {
        User user = new User();
        Blog blog = new Blog();
        Comment comment = new Comment();
        MultipartFile file = new MockMultipartFile("file", "Hello, World!".getBytes());

        when(sessionService.getUserBySession()).thenReturn(user);
        when(blogRepository.findById(anyLong())).thenReturn(Optional.of(blog));
        when(imagesRepository.save(any(Images.class))).thenReturn(new Images());

        commentService.createComment(1L, comment, file);

        verify(commentRepository, times(1)).save(any(Comment.class));
    }

    @Test
    public void testCreateCommentWhenInvalidBlogIdThenCommentIsNotCreated() throws IOException {
        Comment comment = new Comment();
        MultipartFile file = new MockMultipartFile("file", "Hello, World!".getBytes());

        when(blogRepository.findById(anyLong())).thenReturn(Optional.empty());

        commentService.createComment(1L, comment, file);

        verify(commentRepository, times(0)).save(any(Comment.class));
    }

    @Test
    public void testCreateCommentWhenValidBlogIdCommentAndNoFileThenCommentIsCreatedWithoutImage() throws IOException {
        User user = new User();
        Blog blog = new Blog();
        Comment comment = new Comment();

        when(sessionService.getUserBySession()).thenReturn(user);
        when(blogRepository.findById(anyLong())).thenReturn(Optional.of(blog));

        commentService.createComment(1L, comment, null);

        verify(commentRepository, times(1)).save(any(Comment.class));
        verify(imagesRepository, times(0)).save(any(Images.class));
    }
}