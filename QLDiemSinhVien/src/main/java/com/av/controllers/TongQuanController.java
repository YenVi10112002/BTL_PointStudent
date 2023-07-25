/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.av.service.SinhVienService;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")

public class TongQuanController {
    @Autowired
    private SinhVienService tongquanService;
    @Autowired
    private Environment env;
    
    @ModelAttribute
    public void comonAttr(Model model) {
        model.addAttribute("sinhvien", this.tongquanService.getSinhvien(1));
    }
    @RequestMapping("/tongquan")
    public String tongquan(Model model, @RequestParam Map<String, String> params){
        return "tongquan";
    }
}
