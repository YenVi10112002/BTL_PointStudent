/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.Taikhoan;
import com.av.service.GiaoVuService;
import com.av.service.TaiKhoanService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
    private TaiKhoanService tkService;

    @Autowired
    private GiaoVuService gvuService;


    @RequestMapping("/giaovu")
    public String admin(Model model, Authentication auth) {
        model.addAttribute("giaovu", this.gvuService.getGiaovus(this.tkService.GetIdTaiKhoan(tkService.getLoggedInUserDetails(auth))));
        return "admin";
    }

    @RequestMapping("/giaovu/taikhoan/dangki")
    public String dangky(Model model) {
        model.addAttribute("dangki", new Taikhoan());
        return "dangkytkgv";
    }

    @GetMapping("giaovu/taikhoan")
    public String taikhoan(Model model) {
        model.addAttribute("taikhoan", this.tkService.getTaiKhoan());
        return "dstaikhoan";
    }

    @PostMapping("giaovu/taikhoan/dangki")
    public String add(Model model, @ModelAttribute(value = "dangki") @Valid Taikhoan t, BindingResult rs) {
        String errMsg = "";
        if (rs.hasErrors()) {
            if (t.getMatKhau().equals(t.getXacNhanMk())) {
                if (this.tkService.addAcountGV(t) == true) {
                    return "redirect:/giaovu/taikhoan";
                } else {
                    errMsg = "Đã có lỗi!";
                }
            } else {
                errMsg = "Mật khẩu không Khớp!!!";
            }
        }
        model.addAttribute("errMsg", errMsg);
        return "dangkytkgv";
    }

}
