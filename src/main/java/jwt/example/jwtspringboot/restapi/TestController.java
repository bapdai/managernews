package jwt.example.jwtspringboot.restapi;

import jwt.example.jwtspringboot.entity.News;
import jwt.example.jwtspringboot.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    NewsService newsService;

    @GetMapping("/all")
    public ResponseEntity<List<News>> getList(){
        return ResponseEntity.ok(newsService.findAll());
    }

}
