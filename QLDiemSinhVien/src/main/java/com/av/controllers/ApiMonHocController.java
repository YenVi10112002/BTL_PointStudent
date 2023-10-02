/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.DiemMonHoc;
import com.av.pojo.Monhoc;
import com.av.pojo.Monhocdangky;
import com.av.repository.SinhVienRepository;
import com.av.service.MonHocService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FPTSHOP
 */
@RestController
public class ApiMonHocController {
    
    @Autowired
    private MonHocService mhService;
    @Autowired
    private SinhVienRepository svService;
    
    @DeleteMapping("/giaovu/monhoc/add/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.mhService.deleteMonHoc(id);
    }

    @GetMapping("/api/monhocgiangvien/")
    @CrossOrigin
    public ResponseEntity<List<Monhoc>> listMHSV(@RequestParam Map<String, String> params){
        return new ResponseEntity<>(this.mhService.getMonHocByGiangVien(params), HttpStatus.OK);
    }
       
    @GetMapping("/api/monhocsinhvien/")
    @CrossOrigin
    public ResponseEntity<List<DiemMonHoc>> listSVMH(@RequestParam Map<String, String> params){
        return new ResponseEntity<>(this.svService.getSinhvienByMonHoc(params), HttpStatus.OK);
    }
    
        
}
