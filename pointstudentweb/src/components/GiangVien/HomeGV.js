import { useContext, useEffect, useState } from "react";
import { MyUserConText } from "../../App";
import { AuthApis, endpoints } from "../../configs/Apis";
import { Link } from "react-router-dom";

const HomeGV = () => {
  const [user, dispatch, giangvien, dispatchgv] = useContext(MyUserConText);
  const [monHoc, setMonHoc] = useState([]);


  useEffect(() => {
    const loadMonHoc = async () => {
      let e = endpoints['monHocIdTK'];
      e = `${e}?taiKhoanId=${user.idTaiKhoan}`;
      let res = await AuthApis().get(e);

      setMonHoc(res.data);
    }

    loadMonHoc();
  })

  return (
    <>
      <div class="contend">
            <nav class="navbar navbar-1 navbar-expand-sm navbar-dark nav-menu">
                <div class="container-fluid">
                    <a class="navbar-brand dark-color header-logo " href="#"><i class="fa-solid fa-bell icon-padding"></i></a>
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                        <ul class="navbar-nav">
                            <li class="nav-item user-name-img">
                                <a class="nav-link dark-color" href="#"><i class="fa-solid fa-user icon-padding" ></i></a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle dark-color" href="#" role="button" data-bs-toggle="dropdown">Chào,
                                    {giangvien.hoTen}</a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item dark-color " href="#"><i class="fa-solid fa-user icon-padding"></i>Thông Tin Tài Khoản</a></li>
                                    <li><a class="dropdown-item dark-color" href="#"><i class="fa-solid fa-key icon-padding"></i>Thay Đổi Mật Khẩu</a></li>
                                    <li><a class="dropdown-item dark-color" href="#"><i class="fa-solid fa-right-to-bracket icon-padding"></i>Đăng Xuất</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

        <div class="gv-monhoc-giaovien">
          {monHoc.map(mh => {
              let h = `/giangvien/nhapdiem?monHocId=${mh.idMonHoc}`;
              return (<div class="gv-items-monhoc-giaovien" key={mh.idMonHoc}>
              <Link to={h}>
                <div class="gv-item-monhoc-giaovien">
                  <img
                    src="https://res.cloudinary.com/dhcvsbuew/image/upload/v1693123925/mon_bk4slc.png"
                    alt="Image description"
                    class="gv-image-monhoc-giaovien"
                  />
                </div>
                <div class="gv-item-monhoc-giaovien-text">
                  {mh.tenMonHoc}
                </div>
              </Link>
            </div>)

          }
            
          )}
        </div>
      </div>
    </>
  );
};
export default HomeGV;
