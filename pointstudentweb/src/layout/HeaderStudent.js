import { Link } from "react-router-dom";
import { MyUserConText } from "../App";
import { useContext } from "react";




const HeaderStudent = () => {
    const [user, dispatch] = useContext(MyUserConText);
    const logout = () => {
        dispatch({
            "type": "logout"
        });
    }
    return (
        <div class="vertical-menu">
            <div class="active logo-menu">
                <Link to="/home"><i class="fa-solid fa-book-open " ></i>Trường Đại Học Mở</Link>
            </div>
            <div class="menu-items">
                <p class="text-menu ">Dịch Vụ, Tiện Ích</p>
                <Link to="/home" class="menu-item"><i class="fa-solid fa-house icon-padding"></i>Tổng Quan</Link>
                <Link class="menu-item" to="/diendan"><i class="fa-solid fa-message icon-padding"></i>Diễn Đàn</Link>
                <Link class="menu-item" to="/xemdiem"><i class="fa-solid fa-gift icon-padding"></i>Xem Điểm</Link>
            </div>
            <div class="menu-items">
                <p class="text-menu">Thông Tin tài Khoản</p>
                <Link class="menu-item" to="/thongtin"><i class="fa-solid fa-user icon-padding"></i>Thông Tin Tài Khoản</Link>
                <Link class="menu-item" to="/thaydoimatkhau"><i class="fa-solid fa-key icon-padding"></i>Thay Đổi Mật Khẩu</Link>
                <Link class="menu-item" onClick={logout} to="/"><i class="fa-solid fa-right-to-bracket icon-padding"></i>Thoát Quyền Sử Dụng</Link>
            </div>
        </div>    
    )
}
export default HeaderStudent;