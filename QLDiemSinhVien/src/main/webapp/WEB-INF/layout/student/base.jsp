<%-- 
    Document   : base
    Created on : Jul 22, 2023, 9:07:48 AM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tổng Quan</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    </head>
    <body>
        <tiles:insertAttribute name="header" />
        <div class="contend">
            <nav class="navbar navbar-expand-sm navbar-dark nav-menu">
                <div class="container-fluid">
                    <a class="navbar-brand dark-color header-logo " href="#"><i class="fa-solid fa-bell icon-padding"></i></a>
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                        <ul class="navbar-nav">
                            <li class="nav-item user-name-img" style="background-color: aliceblue;border-radius: 50%;">
                                <a class="nav-link " href="#"><i class="fa-solid fa-user icon-padding" style="color: black; background-color: aliceblue;border-radius: 5px;"></i></a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle dark-color" href="#" role="button" data-bs-toggle="dropdown">Chào,
                                    Phạm Hoàng Ân</a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item dark-color " href="#"><i class="fa-solid fa-user icon-padding"></i>Thông Tin Tài Khoản</a></li>
                                    <li><a class="dropdown-item dark-color" href="#"><i class="fa-solid fa-key icon-padding"></i>Thay Đổi Mật Khẩu</a></li>
                                    <li><a class="dropdown-item dark-color" href="#"><i class="fa-solid fa-right-to-bracket icon-padding"></i>Đăng Xuất</a></li>

                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <tiles:insertAttribute name="content"/>

        </div>


        <tiles:insertAttribute name="footer"/>
    </body>

    <style>

        
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

        .contend {
            position: relative;
            left: 20%;
            width: 80%;
        }

        .vertical-menu {
            background-color: #05386B!important;
            ;
            width: 20%;
            height: 100%;
            z-index: 100;
            position: fixed;
            color: aliceblue;
            display: inline-block;
        }

        .text-menu {
            margin-left: 20px;
            font-weight: bold;
        }

        .vertical-menu a {
            display: block;
            text-decoration: none;

        }

        .menu-item:hover {
            background-color: darkgrey;
            color: aliceblue;

        }

        .menu-item{
            padding: 10px 30px;
            color: aliceblue;

        }

        .menu-items {
            margin-bottom: 35px;
        }
        .dropdown-menu{
            background-color: lightcyan;
        }
    </style>

</html>

