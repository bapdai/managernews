package jwt.example.jwtspringboot.service;

import jwt.example.jwtspringboot.entity.News;
import jwt.example.jwtspringboot.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    private NewRepository newsRepository;

    public List<News> findAll(){
        return newsRepository.findAll();
    }

    public Optional<News> findById(Integer id){
        return newsRepository.findById(id);
    }

    public News save(News news) {
        return newsRepository.save(news);
    }

    public void deleteById(Integer id){
        newsRepository.deleteById(id);
    }
}
