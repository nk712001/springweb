package com.example.springweb.Controller;
import com.example.springweb.Entity.GetQuoteResponse;
import com.example.springweb.Entity.User;
import com.example.springweb.Entity.searchFields;
import com.example.springweb.Repository.GetQuoteResponseRepo;
import com.example.springweb.Service.registerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private GetQuoteResponseRepo respRepo;
    @Autowired
    private registerUser regService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("Users", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User Users, Model model) throws InterruptedException {
        User user = new User(Users.getUsername(), Users.getPassword());
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        String pass = enc.encode(Users.getPassword());
        user.setPassword(pass);
        regService.saveUserData(user);
        model.addAttribute("Users", Users);
        return "success";
    }

    @GetMapping("/login")
    public String greetingForm(Model model) {
        model.addAttribute("Users", new User());
        return "login";
    }

    @PostMapping("/login")
    public String greetingSubmit(@ModelAttribute User Users, Model model) {
        System.out.println("sss");
        model.addAttribute("Users", Users);
        return "redirect:/searchByFields";
    }

    @GetMapping("/searchByFields")
    public String usersGet(Model model) {
        model.addAttribute("obj", new searchFields());
        return "searchByFields";
    }


    @PostMapping("/searchByFields")
    public String users(@ModelAttribute searchFields field, Model model) {
        try {
            List<GetQuoteResponse> Users;
            if (!Objects.equals(field.getSumInsured(), "") && !Objects.equals(field.getPeriod(), "")) {
                Users = respRepo.searchField(field.getSumInsured(), field.getPeriod());
            } else if (!Objects.equals(field.getSumInsured(), "")) {
                Users = respRepo.searchSum(field.getSumInsured());
            } else {
                Users = respRepo.searchYear(field.getPeriod());
            }
            model.addAttribute("datae", Users);
        } catch (Exception e) {
            return "field error";
        }
        model.addAttribute("obj", new searchFields());
        return "searchByFields";
    }

}
