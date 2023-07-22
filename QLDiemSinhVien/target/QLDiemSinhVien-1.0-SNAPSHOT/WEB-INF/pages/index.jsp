<%-- 
    Document   : login
    Created on : Jul 20, 2023, 4:35:21 PM
    Author     : FPTSHOP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row ">
        <div class=" form-login  shadow-lg ">
            <div class="text-center " >
                <h4 class="text-login">Đăng nhập</h4>
            </div>
            <select class="form-control text-size" id="form-usertype" name="form-usertype" onchange="do_testvaitro(this.value)">
                <c:forEach items="${loaitaikhoan}" var="l">
                    <option class="text-dropdow text-size" value="svcq">${l.tenloai}</option>
                </c:forEach>				
            </select>
            <form >
                <div class="mb-3 mt-3">
                    <input type="email" class="form-control text-size" id="email" placeholder="Nhập email" name="email" required>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control text-size" id="pwd" placeholder="Nhập password" name="pswd" required>
                </div>

                <div >

                    <a type="submit" id="submit" href="<c:url value="/signUp" /> class="btn Sbtn-bg btn-submit text-size">Đăng nhập</a>
                    <hr  width="100%" size="3px" align="center" color="#9C9C9C" />
                    <div class="btn-submit">
                        <p>Sinh viên chưa có tài khoản <a href="#" class=" text-center text-sign-in">Đăng ký</a></p>
                    </div>
                </div>
                <div>
                    <P>Nếu sinh viên lần đầu đăng nhập:</p>
                    <p class="text-content">Vui lòng chọn đăng ký, và đăng kí tài khoản bằng email trường cung cấp để có thể truy cập,
                        trong trường hợp quên mật khẩu đăng nhập, 
                        vui lòng liên hệ phòng quản lý sinh viên để được hỗ trợ. </p>
                </div>
            </form>
        </div>
    </div>
</div>


