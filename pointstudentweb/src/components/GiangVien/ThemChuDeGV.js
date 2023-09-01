import { useState, useContext, useEffect } from "react";
import { Button, Form } from "react-bootstrap";
import { Link, useNavigate, useSearchParams } from "react-router-dom";
import { MyUserConText } from "../../App";
import { AuthApis, endpoints } from "../../configs/Apis";
const ThemChuDeGV = () => {
    const [user, dispatch, sinhvien, dispatchsv] = useContext(MyUserConText);
    const [noiDung, setNoiDung] = useState();
    const [cauhoi, setcauhoi] = useState([]);
    let nav = useNavigate();
    const [q] = useSearchParams();

    let cauhoiid = q.get("cauhoiId");
    useEffect(() => {
        
        const loadcauhoi = async () => {
            let ch = endpoints['cauhoi']
            let cauhoiid = q.get("cauhoiId");
            if (cauhoiid != null) {
                ch = `${ch}?cauhoiId=${cauhoiid}`;
            }
            let res = await AuthApis().get(ch);
            setcauhoi(res.data);
        
        }
        loadcauhoi();
    }, [q])


    const addCauHoi = (evt) => {
        evt.preventDefault();
        const process = async () => {
            try {
                let cauhoiid = q.get("cauhoiId");
                let res = await AuthApis().post(endpoints['themCauHoi'], {
                    "noiDungCauHoi": noiDung,
                    "idTaiKhoan": user.idTaiKhoan,
                    "idCauHoiDienDan": cauhoiid
                })
            } catch (ex) {
                console.error(ex);
            }
        }
        process();
        
        nav("/giangvien/diendan");
    };

    return (
        <div class="traloi-diendan-none" id="container2">
            <Form className="mt-5 mb-5" onSubmit={addCauHoi}>
                <div class="form-themcauhoi-diendan">
                    <Link to="/giangvien/diendan" className="close-traloi-diendan ">Đóng</Link>
                    <h5><i class="fa-solid fa-user icon-padding mb-3"></i>Thêm Câu Hỏi Diễn Đàn</h5>
                    <p class="content-question-day"><i class="fa-solid fa-calendar-days icon-padding"></i>Diễn đàn trao đổi của sinh viên và giảng viên </p>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Nhập nội dung câu hỏi</Form.Label>
                        <Form.Control className="form-control me-2" type="text" value={noiDung}
                            onChange={(e) => setNoiDung(e.target.value)} placeholder="Câu hỏi....." required/>
                    </Form.Group>
                   
                    {cauhoiid === null ?  <Button className="btn-traloi-diendan mt-3" type="submit"><i class="fa-solid fa-reply icon-padding"></i>Thêm Câu Hỏi</Button>:<Button className="btn-traloi-diendan mt-3" type="submit"><i class="fa-solid fa-reply icon-padding"></i>Chỉnh Sửa</Button>}
                </div>
            </Form>
        </div>
    )
}
export default ThemChuDeGV;