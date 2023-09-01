import { useContext, useEffect, useState } from "react";
import { MyUserConText } from "../../App";
import { AuthApis, endpoints } from "../../configs/Apis";
import { useSearchParams } from "react-router-dom";

const CTMonHoc = () => {
    const [user, dispatch, giangvien, dispatchsv] = useContext(MyUserConText);
    const [DSSinhVien, setDSSinhVien] = useState([]);
    const [q] = useSearchParams();
    useEffect(() => {
        const loadSv = async () => {
            try {
                let e = endpoints['DSSinhVienByMonHoc'];
                let monHocId = q.get("monHocId");
                if (monHocId !== null) {
                    e = `${e}?monHocId=${monHocId}`;
                }
                let res = await AuthApis().get(e);

                setDSSinhVien(res.data);
            } catch (ex) {
                console.error(ex);
            }

        }
        loadSv();
    }, [q]);
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
                                <li class="nav-item gv-Search-student">
                                    <form class="d-flex">
                                        <input
                                            class="form-control me-2"
                                            type="text"
                                            placeholder="Tìm Sinh Viên..."
                                        />
                                        <button class="gv-btn-search-student" type="button">
                                            Search
                                        </button>
                                    </form>
                                </li>
                                <li class="nav-item gv-user-name-img">
                                    <a class="nav-link " href="#">
                                        <i class="fa-solid fa-user gv-icon-padding"></i>
                                    </a>
                                </li>

                                <li class="nav-item dropdown">
                                    <a
                                        class="nav-link dropdown-toggle gv-dark-color"
                                        href="#"
                                        role="button"
                                        data-bs-toggle="dropdown"
                                    >
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
                <div class=" point-ky">
                    <div class="container mt-3">
                        <p class="text-header-tong">Tổng Hợp Điểm Của Từng Học Kỳ</p>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Mã số sinh viên</th>
                                    <th>Họ và tên</th>
                                    <th>Giới tính</th>
                                </tr>
                            </thead>
                            <tbody>
                                {DSSinhVien.map(sv => {
                                    return (
                                        <tr>
                                            <td>{sv.idSinhVien}</td>
                                            <td>{sv.hoTen}</td>
                                            <td>{sv.gioiTinh === 1 ? 'Nam' : 'Nữ'}</td>
                                        </tr>
                                    )
                                })}
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </>
    );
};
export default CTMonHoc;
