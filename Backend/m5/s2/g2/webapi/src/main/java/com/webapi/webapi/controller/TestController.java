package com.webapi.webapi.controller;

import com.webapi.webapi.model.Author;
import com.webapi.webapi.model.Post;
import com.webapi.webapi.service.AuthSvc;
import com.webapi.webapi.service.PostSvc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class TestController {
    static final Logger log= LoggerFactory.getLogger(TestController.class);

    @Autowired
    private PostSvc postSvc;

    private Post npost;

    @GetMapping("/blogPosts")
    public String getPosts(){
        return "Lista posts: " + npost.toString();
    }

    @GetMapping("/blogPosts/1")
    public Post getPost123(){
        return npost;
        }

    @PostMapping("/blogPosts")
    public Post postPost(){
        npost = postSvc.newPost(1L, "category", "title","https://picsum.photos/200","content", 5);
        return npost;
    }

    @PutMapping("/blogPosts/1")
    public Post putPost123(){
        npost = postSvc.newPost(1L, "category_ed", "title_ed","https://picsum.photos/200","content_ed", 5);
        return npost;
    }

    @DeleteMapping("/blogPosts/1")
    public Post delPost123(){
        npost=null;
        return npost;
    }

    @Autowired
    private AuthSvc authSvc;

    private Author nauth;

    @GetMapping("/authors")
    public String getAuths(){
        return "Lista posts: " + nauth.toString();
    }

    @GetMapping("/authors/1")
    public Author getAuth123(){
        return nauth;
    }

    @PostMapping("/authors")
    public Author postAuth(){
        nauth = authSvc.newAuth(1L, "first", "last","first@last.auth", LocalDate.of(1966,6,06), "https://ui-avatars.com/api/?name=First+Last");
        return nauth;
    }

    @PutMapping("/authors/1")
    public Author putAuth123(){
        nauth = authSvc.newAuth(1L, "first_ed", "last_ed","first@last.auth", LocalDate.of(1966,6,06), "https://ui-avatars.com/api/?name=First+Last");
        return nauth;
    }

    @DeleteMapping("/authors/1")
    public Author delAuth123(){
        nauth=null;
        return nauth;
    }

}
