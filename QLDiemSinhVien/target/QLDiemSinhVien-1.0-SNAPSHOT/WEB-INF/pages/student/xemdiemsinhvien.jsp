<%-- 
    Document   : xemdiemsinhvien
    Created on : Jul 25, 2023, 7:28:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="point">
    <h4 style="font-weight: bold;">Tổng quan</h4>
    <h6 style="font-size: 13px; color: darkgrey;">Tổng Hợp Nhanh Các Thông Tin </h6>
    <div class="container mt-3">
        <h2 class="name-text">Phạm Hoàng Ân</h2>
        <p class="text-header-tong">Tổng Hợp Điểm & Xếp Loại Học Tập</p>            
        <table class="table">
            <thead>
                <tr>
                    <th>Điểm Hệ 10</th>
                    <th>Điểm Hệ 4</th>
                    <th>Xếp Loại</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${Diemtrungbinh}</td>
                    <td>${Diemtrungbinh4}</td>
                    <td>Giỏi</td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
<div class=" point-ky">
    <div class="container mt-3">
        <p class="text-header-tong">Tổng Hợp Điểm Của Từng Học Kỳ</p>            
        <table class="table">
            <thead>
                <tr>
                    <th >Học Kỳ</th>
                    <th>Môn Học</th>
                    <th>Điểm Giữa Kì</th>
                    <th>Điểm Cuối Kỳ</th>
                    <th>Điểm Trung Bình</th>
                    <th>Điểm Hệ 4</th>
                    <th>Tình Trạng</th>
                </tr>
            </thead>
            <tbody >

                <c:forEach items="${dsDiem}" var="diem">
                    <tr >
                        <td >${diem[5]}</td>
                        <td>${diem[6]}</td>
                        <td>${diem[2]}</td>
                        <td >${diem[1]}</td>
                        <td>${diem[0]}</td>
                        <td>${diem[7]}</td>
                        <c:choose>
                            <c:when test="${diem[3] == 1}">
                                <td>Đậu</td>
                            </c:when>
                            <c:otherwise>
                                <td>Rớt</td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

