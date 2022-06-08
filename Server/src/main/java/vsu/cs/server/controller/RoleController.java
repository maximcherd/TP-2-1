package vsu.cs.server.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vsu.cs.server.repository.PictureRepository;
import vsu.cs.server.repository.RoleRepository;
import vsu.cs.server.repository.UserRepository;
import vsu.cs.server.service.PictureService;
import vsu.cs.server.service.RoleService;
import vsu.cs.server.service.UserService;

@Controller
@Api(description = "role controller")
public class RoleController {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

}
