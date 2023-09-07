/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.Sinhvien;
import com.av.service.DiemService;
import com.av.service.GiaoVuService;

import com.av.service.SinhVienService;
import com.av.service.TaiKhoanService;

import java.util.Date;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author FPTSHOP
 */
@Controller
public class ADSinhVienController {

    @Autowired
    private SinhVienService svService;

    @Autowired
    private GiaoVuService gvuService;
    
    @Autowired
    private TaiKhoanService tkService;

    @Autowired
    private CustomDateEditor customDateEditor;

    @ModelAttribute
    public void lopHoc(Model model, Authentication auth) {
        model.addAttribute("lophoc", svService.getLopHocs());
        model.addAttribute("giaovu", this.gvuService.getGiaovus(this.tkService.GetIdTaiKhoan(tkService.getLoggedInUserDetails(auth))));

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, customDateEditor);
    }

    @RequestMapping("/giaovu/sinhvien")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("sinhvien", this.svService.getSinhviens(params));

        return "dssinhvien";
    }

    @GetMapping("/giaovu/sinhvien/add")
    public String addsinhVien(Model model) {
        model.addAttribute("sinhvienn", new Sinhvien());
        return "add";
    }

    @GetMapping("/giaovu/sinhvien/add/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("sinhvienn", svService.getSinhVienById(id));
        return "add";
    }

    @PostMapping("/giaovu/sinhvien/add")
    public String add(@ModelAttribute(value = "sinhvienn") @Valid Sinhvien sv, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.svService.addOrUpdateSinhVien(sv) == true) {
                return "redirect:/giaovu/sinhvien";
            }
        }

        return "add";
    }
}
