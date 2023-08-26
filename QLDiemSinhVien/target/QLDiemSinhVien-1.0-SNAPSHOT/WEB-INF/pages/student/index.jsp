<%-- 
    Document   : index
    Created on : Jul 25, 2023, 6:12:55 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="point">
    <h4 style="font-weight: bold;">Tổng quan</h4>
    <h6 style="font-size: 13px; color: darkgrey;">Tổng Hợp Nhanh Các Thông Tin </h6>
    <div class="container mt-3">
        <c:if test="${pageContext.request.userPrincipal.name != null}">    
              <h2 class="name-text"> ${sinhvien.hoTen}</h2>            
        </c:if>
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
                    <th>Điểm Hệ 10</th>
                    <th>Điểm hệ 4</th>
                </tr>
            </thead>
            <tbody >
                <c:forEach items="${dsDiem}" var="diem">
                    <tr>
                    <td>${diem[0]}</td>
                    <td>${diem[1]}</td>
                    <td>${diem[2]}</td>
                </tr>
                </c:forEach>
                
            </tbody>
        </table>
    </div>
</div>



