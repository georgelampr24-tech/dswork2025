package hua.dt.ds.work2025.propertyrental.controllers;

import hua.dt.ds.work2025.propertyrental.entities.Role;
import hua.dt.ds.work2025.propertyrental.repositories.RoleRepository;
import hua.dt.ds.work2025.propertyrental.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {


    RoleRepository roleRepository;
    UserService userService;

    public AuthController(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @PostConstruct
    public void setup() {
      Role role_admin = new Role("ROLE_ADMIN");
      Role role_owner = new Role("ROLE_OWNER");
      Role role_tenant = new Role("ROLE_TENANT");

      roleRepository.updateOrInsert(role_owner);
      roleRepository.updateOrInsert(role_tenant);
      roleRepository.updateOrInsert(role_admin);

    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

}
