package com.blueeye.coffee_shop.controller;

import com.blueeye.coffee_shop.dto.RegisterUser;
import com.blueeye.coffee_shop.dto.UserDto;
import com.blueeye.coffee_shop.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class RegisterController {
    private UserService userService;

    @Autowired
    public RegisterController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/dang-ky")
    public String register(Model model){
        RegisterUser ru = new RegisterUser();
        model.addAttribute("registerUser", ru);
        return "register";
    }

    @InitBinder
    public void initBinder(WebDataBinder data){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        data.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/dang-ky/process")
    public String process(@Valid @ModelAttribute("registerUser") RegisterUser registerUser,
                          BindingResult result,
                          Model model,
                          HttpSession session){
        String username = registerUser.getUsername();
        if(result.hasErrors()){
            return "register";
        }

        UserDto userExist = userService.findByName(username);
        if(userExist!=null){
            model.addAttribute("registerUser", new RegisterUser());
            model.addAttribute("my_error", "Tài khoản đã tồn tại");
            return "register";
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        UserDto user = new UserDto();
        user.setUsername(registerUser.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.getPassword()));
        user.setAddress(registerUser.getAddress());
        user.setPhone(registerUser.getPhone());
        user.setName(registerUser.getName());
        user.setEmail(registerUser.getEmail());

        List<String> list = new ArrayList<>();
        list.add("ROLE_USER");
        user.setRoleNames(list);

        userService.save(user);

        model.addAttribute("success", "Chúc mừng bạn đã đăng ký thành công tài khoản mới. Vui lòng đăng nhập để tiếp tục");
        return "login";
    }
}
