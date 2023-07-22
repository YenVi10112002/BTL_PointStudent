<%-- 
    Document   : logout
    Created on : Jul 21, 2023, 2:26:40 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/registers" var="action" />
<div class="container  " >
    <div class="row ">
        <div class=" margin-auto form-login  shadow-lg ">
            <div class="text-center " >
                <h4 class="text-login">Đăng Ký</h4>
            </div>

            <form >
                <div class="mb-3 mt-3">
                    <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" id="pwd" placeholder="Nhập mật khẩu" name="pswd" required>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" id="pwd" placeholder="Nhập lại mật khẩu" name="pswd" required>
                </div>


                <div >
                    <button type="submit" class="btn btn-primary btn-submit margin-auto">Đăng nhập</button>

                </div>
               

            </form>
        </div>
    </div>
</div>

