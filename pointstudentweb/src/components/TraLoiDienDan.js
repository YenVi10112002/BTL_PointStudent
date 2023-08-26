import { useEffect, useState } from "react";
import { Button, Form } from "react-bootstrap";
import { Link, useSearchParams } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";

const TraLoiDienDan = () => {
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
                let res = await Apis.get(e);

                setCauTraLoi(res.data);
            } catch (ex) {
                console.error(ex);
            }

        }
        const loadcauhoi = async () => {
            let ch = endpoints['cauhoi']
            let cauhoiid = q.get("cauhoiId");
            if (cauhoiid != null) {
                ch = `${ch}?cauhoiId=${cauhoiid}`;
            }
            let res = await Apis.get(ch);

            setcauhoi(res.data);
        }
        loadcautraloi();
        loadcauhoi();
    }, [q])



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
                                    Phạm Hoàng Ân</a>
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
                    <div key={cauhoi[1]}>
                        <h5><i class="fa-solid fa-user icon-padding"></i>{cauhoi[2]}</h5>
                        <p class="content-question-day"><i class="fa-solid fa-calendar-days icon-padding"></i>Ngày 25, tháng 7,
                            năm 2023, 7:57AM</p>
                        <p class="content-question-noidung">{cauhoi[0]}</p>
                    </div>

                    <Form>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Control type="text" placeholder="Trả Lời.... " />
                        </Form.Group>
                        <Form.Group className="mb-3">
                            <Button className="btn-traloi-diendan"><i class="fa-solid fa-reply icon-padding"></i>Trả Lời</Button>
                        </Form.Group>
                    </Form>
                    <Link to="/diendan" class="close-traloi-diendan ">Đóng</Link>


                    {cautraloi.map(c => {
                        if ( c === null) {
                            return (
                                <div class="traloi-diendan-user" key={c[1]}>
                                    <p class="content-question-noidung">Chưa có câu trả lời !!!</p>
                                </div>
                            );
                        }
                        return (
                            <div class="traloi-diendan-user" key={c[1]}>
                                <h5 class="user-traloi-diendan-name"><i class="fa-solid fa-user icon-padding"></i>{c[2]}</h5>
                                <p class="content-question-noidung">{c[0]}</p>
                            </div>
                        );
                    })}

                </div>
            </div>

        </div>
    )
}
export default TraLoiDienDan;