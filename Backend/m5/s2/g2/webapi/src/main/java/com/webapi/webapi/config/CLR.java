//package com.webapi.webapi.config;
//
//import com.webapi.webapi.WebapiApplication;
//import com.webapi.webapi.model.Author;
//import com.webapi.webapi.model.Post;
//import com.webapi.webapi.repository.AuthorRepository;
//import com.webapi.webapi.repository.PostRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CLR implements CommandLineRunner {
//
//        @Autowired
//        private PostRepository postRepo;
//
//        @Autowired
//        private AuthorRepository authRepo;
//
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        @Override
//        public void run(String... args) throws Exception {
//            String[] beanNames = ctx.getBeanDefinitionNames();
//
//            for (String beanName : beanNames) {
//                Object bean = ctx.getBean(beanName);
//                if (bean instanceof Post) {
//                    postRepo.save((Post) bean);
//                } else if (bean instanceof Author){
//                    authRepo.save((Author) bean);
//                }
//            }
//    }
//}