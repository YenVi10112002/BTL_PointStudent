import { MyUserConText } from "../App";
import { useContext, useEffect, useState } from "react";
import { AuthApis, endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";


const XemDiem = () => {
    const [user, dispatch] = useContext(MyUserConText);
    const [DSDiem, setDSDiem] = useState([], null);
    const [Diem, setDiem] = useState([], null);
    const [DiemHe4, setDiemHe4] = useState([]);
    useEffect(() => {
        const loadloadDSDiem = async () => {
            try {
                let e = endpoints['DSDiem'];
                let a = endpoints['DiemTrungBinhHe10'];
                let b = endpoints['DiemTrungBinhHe4'];
                e = `${e}?SinhVienId=${user.idSinhVien}`;
                a = `${a}?SinhVienId=${user.idSinhVien}`;
                b = `${b}?SinhVienId=${user.idSinhVien}`;
                let res1 = await AuthApis().get(e);
                let res2 = await AuthApis().get(a);
                let res3 = await AuthApis().get(b);
                setDSDiem(res1.data);
                setDiem(res2.data);
                setDiemHe4(res3.data);
            } catch (ex) {
                console.error(ex);
            }

        }
        loadloadDSDiem();
    }, []);

    
    return (
        <><div class="contend">
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
            <div class="point">
                <h4>Tổng quan</h4>
                <h6 class="text-header-tong">Tổng Hợp Nhanh Các Thông Tin </h6>
                <div class="container mt-3">
                    <h2 class="name-text">Phạm Hoàng Ân</h2>
                    <p class="text-header-tong">Tổng Hợp Điểm & Xếp Loại Học Tập</p>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Điểm Hệ 10</th>
                                <th>Điểm Hệ 4</th>
                                <th>Xếp Loại</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>{Diem}</td>
                                <td>{DiemHe4}</td>
                                <td>Giỏi</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div><div class=" point-ky">
                <div class="container mt-3">
                    <p class="text-header-tong">Tổng Hợp Điểm Của Từng Học Kỳ</p>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Học Kỳ</th>
                                <th>Môn Học</th>
                                <th>Điểm Giữa Kì</th>
                                <th>Điểm Cuối Kỳ</th>
                                <th>Điểm Trung Bình</th>
                                <th>Điểm Hệ 4</th>
                                <th>Tình Trạng</th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            {DSDiem.map(c => {
                                return (<tr>
                                    <td>{c[5]}</td>
                                    <td>{c[4]}</td>
                                    <td>{c[2]}</td>
                                    <td>{c[1]}</td>
                                    <td>{c[0]}</td>
                                    <td>{c[6]}</td>
                                    <td>{c[3] === 1 ? 'Đậu' : 'Rớt'}</td>
                                </tr>
                                )
                            })
                            }


                        </tbody>
                    </table>
                </div>
            </div>
        </div></>
    )
}
export default XemDiem;