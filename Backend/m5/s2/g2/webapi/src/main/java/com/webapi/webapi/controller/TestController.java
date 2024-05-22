package com.webapi.webapi.controller;

import com.webapi.webapi.dto.AuthDTO;
import com.webapi.webapi.dto.PostDTO;
import com.webapi.webapi.model.Author;
import com.webapi.webapi.model.Post;
import com.webapi.webapi.service.AuthSvc;
import com.webapi.webapi.service.PostSvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private PostSvc postSvc;

    @GetMapping("/blogPosts")
        public Page<Post> getAllPosts(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "id") String sortBy){
            return this.postSvc.getAllPosts(page,size,sortBy);
        }

    @GetMapping("/blogPosts/{id}")
    public ResponseEntity<Post> getByTitle(@PathVariable(required = true) Long id){
        Optional<Post> result=postSvc.getById(id);
        if (result.isPresent()) {
            return new ResponseEntity<Post>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/blogPosts")
    public ResponseEntity<Post> createPost(@RequestBody PostDTO postDTO){
        Post newPost=postSvc.createPost(postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
    }

    @PutMapping("/blogPosts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO){
        Optional<Post> result=postSvc.getById(id);
        if (result.isPresent()) {
            Post updatedPost = postSvc.updatePost(result.orElse(null), postDTO);
            return ResponseEntity.ok(updatedPost);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/blogPosts/{id}")
    public void deletePost(@PathVariable Long id){
        postSvc.deletePost(id);
    }

    @Autowired
    private AuthSvc authSvc;

    @GetMapping("/authors")
    public List<Author> getAllAuths(){
        return authSvc.getAllAuths();
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getById(@PathVariable(required = true) Long id){
        Author result=authSvc.getById(id);
        if (result!=null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/authors")
    public ResponseEntity<Author> createAuth(@RequestBody AuthDTO authDto) {
        Author newAuth = authSvc.createAuth(authDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAuth);
    }


    @PutMapping("/authors/{id}")
public ResponseEntity<Author> updateAuth(@PathVariable Long id, @RequestBody AuthDTO authDTO){
    Author result=authSvc.getById(id);
    if (result!=null) {
        Author updatedAuth = authSvc.updateAuth(result, authDTO);
        return ResponseEntity.ok(updatedAuth);
    } else {
        return ResponseEntity.notFound().build();
    }
}
    @DeleteMapping("/authors/{id}")
    public void deleteAuth(@PathVariable Long id){
        authSvc.deleteAuth(id);
    }

}
