package io.microservice.userservice.controllers;

import io.microservice.userservice.Service.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/Comment")
@CrossOrigin(origins = "*", allowedHeaders = "*") // add this line
public class CommentController {

    @Autowired
    ICommentService commentService;

    @PostMapping(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void createComment(
            @RequestParam Long blogId,
            @RequestParam String msg,
            @RequestParam(name = "file", required = false) MultipartFile file
    ) throws IOException {
        commentService.createComment(blogId, msg, file);
    }


    @DeleteMapping("/deleteComment")
    public ResponseEntity<?> deleteComment(@RequestParam Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("Comment deleted successfully.");
    }
}
