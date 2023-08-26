<%-- 
    Document   : header
    Created on : Aug 9, 2023, 10:38:53 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">Admin</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item me-2">
                    <a class="nav-link" href="<c:url value="/giaovu/sinhvien"/>">Danh sách sinh viên</a>
                </li>
                <li class="nav-item me-2">
                    <a class="nav-link" href="<c:url value="/giaovu/giangvien"/>">Danh sách giảng viên</a>
                </li>
                <li class="nav-item me-2">
                    <a class="nav-link" href="<c:url value="/giaovu/monhoc"/>">Danh sách môn học</a>
                </li>
                <li class="nav-item me-2">
                    <a class="nav-link" href="<c:url value="/giaovu/taikhoan"/>">Danh sách tài khoản</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><i class="fa-solid fa-user" style="color: #f2f2f2;"></i></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Thông tin tài khoản</a></li>
                        <li><a class="dropdown-item" href="#">Thay đổi mật khẩu</a></li>
                        <li><a class="dropdown-item" href="<c:url value="/logout" />">Đăng xuất</a></li>
                    </ul>
                </li>

            </ul>
        </div>
    </div>
</nav>
<style>
    .bg-dark {
        background-color: #05386B!important;
    }
</style>

