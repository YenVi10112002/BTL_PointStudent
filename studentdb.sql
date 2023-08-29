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
  KEY `idTaiKhoan_idx` (`idTaiKhoan`) /*!80000 INVISIBLE */,
  CONSTRAINT `idTaiKhoan` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`idTaiKhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cauhoidiendang`
--

LOCK TABLES `cauhoidiendang` WRITE;
/*!40000 ALTER TABLE `cauhoidiendang` DISABLE KEYS */;
INSERT INTO `cauhoidiendang` VALUES (1,'Bạn nghĩ những phẩm chất nào là quan trọng nhất để một nhân viên IT có thể thăng tiến?',9),(2,'Bạn có thể kể cho tôi về một lần mà công việc không theo ý muốn của bạn?',9),(3,'Bạn nghĩ các tiến bộ khoa học, công nghệ sẽ tác động đến công việc của bạn như thế nào?',9),(4,'Dự án IT gần đây nhất là bạn thực hiện là gì? Bạn đóng vai trò như thế nào trong dự án đó?',9),(5,'Ã¢',9),(6,'Báº¡n nÃ o cÃ³ viá»c lÃ m vÃ o ca ÄÃªm khÃ´ng áº¡ ??',9),(8,'Ban co biet dia chi truong o dau khong?',10);
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
  `idSinhVien` int DEFAULT NULL,
  `idMonHoc` int DEFAULT NULL,
  `xepLoai` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `trangThai` tinyint DEFAULT NULL,
  `diemGiuaKy` double DEFAULT NULL,
  `diemCuoiKy` double DEFAULT NULL,
  `DiemKT1` double DEFAULT NULL,
  `DiemTK2` double DEFAULT NULL,
  `DiemTK3` double DEFAULT NULL,
  `diemTrungBình` double DEFAULT NULL,
  PRIMARY KEY (`idDiem`),
  KEY `idSinhVien_idx` (`idSinhVien`),
  KEY `idMonHoc_idx` (`idMonHoc`),
  CONSTRAINT `idMonHoc` FOREIGN KEY (`idMonHoc`) REFERENCES `monhoc` (`idMonHoc`),
  CONSTRAINT `idSinhVien` FOREIGN KEY (`idSinhVien`) REFERENCES `sinhvien` (`idSinhVien`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diem`
--

LOCK TABLES `diem` WRITE;
/*!40000 ALTER TABLE `diem` DISABLE KEYS */;
INSERT INTO `diem` VALUES (59,36,1,'Giỏi',1,8,8,NULL,NULL,NULL,8),(60,36,2,'Giỏi',1,8,9,NULL,NULL,NULL,8.5),(61,36,3,'Giỏi',1,9,10,NULL,NULL,NULL,9.5),(62,36,4,'Giỏi',1,8,8,NULL,NULL,NULL,8),(63,36,5,'Giỏi',1,9,9,NULL,NULL,NULL,9),(64,36,6,'Giỏi',1,9,8,NULL,NULL,NULL,8.5),(65,36,7,'Giỏi',1,8,9,NULL,NULL,NULL,8.5),(66,37,1,'Giỏi',1,7,7,NULL,NULL,NULL,7),(67,37,2,'Giỏi',1,8,8,NULL,NULL,NULL,8),(68,37,3,'Giỏi',1,9,9,NULL,NULL,NULL,9),(69,37,4,'Giỏi',1,10,10,NULL,NULL,NULL,10),(70,37,5,'Giỏi',1,10,10,NULL,NULL,NULL,10),(71,37,6,'Giỏi',1,9,9,NULL,NULL,NULL,9),(72,37,7,'Giỏi',1,8,8,NULL,NULL,NULL,8),(73,37,8,'Giỏi',1,9,10,NULL,NULL,NULL,9.5);
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
  UNIQUE KEY `idTaiKhoan_UNIQUE` (`idTaiKhoan`),
  KEY `id_idx` (`idTaiKhoan`),
  CONSTRAINT `id` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`idTaiKhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giangvien`
--

LOCK TABLES `giangvien` WRITE;
/*!40000 ALTER TABLE `giangvien` DISABLE KEYS */;
INSERT INTO `giangvien` VALUES (11,'Thai Tan Phat','1995-03-08',1,'phat@gmail.com','Thong Nhat','094567893',37),(13,'Phan Thanh Vi','1997-04-10',1,'vi@gmail.com','Lê Lợi','092356897',39),(14,'Trịnh Bảo Duy','1996-08-04',0,'duy@gmail.com','Nguyễn Văn Lượng ','035467981',35),(16,'Nguyen Thanh','1996-08-07',0,'thanh@ou.edu.vn','Nguyen Van Luong','0986457123',NULL),(17,'Phạm Thanh Thanh','1992-03-04',1,'thanhthanh@gmail.com','2000 Gò Dầu, tân quý, tân Phú','039972203',34);
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
  UNIQUE KEY `idTaiKhoan_UNIQUE` (`idTaiKhoan`),
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
  `idloaitaikhoan` int NOT NULL AUTO_INCREMENT,
  `tenloaitaikhoan` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`idloaitaikhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaitaikhoan`
--

LOCK TABLES `loaitaikhoan` WRITE;
/*!40000 ALTER TABLE `loaitaikhoan` DISABLE KEYS */;
INSERT INTO `loaitaikhoan` VALUES (1,'ROLE_GVU'),(2,'ROLE_GV'),(3,'ROLE_SV');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lophoc`
--

LOCK TABLES `lophoc` WRITE;
/*!40000 ALTER TABLE `lophoc` DISABLE KEYS */;
INSERT INTO `lophoc` VALUES (1,'DH20IT01','2020'),(2,'DH20IT02','2020'),(3,'DH20CS01','2020'),(4,'DH20CS02','2020'),(5,'DH21IT01','2021'),(6,'DH21IT02','2021'),(7,'DH21CS01','2021'),(8,'DH21CS01','2021');
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
  `idGiangVien` int DEFAULT NULL,
  PRIMARY KEY (`idMonHoc`),
  KEY `idhocky_idx` (`hocKy`),
  KEY `GiangVien_MonHoc_idx` (`idGiangVien`),
  CONSTRAINT `GiangVien_MonHoc` FOREIGN KEY (`idGiangVien`) REFERENCES `giangvien` (`idGiangVien`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` VALUES (1,'Lập Trình JaVa','Tự Luận',3,1,'NK-206',11),(2,'Cấu Trúc Dữ Liệu Và Giải Thuật','Trắc Nghiệm',4,1,'NK-301',11),(3,'Lập Trình web','Trắc Nghiệm',4,1,'NK-405',11),(4,'Lập Trình Giao Diện','Tự Luận',4,1,'NK-110',11),(5,'Lập Trình Kiến Trúc','Đồ Án',4,2,'NK-101',13),(6,'Công Nghệ Hiện Đại','Đồ Án',3,2,'NK-402',13),(7,'Dữ Liệu Phân Tán','Tự Luận',4,2,'NK-105',14),(8,'Mạng Máy Tính','Trắc Nghiệm',3,2,'NK-102',14),(22,'Công Nghệ Phần Mềm','Đồ Án',4,3,'NK-103',14),(23,'Quản Trị Mạng','Tự Luận',4,3,'NK-105',13),(24,'Khởi Nghiệp','Đồ Án',4,3,'NK-305',13);
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
  `hoTen` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `heDaoTao` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `ngaySinh` date DEFAULT NULL,
  `diaChi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `gioiTinh` tinyint DEFAULT NULL,
  `soDienThoai` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `maLop` int DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `idTaiKhoan` int DEFAULT NULL,
  PRIMARY KEY (`idSinhVien`),
  UNIQUE KEY `idTaiKhoan_UNIQUE` (`idTaiKhoan`),
  KEY `idLopHoc_idx` (`maLop`),
  KEY `idTaiKhoan_idx` (`idTaiKhoan`),
  KEY `idTaiKhoanSinhVien_idx` (`idTaiKhoan`),
  CONSTRAINT `idLopHoc` FOREIGN KEY (`maLop`) REFERENCES `lophoc` (`idLopHoc`),
  CONSTRAINT `idTaiKhoanSinhVien` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`idTaiKhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
INSERT INTO `sinhvien` VALUES (26,'Nguyễn Hoàng Thiên Ân','Trực tiếp','2002-11-22','161 Lê Thánh Tông, phường 15, Quận 1',0,'0134772501',1,'thienan@ou.edu.vn',NULL),(27,'Phạm Hoàng Khang','Trực Tiếp','2002-04-12','31 Lê Lai, phường 2, Gò Vấp',1,'0377625441',1,'hoangkhang@ou.edu.vn',NULL),(28,'Lê Anh Khoa','Trực tiếp','2002-07-01','14 Phan Văn Tri, p13, Gò Vấp',1,'07725405227',1,'anhkhoa@ou.edu.vn',NULL),(29,'Phạm Hoàng Vân Anh','Trực tiếp','2002-04-04','35 Lê Văn Sỹ, phường 1, tân Bình',0,'0703112345',1,'vananh@ou.edu.vn',NULL),(36,'Phạm Hoàng Ân','Trực tiếp','2002-02-12','200 Gò Dầu, Tân Quý, Tân Phú',1,'0397769522',1,'hoangan@ou.edu.vn',9),(37,'Phan Yến Vi','Trực tiếp','2002-03-01','312 Quang Trung, Phường 12, Gò Vấp',0,'0722711246',1,'yenvi@ou.edu.vn',10),(38,'Phạm Hoàng Khánh Vân','Trực tiếp','2002-07-01','47 Âu Cơ, phường 14, Tân Bình',0,'0705522417',1,'khanhvan@ou.edu.vn',NULL),(39,'Phan Y Nhi','Truc tiep','2002-06-13','100 Tan Son Nhat',0,'0986457123',2,'ynhi@ou.edu.vn',NULL);
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
  `MatKhau` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `ChucVu` int DEFAULT NULL,
  `image` varchar(1000) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`idTaiKhoan`),
  KEY `idloaitk_idx` (`ChucVu`),
  CONSTRAINT `idloaitk` FOREIGN KEY (`ChucVu`) REFERENCES `loaitaikhoan` (`idloaitaikhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES (6,'vanan','$2a$12$i4zdEUlM8hFivEfebiKohu48RZaaJN4K2/NgEWeD740XBswHCep0u',1,''),(7,'kimtuyen','$2a$12$vTtcPHbAkpbyVo8xVLaIKu1hVnliW6Sxmg7Xs0oh9Ab3kBfKT57my',1,''),(8,'vanthanh','$2a$12$I7zWTMDg8luaH4j6pBAY0ug/9/IcxdXQuXOuCpx4i85sbjHwdCboa',1,''),(9,'hoangan@ou.edu.vn','$2a$12$rSt08iChMsNtWY6poU00EuhR0a71qmmmLHPjee9aZ5Fcx.J5CeQA.',3,''),(10,'yenvi@ou.edu.vn','$2a$12$ZZtS0hP3Q.qzeMtj/LJfv.q6OeoTe/.C5VyXLJV9W2hYTYEqUNv/a',3,''),(34,'thanhvi','$2a$10$ZO9WmpbqiBvbQVk/oqRn0.UHJ6HtZwz7dJwaplqngR9As.sYgqfTC',2,''),(35,'baoduy','$2a$10$HcmRtCU8Dqq7axZTs6PkVeacTKV3DTIfK4/QqBqxpRqeeWAcbGJXa',2,''),(37,'phat789','$2a$10$j7PFjCfev3urSyau2t7daeV7apSoeaJBPEbokEl75rIKmKyiEwrnC',2,NULL),(39,'thuyenngu','$2a$10$1RdOE7QnpxveF2HQsFhfSukGU8PcYEUo.jbGtA.WJ8/QYmE9K2JGa',2,NULL);
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
  `noiDungTraLoi` varchar(400) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `idTaiKhoan` int DEFAULT NULL,
  `idCauHoiDienDan` int DEFAULT NULL,
  PRIMARY KEY (`idTraLoiDienDan`),
  KEY `idCauHoi_idx` (`idCauHoiDienDan`),
  KEY `idTaiKhoan_idx` (`idTaiKhoan`),
  CONSTRAINT `idCauHoi` FOREIGN KEY (`idCauHoiDienDan`) REFERENCES `cauhoidiendang` (`idCauHoiDienDan`),
  CONSTRAINT `idTaiKhoanCauTraLoi` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`idTaiKhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traloidiendan`
--

LOCK TABLES `traloidiendan` WRITE;
/*!40000 ALTER TABLE `traloidiendan` DISABLE KEYS */;
INSERT INTO `traloidiendan` VALUES (1,'Có nha bạn !!',10,1),(2,'Cáº§n cá»«u vÃ  siÃªng nÄng.',9,1),(3,'minh khong biet',9,1),(4,'Lamg báº£o vá» ÄÆ°á»£c khÃ´ng áº¡',9,6);
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

-- Dump completed on 2023-08-29 15:53:53
