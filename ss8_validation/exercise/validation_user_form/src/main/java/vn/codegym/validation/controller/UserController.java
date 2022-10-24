package vn.codegym.validation.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.validation.dto.UserDto;
import vn.codegym.validation.model.User;
import vn.codegym.validation.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @GetMapping
    public String showForm(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<User> page = iUserService.findAll(pageable);
        model.addAttribute("user", page);
        return "/home";
    }

    @GetMapping("/create")
    public String showCrate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/form";
    }
    @PostMapping("/save")
    public String createUser(@Validated @ModelAttribute UserDto userDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model){
        new UserDto().validate(userDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "/form";
        }
        else {
            User user=new User();
            BeanUtils.copyProperties(userDto,user);
            iUserService.create(user);
            redirectAttributes.addFlashAttribute("message","Create success!!");
        }
        return "redirect:/user";
    }
}
