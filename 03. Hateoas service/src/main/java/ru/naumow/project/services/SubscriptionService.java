package ru.naumow.project.services;

import ru.naumow.project.domain.Account;
import ru.naumow.project.domain.Blog;

public interface SubscriptionService {

    boolean isSubscriber(Blog blog, Account account);

    void subscribe(Long blogId, Long accountId);

}
