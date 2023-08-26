<%-- 
    Document   : thongtintaikhoan
    Created on : Jul 25, 2023, 7:41:55 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="info-user">
    <div class="info-title-user">
        <c:choose>
            <c:when test="${taikhoan.image == null}">

                <p class="info-user-image"><i class="fa-solid fa-user icon-padding"></i></p>
                </c:when>
                <c:otherwise>
                <div class="info-user-image-2" style="background: url('<c:url value="${taikhoan.image}" />') top center / cover no-repeat; "></div>
            </c:otherwise>
        </c:choose>

        <c:url value="/sinhvien/thongtin" var="action"/>
        <form:form modelAttribute="sv" method="post" action="${action}" enctype="multipart/form-data">
            <form:input path="idTaiKhoan" type="hidden" value="${taikhoan.idTaiKhoan}" />
            <form:input path="tenTaiKhoan" type="hidden" value="${taikhoan.tenTaiKhoan}" />
            <form:input path="matKhau" type="hidden" value="${taikhoan.matKhau}" />
            <form:input path="chucVu" type="hidden" value="${taikhoan.chucVu}" />
            <div class="form-group" >
                <form:input type="file" style="width: 105px;" cssClass="form-control" path="file" id="imgFile"/>
            </div>
            <div class="form-group">
                <button class="btn btn-danger mt-2" type="submit">Thêm Ảnh</button>
            </div>
            <c:if test="${errMsg != null}">
                <div class="alert alert-secondary text-size mt-3 ">
                    ${errMsg}
                </div>
            </c:if>

        </form:form>

        <p class="info-private">Thông tin Cá Nhân</p>
    </div>
    <div class="info-user-text-reply">
        <div class="info-user-texts">
            <span class="info-user-text">Họ Tên:</span>
            <span class="info-user-text2">${sinhvien.hoTen}</span>
        </div >
        <div class="info-user-texts">
            <span class="info-user-text">Email</span>
            <span class="info-user-text2">${sinhvien.email}</span>
        </div>
        <div class="info-user-texts">
            <span class="info-user-text">Địa Chỉ</span>
            <span class="info-user-text2">${sinhvien.diaChi}</span>
        </div>
        <div class="info-user-texts">
            <span class="info-user-text">Số Điện Thoại</span>
            <span class="info-user-text2">${sinhvien.soDienThoai}</span>
        </div>
        <div class="info-user-texts">
            <span class="info-user-text">Khóa Học</span>
            <span class="info-user-text2">2020-2024</span>
        </div>
        <div class="info-user-texts">
            <span class="info-user-text">Hệ Đào Tạo</span>
            <span class="info-user-text2">${sinhvien.heDaoTao}</span>
        </div>
        <div class="info-user-texts">
            <span class="info-user-text">Lớp Học</span>
            <span class="info-user-text2">DH20IT01</span>
        </div>
    </div>

</div>
