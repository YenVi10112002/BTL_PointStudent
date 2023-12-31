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
            return null;
        
    }
    return currentState;
}

export default MyUserReducer;