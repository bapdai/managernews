package jwt.example.jwtspringboot;

import jwt.example.jwtspringboot.entity.Role;
import jwt.example.jwtspringboot.repository.RoleRepository;
import jwt.example.jwtspringboot.service.RoleService;
import jwt.example.jwtspringboot.util.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtspringbootApplication {
//    @Autowired
//    RoleService roleService;
//
    public static void main(String[] args) {
        SpringApplication.run(JwtspringbootApplication.class, args);
//        Role role = new Role();
//        role.setName(ERole.ROLE_USER);
//        Role role1 = new Role();
//        role1.setName(ERole.ROLE_MODERATOR);
//        Role role2 = new Role();
//        role2.setName(ERole.ROLE_ADMIN);
    }
}
