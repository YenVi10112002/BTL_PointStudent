<%-- 
    Document   : monhoc
    Created on : Aug 18, 2023, 9:24:40 AM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center">Danh sách môn học</h1>
<table class="table ">
    <thead>
        <tr>
            <th>Mã môn học</th>
            <th>Tên môn học</th>
            <th>Hình thức thi</th>
            <th>Số tín chỉ</th>
            <th>Học kỳ</th>
            <th>Phòng học</th>
            <th>

                <a  href="<c:url value="/giaovu/monhoc/add"/>" class=" btn-xoavacn bg-add"  >Thêm Môn Học</a>
            </th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${monhoc}" var="mh">
            <tr>
                <td>${mh.idMonHoc}</td>
                <td>${mh.tenMonHoc}</td>
                <td>${mh.hinhThucThi}</td>
                <td>${mh.soTinChi}</td>
                <td>${mh.hocKy}</td>
                <td>${mh.phongHoc}</td>
               
                <td>
                    <c:url value="/giaovu/monhoc/add/${mh.idMonHoc}" var="api"/>
                    <a href="${api}"class="btn-xoavacn bg-cn" > Cập nhật</a>
                    <button onclick="deleteSinhVien('${api}')"  class="btn-xoavacn bg-xoa"> Xóa</button>
                </td>   
            </tr>
        </c:forEach>
    </tbody>
</table>
<script src="<c:url value="/js/main.js" />"></script>