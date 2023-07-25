-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: studentdb
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cauhoidiendang`
--

DROP TABLE IF EXISTS `cauhoidiendang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cauhoidiendang` (
  `idCauHoiDienDan` int NOT NULL AUTO_INCREMENT,
  `noiDungCauHoi` varchar(300) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `idTaiKhoan` int NOT NULL,
  PRIMARY KEY (`idCauHoiDienDan`),
  KEY `idTaiKhoan_idx` (`idTaiKhoan`),
  CONSTRAINT `idTaiKhoan` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`idTaiKhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cauhoidiendang`
--

LOCK TABLES `cauhoidiendang` WRITE;
/*!40000 ALTER TABLE `cauhoidiendang` DISABLE KEYS */;
INSERT INTO `cauhoidiendang` VALUES (1,'Bạn nghĩ những phẩm chất nào là quan trọng nhất để một nhân viên IT có thể thăng tiến?',9),(2,'Bạn có thể kể cho tôi về một lần mà công việc không theo ý muốn của bạn?',9),(3,'Bạn nghĩ các tiến bộ khoa học, công nghệ sẽ tác động đến công việc của bạn như thế nào?',9),(4,'Dự án IT gần đây nhất là bạn thực hiện là gì? Bạn đóng vai trò như thế nào trong dự án đó?',9);
/*!40000 ALTER TABLE `cauhoidiendang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diem`
--

DROP TABLE IF EXISTS `diem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diem` (
  `idDiem` int NOT NULL AUTO_INCREMENT,
  `idSinhVien` int NOT NULL,
  `idMonHoc` int NOT NULL,
  `diemGiuaKy` double DEFAULT NULL,
  `diemCuoiKy` double DEFAULT NULL,
  `diemTrungBinh` double DEFAULT NULL,
  `xepLoai` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `trangThai` tinyint DEFAULT NULL,
  PRIMARY KEY (`idDiem`,`idSinhVien`,`idMonHoc`),
  KEY `idSinhVien_idx` (`idSinhVien`),
  KEY `idMonHoc_idx` (`idMonHoc`),
  CONSTRAINT `idMonHoc` FOREIGN KEY (`idMonHoc`) REFERENCES `monhoc` (`idMonHoc`),
  CONSTRAINT `idSinhVien` FOREIGN KEY (`idSinhVien`) REFERENCES `sinhvien` (`idSinhVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diem`
--

LOCK TABLES `diem` WRITE;
/*!40000 ALTER TABLE `diem` DISABLE KEYS */;
/*!40000 ALTER TABLE `diem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giangvien`
--

DROP TABLE IF EXISTS `giangvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giangvien` (
  `idGiangVien` int NOT NULL AUTO_INCREMENT,
  `hoTen` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `ngaySinh` date DEFAULT NULL,
  `gioiTinh` tinyint NOT NULL,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `diaChi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `soDienThoai` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idTaiKhoan` int DEFAULT NULL,
  PRIMARY KEY (`idGiangVien`),
  KEY `id_idx` (`idTaiKhoan`),
  CONSTRAINT `id` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`idTaiKhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giangvien`
--

LOCK TABLES `giangvien` WRITE;
/*!40000 ALTER TABLE `giangvien` DISABLE KEYS */;
INSERT INTO `giangvien` VALUES (5,'Nguyễn Hưu Thành','1997-03-07',1,'thanh12@gmail.com','45 Nguyễn Kiệm','0376711234',3),(6,'Nguyễn Phương Trang','1998-07-03',0,'trang123@gmail.com','147 Tân Thành','0467884612',4),(7,'Nguyễn Đức Viễn','1980-04-08',1,'vien1234@gmail.com','67 Phổ Quang','0466876921',5);
/*!40000 ALTER TABLE `giangvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giaovu`
--

DROP TABLE IF EXISTS `giaovu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giaovu` (
  `idGiaoVu` int NOT NULL AUTO_INCREMENT,
  `tenGiaoVu` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `gioiTinh` tinyint NOT NULL,
  `soDienThoai` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idTaiKhoan` int DEFAULT NULL,
  PRIMARY KEY (`idGiaoVu`),
  KEY `id_idx` (`idTaiKhoan`),
  CONSTRAINT `idTaiKhoanGiaoVu` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`idTaiKhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giaovu`
--

LOCK TABLES `giaovu` WRITE;
/*!40000 ALTER TABLE `giaovu` DISABLE KEYS */;
INSERT INTO `giaovu` VALUES (1,'Trần Văn An',1,'0356712246',6),(2,'Nguyễn Kim Tuyền',0,'0487568123',7),(3,'Phạm Văn Thanh',1,'0761457345',8);
/*!40000 ALTER TABLE `giaovu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaitaikhoan`
--

DROP TABLE IF EXISTS `loaitaikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaitaikhoan` (
  `idloaitaikhoan` int NOT NULL,
  `tenloai` varchar(45) NOT NULL,
  PRIMARY KEY (`idloaitaikhoan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaitaikhoan`
--

LOCK TABLES `loaitaikhoan` WRITE;
/*!40000 ALTER TABLE `loaitaikhoan` DISABLE KEYS */;
INSERT INTO `loaitaikhoan` VALUES (1,'Giáo Vụ'),(2,'Giảng Viên'),(3,'Sinh Viên');
/*!40000 ALTER TABLE `loaitaikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lophoc`
--

DROP TABLE IF EXISTS `lophoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lophoc` (
  `idLopHoc` int NOT NULL AUTO_INCREMENT,
  `tenLopHoc` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `khoaHoc` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`idLopHoc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lophoc`
--

LOCK TABLES `lophoc` WRITE;
/*!40000 ALTER TABLE `lophoc` DISABLE KEYS */;
INSERT INTO `lophoc` VALUES (1,'DH20IT01','2020'),(2,'DH20IT02','2020');
/*!40000 ALTER TABLE `lophoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monhoc` (
  `idMonHoc` int NOT NULL AUTO_INCREMENT,
  `tenMonHoc` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `hinhThucThi` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `soTinChi` int NOT NULL,
  `hocKy` int NOT NULL,
  `phongHoc` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `idGiangVien` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idMonHoc`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` VALUES (1,'Lập Trình Java','Tự Luận',4,1,'NK-206','5'),(2,'Cấu Trúc Dữ Liệu Và Giải Thuật','Trắc Nghiệm',4,1,'NK-301','6'),(3,'Lập Trình web','Trắc Nghiệm',4,1,'NK-405','7');
/*!40000 ALTER TABLE `monhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinhvien`
--

DROP TABLE IF EXISTS `sinhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinhvien` (
  `idSinhVien` int NOT NULL AUTO_INCREMENT,
  `hoTen` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `heDaoTao` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `ngaySinh` date NOT NULL,
  `diaChi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `gioiTinh` tinyint NOT NULL,
  `soDienThoai` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `maLop` int NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `idTaiKhoan` int DEFAULT NULL,
  PRIMARY KEY (`idSinhVien`),
  KEY `idLopHoc_idx` (`maLop`),
  KEY `idTaiKhoan_idx` (`idTaiKhoan`),
  KEY `idTaiKhoanSinhVien_idx` (`idTaiKhoan`),
  CONSTRAINT `idLopHoc` FOREIGN KEY (`maLop`) REFERENCES `lophoc` (`idLopHoc`),
  CONSTRAINT `idTaiKhoanSinhVien` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`idTaiKhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
INSERT INTO `sinhvien` VALUES (1,'Phạm Hàng Ân','Trưc tiếp','2002-03-24','200/14 Gò Dầu',1,'0397769522',1,'an1234@ou.edu.vn',9),(2,'Trần Yến Vi','Trực tiếp','2002-04-07','30 Cộng Hòa',0,'0393771859',2,'vi1324@ou.edu.vn',NULL),(3,'Nguyễn Kim Sương','Trực tiếp','2003-03-14','41 Tân Thới Nhất',0,'0930895147',1,'suong243@ou.edu.vn',NULL),(4,'Nguyễn Thanh Thuyền','Trực tiếp','2002-06-15','66 Phan Văn Trị',1,'0134711246',2,'thuyenbd12@ou.edu.vn',NULL);
/*!40000 ALTER TABLE `sinhvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `idTaiKhoan` int NOT NULL AUTO_INCREMENT,
  `TenTaiKhoan` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `MatKhau` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `ChucVu` int NOT NULL,
  PRIMARY KEY (`idTaiKhoan`),
  KEY `machucvu_idx` (`ChucVu`),
  CONSTRAINT `loaitaikhoan` FOREIGN KEY (`ChucVu`) REFERENCES `loaitaikhoan` (`idloaitaikhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES (3,'huuthanh','123456',2),(4,'phuongtrang','123456',2),(5,'ducvien','123456',2),(6,'vanan','123456',1),(7,'kimtuyen','123456',1),(8,'vanthanh','123456',1),(9,'hoangan','123456',3),(10,'yenvi','123456',3);
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traloidiendan`
--

DROP TABLE IF EXISTS `traloidiendan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `traloidiendan` (
  `idTraLoiDienDan` int NOT NULL AUTO_INCREMENT,
  `noiDungTraLoi` varchar(400) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `idTaiKhoan` int NOT NULL,
  `idCauHoiDienDan` int NOT NULL,
  PRIMARY KEY (`idTraLoiDienDan`),
  KEY `idCauHoi_idx` (`idCauHoiDienDan`),
  KEY `idTaiKhoan_idx` (`idTaiKhoan`),
  CONSTRAINT `idCauHoi` FOREIGN KEY (`idCauHoiDienDan`) REFERENCES `cauhoidiendang` (`idCauHoiDienDan`),
  CONSTRAINT `idTaiKhoanCauTraLoi` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`idTaiKhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traloidiendan`
--

LOCK TABLES `traloidiendan` WRITE;
/*!40000 ALTER TABLE `traloidiendan` DISABLE KEYS */;
INSERT INTO `traloidiendan` VALUES (1,'Có nha bạn !!',10,1);
/*!40000 ALTER TABLE `traloidiendan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-26  3:39:08
