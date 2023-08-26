/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.Taikhoan;
import com.av.repository.SinhVienRepository;
import com.av.service.ListSinhVienService;
import com.av.service.SignUpService;
import com.av.service.SinhVienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author FPTSHOP
 */
@Controller
public class AdminController {

    @Autowired
    private SignUpService sgService;
    
    
    @RequestMapping("/giaovu")
    public String admin() {
        return "admin";
    }
    

    @RequestMapping("/giaovu/taikhoan/dangki")
    public String dangky(Model model) {
        
        return "dangkytkgv";
    }

    @GetMapping("giaovu/taikhoan")
    public String taikhoan(Model model) {
        model.addAttribute("dangki", new Taikhoan());
        model.addAttribute("taikhoan", this.sgService.getTaiKhoan());
        return "dstaikhoan";
    }
    
    
    
    
}
