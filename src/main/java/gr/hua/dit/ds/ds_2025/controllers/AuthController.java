package gr.hua.dit.ds.ds_2025.controllers;

import gr.hua.dit.ds.ds_2025.entities.Role;
import gr.hua.dit.ds.ds_2025.repositories.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    RoleRepository roleRepository;

    public AuthController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void setup() {
        Role role_admin = new Role("ROLE_ADMIN");

        roleRepository.updateOrInsert(role_admin);
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}