function deleteSinhVien(path) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Something wrong!!!");
        });
    }
}

//function addToCart(idMonHoc) {
//    const idSinhVien = document.getElementById("idSinhVien").textContent
//    fetch(`/QLDiemSinhVien/giaovu/api/monhoc/${idMonHoc}?idSinhVien=${idSinhVien}`).then(res => {
//        if (!res.ok) {
//            throw new Error(`Network response was not ok: ${res.status}`);
//        }
//        return res.json();
//    }).then(data => {
//        var d = document.getElementById("cart-counter");
//        if (d !== null) {
//            d.innerText = data;
//        }
//
//        loadData();
//
//    })
//
//}

function addToCart(idMonHoc) {
    const idSinhVien = document.getElementById("idSinhVien").textContent;

    // Gọi API để thêm môn học vào giỏ hàng
    fetch(`/QLDiemSinhVien/giaovu/api/monhoc/${idMonHoc}?idSinhVien=${idSinhVien}`)
            .then(res => {
                if (!res.ok) {
                    throw new Error(`Network response was not ok: ${res.status}`);
                }
                return res.json();
            })
            .then(data => {
                var d = document.getElementById("cart-counter");
                if (d !== null) {
                    d.innerText = data;
                }

                // Gọi API để lưu dữ liệu xuống server
                const dataToSave = {
                    [idMonHoc]: {
                        idMonHoc: idMonHoc,
                        idSinhVien: idSinhVien
                    }
                };

                return fetch(`/QLDiemSinhVien/giaovu/api/phieuMH`, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(dataToSave)
                });
            })
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error(`Lưu thất bại: ${response.statusText}`);
                }
            })
            .then(responseText => {
                alert(responseText);
                loadData(); // Cập nhật lại dữ liệu sau khi lưu thành công
            })
            .catch(error => {
                console.error(error);
                alert("Lỗi hệ thống.");
            });
}
function loadData() {
    console.log("Loading data...");
    var dataContainer = document.getElementById("table-monhoc");
    var spinner = document.getElementById("spinner");
    

    dataContainer.innerHTML = ""; // Clear existing content
    spinner.style.display = "block"; // Display spinner

    fetch("/QLDiemSinhVien/giaovu/api/cart")
            .then(response => response.json()).then(data => {
        console.log("API response:", data);
        spinner.style.display = "none"; // Hide spinner
        if (data.carts !== null) {
            var tableHtml = '<table><thead><tr><th>Mã môn học</th><th>Tên môn học</th><th>Phòng học</th></tr></thead><tbody>';

                data.carts.forEach(cart => {
                    tableHtml += `<tr><td>${cart.idMonHoc}</td><td>${cart.tenMonHoc}</td><td>${cart.phongHoc}</td></tr>`;
                });

                tableHtml += '</tbody></table>';
              dataContainer.innerHTML = tableHtml;
        } else {
            dataContainer.innerHTML = '<p>No carts available.</p>';
        }
    });

}
function luuPhieu() {

    fetch(`/QLDiemSinhVien/giaovu/api/phieuMH`, {
        method: "POST"
    })
            .then(response => response.text())
            .then(data => {
                if (data.includes("Đã lưu thành công.")) {
                    alert("Lưu thành công.");
                } else {
                    alert("Lưu thất bại.");
                }
            })
            .catch(error => {
                console.error(error);
                alert("Lỗi hệ thống.");
            });
}





