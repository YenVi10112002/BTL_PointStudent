import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { Link } from "react-router-dom";
import Apis, { AuthApis, endpoints } from "../configs/Apis";
import cookie from "react-cookies";
const Login = () => {

    const [username, setusername] = useState();
    const [password, setpassword] = useState();

    const login = (evt) => {
         evt.preventDefault();

         const process = async () => {
            try {
                let res = await Apis.post(endpoints['login'], {
                    "tenTaiKhoan": username,
                    "matKhau": password
                })
                cookie.save("token", res.data);

                let {data} = await AuthApis().get(endpoints['current-user']);
                cookie.save("user", data);
                console.info(data);

            } catch(ex){
                console.error(ex);
            }
         }
         process();

    }

    return (
        <div className="container">
            <div className=" form-login  shadow-lg ">
                <div className="text-center " >
                    <h4 className="text-login">Đăng Nhập</h4>
                </div>
                <Form className="mt-5 mb-5" onSubmit={login}>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Tài Khoản</Form.Label>
                        <Form.Control type="email" value={username} onChange={e => setusername(e.target.value)} placeholder="Tài Khoản" />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Mật Khẩu</Form.Label>
                        <Form.Control type="password" value={password} onChange={e => setpassword(e.target.value)} placeholder="Mật Khẩu" />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Button id="submit" type="submit">Đăng Nhập</Button>
                    </Form.Group>
                    <div>
                        <hr width="100%" size="3px" align="center" color="#9C9C9C" />
                        <div className="btn-submit">
                            <p>Sinh viên chưa có tài khoản <Link to="/signup">Đăng Ký</Link> </p>
                        </div>
                    </div>
                    <div>
                        <p>Nếu sinh viên lần đầu đăng nhập:</p>
                        <p className="text-content">Vui lòng chọn đăng ký, và đăng kí tài khoản bằng email trường cung cấp để có thể truy cập,
                            trong trường hợp quên mật khẩu đăng nhập,
                            vui lòng liên hệ phòng quản lý sinh viên để được hỗ trợ. </p>
                    </div>
                </Form >
            </div>
        </div>


    )
}
export default Login;