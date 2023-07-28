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
    <c:forEach items="${cauhoi}" var="ch">
        <div class="content-question">
            <c:forEach items="${listsinhvien}" var="sv">
                <c:if test="${sv.idTaiKhoan == ch.idTaiKhoan}">
                    <h5><i class="fa-solid fa-user icon-padding"></i>${sv.hoTen}</h5>
                    </c:if>
                </c:forEach>

            <p class="content-question-day"><i class="fa-solid fa-calendar-days icon-padding"></i>Ngày 25, tháng 7, năm 2023, 7:57AM</p>
            <p class="content-question-noidung">${ch.noiDungCauHoi}</p>
            <a href="#" class ="text-contend-link xemcautraloi"><i class="fa-solid fa-comment-dots icon-padding"></i>Xem Câu Trả Lời</a>
            <a href="#" class ="text-contend-link reply-text-link xemcautraloi"><i class="fa-solid fa-reply icon-padding"></i>Trả Lời</a>

        </div>
    </c:forEach>

</div>
<div class="traloi-diendan-none" id="container">
    <div class="form-traloi-diendan">
        <div class="close-traloi-diendan" id="dong-traloi">Đóng</div>
        <h5><i class="fa-solid fa-user icon-padding"></i>Phạm Hoàng Ân</h5>
        <p class="content-question-day"><i class="fa-solid fa-calendar-days icon-padding"></i>Ngày 25, tháng 7,
            năm 2023, 7:57AM</p>

        <p class="content-question-noidung">A dropdown menu is a toggleable menu that allows the user to choose
            one value from a predefined list:</p>

        <form class="d-flex">
            <input class="form-control me-2" type="text" placeholder="Câu trả lời...">
            <button class="btn-traloi-diendan" type="button"><i class="fa-solid fa-reply icon-padding"></i>Trả
                Lời</button>
        </form>
        <div class="traloi-diendan-user">
            <div class="close-traloi-diendan">Đóng</div>
            <h5 class="user-traloi-diendan-name"><i class="fa-solid fa-user icon-padding"></i>Phạm Hoàng Ân</h5>
            <p class="content-question-noidung">A dropdown menu is a toggleable menu that allows the user to
                choose one value from a predefined list:</p>
        </div>
        <div class="traloi-diendan-user">
            <div class="close-traloi-diendan">Đóng</div>
            <h5 class="user-traloi-diendan-name"><i class="fa-solid fa-user icon-padding"></i>Phạm Hoàng Ân</h5>
            <p class="content-question-noidung">A dropdown menu is a toggleable menu that allows the user to
                choose one value from a predefined list:</p>
        </div>
        <div class="traloi-diendan-user">
            <div class="close-traloi-diendan">Đóng</div>
            <h5 class="user-traloi-diendan-name"><i class="fa-solid fa-user icon-padding"></i>Phạm Hoàng Ân</h5>
            <p class="content-question-noidung">A dropdown menu is a toggleable menu that allows the user to
                choose one value from a predefined list:</p>
        </div>
        <div class="traloi-diendan-user">
            <div class="close-traloi-diendan">Đóng</div>
            <h5 class="user-traloi-diendan-name"><i class="fa-solid fa-user icon-padding"></i>Phạm Hoàng Ân</h5>
            <p class="content-question-noidung">A dropdown menu is a toggleable menu that allows the user to
                choose one value from a predefined list:</p>
        </div>
        <div class="traloi-diendan-user">
            <div class="close-traloi-diendan">Đóng</div>
            <h5 class="user-traloi-diendan-name"><i class="fa-solid fa-user icon-padding"></i>Phạm Hoàng Ân</h5>
            <p class="content-question-noidung">A dropdown menu is a toggleable menu that allows the user to
                choose one value from a predefined list:</p>
        </div>



    </div>
</div>
<script>
    // mở đống
    const toggleButtons = document.querySelectorAll('.xemcautraloi');
    const close = document.querySelectorAll('.close-traloi-diendan');
    const container = document.getElementById('container');



    close.forEach(function (button) {
        button.addEventListener('click', function () {
            container.classList.remove('show');
        });
    })


    // Thêm sự kiện click cho button
    toggleButtons.forEach(function (button) {
        button.addEventListener('click', function () {

            if (!container.classList.contains('show')) {
                container.classList.add('show');
            } else {
                container.classList.remove('show');
            }
        });
    });

</script>
<style>
    @keyframes modelFaceIn {
        from {
            transform: translateY(-130px);
            opacity: 0;
        }

        to {
            transform: translateY(0);
            opacity: 1;
        }
    }

    .show {
        display: block !important;
    }

    .user-traloi-diendan-name {
        margin-bottom: -10px;
        font-size: 15px;
    }

    .traloi-diendan-user {
        margin: 25px 20px 5px 20px;
        border-bottom: 1px solid #666;
    }

    .close-traloi-diendan {
        background-color: #05386B;
        position: absolute;
        right: 0;
        top: 0;
        color: #fff;
        padding: 8px;
        border-top-right-radius: 10px;
        border-bottom-left-radius: 10px;
        cursor: pointer;
    }

    .btn-traloi-diendan {
        background-color: #05386B;
        color: aliceblue;
        font-size: small;
        font-weight: 500;
        border-radius: 10px;
        width: 100px;
        height: 50px;
    }

    .form-traloi-diendan {
        background-color: aliceblue;
        position: relative;
        width: 80%;
        padding: 25px;
        border-radius: 10px;
        top: 10%;
        margin: auto;
        max-height: 600px;
        overflow-x: auto;
        scroll-snap-type: x mandatory;
        animation: modelFaceIn ease .4s;

    }

    .traloi-diendan-none {
        display: none;
        position: fixed;
        top: 0;
        right: 0;
        left: 20%;
        bottom: 0;
        background-color: rgba(0, 0, 0, 0.5);
        align-items: center;
        justify-content: center;

    }

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
        margin: 40px 0px;
        border-radius: 10px;
        -moz-box-shadow: -3px -3px 5px 0px #666;
        -webkit-box-shadow: -3px -3px 5px 0px #666;
        box-shadow: -3px -3px 5px 0px #666;

    }
    .content-diendan{
        margin: 40px 60px;
    }
    .nav-menu{
        height: 60px;
    }
</style>


