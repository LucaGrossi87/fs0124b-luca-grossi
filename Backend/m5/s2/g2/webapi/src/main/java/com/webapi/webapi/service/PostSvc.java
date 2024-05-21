package com.webapi.webapi.service;

import com.webapi.webapi.model.Post;
import org.springframework.stereotype.Service;

@Service
public class PostSvc {

    public Post newPost(Long id, String car, String tit, String cov, String con, int read) {
        Post npost = new Post();
        npost.setId(id);
        npost.setCategory(car);
        npost.setTitle(tit);
        npost.setCover(cov);
        npost.setContent(con);
        npost.setReadingTime(read);
        return npost;
    }

}
