///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.av.service.impl;
//
//import com.av.pojo.Taikhoan;
//import com.av.repository.UserRepository;
//import com.av.service.UserService;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
///**
// *
// * @author Admin
// */
//@Service("userDetailsService")
//public class UserServiceImpl implements UserService {
//    
//
//    @Autowired
//    private UserRepository userRepo;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Taikhoan u = this.userRepo.getUserByUserName(username);
//        if (u == null) {
//            throw new UsernameNotFoundException("Invalid");
//        }
//        Set<GrantedAuthority> authorities = new HashSet<>();
//        authorities.add(new SimpleGrantedAuthority(u.getChucVu()));
//        return new org.springframework.security.core.userdetails.User(
//                u.getTenTaiKhoan(), u.getMatKhau(), authorities);
//    }
//
//    @Override
//    public Taikhoan getUserByUn(String username) {
//        return this.userRepo.getUserByUserName(username);
//    }
//
//    @Override
//    public boolean authUser(String username, String password) {
//        return this.userRepo.authUser(username, password);
//    }
//
//    @Override
//    public Taikhoan addUser(Map<String, String> params, MultipartFile avatar) {
//        Taikhoan u = new Taikhoan();
//        u.setTenTaiKhoan(params.get("username"));
//        u.setMatKhau(this.passwordEncoder.encode(params.get("password")));
//        u.setChucVu("ROLE_SV");
//        this.userRepo.addUser(u);
//        return u;
//    }
//
//}
