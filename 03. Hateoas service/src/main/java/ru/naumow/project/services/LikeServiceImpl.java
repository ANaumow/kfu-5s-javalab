package ru.naumow.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.naumow.project.domain.Account;
import ru.naumow.project.domain.Like;
import ru.naumow.project.domain.Post;
import ru.naumow.project.repositories.AccountRepository;
import ru.naumow.project.repositories.LikeRepository;
import ru.naumow.project.repositories.PostRepository;
import ru.naumow.project.util.Exceptions;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void like(Long postId, Long accountId) {
        Post post = postRepository.findById(postId).orElseThrow(Exceptions.notFound("Post"));
        Account account = accountRepository.findById(accountId).orElseThrow(Exceptions.notFound("Account"));

        Like like = new Like();
        like.setAuthor(account);
        like.setPost(post);
        likeRepository.save(like);
    }
}
