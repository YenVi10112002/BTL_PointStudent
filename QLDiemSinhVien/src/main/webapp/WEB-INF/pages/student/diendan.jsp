<%-- 
    Document   : index
    Created on : Jul 25, 2023, 6:12:55 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/sinhvien/diendan" var="action"/>
<div class="content-diendan">
    <h3 style="font-weight: bold;margin: 20px 15px 40px 15px;">Diễn Đàng Trao Đổi ${sinhvien.hoTen}</h3>
    <a href="#" class="text-contend-link add-contend-question" id="themcauhoi">Thêm Chủ Đề</a>
    <c:forEach items="${dscauhoi}" var="ch">
        <div class="content-question">
            <h5><i class="fa-solid fa-user icon-padding"></i>${ch[2]}</h5>
                <c:url value="/sinhvien/diendan" var="cauhoi_id">
                    <c:param name="cauhoiId" value="${ch[1]}"/>
                </c:url>
            <p class="content-question-day"><i class="fa-solid fa-calendar-days icon-padding"></i>Ngày 25, tháng 7, năm 2023, 7:57AM</p>
            <p class="content-question-noidung">${ch[0]}</p>
            <a href="${cauhoi_id}" class ="text-contend-link xemcautraloi"><i class="fa-solid fa-comment-dots icon-padding"></i>Xem Câu Trả Lời</a>
            <a href="${cauhoi_id}" class ="text-contend-link reply-text-link xemcautraloi"><i class="fa-solid fa-reply icon-padding"></i>Trả Lời</a>

        </div>
    </c:forEach>

</div>
<div class="traloi-diendan-none" id="container">
    <div class="form-traloi-diendan">
        <div class="close-traloi-diendan">Đóng</div>
        <h5><i class="fa-solid fa-user icon-padding"></i>${cauhoi[2]}</h5>
        <p class="content-question-day"><i class="fa-solid fa-calendar-days icon-padding"></i>Ngày 25, tháng 7,
            năm 2023, 7:57AM</p>

        <p class="content-question-noidung">${cauhoi[0]}</p>


        <form:form class="d-flex" modelAttribute="traloidiendan" method="post" action="${action}">
            <form:input path="idTaiKhoan" type="hidden" value="${taikhoan.idTaiKhoan}" />
            <form:input path="idCauHoiDienDan" type="hidden" value="${cauhoi[1]}" />
            <form:input class="form-control me-2" type="text" path="noiDungTraLoi" name="noiDungTraLoi"  placeholder="Câu trả lời..." />
            <button class="btn-traloi-diendan" type="submit"><i class="fa-solid fa-reply icon-padding"></i>Trả Lời</button>
        </form:form>

        <c:forEach items="${traloi}" var="tl">
            <div class="traloi-diendan-user">
                <div class="close-traloi-diendan">Đóng</div>

                <h5 class="user-traloi-diendan-name"><i class="fa-solid fa-user icon-padding"></i>${tl[2]}</h5>
                <p class="content-question-noidung">${tl[0]}</p>
            </div>
        </c:forEach>

    </div>
</div>

<script><div class="traloi-diendan-none" id="container2">
    <div class="form-traloi-diendan">
        <div class="close-traloi-diendan" id="dong-traloi">Đóng</div>       
        <form:form class="d-flex" modelAttribute="cauhoidiendan" method="post" action="${action}">
            <form:input path="idTaiKhoan" type="hidden" value="${taikhoan.idTaiKhoan}" />
            <form:input class="form-control me-2" type="text" path="noiDungCauHoi" name="noiDungCauHoi"  placeholder="Câu trả lời..." />
            <button class="btn-traloi-diendan" type="submit"><i class="fa-solid fa-reply icon-padding"></i>Trả Lời</button>
        </form:form>
    </div>
</div>
    // mở đống
    const toggleButtons = document.querySelectorAll('.xemcautraloi');
    const close = document.querySelectorAll('.close-traloi-diendan');
    const container = document.getElementById('container');

    const container2 = document.getElementById('container2');
    const themcauhoi = document.getElementById('themcauhoi');
    const close2 = document.getElementById('dong-traloi');

    themcauhoi.addEventListener('click', function () {
        container2.classList.add('show');
    });
    close2.addEventListener('click', function (){
         container2.classList.remove('show');
    });
        


    function showContainer() {
        container.classList.add('show');
        localStorage.setItem('containerVisible', 'true');
    }

    // Hàm loại bỏ lớp 'show' khỏi container và lưu trạng thái trong localStorage
    function hideContainer() {
        container.classList.remove('show');
        localStorage.setItem('containerVisible', 'false');
    }

    // Kiểm tra xem khóa 'containerVisible' có tồn tại trong localStorage không
    const isContainerVisible = localStorage.getItem('containerVisible');

    // Chờ cho sự kiện DOMContentLoaded xảy ra
    document.addEventListener('DOMContentLoaded', function () {
        // Nếu 'containerVisible' là 'true', hiển thị container
        if (isContainerVisible === 'true') {
            showContainer();
        }
    });

    // Thêm lắng nghe sự kiện cho các nút toggle và nút đóng
    toggleButtons.forEach(function (button) {
        button.addEventListener('click', function () {


            if (!container.classList.contains('show')) {
                showContainer();
            } else {
                hideContainer();
            }
        });
    });

    close.forEach(function (button) {
        button.addEventListener('click', hideContainer);
    });

</script>



