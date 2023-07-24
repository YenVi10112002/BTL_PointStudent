<%-- 
    Document   : logout
    Created on : Jul 21, 2023, 2:26:40 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container  " >
    <div class="row ">
        <div class=" margin-auto form-login  shadow-lg ">
            <div class="text-center " >
                <h4 class="text-login">Đăng Ký</h4>
            </div>
            <c:url value="/signup" var="action"/>
            <form:form modelAttribute="account" method="post" action="${action}">
                <div class="form-floating mb-3 mt-3">
                    <form:input type="text" class="form-control text-size" path="tenTaiKhoan" id="email" placeholder="Email" name="email" />
                    <label for="email">Email</label>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <form:input type="password" class="form-control text-size" path="matKhau" id="pw" placeholder="Mật khẩu" name="pw" />
                    <label for="pw">Mật khẩu</label>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <input type="password" class="form-control text-size" id="cfpw" placeholder="Nhập lại mật khẩu" name="cfpw" />
                    <label for="cfpw">Nhập lại mật khẩu</label>
                </div>
                <div >
                    <a type="submit" id="submit" href="<c:url value="/" />" class="btn Sbtn-bg btn-submit text-size" >Đăng Ký</a>
                </div>    
            </form:form>
        </div>
    </div>
</div>

<!--<div class="container  " >
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





            </form>
        </div>
    </div>
</div>-->

