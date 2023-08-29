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
import HeaderTeacher from "./layout/HeaderTeacher";

export const MyUserConText = createContext();

function App() {
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);
  if (user !== null) {
    return (
      <MyUserConText.Provider value={[user, dispatch]}>
        <BrowserRouter>
          <HeaderTeacher />
          <Routes>
            <Route path="/giangvien/home" element={<HomeGV />} />
            {/* <Route path="/Home" element={<Home />} />
            <Route path="/diendan" element={<DienDan />} />
            <Route path="/traloidiendan" element={<TraLoiDienDan />} />
            <Route path="/themcauhoi" element={<Themchude />} />
            <Route path="/xemdiem" element={<XemDiem />} /> */}
          </Routes>
        </BrowserRouter>
      </MyUserConText.Provider>
    );
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
