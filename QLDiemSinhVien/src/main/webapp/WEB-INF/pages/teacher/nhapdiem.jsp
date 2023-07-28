<%-- 
    Document   : nhapdiem
    Created on : Jul 28, 2023, 11:28:30 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container-nhapdiem-giaovien">
    <div class="container mt-3">
        <p>Danh Sách Sinh Viên Môn Học </p>
        <table class="table">
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Sinh Viên</th>
                    <th>Điểm Giữa Kì</th>
                    <th>Điểm Cuối Kỳ</th>
                    <th>Điểm Trung Bình</th>
                    <th>Điểm Hệ 4</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Phạm Hoàng Ân</td>
                    <td>8.0</td>
                    <td>9.0</td>
                    <td>9.5</td>
                    <td>3.5</td>
                    <td><button class="btn btn-primary btn-js-open" type="button">Nhập Điểm</button></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Phạm Hoàng Ân</td>
                    <td>8.0</td>
                    <td>9.0</td>
                    <td>9.5</td>
                    <td>3.5</td>
                    <td><button class="btn btn-primary btn-js-open" type="button">Nhập Điểm</button></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Phạm Hoàng Ân</td>
                    <td>8.0</td>
                    <td>9.0</td>
                    <td>9.5</td>
                    <td>3.5</td>
                    <td><button class="btn btn-primary btn-js-open" type="button">Nhập Điểm</button></td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>Phạm Hoàng Ân</td>
                    <td>8.0</td>
                    <td>9.0</td>
                    <td>9.5</td>
                    <td>3.5</td>
                    <td><button class="btn btn-primary btn-js-open" type="button">Nhập Điểm</button></td>
                </tr>

            </tbody>
        </table>
    </div>

</div>

<div class="display-form-diem" id="container">
    <div class="container-js-nhapdiem">
        <div id="close" class="close-nhap-diem">Close</div>
        <p1 class="name-nhapdiem-giaovien">Phạm Hoàng Ân</p1>
        <form class="js-nhapdiem">
            <div class="row js-nhapdiem-div">
                <div class="col">
                    <input type="number" class="form-control" placeholder="Điểm Giữa Kỳ" name="email">
                </div>
                <div class="col">
                    <input type="number" class="form-control" placeholder="Điểm Cuối Kỳ" name="email">
                </div>
                <div class="col">
                    <input type="number" class="form-control" placeholder="Điểm Khác" name="email">
                </div>
                <div class="col">
                    <input type="number" class="form-control" placeholder="Điểm Khác" name="email">
                </div>
                <div class="col">
                    <input type="number" class="form-control" placeholder="Điểm Khác" name="email">
                </div>

                <div class="col">
                    <button id="add-diem-js" class="btn btn-primary">+</button>
                </div>
            </div>
            <button class="btn btn-primary btn-luu-diem" id="save">
                Lưu
            </button>
        </form>
    </div>

</div>
<script>




    // mở đống
    const toggleButtons = document.querySelectorAll('.btn-js-open');
    const container = document.getElementById('container');
    const close = document.getElementById('close')
    const save = document.getElementById('save')



    close.addEventListener('click', function () {
        container.classList.remove('show');
    });

    save.addEventListener('click', function () {
        container.classList.remove('show');
    });

    // Thêm sự kiện click cho button
    toggleButtons.forEach(function (button) {
        button.addEventListener('click', function () {

            if (!container.classList.contains('show')) {
                container.classList.add('show');
            } else {
                container.classList.remove('show');
            }
        });
    });

</script>

<style>

    .name-nhapdiem-giaovien {
        position: absolute;
        font-size: 25px;
        font-weight: 500;
        margin-top: 20px;
        margin-left: 25px
    }

    .close-nhap-diem {
        background-color: #05386B;
        position: absolute;
        right: 0;
        top: 0;
        color: #fff;
        padding: 8px;
        cursor: pointer;
    }

    .btn-luu-diem {
        width: 70px;
        position: absolute;
        margin-top: 10px;
        left: 10px;

    }

    .js-nhapdiem {
        position: absolute;
        top: 35%;
        left: 7%;
        margin: 0px 15px;
    }

    .show {
        display: block !important;
    }

    .container-js-nhapdiem {
        background-color: #fff;
        width: 900px;
        min-height: 200px;
        position: relative;
        border-radius: 10px;
        top: 30%;
        margin: auto;
        animation: modelFaceIn ease .4s;


    }

    .display-form-diem {
        display: none;
        position: fixed;
        top: 0;
        right: 0;
        left: 20%;
        bottom: 0;
        background-color: rgba(0, 0, 0, 0.5);
        align-items: center;
        justify-content: center;

    }
    .container-nhapdiem-giaovien{
        margin: 20px 20px;
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

</style>