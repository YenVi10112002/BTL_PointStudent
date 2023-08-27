import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Apis, { AuthApis, endpoints } from "../configs/Apis";
import { MyUserConText } from "../App";
import { useContext } from "react";
const DienDan = () => {
    const [user, dispatch] = useContext(MyUserConText);
    const [cauHois, setCauhois] = useState([]);
    useEffect(() => {
        const loadCauHoi = async () => {

            let res = await AuthApis().get(endpoints['cauHois']);

            setCauhois(res.data);
        }
        loadCauHoi();
    }, [])



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
                                    {user.hoTen}</a>
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
            <div class="content-diendan">
                <h3 >Diễn Đàng Trao Đổi</h3>
                <Link to="/themcauhoi" class="text-contend-link add-contend-question" id="themcauhoi">Thêm Chủ Đề</Link>
                {cauHois.map(c => {
                    let h = `/traloidiendan?cauhoiId=${c[1]}`;
                    return (<div class="content-question" key={c[1]}>
                        <h5><i class="fa-solid fa-user icon-padding"></i>{c[2]}</h5>
                        <p class="content-question-day"><i class="fa-solid fa-calendar-days icon-padding"></i>Ngày 25, tháng 7, năm 2023, 7:57AM</p>
                        <p class="content-question-noidung">{c[0]}</p>
                        <Link to={h} class="text-contend-link xemcautraloi"><i class="fa-solid fa-comment-dots icon-padding"></i>Xem Câu Trả Lời</Link>
                        <Link to={h} class="text-contend-link reply-text-link xemcautraloi"><i class="fa-solid fa-reply icon-padding"></i>Trả Lời</Link>
                    </div>)



                })}
            </div>

        </div>
    )
}
export default DienDan;