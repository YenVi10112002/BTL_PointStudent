<%-- 
    Document   : khoadaotao
    Created on : Sep 26, 2023, 4:32:07 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="table-sv">
    <h1 class="text-center">Danh sách sinh viên</h1>

    <table class="table " id="customers">
        <thead>
            <tr>
                <th>Mã khoa đào tạo</th>
                <th>Tên khoa đào tạo</th>
                <th><a href="#" class="btn-xoavacn bg-add"> Thêm khoa đào tạo</a></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${khoadt}" var="kdt">
                <tr>
                    <td>${kdt.idKhoaDaoTao}</td>
                    <td>${kdt.tenKhoaDaoTao}</td>
                    <td>
                        <a href="#" class="btn-xoavacn bg-cn"> Cập nhật </a>
                    </td>
                    <td>
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
