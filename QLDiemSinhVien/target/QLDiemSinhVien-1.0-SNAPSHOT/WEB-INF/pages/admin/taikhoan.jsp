<%-- 
    Document   : taikhoan
    Created on : Aug 19, 2023, 12:18:13 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="nav-tk">
    <a href="#" id="captaikhoan" class="a-tk">Cấp tài khoản</a>
    <div class="input-button-tk">
        <input placeholder="Nhập tên muốn tìm...."/>
        <button>Tìm kiếm</button>
    </div>
</div >
<div class="table-tk">
    <h1 class="text-tk">Danh sách sinh viên</h1>
    <table class="table table-infoTK">
        <thead>
            <tr>
                <th>Mã tài khoản</th>
                <th>Tên tài khoản</th>
                <th>Chức vụ</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${taikhoan}" var="tk">
                <tr>
                    <td>${tk.idTaiKhoan}</td>
                    <td>${tk.tenTaiKhoan}</td>
                    <td>${tk.chucVu}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<c:url value="/giaovu/taikhoan" var="action"/>
<div class="dangki-taikhoan-none " id="container">
    <div class=" form-dangki-taikhoan ">
        <div class="close-dangki-taikhoan" id="dong-dangki">Đóng</div>
        <div class="text-center " >
            <h3 class="text-center">Đăng Ký</h3>
        </div>
        <c:if test="${errMsg != null}">
            <div id="registration-form" class="alert text-size mt-3 ">
                ${errMsg};
            </div>
        </c:if>
        <div class="text-form-addSV">
            <form:form modelAttribute="dangki" method="post" action="${action}" id="registration-form">
                <div class="form-floating mb-3 mt-3">
                    <form:input type="text" class="form-control text-size" path="tenTaiKhoan" id="username" placeholder="Email" name="username" />
                    <label for="username">Email</label>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <form:input type="password" class="form-control text-size" path="matKhau" id="password" placeholder="Mật khẩu" name="password" />
                    <label for="password">Mật khẩu</label>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <form:input type="password" class="form-control text-size" path="xacNhanMk" id="cfpw" placeholder="Nhập lại mật khẩu" name="cfpw" />
                    <label for="cfpw">Nhập lại mật khẩu</label>
                </div>
                <div class="form-floating mb-3 mt-3">
                    <form:select class="form-select" id="teacher" name="teacher" path="giangvien1">
                        <c:forEach items="${giangvien}" var="gv">
                            <option value="${gv.idGiangVien}">${gv.hoTen}</option>
                        </c:forEach>
                    </form:select> 
                    <label for="teacher">Danh sách giảng viên</label>
                </div>
                <div class="form-floating">
                    <button type="submit" id="submit" class="btn btn-bg btn-submit text-size" >Đăng Ký</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
<script>
    const container = document.getElementById('container')
    const themtaikhoan = document.getElementById('captaikhoan')
    const close = document.getElementById('dong-dangki')

    themtaikhoan.addEventListener('click', function () {
        container.classList.add('show');
    });
    close.addEventListener('click', function () {
        container.classList.remove('show');
    });


</script>
