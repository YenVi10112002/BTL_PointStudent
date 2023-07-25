<%-- 
    Document   : thongtintaikhoan
    Created on : Jul 25, 2023, 7:41:55 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="info-user">
    <div class="info-title-user">
        <p class="info-user-image"><i class="fa-solid fa-user icon-padding"></i></p>
        <p class="info-private">Thông tin Cá Nhân</p>
    </div>
    <div class="info-user-text-reply">
        <div class="info-user-texts">
            <span class="info-user-text">Họ Tên:</span>
            <span class="info-user-text2">Phạm Hoàng Ân</span>
        </div >
        <div class="info-user-texts">
            <span class="info-user-text">Email</span>
            <span class="info-user-text2">cua24032002@ou.edu.vn</span>
        </div>
        <div class="info-user-texts">
            <span class="info-user-text">Địa Chỉ</span>
            <span class="info-user-text2">200/14 Gò Dầu, Tân Quý, Tân Phú</span>
        </div>
        <div class="info-user-texts">
            <span class="info-user-text">Số Điện Thoại</span>
            <span class="info-user-text2">0397769522</span>
        </div>
        <div class="info-user-texts">
            <span class="info-user-text">Khóa Học</span>
            <span class="info-user-text2">2020-2024</span>
        </div>
        <div class="info-user-texts">
            <span class="info-user-text">Hệ Đào Tạo</span>
            <span class="info-user-text2">Chất Lượng Cao</span>
        </div>
        <div class="info-user-texts">
            <span class="info-user-text">Lớp Học</span>
            <span class="info-user-text2">DH20IT01</span>
        </div>
    </div>

</div>
<style>
    .info-user-text-reply{
        padding:0px 50px 50px 50px;
    }
    .info-title-user{
        background-color: cadetblue;
        padding: 15px;
        margin-bottom: 40px;
        border-radius: 10px;
    }
    .info-private{
        display: inline-block;
        position: relative;
        font-size: 28px;
        font-weight: 500;
        margin: 0px 0px 0px 130px;
    }
    .info-user-text2{
        font-weight: 470;
    }
    .info-user-texts{
        border-bottom: 1px solid darkgrey;
        margin: 10px 0px;
    }
    .info-user-text{
        font-size: 17px;
        font-weight: 600 ;
        margin: 10px 5px;
        width: 35%;
        display: inline-block;
    }
    .info-user-image{
        font-size: 40px;
        background-color: antiquewhite;
        display: inline-block;
        padding: 20px;
        margin: auto 20px;
        border-radius: 50%;
    }
    .info-user{
        border: 1px solid gray;
        position: relative;
        width: 60%;
        border-radius: 10px;
        margin:50px auto;
        border-radius: 10px;
        -moz-box-shadow: -3px -3px 5px 0px #666;
        -webkit-box-shadow: -3px -3px 5px 0px #666;
        box-shadow: -3px -3px 5px 0px #666;
    }

</style>