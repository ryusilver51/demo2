package com.example.demo2.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo2.domain.User;
import com.example.demo2.form.UserForm;
import com.example.demo2.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

  @RequestMapping("")
  public String index(UserForm userForm, Model model) {

    Map<Integer, String> hobbyMap = new LinkedHashMap<>();
    hobbyMap.put(1, "野球");
    hobbyMap.put(2, "サッカー");
    hobbyMap.put(3, "テニス");

    model.addAttribute("hobbyMap", hobbyMap);

    return "user/input";
  }

  @RequestMapping("/create")
  public String create(@Validated UserForm userForm, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
    
    if (result.hasErrors()) {
      return index(userForm, model);
    }

    User user = new User();
    BeanUtils.copyProperties(userForm, user);

    List<String> hobbyList = new ArrayList<>();
    for (Integer hobbyCode : userForm.getHobbyList()) {
      String hobby = switch (hobbyCode) {
          case 1 -> "野球";
          case 2 -> "サッカー";
          case 3 -> "テニス";
          default -> "";
      };
      hobbyList.add(hobby);
    }
    
    user.setHobbyList(hobbyList);

    UserService userService = new UserService();
    user = userService.save(user);

    redirectAttributes.addFlashAttribute("user", user);
    return "redirect:/user/toresult";
  }

  @RequestMapping("/toresult")
  public String toresult() {
    return "user/result";
  }

  // for (Integer hobbyCode : userForm.getHobbyList()) {
    //   switch (hobbyCode) {
    //     case 1:
    //       hobbyList.add("野球");
    //       break;
    //     case 2:
    //     hobbyList.add("サッカー");
    //     default:
    //     case 3:
    //     hobbyList.add("テニス");
    //       break;
    //   }
    // }

}