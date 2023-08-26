/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.Monhoc;
import com.av.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author FPTSHOP
 */
@Controller
@ControllerAdvice
public class ADMonHocController {
    
    @Autowired
    private MonHocService mhService;
    
    @ModelAttribute
    public void listMH(Model model){
        model.addAttribute("monhoc", this.mhService.getMonHocs());
    }
    
    @RequestMapping("/giaovu/monhoc")
    public String monhoc(Model model){
        return "dsmonhoc";
    }
    
    @GetMapping("/giaovu/monhoc/add")
    public String addMonHoc(Model model){
        model.addAttribute("monhocc", new Monhoc());
        return "addmh";
    }
    
    @GetMapping("/giaovu/monhoc/add/{id}")
    public String updateMH(Model model, @PathVariable(value = "id") int id){
        model.addAttribute("monhocc", this.mhService.getMonHocById(id));
        return "addmh";
    }
    
    @PostMapping("/giaovu/monhoc/add")
    public String add(@ModelAttribute(value = "monhocc") Monhoc mh){
        if(this.mhService.addOrUpdateMonHoc(mh) == true){
            return "redirect:/giaovu/monhoc";
        }
        return "addmh";
    }
}
