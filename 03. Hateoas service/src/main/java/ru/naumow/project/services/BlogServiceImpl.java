package ru.naumow.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import ru.naumow.project.domain.Account;
import ru.naumow.project.domain.Blog;
import ru.naumow.project.domain.Post;
import ru.naumow.project.repositories.AccountRepository;
import ru.naumow.project.repositories.BlogRepository;
import ru.naumow.project.util.Exceptions;

import java.util.Collections;
import java.util.Set;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SubscriptionService subscriptionService;

    @Override
    public Set<Post> getBlogPosts(@NonNull Long blogId, @NonNull Long accountId) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(Exceptions.notFound("blog"));
        Account account = accountRepository.findById(accountId)
                .orElseThrow(Exceptions.notFound("account"));

        if (subscriptionService.isSubscriber(blog, account)) {
            return blog.getPosts();
        }

        return Collections.emptySet();
    }

}
