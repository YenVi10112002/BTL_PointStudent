import { useContext } from "react";
import { MyUserConText } from "../../App";

const HomeGV = () => {
  const [user, dispatch] = useContext(MyUserConText);
  return (
    <>
      <div class="gv-contend">
        <nav class="navbar navbar-expand-sm navbar-dark">
          <div class="container-fluid">
            <a class="navbar-brand gv-dark-color gv-header-logo " href="#">
              <i class="fa-solid fa-bell gv-icon-padding"></i>
            </a>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
              <ul class="navbar-nav">
                <li class="nav-item gv-Search-student">
                  <form class="d-flex">
                    <input
                      class="form-control me-2"
                      type="text"
                      placeholder="Tìm Sinh Viên..."
                    />
                    <button class="gv-btn-search-student" type="button">
                      Search
                    </button>
                  </form>
                </li>
                <li class="nav-item gv-user-name-img">
                  <a class="nav-link " href="#">
                    <i class="fa-solid fa-user gv-icon-padding"></i>
                  </a>
                </li>

                <li class="nav-item dropdown">
                  <a
                    class="nav-link dropdown-toggle gv-dark-color"
                    href="#"
                    role="button"
                    data-bs-toggle="dropdown"
                  >
                    Chào, {user.hoTen}
                  </a>
                  <ul class="dropdown-menu">
                    <li>
                      <a class="dropdown-item gv-dark-color " href="#">
                        <i class="fa-solid fa-user gv-icon-padding"></i>Thông
                        Tin Tài Khoản
                      </a>
                    </li>
                    <li>
                      <a class="dropdown-item gv-dark-color" href="#">
                        <i class="fa-solid fa-key gv-icon-padding"></i>Thay Đổi
                        Mật Khẩu
                      </a>
                    </li>
                    <li>
                      <a class="dropdown-item gv-dark-color" href="#">
                        <i class="fa-solid fa-right-to-bracket gv-icon-padding"></i>
                        Đăng Xuất
                      </a>
                    </li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </nav>

        <div class="gv-monhoc-giaovien">
          <div class="gv-items-monhoc-giaovien">
            <a href="/NhapDiemSinhVien.html">
              <div class="gv-item-monhoc-giaovien">
                <img
                  src="https://res.cloudinary.com/dhcvsbuew/image/upload/v1693123925/mon_bk4slc.png"
                  alt="Image description"
                  class="gv-image-monhoc-giaovien"
                />
              </div>
              <div class="gv-item-monhoc-giaovien-text">
                Công Nghệ Phần Mềm -NK1012
              </div>
            </a>
          </div>
          <div class="gv-items-monhoc-giaovien">
            <a href="/NhapDiemSinhVien.html">
              <div class="gv-item-monhoc-giaovien">
                <img
                  src="https://res.cloudinary.com/dhcvsbuew/image/upload/v1693123925/mon_bk4slc.png"
                  alt="Image description"
                  class="gv-image-monhoc-giaovien"
                />
              </div>
              <div class="gv-item-monhoc-giaovien-text">
                Công Nghệ Phần Mềm -NK1012
              </div>
            </a>
          </div>
          <div class="gv-items-monhoc-giaovien">
            <a href="/NhapDiemSinhVien.html">
              <div class="gv-item-monhoc-giaovien">
                <img
                  src="https://res.cloudinary.com/dhcvsbuew/image/upload/v1693123925/mon_bk4slc.png"
                  alt="Image description"
                  class="gv-image-monhoc-giaovien"
                />
              </div>
              <div class="gv-item-monhoc-giaovien-text">
                Công Nghệ Phần Mềm -NK1012
              </div>
            </a>
          </div>
          <div class="gv-items-monhoc-giaovien">
            <a href="/NhapDiemSinhVien.html">
              <div class="gv-item-monhoc-giaovien">
                <img
                  src="https://res.cloudinary.com/dhcvsbuew/image/upload/v1693123925/mon_bk4slc.png"
                  alt="Image description"
                  class="gv-image-monhoc-giaovien"
                />
              </div>
              <div class="gv-item-monhoc-giaovien-text">
                Công Nghệ Phần Mềm -NK1012
              </div>
            </a>
          </div>
          <div class="gv-items-monhoc-giaovien">
            <a href="/NhapDiemSinhVien.html">
              <div class="gv-item-monhoc-giaovien">
                <img
                  src="https://res.cloudinary.com/dhcvsbuew/image/upload/v1693123925/mon_bk4slc.png"
                  alt="Image description"
                  class="gv-image-monhoc-giaovien"
                />
              </div>
              <div class="gv-item-monhoc-giaovien-text">
                Công Nghệ Phần Mềm -NK1012
              </div>
            </a>
          </div>
          <div class="gv-items-monhoc-giaovien">
            <a href="/NhapDiemSinhVien.html">
              <div class="gv-item-monhoc-giaovien">
                <img
                  src="https://res.cloudinary.com/dhcvsbuew/image/upload/v1693123925/mon_bk4slc.png"
                  alt="Image description"
                  class="gv-image-monhoc-giaovien"
                />
              </div>
              <div class="gv-item-monhoc-giaovien-text">
                Công Nghệ Phần Mềm -NK1012
              </div>
            </a>
          </div>
        </div>
      </div>
    </>
  );
};
export default HomeGV;
