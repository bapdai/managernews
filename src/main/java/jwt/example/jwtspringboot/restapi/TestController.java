package jwt.example.jwtspringboot.restapi;

import jwt.example.jwtspringboot.entity.News;
import jwt.example.jwtspringboot.entity.Role;
import jwt.example.jwtspringboot.service.NewsService;
import jwt.example.jwtspringboot.service.RoleService;
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

    @Autowired
    RoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<List<News>> getList(){
        return ResponseEntity.ok(newsService.getListByStatus(true));
    }

    @PostMapping("/create/roles/norequest")
    public ResponseEntity<Role> create(@RequestBody Role role){
        return ResponseEntity.ok(roleService.save(role));
}
}
