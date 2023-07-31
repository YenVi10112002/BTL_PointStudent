/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;


import com.av.pojo.Taikhoan;
import com.av.repository.LoginRepository;
import com.av.service.LoginService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author FPTSHOP
 */
@Service("userDetailsService")
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginRepository loginRepo;
    

//    @Override
//    public List<Taikhoan> getTaikhoans(String tenTK) {
//        return this.loginRepo.getTaikhoans(tenTK);
//    }

    @Override
    public Taikhoan getUserByUsername(String username) {
       return this.loginRepo.getUserByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String tenTK) throws UsernameNotFoundException {
        Taikhoan taikhoans = this.getUserByUsername(tenTK);
        if(taikhoans == null)
            throw new UsernameNotFoundException("Tài khoản không tồn tại!!!");
        
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(taikhoans.getChucVu()));
        return new org.springframework.security.core.userdetails.User(taikhoans.getTenTaiKhoan(), taikhoans.getMatKhau(), auth);
    }

    
    public UserDetails getLoggedInUserDetails(Authentication authentication) {
        // Trả về thông tin UserDetails của người dùng đã đăng nhập thành công
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails;
    }
    public int GetIdTaiKhoan(UserDetails userDetails){
        Taikhoan taikhoans = this.getUserByUsername(userDetails.getUsername());
       
        return taikhoans.getIdTaiKhoan();
    }
    
    
    
    

    
}
