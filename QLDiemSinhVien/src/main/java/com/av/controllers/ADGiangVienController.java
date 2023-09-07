/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.Giangvien;
import com.av.service.GiangVienService;
import com.av.service.GiaoVuService;
import com.av.service.TaiKhoanService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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
public class ADGiangVienController {

    @Autowired
    private GiangVienService gvService;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private TaiKhoanService tkService;

    @Autowired
    private GiaoVuService gvuService;

    @Autowired
    private CustomDateEditor customDateEditor;

    @ModelAttribute
    public void listGV(Model model, Authentication auth) {
        model.addAttribute("giangvien", this.gvService.getGiangviens());
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, customDateEditor);
    }

    @GetMapping("/giaovu/giangvien")
    public String giangvien(Model model, Authentication auth) {
        model.addAttribute("giaovu", this.gvuService.getGiaovus(this.tkService.GetIdTaiKhoan(tkService.getLoggedInUserDetails(auth))));
        return "dsgiangvien";
    }

    @GetMapping("/giaovu/giangvien/add")
    public String addGiangVien(Model model, Authentication auth) {
        model.addAttribute("giaovu", this.gvuService.getGiaovus(this.tkService.GetIdTaiKhoan(tkService.getLoggedInUserDetails(auth))));
        model.addAttribute("giangvienn", new Giangvien());
        return "addgv";
    }

    @GetMapping("/giaovu/giangvien/add/{id}")
    public String updateGV(Model model, @PathVariable(value = "id") int id, Authentication auth) {
        model.addAttribute("giaovu", this.gvuService.getGiaovus(this.tkService.GetIdTaiKhoan(tkService.getLoggedInUserDetails(auth))));
        model.addAttribute("giangvienn", this.gvService.getGiangVienById(id));
        return "addgv";
    }

    @PostMapping("/giaovu/giangvien/add")
    public String add(@ModelAttribute(value = "giangvienn") Giangvien gv) {
        if (gvService.addOrUpdateGiangVien(gv) == true) {
            return "redirect:/giaovu/giangvien";
        }
        return "addgv";
    }

}
