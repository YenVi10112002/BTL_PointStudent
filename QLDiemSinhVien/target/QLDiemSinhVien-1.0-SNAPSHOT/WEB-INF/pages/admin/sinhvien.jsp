<%-- 
    Document   : sinhvien
    Created on : Aug 9, 2023, 11:59:40 PM
    Author     : FPTSHOP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="nav-tk">
    
    <div class="input-button-tk">
        <input placeholder="Nhập tên muốn tìm...."/>
        <button>Tìm kiếm</button>
    </div>
</div >
<div class="table-sv">
    <h1 class="text-center">Danh sách sinh viên</h1>

    <table class="table ">
        <thead>
            <tr>
                <th>Mã số sinh viên</th>
                <th>Họ và tên</th>
                <th>Hệ đào tạo</th>
                <th>Ngày sinh</th>
                <th>Địa chỉ</th>
                <th>Giới tính</th>
                <th>Số điện thoại</th>
                <th>Email</th>
                <th><a href="<c:url value="/giaovu/sinhvien/add"/>" class="btn-xoavacn bg-add"> Thêm sinh viên</a></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${sinhvien}" var="sv">
                <tr>
                    <td>${sv.idSinhVien}</td>
                    <td>${sv.hoTen}</td>
                    <td>${sv.heDaoTao}</td>
                    <td>${sv.ngaySinh}</td>
                    <td>${sv.diaChi}</td>
                    <td>${sv.gioiTinh}</td>
                    <td>${sv.soDienThoai}</td>
                    <td>${sv.email}</td>
                    <td>

    
                        <a href="<c:url value="/giaovu/sinhvien/add/${sv.idSinhVien}"/>" class="btn-xoavacn bg-cn"> Cập nhật</a>
                        
                        <c:url value="/giaovu/sinhvien/add/${sv.idSinhVien}" var="api" />

                        <button class="btn btn-danger" onclick="deleteSinhVien('${api}')">Xóa</button>
                        <a href="<c:url value="/giaovu/sinhvien/addMH/${sv.idSinhVien}"/>" class="btn-xoavacn bg-cn"> Cấp môn học</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>   


<script src="<c:url value="/js/main.js" />"></script>

