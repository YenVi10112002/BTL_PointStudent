import { useContext } from "react";
import { MyUserConText } from "../../App";

const ThongTinTaiKhoanGV = () => {
    const [user, dispatch, giangvien, dispatchsv] = useContext(MyUserConText);
return (
<>
    <div class="gv-contend">
        <nav class="navbar navbar-expand-sm navbar-dark">
            <div class="container-fluid">
                <a class="navbar-brand gv-dark-color gv-header-logo " href="#">
                    <i class="fa-solid fa-bell gv-icon-padding"></i>
                </a>
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav">
                        <li class="nav-item gv-user-name-img">
                            <a class="nav-link " href="#">
                                <i class="fa-solid fa-user gv-icon-padding"></i>
                            </a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle gv-dark-color" href="#" role="button"
                                data-bs-toggle="dropdown">
                                Chào, {giangvien.hoTen}
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a class="dropdown-item gv-dark-color " href="#">
                                        <i class="fa-solid fa-user gv-icon-padding"></i>Thông
                                        Tin Tài Khoản
                                    </a>
                                </li>
                                <li>
                                    <a class="dropdown-item gv-dark-color" href="#">
                                        <i class="fa-solid fa-key gv-icon-padding"></i>Thay Đổi
                                        Mật Khẩu
                                    </a>
                                </li>
                                <li>
                                    <a class="dropdown-item gv-dark-color" href="#">
                                        <i class="fa-solid fa-right-to-bracket gv-icon-padding"></i>
                                        Đăng Xuất
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="gv-info-user">
            <div class="gv-info-title-user">
                <p class="gv-info-private">Thông tin Cá Nhân</p>
            </div>
            <div class="gv-info-user-text-reply">
                <div class="gv-info-user-texts">
                    <span class="gv-info-user-text">Họ Tên:</span>
                    <span class="gv-info-user-text2">{giangvien.hoTen}</span>
                </div>
                <div class="gv-info-user-texts">
                    <span class="gv-info-user-text">Email</span>
                    <span class="gv-info-user-text2">{giangvien.email}</span>
                </div>
                <div class="gv-info-user-texts">
                    <span class="gv-info-user-text">Địa Chỉ</span>
                    <span class="gv-info-user-text2">{giangvien.diaChi}</span>
                </div>
                <div class="gv-info-user-texts">
                    <span class="gv-info-user-text">Số Điện Thoại</span>
                    <span class="gv-info-user-text2">{giangvien.soDienThoai}</span>
                </div>
                <div class="gv-info-user-texts">
                    <span class="gv-info-user-text">Khóa Học</span>
                    <span class="gv-info-user-text2">2020-2024</span>
                </div>
            </div>
        </div>
    </div>
</>
);
};
export default ThongTinTaiKhoanGV;