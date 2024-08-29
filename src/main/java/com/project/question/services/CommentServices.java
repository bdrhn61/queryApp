package com.project.question.services;

import com.project.question.entities.Comment;
import com.project.question.entities.Post;
import com.project.question.entities.User;
import com.project.question.repos.CommentRepository;
import com.project.question.requestModel.CommentCreateRequest;
import com.project.question.requestModel.CommentUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServices {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostServices postService;

    public CommentServices(CommentRepository commentRepository, UserService userService,
                           PostServices  postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }




        public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
            List<Comment> comments;
            if(userId.isPresent() && postId.isPresent()) {
                return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
            }else if(userId.isPresent()) {
                return commentRepository.findByUserId(userId.get());
            }else if(postId.isPresent()) {
                return commentRepository.findByPostId(postId.get());
            }else
                return commentRepository.findAll();

        }

    public Comment getOneComment(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createComment(CommentCreateRequest commentCreateRequest) {
        User user = userService.getOneUserById(commentCreateRequest.getUser_id());
        Optional <Post> post= postService.getOnePostById(commentCreateRequest.getPost_id());
        if(user!=null && post.isPresent()){
            Comment tempComment=new Comment();
            tempComment.setId(commentCreateRequest.getId());
            tempComment.setPost(post.get());
            tempComment.setUser(user);
            tempComment.setText(commentCreateRequest.getText());
            tempComment.setCreateDate(new Date());
            return commentRepository.save(tempComment);
        }else
            return null;
        }


    public Comment updateOneComment(Long commentId, CommentUpdateRequest commentUpdateRequest) {
       Optional<Comment> comment= commentRepository.findById(commentId);
       if(comment.isPresent()){
           Comment tempComment=comment.get();
           tempComment.setText(commentUpdateRequest.getText());
         return  commentRepository.save(tempComment);
       }
       return null;
    }

    public void deleteOneComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}

