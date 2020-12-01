package ru.naumow.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.naumow.project.domain.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
}
