import { useEffect, useState } from "react";
import { Link, useSearchParams, useNavigate } from "react-router-dom";
import { AuthApis, endpoints } from "../configs/Apis";
import { MyUserConText } from "../App";
import { useContext } from "react";
import MySpinner from "../layout/MySpinner";
const DienDan = () => {
    const [user, dispatch, sinhvien, dispatchsv] = useContext(MyUserConText);
    const [cauHois, setCauhois] = useState([]);
    let nav = useNavigate();
    const [q] = useSearchParams();
    let cauhoiid = q.get("cauhoiId");
    useEffect(() => {
        const loadCauHoi = async () => {

            let res = await AuthApis().get(endpoints['cauHois']);

            setCauhois(res.data);
        }

        const process = async () => {
            try {
                if (cauhoiid !== null) {
                    const confirmed = window.confirm("Are you sure you want to delete this question?");
                    if (confirmed) {

                        let ch = endpoints['deleteCauHoi'];

                        ch = `${ch}?idCauHoiDienDan=${cauhoiid}`;

                        let res = await AuthApis().delete(ch);
                        if (res.status === 200) {
                            nav("/diendan");
                        }
                    }
                }

            } catch (ex) {
                console.error(ex);
            }

        }
        process();
        loadCauHoi();
    }, [q])

    if (cauHois === null) {
        return <MySpinner />
    }

    const currentDate = new Date();
    const day = currentDate.getDate();
    const month = currentDate.getMonth() + 1; // Tháng bắt đầu từ 0, cộng thêm 1 để hiển thị đúng tháng
    const year = currentDate.getFullYear();
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
            <div class="content-diendan">
                <h3 >Diễn Đàng Trao Đổi</h3>
                <p>Ngày hiện tại: {day}/{month}/{year}</p>
                <Link to="/themcauhoi" class="text-contend-link add-contend-question" id="themcauhoi">Thêm Chủ Đề</Link>
                {cauHois.map(c => {
                    let h = `/traloidiendan?cauhoiId=${c.idCauHoiDienDan}`;
                    let k = `/themcauhoi?cauhoiId=${c.idCauHoiDienDan}`;
                    let a = `/diendan?cauhoiId=${c.idCauHoiDienDan}`;
                    return (<div class="content-question" key={c.idCauHoiDienDan}>
                        <h5><i class="fa-solid fa-user icon-padding"></i>{c.idTaiKhoan.tenTaiKhoan}</h5>
                        <p class="content-question-day"><i class="fa-solid fa-calendar-days icon-padding"></i>Ngày 25, tháng 7, năm 2023, 7:57AM</p>
                        <p class="content-question-noidung">{c.noiDungCauHoi}</p>

                        <Link to={h} class="text-contend-link"><i class="fa-solid fa-comment-dots icon-padding"></i>Xem Câu Trả Lời</Link>
                        {user.idTaiKhoan === c.idTaiKhoan.idTaiKhoan ? <Link to={k} class="text-contend-link update-text-diendan"><i class="fa-solid fa-pen-to-square icon-padding"></i>Chỉnh Sửa</Link> : null}
                        {user.idTaiKhoan === c.idTaiKhoan.idTaiKhoan  ? <Link to={a} class="text-contend-link update-text-diendan"><i class="fa-solid fa-trash icon-padding"></i>Xóa</Link> : null}
                        <Link to={h} class="text-contend-link update-text-diendan"><i class="fa-solid fa-reply icon-padding"></i>Trả Lời</Link>

                    </div>)

                })}
            </div>
        </div>
    )
}
export default DienDan;