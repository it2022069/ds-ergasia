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
        Role role_user = new Role("ROLE_USER");
        roleRepository.updateOrInsert(role_user);

        Role role_admin = new Role("ROLE_ADMIN");
        roleRepository.updateOrInsert(role_admin);

        Role role_owner = new Role("ROLE_OWNER");
        roleRepository.updateOrInsert(role_owner);
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}