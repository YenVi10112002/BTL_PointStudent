import axios from "axios";
import cookie from "react-cookies";
const SERVER_CONTEXT = "/QLDiemSinhVien";

export const endpoints = {
    "cauHois": `${SERVER_CONTEXT}/api/cauhoi/`,
    "cauTraLoi": `${SERVER_CONTEXT}/api/traloi/`,
    "cauhoi": `${SERVER_CONTEXT}/api/cauhoiid/`,
    "login": `${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`,
    "DSDiemTrungBinhHocKy":`${SERVER_CONTEXT}/api/DSDiemSVHocKy/`,
    "DiemTrungBinhHe10":`${SERVER_CONTEXT}/api/TrungBinhDiem/`,
    "DiemTrungBinhHe4":`${SERVER_CONTEXT}/api/TrungBinhDiemHe4/`,
    "DSDiem":`${SERVER_CONTEXT}/api/DanhSachDiem/`,
    "DSMonHocById":`${SERVER_CONTEXT}/api/monhocsinhvien/`,
    "signup":`${SERVER_CONTEXT}/api/users/`,
    "changePassword":`${SERVER_CONTEXT}/api/change-password/`,
    "current-sinhvien":`${SERVER_CONTEXT}/api/current-sinhvien/`,
    "current-giangvien":`${SERVER_CONTEXT}/api/current-user-gv/`,
    "themCauHoi":`${SERVER_CONTEXT}/api/add-cauhoi/`,
    "themTraLoi":`${SERVER_CONTEXT}/api/add-traloi/`,
    "udateImage":`${SERVER_CONTEXT}/api/change-avt/`,
    "deleteCauHoi":`${SERVER_CONTEXT}/api/delete-cauhoi/`,
    "monHocIdTK":`${SERVER_CONTEXT}/api/monhocgiangvien/`,
    "DSSinhVienByMonHoc":`${SERVER_CONTEXT}/api/monhocsinhvien/`,
}

export const AuthApis = () => {
    return axios.create({
        baseURL: "http://localhost:8086",
        headers: {
            "Authorization": cookie.load("token")
        }
    })
}

export default axios.create({
    baseURL: "http://localhost:8086"
})