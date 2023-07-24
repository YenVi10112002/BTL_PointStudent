/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.av.formatter;

import com.av.pojo.Loaitaikhoan;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author FPTSHOP
 */
public class CategoryFormatter implements Formatter<Loaitaikhoan>{

    @Override
    public String print(Loaitaikhoan loaitk, Locale locale) {
        return String.valueOf(loaitk.getIdloaitaikhoan());
    }

    @Override
    public Loaitaikhoan parse(String idLoaiTk, Locale locale) throws ParseException {
        return new Loaitaikhoan(Integer.parseInt(idLoaiTk));
    }
    
}
