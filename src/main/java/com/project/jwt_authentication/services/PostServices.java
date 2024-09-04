package com.project.jwt_authentication.services;

import com.project.jwt_authentication.entities.Post;
import com.project.jwt_authentication.entities.User;
import com.project.jwt_authentication.repos.PostRepository;
import com.project.jwt_authentication.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServices {
   private PostRepository postRepository;
   private UserRepository userRepository;
   public PostServices(PostRepository postRepository,UserRepository userRepository){
        this.postRepository=postRepository;
        this.userRepository=userRepository;
    }

    // Tüm postları getiren servis
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Belirli bir userId'ye göre postları getiren servis
    public Optional<Post> getOnePostById(Long postId) {
        return postRepository.findById(postId);
    }

    public Post createPost(Long userId, String title, String text) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Post post = new Post();
            post.setUser(user);
            post.setTitle(title);
            post.setText(text);
            post.setCreateDate(new Date());  // Tarihi güncel zaman olarak ayarla
            return postRepository.save(post);  // Post nesnesini veritabanına kaydet
        } else {
            throw new IllegalArgumentException("User not found with id: " + userId);
        }
    }

    public Post updateOnePost(Long postId, String title, String text) {
        Optional<Post>  post=postRepository.findById(postId);
        if(post.isPresent()){
            Post postTemp = post.get();
            postTemp.setTitle(title);
            postTemp.setText(text);
        postRepository.save(postTemp);
        return postTemp;
        }
        return null;
    }

    public void deleteOnePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
