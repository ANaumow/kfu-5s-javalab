package ru.naumow.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naumow.project.domain.Post;
import ru.naumow.project.services.BlogService;
import ru.naumow.project.services.SubscriptionService;

import java.util.Set;

@RepositoryRestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping(value = "/blogs/{blog-id}/posts-for-account")
    public @ResponseBody ResponseEntity<?> getPostsOfBlog(@PathVariable("blog-id") Long blogId,
                                                                @RequestParam("account-id") Long accountId) {
        Set<Post> posts = blogService.getPostsOfBlog(blogId, accountId);
        return ResponseEntity
                .ok(CollectionModel.of(posts));
    }

    @PostMapping(value = "/blogs/{blog-id}/subscribe")
    public ResponseEntity<?> subscribe(@PathVariable("blog-id") Long blogId,
                                                           @RequestBody Long accountId) {
        subscriptionService.subscribe(blogId, accountId);

        return ResponseEntity.ok().build();
    }


}
