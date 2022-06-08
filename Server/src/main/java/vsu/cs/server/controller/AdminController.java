package vsu.cs.server.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vsu.cs.server.config.WebSecurityConfig;
import vsu.cs.server.model.Role;
import vsu.cs.server.model.User;
import vsu.cs.server.service.PictureService;
import vsu.cs.server.service.RoleService;
import vsu.cs.server.service.UserService;

import java.security.Principal;

@Controller
@Api(description = "admin controller")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/users")
    public String usersGet(
            Principal principal,
            Model model) {
        if (principal != null) {
            User currUser = userService.getByLogin(principal.getName());
            model.addAttribute("currUser", currUser);
        }
        model.addAttribute("isUser", WebSecurityConfig.isUser());
        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
        model.addAttribute("users", userService.getAllByRole(new Role(WebSecurityConfig.C_ROLE_USER_ID, WebSecurityConfig.C_ROLE_USER)));
        return "admin/users";
    }

    @PostMapping("/users")
    public String usersPost(
            @RequestParam Long id,
            @RequestParam String action,
            Principal principal,
            Model model) {
        if (principal != null) {
            User currUser = userService.getByLogin(principal.getName());
            model.addAttribute("currUser", currUser);
        }
        model.addAttribute("isUser", WebSecurityConfig.isUser());
        model.addAttribute("isAdmin", WebSecurityConfig.isAdmin());
        if (action.equals("delete")) {
            userService.remove(userService.getById(id));
        }
        return "redirect:admin/users";
    }
}

