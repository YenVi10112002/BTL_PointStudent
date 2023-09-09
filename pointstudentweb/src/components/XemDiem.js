import { MyUserConText } from "../App";
import { useContext, useEffect, useState } from "react";
import { AuthApis, endpoints } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";
import HeaderSV from "../layout/sinhvien/HeaderSV"


const XemDiem = () => {
    const [user, dispatch, sinhvien, dispatch2] = useContext(MyUserConText);
    const [DSDiem, setDSDiem] = useState([], null);
    const [Diem, setDiem] = useState([], null);
    const [DiemHe4, setDiemHe4] = useState([]);
    useEffect(() => {
        const loadloadDSDiem = async () => {
            try {
                let e = endpoints['DSDiem'];
                let a = endpoints['DiemTrungBinhHe10'];
                let b = endpoints['DiemTrungBinhHe4'];
                e = `${e}?SinhVienId=${sinhvien.idSinhVien}`;
                a = `${a}?SinhVienId=${sinhvien.idSinhVien}`;
                b = `${b}?SinhVienId=${sinhvien.idSinhVien}`;
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
            <HeaderSV />
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
                                <td>
                                    {(() => {
                                        switch (true) {
                                            case Diem >= 8.5:
                                                return 'Giỏi';
                                            case Diem >= 7:
                                                return 'Khá';
                                            case Diem >= 5:
                                                return 'Trung bình';
                                            default:
                                                return 'Yếu';
                                        }
                                    })()}
                                </td>
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
                                return (<tr key={c[5]}>
                                    <td>{c[5]}</td>
                                    <td>{c[4]}</td>
                                    <td>{c[1]}</td>
                                    <td>{c[2]}</td>
                                    <td>{parseFloat(c[0]).toFixed(2)}</td>
                                    <td>{parseFloat(c[6]).toFixed(2)}</td>
                                    {c[7] === 1 ? <>
                                        <td>{c[3] === 1 ? 'Đậu' : 'Rớt'}</td></> : <>
                                        <td>Chưa khóa</td></>}

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