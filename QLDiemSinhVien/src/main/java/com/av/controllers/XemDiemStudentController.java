/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.service.DiemService;
import com.av.service.SinhVienService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */



@Controller
public class XemDiemStudentController {
    @Autowired
    private SinhVienService tongquanService;
    @Autowired
    private DiemService diemService;
    @Autowired
    private Environment env;

    @ModelAttribute
    public void comonAttr(Model model) {
        model.addAttribute("sinhvien", this.tongquanService.getSinhvien(1));

    }
    
    @GetMapping("/sinhvien/xemdiem")
    public String xemdiem(Model model, @RequestParam Map<String, String> params){
         
        return "xemdiemsinhvien";
    }
}
