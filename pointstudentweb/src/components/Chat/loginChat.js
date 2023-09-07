import React, { useReducer, useState } from 'react';
import cookie from "react-cookies";
import { auth } from '../Chat/firebase';
import { Alert, Button, Form } from 'react-bootstrap';
import Header from '../../layout/sinhvien/HeaderSV';
import { useNavigate } from 'react-router-dom';
import { signInWithEmailAndPassword } from 'firebase/auth';
import MyUserReducer from '../../reducers/MyUserReducer';



const LoginChat = () => {
    const [user_chat, dispatchChat] = useReducer(MyUserReducer, cookie.load("user_chat_id") || null);
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [pass, setPass] = useState(false);
    let nav = useNavigate();
    const handleLogin = async (e) => {
        setPass(false);
        e.preventDefault();
        signInWithEmailAndPassword(auth, email, password)
            .then((userCredential) => {
                const user = userCredential.user;
                cookie.save("user_chat_id", user.uid);
                console.log('Đăng nhập thành công');
                nav("/chatTrucTuyen");
            })
            .catch((error) => {
                console.error('Đăng nhập thất bại:', error.message);
                setPass(true);
            });
    }
    if(user_chat!==null){
        nav("/chatTrucTuyen");
    }

    return (
        <div class="contend">
            <Header />
            <div class="change-password ">
                <p class="change-password-title">Đăng nhập</p>
                <Form className="change-password-form">
                    <Form.Control
                        required
                        type="email"
                        placeholder="Nhập email..."
                        className="mb-4"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <Form.Control
                        required
                        type="password"
                        placeholder="Nhập mật khẩu..."
                        className="mb-4"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    <hr width="100%" size="3px" align="center" color="#9C9C9C" />
                    <Button id="submit" type="submit" onClick={handleLogin}>
                        Đăng nhập
                    </Button>
                    {pass ? <Alert variant="secondary" className="mt-3">Sai tên tài khoản hoặc mật khẩu</Alert> : <></>}
                </Form>
            </div>

        </div>
    );
}


export default LoginChat;