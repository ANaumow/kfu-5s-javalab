package ru.naumow.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.naumow.project.domain.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
