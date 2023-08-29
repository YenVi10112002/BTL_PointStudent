/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.components.JwtService;
import com.av.pojo.Giangvien;
import com.av.pojo.Sinhvien;
import com.av.pojo.Taikhoan;
import com.av.service.DiemService;
import com.av.service.GiangVienService;
import com.av.service.SinhVienService;
import com.av.service.TaiKhoanService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiUserController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private TaiKhoanService tkService;
    @Autowired
    private GiangVienService gvService;
    @Autowired
    private SinhVienService sinhvienService;
    @Autowired
    private DiemService diemserviec;
    
    @PostMapping("/login/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody Taikhoan user) {
        if (this.tkService.authUser(user.getTenTaiKhoan(), user.getMatKhau()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getTenTaiKhoan());
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }
    
    @GetMapping("/test/")
    @CrossOrigin(origins = {"127.0.0.1:5500"})
    public ResponseEntity<String> test(Principal pricipal) {
        return new ResponseEntity<>("SUCCESSFUL", HttpStatus.OK);
    }
    
    @PostMapping(path = "/users/", 
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Taikhoan> addUser(@RequestParam Map<String, String> params) {
        Taikhoan user = this.tkService.addUser(params);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Giangvien> details(Principal user) {
        Taikhoan u = this.tkService.getUserByUsername(user.getName());
//        Sinhvien sv = this.sinhvienService.getSinhvien(u.getIdTaiKhoan());
        Giangvien gv = this.gvService.getGiangVienByIdTaiKhoan(u.getIdTaiKhoan());
        return new ResponseEntity<>(gv, HttpStatus.OK);
    }
    
//    @GetMapping(path = "/current-user-gv/", produces = MediaType.APPLICATION_JSON_VALUE)
//    @CrossOrigin
//    public ResponseEntity<Giangvien> details(Principal user) {
//        Taikhoan u = this.tkService.getUserByUsername(user.getName());
//        Giangvien gv = this.sinhvienService.getSinhvien(u.getIdTaiKhoan());
//        return new ResponseEntity<>(gv, HttpStatus.OK);
//    }
}
