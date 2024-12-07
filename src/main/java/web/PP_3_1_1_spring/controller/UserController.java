package web.PP_3_1_1_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.PP_3_1_1_spring.model.User;
import web.PP_3_1_1_spring.service.UserService;


@Controller
@RequestMapping
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getIndex(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping(value = "/add")
    public String addForm(ModelMap model) {
        model.addAttribute("users", new User());
        return "add";
    }

    @PostMapping(value = "/add")
    public String addSumbit(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @PostMapping(value = "/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String editPage(@RequestParam("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping(value = "/edit")
    public String editSubmit(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
