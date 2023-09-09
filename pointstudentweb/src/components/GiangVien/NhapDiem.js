import { useCallback, useContext, useEffect, useRef, useState } from "react";
import { MyUserConText } from "../../App";
import { AuthApis, endpoints } from "../../configs/Apis";
import { Link, useNavigate, useSearchParams } from "react-router-dom";
import { Button, Form, Alert, Col, Row } from "react-bootstrap";
import MySpinner from "../../layout/MySpinner";
import PDFGenerator from "../../layout/PDFGenerator";

const CTMonHoc = () => {
    const [user, dispatch, giangvien, dispatchsv] = useContext(MyUserConText);
    const [DSSinhVien, setDSSinhVien] = useState([]);
    const [DSSinhVienCheck, setDSSinhVienCheck] = useState([]);
    const [q] = useSearchParams();
    const fileDiem = useRef();
    const [loading, setLoading] = useState(false);
    const [kw, setKw] = useState("");
    const [pass, setPass] = useState(true);
    const [chot, setChot] = useState(true);
    const [checkTB, setCheckTB] = useState(false);
    const [success, setSuccess] = useState();
    const [checkKhoaDiem, setCheckKhoaDiem] = useState(true);
    let monHocId = q.get("monHocId");
    let nav = useNavigate();
    const [diems, setsetDiems] = useState({
        "idMonHoc": ""
    });
    useEffect(() => {
        setChot(false)
        setSuccess(false)
       
        const loadSv = async () => {
            try {
                let e = endpoints['DSSinhVienByMonHoc'];
                monHocId = q.get("monHocId");
                let tenSinhVien = q.get("tenSinhVien");
                setsetDiems({
                    ...diems,
                    "idMonHoc": monHocId
                });

                //Loc điểm theo idMonHoc, Id SinhVien, tên Sinh Vien
                if (monHocId !== null) {
                    if (tenSinhVien !== null) {
                        e = `${e}?monHocId=${monHocId}&tenSinhVien=${tenSinhVien}`;
                        let res = await AuthApis().get(e);
                        setDSSinhVien(res.data);
                        setCheckKhoaDiem(false)
                    }
                    else {
                        e = `${e}?monHocId=${monHocId}`;
                        let res = await AuthApis().get(e);
                        setDSSinhVien(res.data);
                        const data = res.data;
                        const hasKhoaDiemZero = data.some(sinhvien => sinhvien.khoaDiem === 1);
                        
                        if(hasKhoaDiemZero){
                            setCheckKhoaDiem(false);
                        }

                        
                    }
                    //Kiểm tra xem các cột điểm đã khóa hay chưa
                    
                    
                }

            } catch (ex) {
                console.error(ex);
            }
            
            
        }

        loadSv();
        
        
        
    }, [q, chot, success]);


    ///tìm kiếm sinhvien
    const search = (evt) => {
        evt.preventDefault();
        nav(`/giangvien/nhapdiem?monHocId=${monHocId}&tenSinhVien=${kw}`)
    }

    ///update điểm bằng file csv
    const updateDiem = (evt) => {
        evt.preventDefault();
        setPass(true);
        // setSuccess(false);


        const process = async () => {
            let form = new FormData();

            for (let field in diems)
                form.append(field, diems[field]);

            form.append("file", fileDiem.current.files[0]);

            setLoading(true)
            let res = await AuthApis().post(endpoints['addListDiem'], form);
        }
        if (fileDiem.current.files.length > 0) {
            process();
            setLoading(false);
            setSuccess(true);
        }
        else {
            setPass(false);
        }
    }

    ///chốt điểm sinh viên
    const chotDiem = (evt) => {
        evt.preventDefault();
        setCheckTB(false);
        //kiểm tra xem điểm đã nhập chưa
        const check = async () => {
            try {
                let e = endpoints['DSSinhVienByMonHoc'];
                if (monHocId !== null) {
                    e = `${e}?idMonHoc=${monHocId}`;
                    let res = await AuthApis().get(e);
                    setDSSinhVienCheck(res.data);
                    for (let sinhvien in DSSinhVienCheck) {
                        if (sinhvien.diemTrungBinh === null) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (ex) {
                console.error(ex);
            }
        }

        const process = async () => {
            let e = endpoints['khoaDiem'];
            if (monHocId !== null) {

                e = `${e}?idMonHoc=${monHocId}`;
                let res = await AuthApis().post(e);
            }

        }
        const confirmed = window.confirm("Bạn có chắc muốn khóa điểm?");
        if (check && confirmed) {
            process();
            setChot(true);
        }
        else {
            setCheckTB(true);
        }

    }
    return (
        <>
            <div class="contend">
                <nav class="navbar navbar-1 navbar-expand-sm navbar-dark nav-menu">
                    <div class="container-fluid">
                        <a class="navbar-brand dark-color header-logo " href="#"><i class="fa-solid fa-bell icon-padding"></i></a>
                        <div class="collapse navbar-collapse" id="collapsibleNavbar">
                            <ul class="navbar-nav">
                                <li class="nav-item gv-Search-student">
                                    <Form onSubmit={search} className="d-flex align-items-center Search-student">
                                        <Form.Control
                                            type="text"
                                            value={kw}
                                            onChange={e => setKw(e.target.value)}
                                            placeholder="Nhập tên sinh viên"
                                            name="kw"
                                            className="mr-2"
                                        />
                                        <Button type="submit" className="btn-search-student">Tìm</Button>
                                    </Form>
                                </li>
                                <li class="nav-item gv-user-name-img ">
                                    {user.image === null ? <a class="nav-link dark-color" href="#"><i class="fa-solid fa-user icon-padding" ></i></a> : <div class="info-user-image-3" ><img class="img-user-avatar-header" src={user.image} alt="Ảnh đại diện" /></div>}
                                </li>

                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle dark-color" href="#" role="button" data-bs-toggle="dropdown">Chào,
                                        {giangvien.hoTen}</a>
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
                <div class=" point-ky">
                    <div class="container mt-3 " >
                        <p class="text-header-tong">Tổng Hợp Điểm Của Từng Học Kỳ</p>
                        <div >
                            <table class="table" id="table-to-pdf">
                                <thead>
                                    <tr>
                                        <th>Mã sinh viên</th>
                                        <th>Họ và tên</th>
                                        <th>Điểm KT 1</th>
                                        <th>Điểm KT 2</th>
                                        <th>Điểm JT 3</th>
                                        <th>Điểm Giữa Kỳ</th>
                                        <th>Điểm Cuối Kỳ</th>
                                        <th>Điểm Trung Bình</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    {DSSinhVien.map(sv => {
                                        let h = `/giangvien/nhapdiemsinhvien?idDiem=${sv.idDiem}&idMonHoc=${sv.idMonHoc.idMonHoc}`;
                                        return (
                                            <tr key={sv.idDiem}>
                                                <td>{sv.idSinhVien.idSinhVien}</td>
                                                <td>{sv.idSinhVien.hoTen}</td>
                                                {sv.diemKT1 === null ? <td>Chưa có</td> : <td>{sv.diemKT1}</td>}
                                                {sv.diemTK2 === null ? <td>Chưa có</td> : <td>{sv.diemTK2}</td>}
                                                {sv.diemTK2 === null ? <td>Chưa có</td> : <td>{sv.diemTK2}</td>}
                                                <td>{sv.diemGiuaKy}</td>
                                                <td>{sv.diemCuoiKy}</td>
                                                <td>{sv.diemTrungBình}</td>
                                                {sv.khoaDiem === 1 ? <div class="btn btn-secondary mt-2">Đã khóa</div> : <Link to={h} className="btn btn-secondary mt-2">Nhập Điểm</Link>}

                                            </tr>
                                        )
                                    })}

                                </tbody>
                            </table>
                            {DSSinhVien.length === 0 ? <Alert variant="secondary" className="mt-3">Không có sinh viên</Alert> : <></>}
                        </div>
                        {DSSinhVien.length !== 0 && checkKhoaDiem ? <><Link onClick={chotDiem} className="btn btn-secondary mt-2 mb-5 ">Chốt Điểm</Link><PDFGenerator data={DSSinhVien} /></> : <></>}
                        {checkTB === true ? <Alert variant="danger" className="mt-3">Thất bại do điểm chưa hoàn thành !!!</Alert> : <div></div>}
                        {DSSinhVien.length !== 0 && checkKhoaDiem ? <Form onSubmit={updateDiem}>
                            <Form.Group className="mb-3">
                                <Form.Label>Chọn File Điểm</Form.Label>
                                <Form.Control type="file" ref={fileDiem} />
                            </Form.Group>
                            <div class="form-group">
                                {loading === true ? <MySpinner /> : <Button class="btn btn-danger mt-2" type="submit">Thêm Điểm </Button>}
                                {success === true ? <Alert variant="secondary" className="mt-3">Cập nhập điểm thành công !!!</Alert> : <div></div>}
                                {pass === false ? <Alert variant="danger" className="mt-3">Vui lòng chọn file điểm</Alert> : <div></div>}
                            </div>
                        </Form> : <></>}
                    </div>
                </div>
            </div>
        </>
    );
};
export default CTMonHoc;
