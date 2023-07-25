<%-- 
    Document   : index
    Created on : Jul 25, 2023, 6:12:55 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<div class="content-diendan">
    <h3 style="font-weight: bold;margin: 20px 15px 40px 15px;">Diễn Đàng Trao Đổi</h3>
    <a href="#" class="text-contend-link add-contend-question">Thêm Chủ Đề</a>
    <div class="content-question">
        <h5><i class="fa-solid fa-user icon-padding"></i>Phạm Hoàng Ân</h5>
        <p class="content-question-day"><i class="fa-solid fa-calendar-days icon-padding"></i>Ngày 25, tháng 7, năm 2023, 7:57AM</p>
        <p class="content-question-noidung">A dropdown menu is a toggleable menu that allows the user to choose one value from a predefined list:</p>
        <a href="#" class ="text-contend-link"><i class="fa-solid fa-comment-dots icon-padding"></i>Xem Câu Trả Lời</a>
        <a href="#" class ="text-contend-link reply-text-link"><i class="fa-solid fa-reply icon-padding"></i>Trả Lời</a>

    </div>
    <div class="content-question">
        <h5><i class="fa-solid fa-user icon-padding"></i>Phạm Hoàng Ân</h5>
        <p class="content-question-day"><i class="fa-solid fa-calendar-days icon-padding"></i>Ngày 25, tháng 7, năm 2023, 7:57AM</p>
        <p class="content-question-noidung">A dropdown menu is a toggleable menu that allows the user to choose one value from a predefined list:</p>
        <a href="#" class ="text-contend-link"><i class="fa-solid fa-comment-dots icon-padding"></i>Xem Câu Trả Lời</a>
        <a href="#" class ="text-contend-link reply-text-link"><i class="fa-solid fa-reply icon-padding"></i>Trả Lời</a>

    </div>
    <div class="content-question">
        <h5><i class="fa-solid fa-user icon-padding"></i>Phạm Hoàng Ân</h5>
        <p class="content-question-day"><i class="fa-solid fa-calendar-days icon-padding"></i>Ngày 25, tháng 7, năm 2023, 7:57AM</p>
        <p class="content-question-noidung">A dropdown menu is a toggleable menu that allows the user to choose one value from a predefined list:</p>
        <a href="#" class ="text-contend-link"><i class="fa-solid fa-comment-dots icon-padding"></i>Xem Câu Trả Lời</a>
        <a href="#" class ="text-contend-link reply-text-link"><i class="fa-solid fa-reply icon-padding"></i>Trả Lời</a>

    </div>
</div>
<style>
    <!-- comment -->
    .add-contend-question{
        position: absolute;
        left: 80%;
        top:10%;
        padding: 10px 15px;
        color: aliceblue !important;
        border-radius: 10px;
        background-color: #05386B;
    }
    .content-question-noidung{
        margin: 25px 15px;
    }
    .content-question-day{
        margin-left: 20px;
        color: #525d69;
    }
    .reply-text-link{
        margin-left: 800px;
    }
    .text-contend-link{
        text-decoration: none;
        color: black;
    }
    .text-contend-link:hover{
        color: #525d69;
    }
    .content-question{
        border: 0.5px solid gray;
        padding: 25px;
        margin: 20px 0px;
        border-radius: 10px;
        -moz-box-shadow: -3px -3px 5px 0px #666;
        -webkit-box-shadow: -3px -3px 5px 0px #666;
        box-shadow: -3px -3px 5px 0px #666;

    }
    .content-diendan{
        margin: 30px 60px;
    }
    .nav-menu{
        height: 60px;
    }
</style>


