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
@RequestMapping("/api/test/user")
@PreAuthorize("hasRole('USER')")
public class TestControllerUser {
    @Autowired
    NewsService newsService;

    @GetMapping()
    public ResponseEntity<List<News>> getList(){
        return ResponseEntity.ok(newsService.getListByStatus(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetail(@PathVariable Integer id) {
        Optional<News> optionalNews = newsService.getListByIdAndStatus(id, true);
        if (!optionalNews.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        optionalNews.get().setViews(optionalNews.get().getViews() + 1);
        newsService.save(optionalNews.get());
        return ResponseEntity.ok(optionalNews.get());
    }
}
