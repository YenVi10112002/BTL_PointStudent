import { useContext, useEffect, useState } from "react";
import { Button, Form, Alert } from "react-bootstrap";
import { Link, useNavigate, useSearchParams } from "react-router-dom";
import { MyUserConText } from "../../App";
import { AuthApis, endpoints } from "../../configs/Apis";
import MySpinner from "../../layout/MySpinner";
import Header from "../../layout/giangVien/Header";

const NhapDiemSinhVien = () => {
    const [loading, setLoading] = useState(false);
    const [success, setSuccess] = useState(false);
    const [q] = useSearchParams();
    let idDiem = q.get("idDiem");
    let idMonHoc = q.get("idMonHoc");
    const [user, dispatch, giangvien, dispatch2] = useContext(MyUserConText);
    const [diem1, setDiem1] = useState([]);
    const [diem, setDiem] = useState({
        "idDiem": idDiem,
        "diemGiuaKy": diem1.diemGiuaKy,
        "diemCuoiKy": diem1.diemCuoiKy,
        "diemKT1": diem1.diemKT1,
        "diemTK2": diem1.diemTK2,
        "diemTK3": diem1.diemTK3,

    });
    useEffect(() => {
        const loadDiem = async () => {
            try {
                let e = endpoints['getdiemById'];
                idDiem = q.get("idDiem");
                if (idDiem !== null) {
                    e = `${e}?idDiem=${idDiem}`;

                    let res = await AuthApis().get(e);
                    setDiem1(res.data);
                }
            } catch (ex) {
                console.error(ex);
            }

        }
        loadDiem();
    }, [q]);


    let nav = useNavigate();


    const addDiem = (evt) => {
        setSuccess(false);


        evt.preventDefault();
        const process = async () => {
            // let formData = new FormData();
            // for (let field in diem)
            //     formData.append(field, diem[field]);
            let res = await AuthApis().post(endpoints['addDiem'], diem);
            setLoading(true);
            if(res.status===200){
                nav(`/giangvien/nhapdiem?monHocId=${idMonHoc}`);
            }
            
        };
        process();
        
    }


    const change = (evt, field) => {
        setDiem(current => {
            return { ...current, [field]: evt.target.value }
        })
    }

    let h = `/giangvien/nhapdiem?monHocId=${idMonHoc}`;

    return (
        <div class="gv-contend">
            <Header />
            <div class="traloi-diendan-none" id="container2">
                <Form className="mt-5 mb-5" onSubmit={addDiem}>

                    <div class="form-themcauhoi-diendan">
                        <Link to={h} className="close-traloi-diendan ">Đóng </Link>
                        <h5><i class="fa-solid fa-user icon-padding mb-3"></i>Nhập điểm sinh viên</h5>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label htmlFor="diemCK">Điểm Giữa Kỳ<span class="text-danger"></span></Form.Label>
                            <Form.Control type="number" min="0" max="10" step="0.1" required value={diem.diemGiuaKy}
                                onChange={e => change(e, "diemGiuaKy")} placeholder="Điểm Giữa Kỳ" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label htmlFor="diemCK">Điểm Cuối Kỳ<span class="text-danger">*</span></Form.Label>
                            <Form.Control type="number" min="0" max="10" step="0.1" required value={diem.diemCuoiKy}
                                onChange={e => change(e, "diemCuoiKy")} placeholder="Điểm cuối Kỳ" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label htmlFor="diemCK">Điểm Khác 1</Form.Label>
                            <Form.Control type="number" min="0" max="10" step="0.1" required value={diem.diemKT1}
                                onChange={e => change(e, "diemKT1")} placeholder="Điểm Khác 1" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label htmlFor="diemCK">Điểm Khác 2</Form.Label>
                            <Form.Control type="number" min="0" max="10" step="0.1" required value={diem.diemTK2}
                                onChange={e => change(e, "diemTK2")} placeholder="Điểm Khác 2" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label htmlFor="diemCK">Điểm Khác 3</Form.Label>
                            <Form.Control type="number" min="0" max="10" step="0.1" required value={diem.diemTK3}
                                onChange={e => change(e, "diemTK3")} placeholder="Điểm Khác 3" />
                        </Form.Group>
                        {loading === true ? <MySpinner /> : <Button className="btn-traloi-diendan mt-3" type="submit"><i class="fa-solid fa-reply icon-padding"></i>Thêm điểm</Button>}
                        {success === true ? <Alert variant="secondary">Thêm điểm thành công !!!</Alert> : <div></div>}
                    </div>
                </Form>
            </div>
        </div>
    )
}
export default NhapDiemSinhVien;