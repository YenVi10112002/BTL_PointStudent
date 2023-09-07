/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.service.GiangVienService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FPTSHOP
 */
@RestController
public class ApiGiangViengController {

    @Autowired
    private GiangVienService gvService;

    @DeleteMapping("/giaovu/giangvien/add/{id}")
    
    public void delete(Model model, @PathVariable(value = "id") int id, HttpServletResponse response) {
        boolean success = this.gvService.deleteGV(id); 
    if (success) {
        response.setStatus(HttpServletResponse.SC_NO_CONTENT); // Thiết lập trạng thái NO_CONTENT (204)
    } else {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Thiết lập trạng thái INTERNAL_SERVER_ERROR (500)
    }
    }
}
