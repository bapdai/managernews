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
@PreAuthorize("hasRole('ADMIN')")
public class TestControllerAdmin {
    @Autowired
    NewsService newsService;

    @GetMapping("/admin")
    public ResponseEntity<List<News>> getList(){
        return ResponseEntity.ok(newsService.findAll());
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<?> getDetail(@PathVariable Integer id){
        Optional<News> optionalNews = newsService.findById(id);
        if (!optionalNews.isPresent()){
            ResponseEntity.badRequest().build();
        }
        optionalNews.get().setViews(optionalNews.get().getViews() + 1);
        newsService.save(optionalNews.get());
        return ResponseEntity.ok(optionalNews.get());
    }

    @PostMapping("/admin")
    public ResponseEntity<News> create(@RequestBody News news){
        return ResponseEntity.ok(newsService.save(news));
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<News> update(@PathVariable Integer id, @RequestBody News news){
        Optional<News> optionalNews = newsService.findById(id);
        if ((!optionalNews.isPresent())){
            ResponseEntity.badRequest().build();
        }
        News existNews = optionalNews.get();

        existNews.setTitle(news.getTitle());
        existNews.setDescription(news.getDescription());
        existNews.setContent(news.getContent());
        existNews.setViews(news.getViews());
        existNews.setStatus(news.getStatus());
        existNews.setAuthor(news.getAuthor());
        return ResponseEntity.ok(newsService.save(existNews));
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if ((!newsService.findById(id).isPresent())){
            ResponseEntity.badRequest().build();
        }
        newsService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
