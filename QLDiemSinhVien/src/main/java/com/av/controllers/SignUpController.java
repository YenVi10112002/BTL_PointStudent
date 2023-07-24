/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.Taikhoan;
import com.av.service.LoginService;
import com.av.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author FPTSHOP
 */
@Controller
public class SignUpController {
    
    @Autowired
    private SignUpService signUpService;
    
    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("account", new Taikhoan());
        return "signup";
    }
    
    @PostMapping("/signup")
    public String add(@ModelAttribute(value= "account") Taikhoan t){
        if(this.signUpService.addOrUpdateAcount(t) == true)
            return "redirect:/";
        
        return "signup";
    }
    
}
