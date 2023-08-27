/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.pojo.PhieuMonHoc;
import com.av.pojo.Monhoc;
import com.av.pojo.Sinhvien;
import com.av.repository.PhieuMonHocRepository;
import com.av.service.MonHocService;
import com.av.service.PhieuMonHocService;
import com.av.service.SinhVienService;
import com.av.utils.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FPTSHOP
 */
@RestController
public class ApiPhieuMoNhocController {

    @Autowired
    private MonHocService mhService;
    
    @Autowired
    private SinhVienService svService;
    
    @Autowired
    private PhieuMonHocService phieuMHService;

    @GetMapping("/giaovu/api/monhoc")
    public ResponseEntity<List<Monhoc>> listMonHoc() {
        List<Monhoc> monhocs = this.mhService.getMonHocs();

        return new ResponseEntity<>(monhocs, HttpStatus.OK);
    }
    
    @PostMapping("/giaovu/api/phieuMH")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> listCart(@RequestBody Map<String, PhieuMonHoc> cart){
        boolean success = this.phieuMHService.addPhieuMH(cart);
        if(success){
            return ResponseEntity.ok("Đã lưu thành công.");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lưu thất bại.");
        }
    }
    
    @GetMapping("/giaovu/api/cart")
    @CrossOrigin
    public ResponseEntity<?> dangKi(HttpSession session, Model model) {
        Map<String, PhieuMonHoc> cart = (Map<String, PhieuMonHoc>) session.getAttribute("cart");

        Map<String, Object> response = new HashMap<>();

        if (cart != null) {
            response.put("cart", cart.values());
        } else {
            response.put("cart", null);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/giaovu/api/monhoc/{idMonHoc}")
    public ResponseEntity<Integer> cart(@RequestParam(value = "idSinhVien") Integer idSinhVien,@PathVariable(value = "idMonHoc") Integer id, HttpSession session) {
        Map<Integer, PhieuMonHoc> cart = (Map<Integer, PhieuMonHoc>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        if (cart.containsKey(id) == true) {
            PhieuMonHoc c = cart.get(id);
        } else {
            Monhoc mh = this.mhService.getMonHocById(id);
            Sinhvien sv = this.svService.getSinhVienById(idSinhVien);
            PhieuMonHoc c = new PhieuMonHoc();
            c.setIdMonHoc(mh.getIdMonHoc());
            c.setTenMonHoc(mh.getTenMonHoc());
            c.setPhongHoc(mh.getPhongHoc());
            c.setDem(1);
            c.setIdSinhVien(sv.getIdSinhVien());
            cart.put(id, c);
        }
        session.setAttribute("cart", cart);

        return new ResponseEntity<>(Utils.countCart(cart), HttpStatus.OK);
//        System.out.printf("=== Cart = %d\n", Utils.countCart(cart));
    }
}
