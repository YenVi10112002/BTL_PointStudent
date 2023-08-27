/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.service.DiemService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class ApiDiemController {
    @Autowired
    private DiemService diemService ;
    
    @RequestMapping("/DSDiemSVHocKy/")
    @CrossOrigin
    public ResponseEntity<List<Object>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.diemService.getListDiemTrungBinh2(params), HttpStatus.OK);
    }
    @RequestMapping("/TrungBinhDiem/")
    @CrossOrigin
    public ResponseEntity<Double> DiemtrungbinhSv(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.diemService.getDiemTrungBinh2(params), HttpStatus.OK);
    }
    
    @RequestMapping("/TrungBinhDiemHe4/")
    @CrossOrigin
    public ResponseEntity<Double> DiemtrungbinhSvHe4(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.diemService.getDiemTrungBinhHe4(params), HttpStatus.OK);
    }
    @RequestMapping("/DanhSachDiem/")
    @CrossOrigin
    public ResponseEntity<List<Object>> DanhSachDiem(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.diemService.getListDiem2(params), HttpStatus.OK);
    }
}
