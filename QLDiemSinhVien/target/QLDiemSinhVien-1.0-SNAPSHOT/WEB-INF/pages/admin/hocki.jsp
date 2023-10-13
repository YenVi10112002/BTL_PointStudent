<%-- 
    Document   : hocki
    Created on : Oct 2, 2023, 12:29:39 PM
    Author     : FPTSHOP
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="table-sv">
    <div class="title-gv">
        <h1 class="text">Danh sách học kỳ</h1>
        <a   href="<c:url value="/giaovu/giangvien/add"/>" class=" btn-xoavacn-gv bg-add-gv"  >Thêm Giảng viên</a>
    </div>

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
                        <a href="${api}"class="btn-xoavacn-gv bg-cn " alt="Cập nhật"> <i class="fa-regular fa-pen-to-square"></i></a>
                        <button onclick="deleteSinhVien('${api}')" alt="Xóa" class="btn-xoavacn-gv bg-xoa"><i class="fa-regular fa-trash-can"></i></button>
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
<script src="<c:url value="/js/main.js" />"></script>