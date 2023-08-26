/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.Taikhoan;
import com.av.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FPTSHOP
 */
@RestController
public class ApiTaiKhoanController {
    @Autowired
    private SignUpService sgService;
    
    @PostMapping("giaovu/taikhoan")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String add(Model model, @ModelAttribute(value = "dangki") Taikhoan t) {
        String errMsg = "";
        if (t.getMatKhau().equals(t.getXacNhanMk())) {
            if (this.sgService.addAcountGV(t) == true) {
                return "redirect:/giaovu/taikhoan";
            } else {
                errMsg = "Đã có lỗi!";
            }
        } else {
            errMsg = "Mật khẩu không Khớp!!!";
        }
        model.addAttribute("errMsg", errMsg);
        return "dstaikhoan";
    }
    
    
}
