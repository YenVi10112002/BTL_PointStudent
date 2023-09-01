import { BrowserRouter, Route, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import Login from "./components/Login";
import Signup from "./components/Signup";
import "./resources/css/student.css";
import "./resources/css/access.css";
import "./resources/css/teacher.css";
import Home from "./components/Home";
import HeaderStudent from "./layout/HeaderStudent";
import DienDan from "./components/DienDan";
import TraLoiDienDan from "./components/TraLoiDienDan";
import Themchude from "./components/ThemChuDe";
import Header from "./layout/header";
import Footer from "./layout/Footer";
import { createContext, useReducer } from "react";
import MyUserReducer from "./reducers/MyUserReducer";
import cookie from "react-cookies";
import XemDiem from "./components/XemDiem";
import HomeGV from "./components/GiangVien/HomeGV";
import NhapDiem from "./components/GiangVien/NhapDiem";
import HeaderTeacher from "./layout/HeaderTeacher";
import ThayDoiMatKhau from "./components/ThayDoiMatKhau";
import Thongtintaikhoan from "./components/ThongTinTaiKhoan";
import DienDanGV from "./components/GiangVien/DienDanGV";
import ThemChuDeGV from "./components/GiangVien/ThemChuDeGV";
import TraLoiDienDanGV from "./components/GiangVien/TraLoiDienDanGV";
import ThayDoiMatKhauGV from "./components/GiangVien/ThayDoiMatKhauGV";
import ThongTinTaiKhoanGV from "./components/GiangVien/ThongTinTaiKhoaGV";

export const MyUserConText = createContext();

function App() {


  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);
  const [sinhvien, dispatchsv] = useReducer(MyUserReducer, cookie.load("sinhvien") || null);
  const [giangvien, dispatchgv] = useReducer(MyUserReducer, cookie.load("giangvien") || null);
  if (user !== null) {
    if (user.chucVu.tenloaitaikhoan === "ROLE_SV") {
      return (
        <MyUserConText.Provider value={[user, dispatch, sinhvien, dispatchsv]}>
          <BrowserRouter>
            <HeaderStudent />
            <Routes>
              <Route path="/home" element={<Home />} />
              <Route path="/diendan" element={<DienDan />} />
              <Route path="/traloidiendan" element={<TraLoiDienDan />} />
              <Route path="/themcauhoi" element={<Themchude />} />
              <Route path="/xemdiem" element={<XemDiem />} />
              <Route path="/thaydoimatkhau" element={<ThayDoiMatKhau />} />
              <Route path="/thongtin" element={<Thongtintaikhoan/>} />
            </Routes>
          </BrowserRouter>
        </MyUserConText.Provider>
      );
    }
    else {
      return (
        <MyUserConText.Provider value={[user, dispatch, giangvien, dispatchgv]}>
          <BrowserRouter>
            <HeaderTeacher />
            <Routes>
              <Route path="/giangvien/home" element={<HomeGV />} />
              <Route path="/giangvien/nhapdiem" element={<NhapDiem />} />
              <Route path="/giangvien/diendan" element={<DienDanGV />} />
              <Route path="/giangvien/themchude" element={<ThemChuDeGV />} />
              <Route path="/giangvien/traloidiendan" element={<TraLoiDienDanGV />} />
              <Route path="/giangvien/thaydoimatkhau" element={<ThayDoiMatKhauGV />} />
              <Route path="/giangvien/thongtintaikhoan"element={<ThongTinTaiKhoanGV />}/>
            </Routes>
          </BrowserRouter>
        </MyUserConText.Provider>
      )

    }

  } else {
    return (
      <MyUserConText.Provider value={[user, dispatch]}>
        <BrowserRouter>
          <Header />
          <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/signup" element={<Signup />} />
          </Routes>
          <Footer />
        </BrowserRouter>
      </MyUserConText.Provider>
    );
  }
}
export default App;
