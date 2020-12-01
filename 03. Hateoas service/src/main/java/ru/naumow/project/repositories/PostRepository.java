package ru.naumow.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.naumow.project.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
