import axios from "axios";
import cookie from "react-cookies";
const SERVER_CONTEXT = "/QLDiemSinhVien"

export const endpoints = {
    "cauHois": `${SERVER_CONTEXT}/api/cauhoi/`,
    "cauTraLoi": `${SERVER_CONTEXT}/api/traloi/`,
    "cauhoi": `${SERVER_CONTEXT}/api/cauhoiid/`,
    "login": `${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`
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