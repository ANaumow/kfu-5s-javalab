package ru.naumow.project.services;

import ru.naumow.project.domain.Post;

import java.util.Set;

public interface BlogService {

    Set<Post> getPostsOfBlog(Long blogId, Long accountId);

}
