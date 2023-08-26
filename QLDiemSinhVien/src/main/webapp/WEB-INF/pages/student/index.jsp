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
                    <td></td>
                    <td></td>
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
                
                <tr>
                    <td>2</td>
                    <td>8.5</td>
                    <td>3.0</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>10</td>
                    <td>4.0</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>7</td>
                    <td>2.5</td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>8</td>
                    <td>3.5</td>
                </tr>
                <tr >
                    <td >6</td>
                    <td>9.0</td>
                    <td>3.5</td>
                </tr>
                <tr>
                    <td>7</td>
                    <td>8.5</td>
                    <td>3.0</td>
                </tr>
                <tr>
                    <td>8</td>
                    <td>10</td>
                    <td>4.0</td>
                </tr>
                <tr>
                    <td>9</td>
                    <td>7</td>
                    <td>2.5</td>
                </tr>
                <tr>
                    <td>10</td>
                    <td>8</td>
                    <td>3.5</td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
<style>
    .table{
        margin-left: 30px;
    }
    .icon-padding{
        padding: 0 10px;
    }
    .dark-color{
        color: black !important;
    }
    .navbar{
        background-color: lightcyan !important;
    }
    .name-text{
        margin: 30px 10px;
        font-weight: bold;
    }
    .text-header-tong{
        margin-left: 30px;
        color: darkgrey;
    }
    .point-ky{
        margin: 40px 30px;
    }
    .point-tong>li{
        float: left;
    }
    .point {
        margin: 20px 30px;
    }

    .user-name-img {
        margin-left: 900px;
    }

    .logo-menu {
        height: 120px;
        padding: 10px 5px;
        text-align: center;


    }
    .header-logo{
        color: black;
    }

    .logo-menu a {
        line-height: 100px;
        font-weight: bold;
    }
</style>


