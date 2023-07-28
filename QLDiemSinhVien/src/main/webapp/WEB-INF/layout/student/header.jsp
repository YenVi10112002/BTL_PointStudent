<%-- 
    Document   : header
    Created on : Jul 24, 2023, 10:13:01 AM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="vertical-menu">

    <div class="active logo-menu">
        <a href="#"><i class="fa-solid fa-book-open " style="padding-right: 5px;"></i>Trường Đại Học Mở</a>
    </div>
    <div class="menu-items">
        <p class="text-menu ">Dịch Vụ, Tiện Ích</p>
        <a class="menu-item" href="<c:url value="/sinhvien" />"><i class="fa-solid fa-house icon-padding"></i>Tổng Quan</a>
        <a class="menu-item" href="<c:url value="/sinhvien/diendan" />"><i class="fa-solid fa-message icon-padding"></i>Diễn Đàn</a>
        <a class="menu-item" href="<c:url value="/sinhvien/xemdiem" />"><i class="fa-solid fa-gift icon-padding"></i>Xem Điểm</a>
    </div>
    <div class="menu-items">
        <p class="text-menu">Thông Tin tài Khoản</p>
        <a class="menu-item" href="<c:url value="/sinhvien/thongtin" />"><i class="fa-solid fa-user icon-padding"></i>Thông Tin Tài Khoản</a>
        <a class="menu-item" href="<c:url value="/sinhvien/thaydoimatkhau" />"><i class="fa-solid fa-key icon-padding"></i>Thay Đổi Mật Khẩu</a>
        <a class="menu-item" href="<c:url value="/logout" />"><i class="fa-solid fa-right-to-bracket icon-padding"></i>Thoát Quyền Sử Dụng</a>
    </div>

</div>

