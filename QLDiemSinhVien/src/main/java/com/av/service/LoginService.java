/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.av.service;

import com.av.pojo.Taikhoan;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author FPTSHOP
 */
public interface LoginService extends UserDetailsService{
    Taikhoan getUserByUsername(String username);
    UserDetails getLoggedInUserDetails(Authentication authentication);
    int GetIdTaiKhoan(UserDetails userDetails);
}
