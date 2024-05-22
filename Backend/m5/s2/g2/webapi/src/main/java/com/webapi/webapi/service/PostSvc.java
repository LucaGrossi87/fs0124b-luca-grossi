package com.webapi.webapi.service;

import com.webapi.webapi.dto.PostDTO;
import com.webapi.webapi.model.Author;
import com.webapi.webapi.model.Post;
import com.webapi.webapi.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostSvc {

    @Autowired
    private PostRepository postRepo;

    public Post newPost(String car, String tit, String cov, String con, int read, Author auth) {
        Post npost = new Post(car, tit, cov, con, read, auth);
        return postRepo.save(npost);
    }

    public Optional<Post> getById(Long id){
        return postRepo.findById(id);
    }

    public Page<Post> getAllPosts(int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
                return this.postRepo.findAll(pageable);
    }

    public void deletePost(Long id){
        postRepo.deleteById(id);
    }

    @Autowired
    private AuthSvc authSvc;

    public Post createPost(PostDTO postDTO) {
        Post newPost = new Post();
        newPost.setCategory(postDTO.getCategory());
        newPost.setTitle(postDTO.getTitle());
        newPost.setCover(postDTO.getCover());
        newPost.setContent(postDTO.getContent());
        newPost.setReadingTime(postDTO.getReadingTime());
        Author author = authSvc.getById(postDTO.getAuthorId());
        newPost.setAuthor(author);

        return postRepo.save(newPost);
    }

    public Post updatePost(Post result, PostDTO edPostDTO) {
        result.setCategory(edPostDTO.getCategory());
        result.setTitle(edPostDTO.getTitle());
        result.setCover(edPostDTO.getCover());
        result.setReadingTime(edPostDTO.getReadingTime());
        result.setContent(edPostDTO.getContent());
        return postRepo.save(result);
    }
}
