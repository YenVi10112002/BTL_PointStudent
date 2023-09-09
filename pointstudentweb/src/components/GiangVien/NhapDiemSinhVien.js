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
    const [showCotDiem1, setShowCotDiem1] = useState(false);
    const [showCotDiem2, setShowCotDiem2] = useState(false);
    const [showCotDiem3, setShowCotDiem3] = useState(false);
    const [q] = useSearchParams();
    let idDiem = q.get("idDiem");
    let idMonHoc = q.get("idMonHoc");
    const [user, dispatch, giangvien, dispatch2] = useContext(MyUserConText);
    const [diem1, setDiem1] = useState([]);
    const [diem, setDiem] = useState({
        "idDiem": idDiem,
        "diemGiuaKy": '',
        "diemCuoiKy": '',
        "diemKT1": '',
        "diemTK2": '',
        "diemTK3": '',
    });
    const addCotDiem1 = () => {
        setShowCotDiem1(!showCotDiem1);
        if (showCotDiem1 === true) {
            setShowCotDiem2(false);
            setShowCotDiem3(false);
        }
        const updatedDiem = { ...diem };
        updatedDiem.diemKT1 = '';
        updatedDiem.diemTK2 = '';
        updatedDiem.diemTK3 = '';
        setDiem(updatedDiem);

    };
    const addCotDiem2 = () => {
        if (showCotDiem1) {
            setShowCotDiem2(!showCotDiem2);
        }
        if (showCotDiem2 === false) {
            setShowCotDiem3(false);
        }
        const updatedDiem = { ...diem };
        updatedDiem.diemTK2 = '';
        updatedDiem.diemTK3 = '';
        setDiem(updatedDiem);
    };
    const addCotDiem3 = () => {
        if (showCotDiem2 && showCotDiem1) {
            setShowCotDiem3(!showCotDiem3);
        }
        const updatedDiem = { ...diem };
        updatedDiem.diemTK3 = '';
        setDiem(updatedDiem);
    };


    useEffect(() => {
        const loadDiem = async () => {
            try {
                let e = endpoints['getdiemById'];
                idDiem = q.get("idDiem");
                if (idDiem !== null) {
                    e = `${e}?idDiem=${idDiem}`;
                    let res = await AuthApis().post(e);
                    setDiem1(res.data);
                    const updatedDiem = { ...diem };
                    updatedDiem.diemKT1 = res.data.diemKT1;
                    
                    updatedDiem.diemTK2 = res.data.diemTK2;
                    updatedDiem.diemTK3 = res.data.diemTK3;
                    updatedDiem.diemGiuaKy = res.data.diemGiuaKy;
                    updatedDiem.diemCuoiKy = res.data.diemCuoiKy;
                    setDiem(updatedDiem);
                    if(res.data.diemKT1!==null){
                        setShowCotDiem1(true);
                    }
                    if(res.data.diemTK2!==null){
                        setShowCotDiem2(true);
                    }
                    if(res.data.diemTK3!==null){
                        setShowCotDiem3(true);
                    }
                }
                console.log(diem1)
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
            if (res.status === 200) {
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
            <div class="traloi-diendan-none roll-nhapdiem" id="container2">
                <Form className="mt-5 mb-5" onSubmit={addDiem}>

                    <div class="form-themcauhoi-diendan">
                        <Link to={h} className="close-traloi-diendan ">Đóng </Link>
                        <h5><i class="fa-solid fa-user icon-padding mb-3"></i>Nhập điểm sinh viên</h5>
                        
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label htmlFor="diemCK">Điểm Giữa Kỳ<span class="text-danger">*</span></Form.Label>
                            <Form.Control type="number" min="0" max="10" step="0.1" required value={diem.diemGiuaKy}
                                onChange={e => change(e, "diemGiuaKy")} placeholder="Điểm Giữa Kỳ" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label htmlFor="diemCK">Điểm Cuối Kỳ<span class="text-danger">*</span></Form.Label>
                            <Form.Control type="number" min="0" max="10" step="0.1" required value={diem.diemCuoiKy}
                                onChange={e => change(e, "diemCuoiKy")} placeholder="Điểm cuối Kỳ" />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <div className="row">
                                <div className="col">
                                    {showCotDiem1 ? <><Form.Label htmlFor="diemCK">Điểm Khác 1</Form.Label>
                                        <Form.Control type="number" min="0" max="10" step="0.1" required value={diem.diemKT1}
                                            onChange={e => change(e, "diemKT1")} placeholder="Điểm Khác 1" /></> : <></>}
                                </div>
                                <div className="col">
                                    <Button className="btn-themdiem-add" onClick={addCotDiem1}>{showCotDiem1 ? "-" : "+"}</Button>
                                </div>
                            </div>


                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <div className="row">
                                <div className="col">
                                    {showCotDiem2 ? <><Form.Label htmlFor="diemCK">Điểm Khác 2</Form.Label>
                                        <Form.Control type="number" min="0" max="10" step="0.1" required value={diem.diemTK2}
                                            onChange={e => change(e, "diemTK2")} placeholder="Điểm Khác 2" /></> : <></>}
                                </div>
                                <div className="col">
                                    {showCotDiem1 ? <Button className="btn-themdiem-add" onClick={addCotDiem2}>{showCotDiem2 ? "-" : "+"}</Button> : <></>}
                                </div>
                            </div>




                        </Form.Group>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <div className="row">
                                <div className="col">
                                    {showCotDiem3 ? <><Form.Label htmlFor="diemCK">Điểm Khác 3</Form.Label>
                                        <Form.Control type="number" min="0" max="10" step="0.1" required value={diem.diemTK3}
                                            onChange={e => change(e, "diemTK3")} placeholder="Điểm Khác 3" /></> : <></>}
                                </div>
                                <div className="col">
                                    {showCotDiem1 && showCotDiem2 ? <Button className="btn-themdiem-add" onClick={addCotDiem3}>{showCotDiem3 ? "-" : "+"}</Button> : <></>}
                                </div>
                            </div>
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