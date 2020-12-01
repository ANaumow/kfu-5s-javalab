package ru.naumow.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.naumow.project.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
