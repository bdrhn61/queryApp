package com.project.question.controllers;

import com.project.question.entities.Post;
import com.project.question.services.PostServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostServices postServices;
    public PostController (PostServices postServices){
        this.postServices=postServices;
    }

    @GetMapping()
    public List<Post> getAllPosts() {
        return postServices.getAllPosts();
    }

    // Belirli bir userId'ye göre postları getiren endpoint
    @GetMapping("/{postId}")
    public Optional<Post> getOnePostById(@PathVariable Long postId) {
        return postServices.getOnePostById(postId);
    }


    @PostMapping
    public ResponseEntity<Post> createPost(@RequestParam Long userId,
                                           @RequestParam String title,
                                           @RequestParam String text) {
        Post post = postServices.createPost(userId, title, text);
        return ResponseEntity.ok(post);
    }
    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestParam String title,
                              @RequestParam String text){
        return postServices.updateOnePost(postId,title,text);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
         postServices.deleteOnePost(postId);
    }

}
