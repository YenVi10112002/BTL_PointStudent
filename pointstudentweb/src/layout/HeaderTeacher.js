import { Link } from "react-router-dom";
import { MyUserConText } from "../App";
import { useContext } from "react";

const HeaderTeacher = () => {
  const [user, dispatch] = useContext(MyUserConText);
  const logout = () => {
    dispatch({
      type: "logout",
    });
  };
  return (
    <>
      <div class="gv-vertical-menu">
        <div class="active gv-logo-menu">
          <a href="#">
            <i class="fa-solid fa-book-open "></i>
            Trường Đại Học Mở
          </a>
        </div>
        <div class="menu-items">
          <p class="text-menu ">Dịch Vụ, Tiện Ích</p>
          <Link class="menu-item" to="/giangvien/home">
            <i class="fa-solid fa-house gv-icon-padding"></i>Tổng Quan
          </Link>
          <a class="menu-item" href="#">
            <i class="fa-solid fa-message gv-icon-padding"></i>Diễn Đàn
          </a>
          <a class="menu-item" href="#">
            <i class="fa-solid fa-gift gv-icon-padding"></i>Danh Sách Môn
          </a>
          <a class="menu-item" href="#">
            <i class="fa-solid fa-gift gv-icon-padding"></i>Nhập Điểm
          </a>
        </div>
        <div class="menu-items">
          <p class="gv-text-menu">Thông Tin tài Khoản</p>
          <a class="menu-item" href="#">
            <i class="fa-solid fa-user gv-icon-padding"></i>Thông Tin Tài Khoản
          </a>
          <a class="menu-item" href="#">
            <i class="fa-solid fa-key gv-icon-padding"></i>Thay Đổi Mật Khẩu
          </a>
          <Link class="menu-item" onClick={logout}>
            <i class="fa-solid fa-right-to-bracket icon-padding"></i>Thoát Quyền
            Sử Dụng
          </Link>
        </div>
      </div>
    </>
  );
};
export default HeaderTeacher;
