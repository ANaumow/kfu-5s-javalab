package ru.naumow.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.naumow.project.services.LikeService;

@RepositoryRestController
public class PostController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/posts/{post-id}/like")
    public void like(@PathVariable("post-id") Long postId,
                     @RequestParam("account-id") Long accountId) {
        likeService.like(postId, accountId);
    }

}
