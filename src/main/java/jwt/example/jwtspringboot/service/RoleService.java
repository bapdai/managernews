package jwt.example.jwtspringboot.service;

import jwt.example.jwtspringboot.entity.Role;
import jwt.example.jwtspringboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role save(Role srole){
        return roleRepository.save(srole);
    }
}
