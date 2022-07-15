package jwt.example.jwtspringboot.restapi;

import jwt.example.jwtspringboot.entity.News;
import jwt.example.jwtspringboot.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@PreAuthorize("hasRole('MODERATOR')")
public class TestControllerMod {

    @Autowired
    NewsService newsService;

    @GetMapping("/mod")
    public ResponseEntity<List<News>> getList(){
        return ResponseEntity.ok(newsService.findAll());
    }

    @GetMapping("/mod/{id}")
    public ResponseEntity<?> getDetail(@PathVariable Integer id) {
        Optional<News> optionalNews = newsService.findById(id);
        if (!optionalNews.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        optionalNews.get().setViews(optionalNews.get().getViews() + 1);
        newsService.save(optionalNews.get());
        return ResponseEntity.ok(optionalNews.get());
    }

    @PostMapping("/mod")
    public ResponseEntity<News> create(@RequestBody News news){
        return ResponseEntity.ok(newsService.save(news));
    }

    @PutMapping("/mod/{id}")
    public ResponseEntity<News> update(@PathVariable Integer id, @RequestBody News news){
        Optional<News> optionalNews = newsService.findById(id);
        if ((!optionalNews.isPresent())){
            ResponseEntity.badRequest().build();
        }
        News existNews = optionalNews.get();

        existNews.setTitle(news.getTitle());
        existNews.setDescription(news.getDescription());
        existNews.setImg(news.getImg());
        existNews.setContent(news.getContent());
        existNews.setViews(news.getViews());
        existNews.setStatus(news.getStatus());
        existNews.setAuthor(news.getAuthor());
        return ResponseEntity.ok(newsService.save(existNews));
    }
}
