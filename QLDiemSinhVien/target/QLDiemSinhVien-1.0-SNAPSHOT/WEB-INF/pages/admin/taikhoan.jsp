<%-- 
    Document   : taikhoan
    Created on : Aug 19, 2023, 12:18:13 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="nav-tk">
    <form class="search" action="${action}">
        <input class="search-input"  type="text" name="tensv" placeholder="Search...."/>
        <button class="search-button"><i class="fa-solid fa-magnifying-glass" style="color: #b7b7b8;"></i></button>
    </form>
</div >
<div class="table-sv">
    <div class="title-gv">
        <h1 class="text-center">Danh sách tài khoản</h1>
        <a href="<c:url value="/giaovu/taikhoan/dangki"/>"  class="btn-xoavacn-gv bg-add-gv">Cấp tài khoản</a>
    </div>

    <table class="table table-infoTK">
        <thead>
            <tr>
                <th>Mã tài khoản</th>
                <th>Tên tài khoản</th>
                <th>Chức vụ</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${taikhoan}" var="tk">
                <tr>
                    <td>${tk.idTaiKhoan}</td>
                    <td>${tk.tenTaiKhoan}</td>
                    <td>${tk.chucVu.tenloaitaikhoan}</td>
                    <td>
                        <a class="a-tk" href="#">Xem chi tiết</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="pagination-div">
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
</div>
