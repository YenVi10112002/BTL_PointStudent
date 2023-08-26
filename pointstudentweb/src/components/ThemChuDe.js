import { Button, Form } from "react-bootstrap";
import { Link } from "react-router-dom";

const Themchude = () => {
    return (
        <div class="traloi-diendan-none" id="container2">
            <Form className="mt-5 mb-5">
                <div class="form-themcauhoi-diendan">
                <Link to="/diendan" className="close-traloi-diendan ">Đóng</Link>
                    <h5><i class="fa-solid fa-user icon-padding mb-3"></i>Thêm Câu Hỏi Diễn Đàn</h5>
                    <p class="content-question-day"><i class="fa-solid fa-calendar-days icon-padding"></i>Diễn đàn trao đổi của sinh viên và giảng viên </p>
                        <Form.Control className="form-control me-2" type="text" placeholder="Câu hỏi..." />
                        <Button className="btn-traloi-diendan mt-3" type="submit"><i class="fa-solid fa-reply icon-padding"></i>Thêm Câu Hỏi</Button>
                </div>
            </Form>
        </div>
    )
}
export default Themchude;