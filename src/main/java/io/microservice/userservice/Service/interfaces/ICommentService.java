package io.microservice.userservice.Service.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ICommentService {
    void createComment(Long blogId,String msj, MultipartFile file) throws IOException;
    void deleteComment(Long commentId);
}
