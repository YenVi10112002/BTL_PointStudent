import { Button, Form } from "react-bootstrap";
const Signup = () => {
    return (
        <div className="container">
            <div className=" form-login  shadow-lg ">
                <div className="text-center " >
                    <h4 className="text-login">Đăng nhập</h4>
                </div>
                <Form className="mt-5 mb-5">
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Tài Khoản</Form.Label>
                        <Form.Control type="email" placeholder="Tài Khoản" />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Mật Khẩu</Form.Label>
                        <Form.Control type="password" placeholder="Mật Khẩu" />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Nhập Lại Mật Khẩu</Form.Label>
                        <Form.Control type="password" placeholder="Nhập Lại Mật Khẩu" />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Button  id="submit" className="btn Sbtn-bg btn-submit text-size">Đăng Ký</Button>
                    </Form.Group>

                </Form >
            </div>

        </div>
    )
}
export default Signup;