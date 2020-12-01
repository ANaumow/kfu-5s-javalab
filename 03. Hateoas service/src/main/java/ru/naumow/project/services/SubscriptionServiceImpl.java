package ru.naumow.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.naumow.project.domain.Account;
import ru.naumow.project.domain.Blog;
import ru.naumow.project.domain.Subscription;
import ru.naumow.project.repositories.AccountRepository;
import ru.naumow.project.repositories.BlogRepository;
import ru.naumow.project.repositories.SubscriptionRepository;
import ru.naumow.project.util.Exceptions;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public boolean isSubscriber(Blog blog, Account account) {
        return blog.getSubscriptions()
                .stream()
                .anyMatch(subscription -> subscription.getAccount().equals(account));
    }

    @Override
    public void subscribe(Long blogId, Long accountId) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(Exceptions.notFound("Blog"));
        Account account = accountRepository.findById(accountId).orElseThrow(Exceptions.notFound("Account"));

        Subscription subscription = new Subscription();
        subscription.setAccount(account);
        subscription.setBlog(blog);
        subscriptionRepository.save(subscription);
    }
}
