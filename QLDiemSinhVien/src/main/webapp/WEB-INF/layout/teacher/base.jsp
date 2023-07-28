<%-- 
    Document   : base
    Created on : Jul 28, 2023, 11:06:07 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <nav class="navbar navbar-expand-sm navbar-dark">
                <div class="container-fluid">
                    <a class="navbar-brand dark-color header-logo " href="#"><i
                            class="fa-solid fa-bell icon-padding"></i></a>
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                        <ul class="navbar-nav" style="width: 100%;">
                            <li class="nav-item Search-student">
                                <form class="d-flex">
                                    <input class="form-control me-2" type="text" placeholder="Tìm Sinh Viên...">
                                    <button class="btn-search-student" type="button">Search</button>
                                </form>
                            </li>
                            <li class="nav-item user-name-img">
                                <a class="nav-link " href="#"><i class="fa-solid fa-user icon-padding"
                                                                 style="color: black;"></i></a>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle dark-color" href="#" role="button"
                                   data-bs-toggle="dropdown">Chào,
                                    Phạm Hoàng Ân</a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item dark-color " href="#"><i
                                                class="fa-solid fa-user icon-padding"></i>Thông Tin Tài Khoản</a></li>
                                    <li><a class="dropdown-item dark-color" href="#"><i
                                                class="fa-solid fa-key icon-padding"></i>Thay Đổi Mật Khẩu</a></li>
                                    <li><a class="dropdown-item dark-color" href="#"><i
                                                class="fa-solid fa-right-to-bracket icon-padding"></i>Đăng Xuất</a></li>

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

        .btn-search-student {
            border-radius: 10px;
            border: #05386B;
            background-color: #05386B;
            color: aliceblue;
            margin-left: 10px;
        }

        .btn-search-student:hover {
            background-color: #0d6097;
        }

        .Search-student {
            width: 33%;
            margin-left: 500px;

        }

        .item-name {
            position: relative;


        }

        .icon-padding {
            padding: 0 10px;
        }

        .dark-color {
            color: black !important;
        }

        .navbar {
            background-color: lightcyan !important;
        }

        .name-text {
            margin: 30px 10px;
            font-weight: bold;
        }

        .text-header-tong {
            margin-left: 30px;
            color: darkgrey;
        }

        .point-ky {
            margin: 40px 30px;
        }

        .point-tong>li {
            float: left;
        }

        .point {
            margin: 20px 30px;
        }

        .user-name-img {
            margin-left: 30px;
        }

        .logo-menu {
            height: 120px;
            padding: 10px 5px;
            text-align: center;


        }

        .header-logo {
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
            background-color: #05386B !important;
            ;
            width: 20%;
            height: 100%;
            z-index: 100;
            position: fixed;
            color: aliceblue;
            display: inline-block;
            /* Set a width if you like */
        }

        .text-menu {
            margin-left: 20px;
            font-weight: bold;
        }

        .vertical-menu a {



            /* Grey background color */

            /* Black text color */
            display: block;
            /* Make the links appear below each other */
            /* Add some padding */
            text-decoration: none;
            /* Remove underline from links */
        }

        .menu-item:hover {
            background-color: darkgrey;
            color: aliceblue;

        }

        .menu-item {
            padding: 10px 30px;
            color: aliceblue;

        }

        .menu-items {
            margin-bottom: 35px;
        }

        .dropdown-menu {
            background-color: lightcyan;
        }
    </style>

</html>
