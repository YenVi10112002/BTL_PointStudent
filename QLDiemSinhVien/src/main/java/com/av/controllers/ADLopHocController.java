/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;


import com.av.service.DaoTaoService;
import com.av.service.GiaoVuService;
import com.av.service.SinhVienService;
import com.av.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
public class ADLopHocController {
    
    @Autowired
    private DaoTaoService daoTaoService;
    
    @Autowired
    private GiaoVuService gvuService;
    
    @Autowired
    private TaiKhoanService tkService;
    @Autowired
    private SinhVienService svService;
    
    
    @GetMapping("/giaovu/lophoc")
    public String dslophoc(Model model) {
         model.addAttribute("listLopHoc", this.daoTaoService.listLopHoc());
        return "lophoc";
    }
    
    @GetMapping("/giaovu/lophoc/{id}")
    public String lophoc(Model model, @PathVariable(value = "id") int id) {
         model.addAttribute("listSinhVien", this.svService.getSinhVienByIdLop(id));
         model.addAttribute("lop", this.daoTaoService.getLopById(id));
        return "listsinhvienbyidlop";
    }
}
