import { useState } from "react";
import { Button, Form, Alert } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import { useNavigate } from "react-router-dom";
import MySpinner from "../layout/MySpinner";
const Signup = () => {




    let nav = useNavigate();

    const [loading, setLoading] = useState(false);
    const [pass, setPass] = useState(true);
    const [user, setUser] = useState({
        "tenTaiKhoan": "",
        "matKhau": "",
        "xacNhanMK": ""
    });


    
    /*Gui maill */
    
    const change = (evt, field) => {
        setUser(current => {
            return { ...current, [field]: evt.target.value }
        })
    }


    const signup = (evt) => {
        evt.preventDefault();

        const process = async () => {
            let formData = new FormData();

            for (let field in user)
                if (field !== "xacNhanMK")
                    formData.append(field, user[field]);
            setLoading(true)
            let res = await Apis.post(endpoints['signup'], formData);
            if (res.status === 201) {
                nav("/");
            }
        }

        if (user.matKhau !== user.xacNhanMK) {
            setPass(false);
        }
        else {
            process();

        }

    }

    
    return (
        <div className="container">
            <div className=" form-login  shadow-lg ">
                <div className="text-center " >
                    <h4 className="text-login">Đăng nhập</h4>
                </div>

                <Form className="mt-5 mb-5" onSubmit={signup}>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Tài Khoản</Form.Label>
                        <Form.Control type="email" value={user.tenTaiKhoan}
                            onChange={e => change(e, "tenTaiKhoan")} placeholder="Tài Khoản" required />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Mật Khẩu</Form.Label>
                        <Form.Control type="password" value={user.xacNhanMK}
                            onChange={e => change(e, "xacNhanMK")} placeholder="Mật Khẩu" required />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Nhập Lại Mật Khẩu</Form.Label>
                        <Form.Control type="password" value={user.matKhau}
                            onChange={e => change(e, "matKhau")} placeholder="Nhập Lại Mật Khẩu" required />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        {loading === true ? <MySpinner /> : <Button id="submit" type="submit" className="btn Sbtn-bg btn-submit text-size">Đăng Ký</Button>}

                    </Form.Group>
                </Form >
                {pass === false ? <Alert variant="secondary">Mật khẩu không trùng khớp</Alert> : <div></div>}
            </div>

        </div>
    )
}
export default Signup;