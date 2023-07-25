<%-- 
    Document   : thaydoimatkhau
    Created on : Jul 25, 2023, 7:46:14 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="change-password">
    <p class="change-password-title">Thay Đổi Mật Khẩu</p>
    <form action="/action_page.php" class="change-password-form">
        <div class="mb-3 mt-3">
            <label for="email" class="form-label">Nhập Mật Khẩu Cũ:</label>
            <input type="email" class="form-control" id="email" placeholder="Nhập Mật Khẩu Cũ" name="email"
                   required>
        </div>
        <div class="mb-3">
            <label for="pwd" class="form-label">Nhập Mật Khẩu Mới:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Nhập Mật Khẩu Mới" name="pswd"
                   required>
        </div>
        <div class="mb-3">
            <label for="pwd" class="form-label">Nhập Lại Mật Khẩu:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Nhập Lại Mật Khẩu" name="pswd"
                   required>
        </div>
        <div class="btn-change-password-div">
            <button type="submit" class="btn btn-primary btn-change-password ">Submit</button>
        </div>


    </form>
</div>
<style>
    .btn-change-password-div {
        display: flex;
        justify-content: center;
    }

    .btn-change-password {
        margin-top: 10px;
        width: 100px;
        position: relative;
    }

    .change-password-form {
        width: 70%;
        position: relative;
        margin: 0px auto;
    }

    .change-password-title {
        font-size: 30px;
        font-weight: 400;
        text-align: center;

    }

    .change-password {
        padding: 30px 20px;
        width: 60%;
        background-color: cadetblue;
        position: relative;
        margin: 70px auto;
        border-radius: 10px;
        border-radius: 10px;
        -moz-box-shadow: -3px -3px 5px 0px #666;
        -webkit-box-shadow: -3px -3px 5px 0px #666;
        box-shadow: -3px -3px 5px 0px #666;
    }

</style>