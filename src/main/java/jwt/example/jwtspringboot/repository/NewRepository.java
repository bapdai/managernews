package jwt.example.jwtspringboot.repository;

import jwt.example.jwtspringboot.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewRepository extends JpaRepository<News, Integer> {
    List<News> findAllByStatus(boolean status);
}
