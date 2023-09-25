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
    <h1 class="text-center">Danh sách lớp học</h1>


    <table class="table " >
        <thead>
            <tr>
                <th>Mã Lớp Học</th>
                <th>Tên Lớp Học</th>
                <th>Sĩ Số</th>
                <th>Ngành Đào Tạo</th>
                <th>Khóa Học</th>

                <th><a href="#" class="btn-xoavacn bg-add"> Thêm Lớp Học</a></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listLopHoc}" var="lop">
                <tr>
                    <td>${lop.idLopHoc}</td>
                    <td>${lop.tenLopHoc}</td>
                    <td>1</td>
                    <td>${lop.idNganh.tenNganhDaoTao}</td>
                    <td>${lop.idKhoaHoc.tenKhoa}</td>
                    <td>

                         <c:url value="/giaovu/lophoc/${lop.idLopHoc}" var="dsSinhVien"/>
                        <a href="${dsSinhVien}"class="btn-xoavacn bg-cn" > Danh Sách</a>
                        <button class="btn-xoavacn bg-xoa"> Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>   

