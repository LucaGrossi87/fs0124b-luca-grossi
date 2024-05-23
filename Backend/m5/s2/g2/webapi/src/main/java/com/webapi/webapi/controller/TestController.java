package com.webapi.webapi.controller;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.webapi.webapi.WebapiApplication;
import com.webapi.webapi.dto.AuthDTO;
import com.webapi.webapi.dto.PostDTO;
import com.webapi.webapi.model.Author;
import com.webapi.webapi.model.Post;
import com.webapi.webapi.service.AuthSvc;
import com.webapi.webapi.service.ImageUploadService;
import com.webapi.webapi.service.PostSvc;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RestController
@RequestMapping("/api")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(WebapiApplication.class);

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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Post> createPost(@RequestBody @Validated PostDTO postDTO, BindingResult validation){
        if (validation.hasErrors()){
            try {
                throw new BadRequestException(String.valueOf(validation.getAllErrors()));
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        }
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

    private ImageUploadService imageUploadService;

    @Autowired
    public void ImageUploadController(ImageUploadService imageUploadService) {
        this.imageUploadService = imageUploadService;
    }
    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> upload(@RequestParam("file")MultipartFile file){
        try {
            Map<String, Object> result = imageUploadService.uploadImage(file);
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(Map.of("error", "Image upload failed"));
        }
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

        @Value("${sendgrid.api.key}")
        private String sendGridApiKey;
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Author> createAuth(@RequestBody @Validated AuthDTO authDto, BindingResult validation) throws IOException {
        if (validation.hasErrors()){
            try {
                throw new BadRequestException(String.valueOf(validation.getAllErrors()));
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        }
        Author newAuth = authSvc.createAuth(authDto);
        Email from = new Email("textfrom@example.com");
        String subject = "Sending with SendGrid is Fun";
        Email to = new Email("textto@example.com");
        Content content = new Content("text/plain","and easy to do anywhere");
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            logger.info(String.valueOf(response.getStatusCode()));
            logger.info(response.getBody());
            logger.info(String.valueOf(response.getHeaders()));
        } catch (IOException ex) {
            throw ex;
        }
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
