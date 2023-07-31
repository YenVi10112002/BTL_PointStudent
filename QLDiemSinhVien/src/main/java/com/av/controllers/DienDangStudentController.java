/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import java.util.Map;
import com.av.service.CauHoiService;
import com.av.service.ListSinhVienService;
import com.av.service.SinhVienService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class DienDangStudentController {
    @Autowired
    private ListSinhVienService sinhvienService;
    @Autowired
    private CauHoiService cauhoiServite;
    @Autowired
    private SinhVienService tongquanService;
    @Autowired
    private Environment env;
    
    @ModelAttribute
    public void comonAttr(Model model) {
        model.addAttribute("dscauhoi", this.cauhoiServite.getCauhoidiendangs());
        model.addAttribute("listsinhvien", this.sinhvienService.getSinhviens());
        
    }
    
    
    @RequestMapping("/sinhvien/diendan")
    public String diendan(Model model, @RequestParam Map<String, String> params){
        
        model.addAttribute("traloi", this.tongquanService.getTraloi(params));
        model.addAttribute("cauhoi", this.cauhoiServite.getCauHoi(params));
        return "diendansinhvien";
    }
}
