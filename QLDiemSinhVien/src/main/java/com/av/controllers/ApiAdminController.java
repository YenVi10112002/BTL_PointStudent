/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.controllers;

import com.av.service.GiangVienService;
import com.av.service.HeDaoTaoService;
import com.av.service.HocKyService;
import com.av.service.KhoaDaoTaoService;
import com.av.service.LopHocService;
import com.av.service.PhieuMonHocService;
import com.av.service.SinhVienService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FPTSHOP
 */
@RestController
public class ApiAdminController {
    
    @Autowired
    private LopHocService lhService;
    
    @Autowired
    private KhoaDaoTaoService kdtService;
    
    @Autowired
    private HocKyService hkService;
    
    @Autowired
    private HeDaoTaoService hdtService;
    
    @Autowired
    private SinhVienService svService;
    
    @Autowired
    private GiangVienService gvService;
    
    @Autowired
    private PhieuMonHocService phieuMHService;
    
    @DeleteMapping("/giaovu/hocki/chitiethocki/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePMH(@PathVariable(value = "id")int id){
        this.phieuMHService.deleteMHHK(id);
    }
    
    @DeleteMapping("/giaovu/sinhvien/add/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSV(@PathVariable(value = "id") int id) {
        this.svService.deleteSinhVien(id);
    }

    @DeleteMapping("/giaovu/giangvien/add/{id}")
    public void delete(Model model, @PathVariable(value = "id") int id, HttpServletResponse response) {
        boolean success = this.gvService.deleteGV(id);
        if (success) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT); // Thiết lập trạng thái NO_CONTENT (204)
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Thiết lập trạng thái INTERNAL_SERVER_ERROR (500)
        }
    }
    
    @DeleteMapping("/giaovu/lophoc/add/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLH(@PathVariable(value = "id")int id){
        this.lhService.deleteLopHoc(id);
    }
    @DeleteMapping("/giaovu/khoadaotao/add/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKDT(@PathVariable(value = "id") int id){
        this.kdtService.deleteKhoaDaoTao(id);
    }
    
    @DeleteMapping("/giaovu/khoahoc/add/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKH(@PathVariable(value = "id") int id){
        this.kdtService.deleteKhoaHoc(id);
    }
    
    @DeleteMapping("/giaovu/phonghoc/add/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePH(@PathVariable(value = "id") int id){
        this.kdtService.deletePH(id);
    }
    
    @DeleteMapping("/giaovu/hocky/add/{idHK}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHK(@PathVariable(value = "idHK") int id){
        this.hkService.deleteHK(id);
    }
    
    @DeleteMapping("/giaovu/hedaotao/add/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHDT(@PathVariable(value = "id") int id){
        this.hdtService.deleteHDT(id);
    }
}
