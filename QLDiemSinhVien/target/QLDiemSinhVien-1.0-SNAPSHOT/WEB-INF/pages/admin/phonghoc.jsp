<%-- 
    Document   : phonghoc
    Created on : Sep 26, 2023, 5:01:51 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="table-sv">
    <h1 class="text-center">Danh sách sinh viên</h1>

    <table class="table " id="customers">
        <thead>
            <tr>
                <th>Mã phòng học</th>
                <th>Tên phòng học</th>
                <th><a href="#" class="btn-xoavacn bg-add"> Thêm phòng học</a></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${phonghoc}" var="ph" >
                <tr>
                    <td>${ph.idPhongHoc}</td>
                    <td>${ph.tenPhongHoc}</td>
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
