/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.Khoa;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.av.service.KhoaDaoTaoService;

/**
 *
 * @author FPTSHOP
 */
@Controller
public class KhoaHocController {
    
    @Autowired
    private KhoaDaoTaoService KhoaHocService;
    
    @RequestMapping("/giaovu/khoahoc")
    public String khoaHoc(Model model, Map<String, String> params){
        model.addAttribute("khoahoc", this.KhoaHocService.getKhoas(params));
         return "khoahoc";
    }
}
