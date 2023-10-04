<%-- 
    Document   : chitietsinhvien
    Created on : Sep 26, 2023, 3:22:22 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<h1 class="header-info-student-ad">Thông tin Sinh viên</h1>
<div class="container-info-stundent">

    <div class="student-info-ad">
        <h2>Họ và tên: ${sinhvienn.hoTen}</h2>
        <p>Mã sinh viên:  ${sinhvienn.idSinhVien}</p>
        <p>Ngày sinh:  ${sinhvienn.ngaySinh}</p>
        <p>Địa chỉ:  ${sinhvienn.diaChi}</p>
        <p>Email:  ${sinhvienn.email}</p>
        <a href="<c:url value="/giaovu/sinhvien/add/${sinhvienn.idSinhVien}"/>" class="btn-xoavacn bg-cn"> Cập nhật</a>
        <c:url value="/giaovu/sinhvien/add/${sv.idSinhVien}" var="api" />
        <button class="btn-xoavacn bg-xoa " onclick="deleteSinhVien('${api}')">Xóa</button>
    </div>

    <div class="courses">


        <h2>Danh sách môn đã hoàn thành</h2>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Tên Môn Học</th>
                    <th>Học Kỳ</th>
                    <th>Khóa</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${monHocDaHoc}" var="mh">
                    <tr>
                        <td>${mh.idMonHoc.idMonHoc.tenMonHoc}</td>
                        <td>${mh.idMonHoc.idHocky.tenHocKy}</td>
                        <td>${mh.idMonHoc.idHocky.idLop.idKhoaHoc.tenKhoa}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <h2>Danh sách môn đang học</h2>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Tên Môn Học</th>
                    <th>Học Kỳ</th>
                    <th>Khóa</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${monHocDangHoc}" var="mh">
                    <tr>
                        <td>${mh.idMonHoc.idMonHoc.tenMonHoc}</td>
                        <td>${mh.idMonHoc.idHocky.tenHocKy}</td>
                        <td>${mh.idMonHoc.idHocky.idLop.idKhoaHoc.tenKhoa}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
</div>

<style>
    .container-info-stundent {
        max-width: 1000px;
        margin: 0 auto;
        padding: 20px;
        display: flex;
        justify-content: space-between;
    }
    .header-info-student-ad {
        text-align: center;
        margin-top: 40px;
    }
    .student-info-ad {
        border: 1px solid #ccc;
        padding: 20px;
        margin-top: 20px;
    }
    .student-info-ad h2 {
        margin-top: 0;
    }
    .student-info-ad p {
        margin: 10px 0;
    }
    .courses {
        flex: 2;
        border: 1px solid #ccc;
        padding: 20px;
        margin-top: 20px;
    }
    .courses h2 {
        margin-top: 0;
    }
    .course-list {
        list-style-type: none;
        padding: 0;
    }
    .course-list li {
        margin: 10px 0;
    }
</style>
