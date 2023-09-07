<%-- 
    Document   : giangvien
    Created on : Aug 10, 2023, 12:56:15 AM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:if test="${errMsg != null}">
<div class="alert alert-secondary">
  <strong>${errMsg}</strong> 
</div>
</c:if>
<h1 class="text-center">Danh sách giảng viên</h1>
<table class="table ">
    <thead>
        <tr>
            <th>Mã giảng viên</th>
            <th>Họ và tên</th>
            <th>Ngày sinh</th>
            <th>Giới tính</th>
            <th>Email</th>
            <th>Địa chỉ</th>
            <th>Số điện thoại</th>
            <th>

                <a   href="<c:url value="/giaovu/giangvien/add"/>" class=" btn-xoavacn bg-add"  >Thêm Giảng viên</a>
            </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${giangvien}" var="gv">
            <tr>
                <td>${gv.idGiangVien}</td>
                <td>${gv.hoTen}</td>
                <td>${gv.ngaySinh}</td>
                <td>${gv.gioiTinh}</td>
                <td>${gv.email}</td>
                <td>${gv.diaChi}</td>
                <td>${gv.soDienThoai}</td>
                <td>
                    <c:url value="/giaovu/giangvien/add/${gv.idGiangVien}" var="api"/>
                    <a href="${api}"class="btn-xoavacn bg-cn" > Cập nhật</a>
                    <button onclick="deleteSinhVien('${api}')" class="btn-xoavacn bg-xoa"> Xóa</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<script src="<c:url value="/js/main.js" />"></script>
