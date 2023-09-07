import React from 'react';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';

pdfMake.vfs = pdfFonts.pdfMake.vfs;

const PDFGenerator = ({ data }) => {
  const createPDF = (TenMonHoc) => {
    const documentDefinition = {
      content: [
        {
          text: 'Bảng Điểm Sinh Viên',
          style: 'header',
        },
        {
          table: {
            headerRows: 1,
            widths: ['auto', 'auto', 'auto', 'auto', 'auto', 'auto', 'auto', 'auto'],
            body: [
              [
                'Mã số sinh viên',
                'Họ và tên',
                'Điểm Kiểm Tra 1',
                'Điểm Kiểm Tra 2',
                'Điểm Kiểm Tra 3',
                'Điểm Giữa Kỳ',
                'Điểm Cuối Kỳ',
                'Tình Trạng',
              ],
              ...data.map((sv) => [
                sv.idSinhVien.idSinhVien,
                sv.idSinhVien.hoTen,
                sv.diemKT1 === null ? 'Chưa có' : sv.diemKT1,
                sv.diemTK2 === null ? 'Chưa có' : sv.diemTK2,
                sv.diemTK3 === null ? 'Chưa có' : sv.diemTK3,
                sv.diemGiuaKy,
                sv.diemCuoiKy,
                sv.trangThai === 1 ? 'Đậu' : 'Rớt',
              ]),
            ],
          },
        },
      ],
      styles: {
        header: {
          fontSize: 18,
          bold: true,
          alignment: 'center',
          margin: [0, 0, 0, 10],
        },
      },
    };

    pdfMake.createPdf(documentDefinition).download(`${TenMonHoc}table-pdf.pdf`);
  };

  return (
    <button onClick={() =>createPDF(data.length > 0 ? data[0].idMonHoc.tenMonHoc : "")} className="btn btn-secondary mt-2 mb-5 btn-creat-pdf">
      Xuất File PDF
    </button>
  );
};

export default PDFGenerator;