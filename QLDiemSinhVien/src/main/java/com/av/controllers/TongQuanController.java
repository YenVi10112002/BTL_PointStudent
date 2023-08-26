/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.Sinhvien;
import com.av.service.DiemService;
import com.av.service.LoginService;
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
import org.springframework.security.core.Authentication;

/**
 *
 * @author Admin
 */
@Controller
@PropertySource("classpath:configs.properties")
public class TongQuanController {

    @Autowired
    private SinhVienService tongquanService;
    @Autowired
    private DiemService diemService;
    @Autowired
    private LoginService loService;
    @Autowired
    private Environment env;

    @ModelAttribute
    public void comonAttr(Model model, Authentication authentication) {
        
    }

    @RequestMapping("/sinhvien")
    public String tongquan(Model model, @RequestParam Map<String, String> params, Authentication authentication) {
        model.addAttribute("hocky", this.tongquanService.getHocKy());
        model.addAttribute("sinhvien", this.tongquanService.getSinhvien(loService.GetIdTaiKhoan(loService.getLoggedInUserDetails(authentication))));

        return "sinhvien";
    }
}
