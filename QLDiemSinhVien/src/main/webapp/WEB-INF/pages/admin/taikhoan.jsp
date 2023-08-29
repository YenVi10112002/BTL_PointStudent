<%-- 
    Document   : taikhoan
    Created on : Aug 19, 2023, 12:18:13 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="nav-tk">
    <a href="<c:url value="/giaovu/taikhoan/dangki"/>"  class="a-tk">Cấp tài khoản</a>
    <div class="input-button-tktk">
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
                    <td>${tk.chucVu.tenloaitaikhoan}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
