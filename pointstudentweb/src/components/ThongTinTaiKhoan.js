import { Button, Form, Alert } from "react-bootstrap";
import { MyUserConText } from "../App";
import { useContext, useRef, useState } from "react";
import MySpinner from "../layout/MySpinner";
import { AuthApis, endpoints } from "../configs/Apis";


const Thongtintaikhoan = () => {

    const [user, dispatch, sinhvien, dispatchsv] = useContext(MyUserConText);
    const [loading, setLoading] = useState(false);
    const [pass, setPass] = useState(true);
    const [success, setSuccess] = useState(false);
    const avatar = useRef();


    const [taiKhoan, setTaiKhoan] = useState({
        "idTaiKhoan": user.idTaiKhoan,
        "tenTaiKhoan": user.tenTaiKhoan,
        "matKhau": user.matKhau,
        "chucVu": user.chucVu.tenloaitaikhoan,
    });

    const updateImage = (evt) => {
        evt.preventDefault();
        setPass(true);
        setSuccess(false);

        const process = async () => {
            let form = new FormData();

            for (let field in taiKhoan)

                form.append(field, taiKhoan[field]);

            form.append("avatar", avatar.current.files[0]);

            setLoading(true)
            let res = await AuthApis().post(endpoints['udateImage'], form);
        }
        if (avatar.current.files.length > 0) {
            process();
            setLoading(false);
            setSuccess(true);
        }
        else {
            setPass(false);
        }
    }

    return (

        <div class="contend">
            <nav class="navbar navbar-1 navbar-expand-sm navbar-dark nav-menu">
                <div class="container-fluid">
                    <a class="navbar-brand dark-color header-logo " href="#"><i class="fa-solid fa-bell icon-padding"></i></a>
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                        <ul class="navbar-nav">
                            <li class="nav-item user-name-img">
                                <a class="nav-link dark-color" href="#"><i class="fa-solid fa-user icon-padding" ></i></a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle dark-color" href="#" role="button" data-bs-toggle="dropdown">Chào,
                                    {sinhvien.hoTen}</a>
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
            <div class="info-user">
                <div class="info-title-user">
                    {user.image === null ? <p class="info-user-image"><i class="fa-solid fa-user icon-padding"></i></p> : <div class="info-user-image-2" ><img class="img-user-avatar" src={user.image} alt="Ảnh đại diện" /></div>}

                    <Form onSubmit={updateImage}>
                        <Form.Group className="mb-3">
                            <Form.Label>Ảnh đại diện</Form.Label>
                            <Form.Control type="file" ref={avatar} />
                        </Form.Group>
                        <div class="form-group">

                            {loading === true ? <MySpinner /> : <Button class="btn btn-danger mt-2" type="submit">Thêm Ảnh </Button>}
                        </div>
                        {pass === false ? <Alert variant="secondary">Vui lòng chọn ảnh</Alert> : <div></div>}
                        {success === true ? <Alert variant="secondary">Cập nhập ảnh thành công !!!</Alert> : <div></div>}
                    </Form>
                    <p class="info-private">Thông tin Cá Nhân</p>
                </div>
                <div class="info-user-text-reply">
                    <div class="info-user-texts">
                        <span class="info-user-text">Họ Tên:</span>
                        <span class="info-user-text2">{sinhvien.hoTen}</span>
                    </div >
                    <div class="info-user-texts">
                        <span class="info-user-text">Email</span>
                        <span class="info-user-text2">{sinhvien.email}</span>
                    </div>
                    <div class="info-user-texts">
                        <span class="info-user-text">Địa Chỉ</span>
                        <span class="info-user-text2">{sinhvien.diaChi}</span>
                    </div>
                    <div class="info-user-texts">
                        <span class="info-user-text">Số Điện Thoại</span>
                        <span class="info-user-text2">{sinhvien.soDienThoai}</span>
                    </div>
                    <div class="info-user-texts">
                        <span class="info-user-text">Khóa Học</span>
                        <span class="info-user-text2">2020-2024</span>
                    </div>
                    <div class="info-user-texts">
                        <span class="info-user-text">Hệ Đào Tạo</span>
                        <span class="info-user-text2">{sinhvien.heDaoTao}</span>
                    </div>
                    <div class="info-user-texts">
                        <span class="info-user-text">Lớp Học</span>
                        <span class="info-user-text2">{sinhvien.maLop.tenLopHoc}</span>
                    </div>
                </div>

            </div>
        </div>
    )
}
export default Thongtintaikhoan;