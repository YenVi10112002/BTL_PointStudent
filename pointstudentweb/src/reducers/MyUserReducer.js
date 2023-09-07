import cookie from "react-cookies";

const MyUserReducer = (currentState, action) => {
    switch (action.type){
        case"login":
            return action.payLoad;
        case "logout":
            cookie.remove("token");
            cookie.remove("user");
            cookie.remove("sinhvien");
            cookie.remove("giangvien");
            cookie.remove("user_chat_id");
            return null;
        case "logout_chat":
            cookie.remove("user_chat_id");
        

    }
    return currentState;
}

export default MyUserReducer;