import { useEffect, useState } from "react";
import { Button, Form, Alert } from "react-bootstrap";
import { Link, useSearchParams } from "react-router-dom";
import Apis, { AuthApis, endpoints } from "../configs/Apis";
import { MyUserConText } from "../App";
import { useContext } from "react";

const TraLoiDienDan = () => {
    const [user, dispatch, sinhvien, dispatchsv] = useContext(MyUserConText);
    const [changeSuccess, setChangeSuccess] = useState(false);
    const [noiDung, setNoiDung] = useState();
    const [cautraloi, setCauTraLoi] = useState([]);
    const [cauhoi, setcauhoi] = useState([]);
    const [q] = useSearchParams();
    useEffect(() => {
        const loadcautraloi = async () => {
            try {
                let e = endpoints['cauTraLoi'];
                let cauhoiid = q.get("cauhoiId");
                if (cauhoiid != null) {
                    e = `${e}?cauhoiId=${cauhoiid}`;
                }
                let res = await AuthApis().get(e);

                setCauTraLoi(res.data);
            } catch (ex) {
                console.error(ex);
            }

        }
        const loadcauhoi = async () => {
            let ch = endpoints['cauhoi'];
            let cauhoiid = q.get("cauhoiId");
            if (cauhoiid != null) {
                ch = `${ch}?cauhoiId=${cauhoiid}`;
            }
            let res = await AuthApis().get(ch);

            setcauhoi(res.data);
        }
        loadcautraloi();
        loadcauhoi();
    }, [q], setChangeSuccess)

    const addTraLoi = (evt) => {
        evt.preventDefault();
        const process = async () => {
            try {
                let cauHoiId = q.get("cauhoiId");
                let res = await AuthApis().post(endpoints['themTraLoi'], {
                    "noiDungTraLoi": noiDung,
                    "idTaiKhoan": user.idTaiKhoan,
                    "idCauHoiDienDan": cauHoiId
                })
            } catch (ex) {
                console.error(ex);
            }
            setNoiDung("");
        }
        process();

        setChangeSuccess(true);

    };

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
            <div class="traloi-diendan-none">
                <div class="form-traloi-diendan">
                    <div key={cauhoi.idCauHoiDienDan}>
                        <h5><i class="fa-solid fa-user icon-padding"></i></h5>
                        <p class="content-question-day"><i class="fa-solid fa-calendar-days icon-padding"></i>Ngày 25, tháng 7,
                            năm 2023, 7:57AM</p>
                        <p class="content-question-noidung">{cauhoi.noiDungCauHoi}</p>
                    </div>

                    <Form onSubmit={addTraLoi}>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Control type="text" value={noiDung}
                                onChange={(e) => setNoiDung(e.target.value)} placeholder="Trả Lời.... " required />
                        </Form.Group>
                        <Form.Group className="mb-3">
                            <Button className="btn-traloi-diendan" type="submit"><i class="fa-solid fa-reply icon-padding"></i>Trả Lời</Button>
                        </Form.Group>
                        {changeSuccess === true ? <Alert variant="secondary">Trả Lời Thành Công </Alert> : <div></div>}
                    </Form>
                    <Link to="/diendan" class="close-traloi-diendan ">Đóng</Link>

                    {cautraloi.length === 0 ? <div class="traloi-diendan-user">
                        <p class="content-question-noidung">Chưa có câu trả lời !!!</p>
                    </div>: <></>}
                    {cautraloi.map(c => {   
                        return (
                            <div class="traloi-diendan-user" key={c.idTraLoiDienDan}>
                                <h5 class="user-traloi-diendan-name"><i class="fa-solid fa-user icon-padding"></i>{c.idTaiKhoan.tenTaiKhoan}</h5>
                                <p class="content-question-noidung">{c.noiDungTraLoi}</p>
                            </div>
                        );
                    })}

                </div>
            </div>

        </div>
    )
}
export default TraLoiDienDan;