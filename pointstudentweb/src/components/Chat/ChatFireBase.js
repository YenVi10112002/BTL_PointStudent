import { useContext, useReducer } from "react";
import MyUserReducer from "../../reducers/MyUserReducer";
import cookie from "react-cookies";
import { useNavigate } from "react-router-dom";
import { Button } from "react-bootstrap";
import { MyUserConText } from "../../App";

const ChatFireBase = () => {
    const [user_chat, dispatchChat] = useReducer(MyUserReducer, cookie.load("user_chat_id") || null);
    const [user, dispatch] = useContext(MyUserConText);
    let nav = useNavigate();

    const logout = () => {
        dispatch({
            "type": "logout_chat"
        });
        nav("/chat")
    }
    if(user_chat!==null){
        return (
            <div class="contend">
                <h1>Sinh Viên &copy; 2023</h1>
                <p>Khoa CNTT, Đại học Mở Tp.HCM</p>
                <Button onClick={logout}>Đăng Xuất</Button>
            </div>
        )
    }
    else{
        nav("/chat")
    }
    
}
export default ChatFireBase;