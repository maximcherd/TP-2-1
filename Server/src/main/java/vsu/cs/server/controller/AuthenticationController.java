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
import vsu.cs.server.model.User;
import vsu.cs.server.service.PictureService;
import vsu.cs.server.service.RoleService;
import vsu.cs.server.service.UserService;

import java.security.Principal;

@Controller
@Api(description = "user controller")
@RequestMapping("/authentication")
public class AuthenticationController {
    private static final String C_ERROR_PASSWORD = "пароли не совпадают";
    private static final String C_ERROR_LOGIN = "логин занят";


    @Autowired
    private PictureService pictureService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/registration")
    public String registrationGet(
            Principal principal,
            Model model) {
        if (principal != null) {
            User currUser = userService.getByLogin(principal.getName());
            model.addAttribute("currUser", currUser);
        }
        model.addAttribute("user", WebSecurityConfig.isUser());
        model.addAttribute("admin", WebSecurityConfig.isAdmin());
        return "authentication/registration";
    }

    @PostMapping("/registration")
    public String registrationPost(
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String passwordConfirm,
            @RequestParam String name,
            @RequestParam String mail,
            @RequestParam String phone,
            Principal principal,
            Model model) {
        if (principal != null) {
            User currUser = userService.getByLogin(principal.getName());
            model.addAttribute("currUser", currUser);
        }
        model.addAttribute("user", WebSecurityConfig.isUser());
        model.addAttribute("admin", WebSecurityConfig.isAdmin());
        if (!password.equals(passwordConfirm)) {
            model.addAttribute("error", C_ERROR_PASSWORD);
            return "authentication/registration";
        }
        User user = new User(login, password, name, mail, phone);
        if (!userService.addNew(user)) {
            model.addAttribute("error", C_ERROR_LOGIN);
            return "authentication/registration";
        }
        return "redirect:/home/main";
    }
}

