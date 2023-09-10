import { useContext, useEffect, useReducer, useState } from "react";
import MyUserReducer from "../../reducers/MyUserReducer";
import { database, ref, onValue, push, set, auth, child, get } from "../Chat/firebase";
import cookie from "react-cookies";
import { useNavigate } from "react-router-dom";
import { Button, Form } from "react-bootstrap";
import { MyUserConText } from "../../App";
import { firestore } from './firebase';



const ChatFireBase = () => {
    const [user_chat, dispatchChat] = useReducer(MyUserReducer, cookie.load("user_chat_id") || null);
    const [user, dispatch] = useContext(MyUserConText);
    const [chatRooms, setChatRooms] = useState([]);
    let nav = useNavigate();

    useEffect(() => {
        if (user_chat) {
            const db = database;
            const chatRoomsRef = ref(db, "chatRooms");
            console.log(chatRoomsRef);

            // Lắng nghe sự thay đổi trong dữ liệu các phòng chat
            onValue(chatRoomsRef, (snapshot) => {
                if (snapshot.exists()) {
                    const chatRoomsData = snapshot.val();
                    const chatRoomsArray = Object.keys(chatRoomsData).map((roomId) => ({
                        id: roomId,
                        ...chatRoomsData[roomId],
                    }));
                    const userChatRooms = chatRoomsArray.filter((room) =>
                        room.members.hasOwnProperty(user_chat)
                    );
                    console.log("Fetched chat rooms:", userChatRooms); // Debug: Log the fetched data
                    setChatRooms(userChatRooms);
                } else {
                    console.log("No chat rooms found"); // Debug: Log if no chat rooms were found
                }
            }, {
                onlyOnce: true // Thêm này nếu bạn chỉ muốn lấy dữ liệu một lần khi thành phần được gắn kết
            });
        }
    }, [user_chat]);

   
    const logout2 = () => {
        console.log(user_chat)
    }


    const logout = () => {
        dispatch({
            "type": "logout_chat"
        });
        nav("/chat")
    }
    if (user_chat !== null) {
        return (
            <div class="contend">
                {user_chat && (
                    <div className="vertical-menu-chat">
                        <div className="menu-items">
                            <p className="text-menu-chat">Nhóm Chat Của Bạn:</p>
                            {chatRooms.map((room) => (
                                <div key={room.id} className="menu-item">
                                    <i className="fa-solid fa-house icon-padding"></i>
                                    {room.roomName}
                                </div>
                            ))}
                            <div className="menu-item" onClick={logout} to="/">
                                <i className="fa-solid fa-right-to-bracket icon-padding"></i>Thoát
                            </div>
                            
                        </div>
                    </div>
                )}
                <div class="contend-chat">
                    <div class="container">
                        <h1 class="header-chat-group">Group Chat</h1>

                        <div class="chat-box">
                            <div class="chat-header">Lập Trình Java</div>
                            <div class="message">
                                <div class="message-content">
                                    <div class="user-name"><i class="fa-solid fa-user icon-padding" ></i>User 2:</div>
                                    <p>Hello, how are you?</p>
                                </div>
                            </div>
                            <div class="message">
                                <div class="message-content">
                                    <div class="user-name"><i class="fa-solid fa-user icon-padding" ></i>User 2:</div>
                                    <p>I'm good, thanks! How about you?</p>
                                </div>
                            </div>
                        </div>
                        <Form className="mt-1 mb-5 ">
                            <div className="row">
                                <div className="col">
                                    <Form.Group controlId="exampleForm.ControlInput1">
                                        <Form.Control
                                            className="input-chat"
                                            type="text"
                                            placeholder="Nhập tin nhắn"
                                            required
                                        />
                                    </Form.Group>
                                </div>
                                <div className="col ">
                                    <Form.Group>
                                        <Button onClick={logout2} className="btn-traloi-diendan" type="submit"><i class="fa-brands fa-facebook-messenger icon-padding"></i>
                                            Gửi
                                        </Button>
                                    </Form.Group>
                                </div>
                            </div>
                        </Form>

                    </div>
                </div>
            </div >
        )
    }
    else {
        nav("/chat")
    }

}
export default ChatFireBase;