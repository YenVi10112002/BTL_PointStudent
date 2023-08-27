<%-- 
    Document   : base
    Created on : Aug 9, 2023, 10:38:44 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
            <tiles:insertAttribute name="title" />
        </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    </head>
    <body>
        <tiles:insertAttribute name="header" />
        <div class="container">
            <tiles:insertAttribute name="content"/>
        </div>
        <tiles:insertAttribute name="footer"/>
        <script src="<c:url value="/resources/js/main.js" />"></script>

    </body>

</html>
<style>
    body {
        font-family: initial;
    }
    .input-button-tktk{
        margin-left: auto;
    }
    .btn-xoavacn {
        border: 1px solid black;
        padding: 5px;
        color: black;
        text-decoration: none;
        border-radius: 5px
    }
    .bg-cn {
        background-color: LightSkyBlue;
        display: inline-block;
        text-align: center;
    }
    .bg-xoa {
        background-color: #FF6A6A;
        display: inline-block;
        width: 50px;
        text-align: center;
    }
    .bg-add {
        display: inline-block;
        width: 144px;
        text-align: center;
        background-color: #66FF99;
    }
    h1.text-center {
        margin-top: 10px;
        margin-bottom: 20px
    }
    .form-addSV{
        max-width: 600px;
        box-shadow: -5px -5px 10px -1px rgba(0, 0, 0, 0.3),
            5px 5px 10px 2px rgba(0, 0, 0, 0.3);
        border-radius: 15px;
        padding: 39px;
        margin: 15px auto;
    }
    .text-form-addSV{
        font-size: 20px;
    }
    .btn-form-addsv{
        text-align: center;
        margin-top: 30px;
    }
    .input-form-addsv{
        width: 85px;
        padding: 5px;
        background-color: #33CC99;
        border-radius: 5px;
        border: 1px
    }
    .form-login {
        width: 600px;
        margin: 10px auto;
        border-radius: 25px;
        padding: 45px
    }
    .btn-bg {
        background: lightblue;
        width: 100%;
        margin-top: 10px
    }
    .table-infoTK{
        margin: 0px auto;
    }
    .table-tk{
        box-shadow: rgba(0, 0, 0, 0.05) 0px 6px 24px 0px, rgba(0, 0, 0, 0.08) 0px 0px 0px 1px;
        border-radius: 15px;
        padding-top: 1px;
        padding-bottom: 40px;
        padding: 1px 50px 40px;
        width: 1015px;
        margin: 50px auto;
    }
    .text-tk{
        margin: 20px auto;
        text-align: center;
    }
    .nav-tk{
        margin: 0px 220px;
        display: flex;
        box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px 6px;
        background: #E0FFFF;
        height: 59px;
        padding: 13px;
        font-size: 18px;
    }
    .input-button-tk{
        margin: 0px auto;
    }
    a.a-tk{
        box-shadow: rgba(9, 30, 66, 0.25) 0px 1px 1px, rgba(9, 30, 66, 0.13) 0px 0px 1px 1px;
        width: 140px;
        height: 32px;
        text-decoration: none;
        background: #1E90FF;
        color: white;
        border-radius: 3px;
        text-align: center;
        padding: 3px;
    }
    .table-sv{
        box-shadow: rgba(17, 17, 26, 0.1) 0px 1px 0px, rgba(17, 17, 26, 0.1) 0px 8px 24px, rgba(17, 17, 26, 0.1) 0px 16px 48px;
        margin-top: 50px;
        padding: 20px 40px 25px;
    }
    .display-add-MhSV{
        display: flex;
        margin-top:60px;
    }
    .table-info-svmh{
        box-shadow: rgba(0, 0, 0, 0.05) 0px 6px 24px 0px, rgba(0, 0, 0, 0.08) 0px 0px 0px 1px;
        padding: 20px;
        margin-left: 5px;
        width: 1000px;
    }
    .info-svmh{
        box-shadow: rgba(0, 0, 0, 0.05) 0px 6px 24px 0px, rgba(0, 0, 0, 0.08) 0px 0px 0px 1px;
        padding: 20px;
        width: 400px;
    }
    .header-info-svmh{
        font-size: 23px;
        text-align: center;
    }
    .label-info-svmh{
        font-size: 18px;
        margin-bottom: 5px;
    }
    /*    li.dropdown{
            margin-left: 650px;
            display: inline-block;
            padding-left: 100px;
        }*/
    .navbar-nav {
        list-style: none;
        padding: 0;
        margin: 0;
        display: flex;
    }

    .nav-item {
        margin-right: 10px; /* Khoảng cách giữa các phần tử <li> */
    }

    li.last-item {
        float: right;
        display: inline-block;/* Đẩy phần tử cuối cùng ra góc phải */
    }
    .center-text-addmh{
        width: 130px;
        font-weight: bold;
    }
    #customers {
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #customers td, #customers th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #customers tr:nth-child(even){
        background-color: #f2f2f2;
    }

    #customers tr:hover {
        background-color: #ddd;
    }

    #customers th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: #87CEFA;
        color: black;
    }
    @keyframes modelFaceIn {
        from {
            transform: translateY(-130px);
            opacity: 0;
        }

        to {
            transform: translateY(0);
            opacity: 1;
        }
    }
    .show {
        display: block !important;
    }
    .close-dangki-taikhoan {
        background-color: #05386B;
        position: absolute;
        right: 0;
        top: 0;
        color: #fff;
        padding: 8px;
        border-top-right-radius: 10px;
        border-bottom-left-radius: 10px;
        cursor: pointer;
    }

    .btn-add-teacher {
        background-color: #05386B;
        color: aliceblue;
        font-size: small;
        font-weight: 500;
        border-radius: 10px;
        width: 100px;
        height: 50px;
    }

    .form-dangki-taikhoan {
        background-color: aliceblue;
        position: relative;
        width: 40%;
        padding: 25px;
        border-radius: 10px;
        top: 10%;
        margin: auto;
        max-height: 600px;
        overflow-x: auto;
        scroll-snap-type: x mandatory;
        animation: modelFaceIn ease .5s;

    }

    .dangki-taikhoan-none {
        display: none;
        position: fixed;
        top: 56px;
        right: 0;
        left: 0;
        bottom: 0;
        background-color: rgba(0, 0, 0, 0.5);
        align-items: center;
        justify-content: center;

    }



</style>

