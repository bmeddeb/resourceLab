package org.asu.ResourceLab.controller;


import org.asu.ResourceLab.model.User;
import org.asu.ResourceLab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@RequestMapping("/user-management")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String viewAllUsers(Model model) {
        model.addAttribute("users", userRepository.getAllUsers());
        model.addAttribute("breadcrumbs", Arrays.asList("Home", "User Management"));
        return "user-management/list";
    }

    @GetMapping("/new")
    public String viewCreateUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("breadcrumbs", Arrays.asList("Home", "User Management", "Create User"));
        return "user-management/form";
    }

    @GetMapping("/edit/{id}")
    public String viewEditUserForm(@PathVariable int id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("breadcrumbs", Arrays.asList("Home", "User Management", "Edit User"));
        return "user-management/form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        if (user.getUserID() == 0) {
            userRepository.createUser(user);
            redirectAttributes.addFlashAttribute("successMessage", "User created successfully");
        } else {
            userRepository.updateUser(user);
            redirectAttributes.addFlashAttribute("successMessage", "User updated successfully");
        }
        return "redirect:/user-management";
    }


    @GetMapping("/delete/{id}")
    public String viewDeleteUserConfirmation(@PathVariable int id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("breadcrumbs", Arrays.asList("Home", "User Management", "Delete User"));
        return "user-management/delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userRepository.deleteUser(id);
        return "redirect:/user-management";
    }
}



