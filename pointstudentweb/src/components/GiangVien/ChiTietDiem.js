import { useContext, useState } from "react";
import { Button, Form } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";
import { MyUserConText } from "../../App";
import { AuthApis, endpoints } from "../../configs/Apis";

const ChiTietDiem = () => {
    const[user] = useContext(MyUserConText);
    const[diemCuoiKy, setDiemCuoiKy] = useState()
    const[diemGiuaKy, setDiemGiuaKy] = useState()
    const[diemTK1, setDiemTK1] = useState()
    const[diemTK2, setDiemTK2] = useState()
    const[diemTK3, setDiemTK3] = useState()
    let nav = useNavigate();

    const addDiem = (evt) =>{
        evt.preventDefault();
        const process = async () => {
            try {
                let res = await AuthApis().post(endpoints['themdiem'], {
                    
                    "diemCuoiKy": diemCuoiKy,
                    "diemGiuaKy": diemGiuaKy,
                    "diemTK1": diemTK1,
                    "diemTK2": diemTK2,
                    "diemTK3": diemTK3
                })
            } catch (ex) {
                console.error(ex);
            }
            nav("/giangvien/nhapdiem");
        }
        process();
        
    }
    return (
        <div class="traloi-diendan-none" id="container2">
            <Form className="mt-5 mb-5" onSubmit={addDiem}>
                <div class="form-themcauhoi-diendan">
                    <Link to="/giangvien/nhapdiem" className="close-traloi-diendan ">Đóng</Link>
                    <h5><i class="fa-solid fa-user icon-padding mb-3"></i>Thêm Câu Hỏi Diễn Đàn</h5>
                    <p class="content-question-day"><i class="fa-solid fa-calendar-days icon-padding"></i>Diễn đàn trao đổi của sinh viên và giảng viên </p>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label htmlFor="diemCK">Nhập điểm cuối ký</Form.Label>
                        <Form.Control className="form-control me-2" id="diemCK" type="text" value={diemCuoiKy}
                            onChange={(e) => setDiemCuoiKy(e.target.value)} placeholder="Điểm cuối kỳ....." required/>
                    </Form.Group>
                   
                    <Button className="btn-traloi-diendan mt-3" type="submit"><i class="fa-solid fa-reply icon-padding"></i>Thêm điểm</Button>:<Button className="btn-traloi-diendan mt-3" type="submit"><i class="fa-solid fa-reply icon-padding"></i>Chỉnh Sửa</Button>
                </div>
            </Form>
        </div>
    )
}
export default ChiTietDiem;