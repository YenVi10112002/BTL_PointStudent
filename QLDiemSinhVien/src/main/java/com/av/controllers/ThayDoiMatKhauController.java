/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Admin
 */
@Controller
public class ThayDoiMatKhauController {
    @GetMapping("/sinhvien/thaydoimatkhau")
    public String thaydoimatkhau(){
        return "thaydoimatkhau";
    }
}