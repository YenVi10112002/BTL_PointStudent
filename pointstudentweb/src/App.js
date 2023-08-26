import { BrowserRouter, Route, Routes } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from "./components/Login";
import Signup from "./components/Signup";
import './resources/css/student.css';
import './resources/css/access.css';
import Home from "./components/Home";
import HeaderStudent from "./layout/HeaderStudent";
import DienDan from "./components/DienDan";
import TraLoiDienDan from "./components/TraLoiDienDan";
import Themchude from "./components/ThemChuDe";
import Header from "./layout/header";
import Footer from "./layout/Footer";


function App() {
  // if(true){
  //   return (
  //     <BrowserRouter>
  //     <Header />
  //       <Routes>
  //         <Route path="/" element={<Login />} />
  //         <Route path="/signup" element={<Signup />} />   
          
  //       </Routes>
  //       <Footer />
  //   </BrowserRouter>
  //   )
  // }
  return (
    <BrowserRouter>
      <HeaderStudent />
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/signup" element={<Signup />} />   
          <Route path="/home" element={<Home />} />  
          <Route path="/diendan" element={<DienDan />} /> 
          <Route path="/traloidiendan" element={<TraLoiDienDan />} /> 
          <Route path="/themcauhoi" element={<Themchude />} /> 
        </Routes>
    </BrowserRouter>
  );
}
export default App;