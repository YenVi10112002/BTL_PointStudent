<%-- 
    Document   : khoahoc
    Created on : Sep 26, 2023, 1:06:03 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="table-sv">
    <h1 class="text-center">Danh sách sinh viên</h1>

    <table class="table " id="customers">
        <thead>
            <tr>
                <th>Mã Khóa</th>
                <th>Tên khóa</th>
                <th>Thời gian bắt đầu</th>
                <th>Thời gian kết thúc</th>
                <th><a href="#" class="btn-xoavacn bg-add"> Thêm Khóa</a></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${khoahoc}" var="kh">
                <tr>
                    <td>${kh.idkhoa}</td>
                    <td>${kh.tenKhoa}</td>
                    <td>1-10-2023</td>
                    <td>31-12-2023</td>
                    <td>
                        
                        <a href="#" class="btn-xoavacn bg-cn"> Cập nhật </a>
                        <button class="btn-xoavacn bg-xoa ">Xóa</button>
                        
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
