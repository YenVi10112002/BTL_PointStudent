import { useContext, useEffect, useState } from "react";
import { MyUserConText } from "../../App";
import { AuthApis, endpoints } from "../../configs/Apis";
import { useSearchParams } from "react-router-dom";
import { Alert } from "react-bootstrap";
import Header from "../../layout/giangVien/Header";

const TimSinhVien = () => {
    const [user, dispatch, giangvien, dispatchsv] = useContext(MyUserConText);
    const [DSSinhVien, setDSSinhVien] = useState([]);
    const [q] = useSearchParams();
    useEffect(() => {
        const loadSv = async () => {
            try {
                let e = endpoints['getSinhVienByIdOrTen'];
                let idGiangVien = q.get("idGiangVien");
                let tenSinhVien = q.get("tenSinhVien");
                if (idGiangVien !== null) {
                    if (tenSinhVien !== null) {
                        e = `${e}?idGiangVien=${idGiangVien}&tenSinhVien=${tenSinhVien}`;
                        let res = await AuthApis().post(e);
                        setDSSinhVien(res.data);
                    }
                    else {
                        e = `${e}?idGiangVien=${idGiangVien}`;
                        let res = await AuthApis().post(e);
                        setDSSinhVien(res.data);
                    }
                }
            } catch (ex) {
                console.error(ex);
            }

        }
        loadSv();
    }, [q]);

return (
    <>
        <div class="contend">

            <Header />
            <div class=" point-ky">
                <div class="container mt-3 " >
                    <p class="text-header-tong">Danh Sách Sinh Viên Của Bạn</p>
                    <div >
                        <table class="table" >
                            <thead>
                                <tr>
                                    <th>Mã sinh viên</th>
                                    <th>Họ và tên</th>
                                    <th>Môn Học</th>
                                    <th>Mã Môn Học</th>
                                    <th>Điểm KT 1</th>
                                    <th>Điểm KT 2</th>
                                    <th>Điểm KT 3</th>
                                    <th>Điểm Giữa Kỳ</th>
                                    <th>Điểm Cuối Kỳ</th>

                                </tr>
                            </thead>
                            <tbody>
                                {DSSinhVien.map(sv => {
                                    return (
                                        <tr key={sv.idDiem}>
                                            <td>{sv.idSinhVien.idSinhVien}</td>
                                            <td>{sv.idSinhVien.hoTen}</td>
                                            <td>{sv.idMonHoc.tenMonHoc}</td>
                                            <td>{sv.idMonHoc.idMonHoc}</td>
                                            {sv.diemKT1 === null ? <td>Chưa có</td> : <td>{sv.diemKT1}</td>}
                                            {sv.diemTK2 === null ? <td>Chưa có</td> : <td>{sv.diemTK2}</td>}
                                            {sv.diemTK2 === null ? <td>Chưa có</td> : <td>{sv.diemTK2}</td>}
                                            <td>{sv.diemGiuaKy}</td>
                                            <td>{sv.diemCuoiKy}</td>
                                        </tr>
                                    )
                                })}

                            </tbody>
                        </table>
                        {DSSinhVien.length === 0 ? <Alert variant="secondary" className="mt-3">Không có sinh viên</Alert> : <></>}
                    </div>


                </div>
            </div>
        </div>
    </>
);
};
export default TimSinhVien;
