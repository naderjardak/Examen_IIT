package io.microservice.userservice.controllers;

import io.microservice.userservice.Service.interfaces.ICommentService;
import io.microservice.userservice.entities.Comments;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CommentControllerTest {

    @Mock
    private ICommentService commentService;

    @InjectMocks
    private CommentController commentController;

    private Long blogId;
    private Comments comment;
    private MultipartFile file;

    @BeforeEach
    public void setUp() {
        blogId = 1L;
        comment = new Comments();
        file = new MockMultipartFile("file", "Hello, World!".getBytes());
    }

    @Test
    public void testCreateCommentWhenInvokedThenServiceMethodIsCalled() throws IOException {
        commentController.createComment(blogId, String.valueOf(comment), file);

        verify(commentService).createComment(eq(blogId), eq(String.valueOf(comment)), eq(file));
    }

    @Test
    public void testCreateCommentWhenFileCannotBeReadThenIOExceptionIsThrown() throws IOException {
        doThrow(IOException.class).when(commentService).createComment(any(Long.class), String.valueOf(any(Comments.class)), any(MultipartFile.class));

        try {
            commentController.createComment(blogId, String.valueOf(comment), file);
        } catch (IOException e) {
            verify(commentService).createComment(eq(blogId), String.valueOf(eq(comment)), eq(file));
            throw e;
        }
    }
}