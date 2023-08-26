/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.Diem;
import com.av.pojo.Sinhvien;
import com.av.service.DiemService;
import com.av.service.ListSinhVienService;
import com.av.service.SinhVienService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
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
public class ADSinhVienController {

    @Autowired
    private SinhVienService svService;

    @Autowired
    private ListSinhVienService listSVService;

    @Autowired
    private DiemService diemService;

    @Autowired
    private CustomDateEditor customDateEditor;

    @ModelAttribute
    public void lopHoc(Model model) {
        model.addAttribute("lophoc", svService.getLopHocs());
        
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, customDateEditor);
    }

    @RequestMapping("/giaovu/sinhvien")
    public String list(Model model, Map<String, String> params) {
        model.addAttribute("sinhvien", listSVService.getSinhviens(params));
        return "dssinhvien";
    }

    @GetMapping("/giaovu/sinhvien/add")
    public String addsinhVien(Model model) {
        model.addAttribute("sinhvien", new Sinhvien());
        return "add";
    }

    @GetMapping("/giaovu/sinhvien/add/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("sinhvien", svService.getSinhVienById(id));
        return "add";
    }

    @PostMapping("/giaovu/sinhvien/add")
    public String add(@ModelAttribute(value = "sinhvien") Sinhvien sv) {
        if (this.svService.addOrUpdateSinhVien(sv) == true) {
                return "redirect:/giaovu/sinhvien";
        }
        
        return "add";
    }
}
