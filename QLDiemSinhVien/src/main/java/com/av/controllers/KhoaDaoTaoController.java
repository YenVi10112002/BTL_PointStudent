/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.repository.KhoaDaoTaoRepository;
import com.av.service.KhoaDaoTaoService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author FPTSHOP
 */
@Controller
public class KhoaDaoTaoController {
    
    @Autowired
    private KhoaDaoTaoService khoaDTService;
    
    @RequestMapping("/giaovu/khoadaotao")
    public String khoaDT(Model model, Map<String, String> params){
        model.addAttribute("khoadt", this.khoaDTService.getKhoadaotaos(params));
        return "khoadaotao";
    }
}
