package ru.naumow.project.controllers;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.EmbeddedResourcesAssembler;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naumow.project.domain.Post;
import ru.naumow.project.services.BlogService;
import ru.naumow.project.services.SubscriptionService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RepositoryRestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private PostProcessor postProcessor;

    @GetMapping(value = "/blogs/{blog-id}/posts-for-account")
    public ResponseEntity<CollectionModel<Post>> getBlogPosts(@PathVariable("blog-id") Long blogId,
                                                                          @RequestParam("account-id") Long accountId) {
        Set<Post> posts = blogService.getBlogPosts(blogId, accountId);
//        Set<EntityModel<Post>> posts2 = posts.stream().collect(Collectors.toSet());
        return ResponseEntity/*.created(Link.of("/blogs/{blog-id}/"))*/
                .ok(CollectionModel.of(posts));
    }

    @PostMapping(value = "/blogs/{blog-id}/subscribe")
    public ResponseEntity<?> subscribe(@PathVariable("blog-id") Long blogId,
                                                           @RequestBody Long accountId) {
        subscriptionService.subscribe(blogId, accountId);

        return ResponseEntity.ok().build();
    }


}
