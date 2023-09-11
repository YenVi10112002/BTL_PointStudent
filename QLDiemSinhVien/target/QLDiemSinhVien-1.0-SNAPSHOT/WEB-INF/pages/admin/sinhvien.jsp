<%-- 
    Document   : sinhvien
    Created on : Aug 9, 2023, 11:59:40 PM
    Author     : FPTSHOP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/giaovu/sinhvien" var="action"/>
<div class="nav-tk">
    <form class="input-button-tk" action="${action}">
        <input  type="text" name="tensv" placeholder="Nhập tên muốn tìm...."/>
        <button type="submit">Tìm kiếm</button>
    </form>
</div >
<div class="table-sv">
    <h1 class="text-center">Danh sách sinh viên</h1>

    <table class="table " id="customers">
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
                    <td><c:choose>
                            <c:when test="${sv.gioiTinh == 0}">Nữ</c:when>
                            <c:when test="${sv.gioiTinh == 1}">Nam</c:when>
                            <c:otherwise>Giới tính không xác định</c:otherwise>
                        </c:choose></td>

                    <td>${sv.soDienThoai}</td>
                    <td>${sv.email}</td>
                    <td>
                        <a href="<c:url value="/giaovu/sinhvien/add/${sv.idSinhVien}"/>" class="btn-xoavacn bg-cn"> Cập nhật</a>
                        <c:url value="/giaovu/sinhvien/add/${sv.idSinhVien}" var="api" />
                        <button class="btn-xoavacn bg-xoa " onclick="deleteSinhVien('${api}')">Xóa</button>
                        <a href="<c:url value="/giaovu/sinhvien/addMH/${sv.idSinhVien}"/>" class="btn-xoavacn bg-cn "> Cấp môn học</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="${action}">Tất cả</a></li>
            <c:forEach begin="1" end="${counter}" var="i">
                <c:url value="/giaovu/sinhvien" var="pageAction">
                    <c:param name="page" value="${i}"/>
                </c:url>
            <li class="page-item"><a class="page-link" href="${pageAction}">${i}</a></li>
            </c:forEach>
    </ul> 
</div>   

