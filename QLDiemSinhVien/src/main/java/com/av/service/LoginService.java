/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.service;

import com.av.pojo.Taikhoan;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author FPTSHOP
 */
public interface LoginService extends UserDetailsService{
//    List<Taikhoan> getTaikhoans(String tenTK);
    Taikhoan getUserByUsername(String username);
    UserDetails getLoggedInUserDetails(Authentication authentication);
    boolean authUser(String username, String password);
    Taikhoan addUser(Map<String, String> params);
    int GetIdTaiKhoan(UserDetails userDetails);
}
