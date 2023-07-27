/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.service.impl;


import com.av.pojo.Taikhoan;
import com.av.repository.LoginRepository;
import com.av.service.LoginService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
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
    

    @Override
    public List<Taikhoan> getTaikhoans(String tenTK) {
        return this.loginRepo.getTaikhoans(tenTK);
    }

    @Override
    public UserDetails loadUserByUsername(String tenTK) throws UsernameNotFoundException {
        List<Taikhoan> taikhoans = this.getTaikhoans(tenTK);
        if(taikhoans.isEmpty())
            throw new UsernameNotFoundException("Tài khoản không tồn tại!!!");
        Taikhoan tk = taikhoans.get(0);
        
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(tk.getChucVu()));
        
        return new org.springframework.security.core.userdetails.User(tk.getTenTaiKhoan(), tk.getMatKhau(), auth);
    }

    
}
