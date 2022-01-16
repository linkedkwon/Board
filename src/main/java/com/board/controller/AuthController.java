package com.board.controller;

import com.board.domain.User;
import com.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/register")
    public String renderRegister(Model model){
        model.addAttribute("obj", new User());
        return "register";
    }

    @GetMapping("/login")
    public String renderLogin(Model model, @RequestParam("msg") Optional<String> msg){
        model.addAttribute("obj", new User());
        model.addAttribute("msg", Optional.ofNullable(msg)
                .get().orElseGet(() -> {return "";}));

        return "login";
    }

    @PostMapping("/auth/create")
    public String signUp(User user){
        userService.createUser(user);
        return "redirect:/login";
    }

    @PostMapping("/auth/login")
    public String signIn(User user, RedirectAttributes re){
        if(userService.signInUser(user))
            return "redirect:/board";

        re.addAttribute("msg", "error");
        return "redirect:/login";
    }
}
