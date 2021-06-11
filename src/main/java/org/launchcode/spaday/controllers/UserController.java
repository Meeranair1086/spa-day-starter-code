package org.launchcode.spaday.controllers;



import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    /*
    @GetMapping("add")
    public String displayAddUserForm(Model model){
        model.addAttribute(new User());
        return "/user/add";
    }*/
    /*
   @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify, String email) {
        model.addAttribute("user",user);
        model.addAttribute("verify",verify);
        model.addAttribute("email",email);
        model.addAttribute("username",user.getUsername());
        model.addAttribute("password",user.getPassword());
       if(user.getPassword().equals(verify)){
            return "user/index";
        }
        else{
            model.addAttribute("error","password does not match");
            return "user/add";
        }
    }
    */
    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "Add a New User");
        return "user/add";
    }
    @PostMapping("")
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add a New User");
            return "user/add";
        }
        return "user/index";
    }

}
