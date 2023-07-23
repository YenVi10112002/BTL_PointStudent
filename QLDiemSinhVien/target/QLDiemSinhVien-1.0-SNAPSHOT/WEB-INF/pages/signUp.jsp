<%-- 
    Document   : logout
    Created on : Jul 21, 2023, 2:26:40 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container  " >
    <div class="row ">
        <div class=" margin-auto form-login  shadow-lg ">
            <div class="text-center " >
                <h4 class="text-login">Đăng Ký</h4>
            </div>

            <form >
                <div class="mb-3 mt-3">
                    <input type="email" class="form-control text-size" id="email" placeholder="Enter email" name="email" required>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control text-size" id="pwd" placeholder="Nhập mật khẩu" name="pswd" required>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control text-size" id="pwd" placeholder="Nhập lại mật khẩu" name="pswd" required>
                </div>


                <div >
                    <a type="submit" id="submit" href="<c:url value="/" />" class="btn Sbtn-bg btn-submit text-size" >Đăng Ký</a>

                </div>
               

            </form>
        </div>
    </div>
</div>

