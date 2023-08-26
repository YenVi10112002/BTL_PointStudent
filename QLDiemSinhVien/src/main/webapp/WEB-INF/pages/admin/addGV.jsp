<%-- 
    Document   : addGV
    Created on : Aug 17, 2023, 2:41:15 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/giaovu/giangvien/add" var="action"/>   
<div class="roww">
    <div class="margin-auto form-login  form-addSV">
        <h1 class="text-center">Thêm Giảng Viên</h1>
        <div class="text-form-addSV">
            <form:form  modelAttribute="giangvienn" method="post" action="${action}">
                <form:hidden path="idGiangVien" />
                <form:hidden path="idTaiKhoan" />
                <div class="form-floating mb-3 mt-3">
                    <form:input type="text" class="form-control" path="hoTen" id="name" placeholder="Họ và tên" name="name" />
                    <label for="name">Họ và tên</label>
                </div>
                            <div class="form-floating mt-3 mb-3">
                <form:input type="text" class="form-control" path="ngaySinh" id="dateofbirth" placeholder="Ngày sinh" name="dateofbirth"/>
                <label for="dateofbirth">Ngày sinh</label>
            </div>
                <div class="form-floating mt-3 mb-3">
                    <form:input type="text" class="form-control" path="diaChi" id="address" placeholder="Địa chỉ " name="address"/>
                    <label for="address">Địa chỉ</label>
                </div>
                <div class="form-floating mt-3 mb-3">
                    <form:select path="gioiTinh" id="sex" class="form-select" cssErrorClass="is-invalid">
                        <form:option value="-1" label="Chọn giới tính" />
                        <form:option value="1" label="Nam" />
                        <form:option value="0" label="Nữ" />
                    </form:select>
                    <label for="sex">Giới tính</label>
                </div>
                <div class="form-floating mt-3 mb-3">
                    <form:input type="text" class="form-control" path="soDienThoai" id="phonenumber" placeholder="Số điện thoại" name="phonenumber"/>
                    <label for="phonenumber">Số điện thoại</label>
                </div>
                <div class="form-floating mt-3 mb-3">
                    <form:input type="text" class="form-control" path="email" id="email" placeholder="Email" name="email"/>
                    <label for="email">Email</label>
                </div>
                <div class="btn-form-addsv">
                    <button class="btn input-form-addsv" type="submit">Thêm Giảng viên</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
