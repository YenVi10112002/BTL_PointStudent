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
  `ngayTao` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`idCauHoiDienDan`),
  KEY `idTaiKhoan_idx` (`idTaiKhoan`) /*!80000 INVISIBLE */,
  CONSTRAINT `idTaiKhoan` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`idTaiKhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cauhoidiendang`
--

LOCK TABLES `cauhoidiendang` WRITE;
/*!40000 ALTER TABLE `cauhoidiendang` DISABLE KEYS */;
INSERT INTO `cauhoidiendang` VALUES (16,'Cái chết được hiểu như thế nào trong văn hóa của bạn?',10,'2023-09-09 04:45'),(17,'Sự sẵn có của cái chết ảnh hưởng đến cuộc sống của chúng ta như thế nào? ',10,'2023-09-09 04:45'),(18,'Cái chết và ý nghĩa của cuộc sống ?',10,'2023-09-09 04:45'),(19,'Làm thế nào các nghệ sĩ và nhà văn đã biểu thị cái chết trong tác phẩm của họ? Cái chết thường thể hiện qua nghệ thuật và văn hóa ở cách nào?',10,'2023-09-09 04:45'),(47,'Sự sống là gì theo quan điểm của bạn?',9,'2023-09-09 04:45'),(49,'Sự sống có ý nghĩa gì đối với bạn?',34,'2023-09-09 04:48'),(51,'Bạn nghĩ sự sống có tồn tại ở ngoài Trái Đất không?',9,'2023-09-09 04:48'),(52,'Sự sống có xuất hiện ở đâu trước tiên trên Trái Đất?',9,'2023-09-09 04:48'),(53,'Sự sống có tồn tại ở những nơi khác trong Vũ trụ không?',10,'2023-09-09 04:48');
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
  `khoaDiem` tinyint DEFAULT NULL,
  PRIMARY KEY (`idDiem`),
  KEY `idSinhVien_idx` (`idSinhVien`),
  KEY `idMonHoc_idx` (`idMonHoc`),
  CONSTRAINT `idMonHoc` FOREIGN KEY (`idMonHoc`) REFERENCES `monhoc` (`idMonHoc`),
  CONSTRAINT `idSinhVien` FOREIGN KEY (`idSinhVien`) REFERENCES `sinhvien` (`idSinhVien`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diem`
--

LOCK TABLES `diem` WRITE;
/*!40000 ALTER TABLE `diem` DISABLE KEYS */;
INSERT INTO `diem` VALUES (59,37,3,'Yếu',0,2,1,1,3,1,1.4,1),(60,36,2,'Yếu',0,1,1,1,1,1,1,0),(61,36,3,'Khá',1,7,7,5,7,9,6.8,1),(62,36,4,'Giỏi',1,8,8,NULL,NULL,NULL,8,0),(63,36,5,'Giỏi',1,9,9,NULL,NULL,NULL,9,0),(64,36,6,'Giỏi',1,9,8,NULL,NULL,NULL,8.5,0),(65,36,7,'Giỏi',1,8,9,NULL,NULL,NULL,8.5,0),(66,37,2,'Yếu',0,2,1,1,1,1,1.2,0),(88,37,24,'Giỏi',1,9,9,9,9,9,9,0),(112,28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(113,28,2,'Khá',1,7,8,4,7,2,6.7,0),(114,36,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(115,29,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(116,38,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(127,36,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(128,29,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(129,37,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(130,38,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(131,39,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(132,28,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(133,28,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0);
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
INSERT INTO `giangvien` VALUES (11,'Thai Tan Phat','1995-03-08',1,'phat@gmail.com','Thong Nhat','094567893',37),(13,'Phan Thanh Vi','1997-04-10',1,'vi@gmail.com','Lê Lợi','092356897',39),(14,'Trịnh Bảo Duy','1996-08-04',0,'duy@gmail.com','Nguyễn Văn Lượng ','035467981',35),(17,'Phạm Thanh Thanh','1992-03-04',1,'thanhthanh@gmail.com','2000 Gò Dầu, tân quý, tân Phú','039972203',34);
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` VALUES (1,'Lập Trình JaVa','Tự Luận',3,1,'NK-206',17),(2,'Cấu Trúc Dữ Liệu Và Giải Thuật','Trắc Nghiệm',4,1,'NK-301',17),(3,'Lập Trình web','Trắc Nghiệm',4,1,'NK-405',17),(4,'Lập Trình Giao Diện','Tự Luận',4,1,'NK-110',17),(5,'Lập Trình Kiến Trúc','Đồ Án',4,2,'NK-101',13),(6,'Công Nghệ Hiện Đại','Đồ Án',3,2,'NK-402',13),(7,'Dữ Liệu Phân Tán','Tự Luận',4,2,'NK-105',14),(8,'Mạng Máy Tính','Trắc Nghiệm',3,2,'NK-102',14),(22,'Công Nghệ Phần Mềm','Đồ Án',4,3,'NK-103',14),(23,'Quản Trị Mạng','Tự Luận',4,3,'NK-105',13),(24,'Khởi Nghiệp','Đồ Án',4,3,'NK-305',13);
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
  `hoTen` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `heDaoTao` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `ngaySinh` date DEFAULT NULL,
  `diaChi` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `gioiTinh` tinyint DEFAULT NULL,
  `soDienThoai` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `maLop` int DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `idTaiKhoan` int DEFAULT NULL,
  PRIMARY KEY (`idSinhVien`),
  UNIQUE KEY `idTaiKhoan_UNIQUE` (`idTaiKhoan`),
  KEY `idLopHoc_idx` (`maLop`),
  KEY `idTaiKhoan_idx` (`idTaiKhoan`),
  KEY `idTaiKhoanSinhVien_idx` (`idTaiKhoan`),
  CONSTRAINT `idLopHoc` FOREIGN KEY (`maLop`) REFERENCES `lophoc` (`idLopHoc`),
  CONSTRAINT `idTaiKhoanSinhVien` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`idTaiKhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
INSERT INTO `sinhvien` VALUES (28,'Lê Anh Khoa','Trực tiếp','2002-07-01','14 Phan Văn Tri, p13, Gò Vấp',1,'07725405227',1,'anhkhoa@ou.edu.vn',47),(29,'Phạm Hoàng Vân Anh','Trực tiếp','2002-04-04','35 Lê Văn Sỹ, phường 1, tân Bình',0,'0703112345',1,'vananh@ou.edu.vn',NULL),(36,'Phạm Hoàng Ân','Trực tiếp','2002-02-12','200 Gò Dầu, Tân Quý, Tân Phú',1,'0397769522',1,'hoangan@ou.edu.vn',9),(37,'Phan Yến Vi','Trực tiếp','2002-03-01','312 Quang Trung, Phường 12, Gò Vấp',0,'0722711246',1,'2051050021ani@ou.edu.vn',10),(38,'Phạm Hoàng Khánh Vân','Trực tiếp','2002-07-01','47 Âu Cơ, phường 14, Tân Bình',0,'0705522417',1,'khanhvan@ou.edu.vn',49),(39,'Phan Y Nhi','Truc tiep','2002-06-13','100 Tan Son Nhat',0,'0986457123',2,'ynhi@ou.edu.vn',48),(47,'Lê Thanh An','Trực tiếp','2003-07-01','312 Quang Trung, Phường 12, Gò Vấp',1,'0377615271',3,'thanhan@ou.edu.vn',50);
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
  `image` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  PRIMARY KEY (`idTaiKhoan`),
  KEY `idloaitk_idx` (`ChucVu`),
  CONSTRAINT `idloaitk` FOREIGN KEY (`ChucVu`) REFERENCES `loaitaikhoan` (`idloaitaikhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES (6,'vanan','$2a$10$xFjJA.u4nzT3Tgo.Xrb2qOlyJX39WWdWaUCH8SuuYxe7Vw44TM9NW',1,''),(7,'kimtuyen','$2a$12$vTtcPHbAkpbyVo8xVLaIKu1hVnliW6Sxmg7Xs0oh9Ab3kBfKT57my',1,''),(8,'vanthanh','$2a$12$I7zWTMDg8luaH4j6pBAY0ug/9/IcxdXQuXOuCpx4i85sbjHwdCboa',1,''),(9,'hoangan@ou.edu.vn','$2a$10$gXzl63/9Uwrc1N12ox8HxOQSSnn5MQFU7qLQzDlC/ZHcmV9vaMPrC',3,'https://res.cloudinary.com/dhcvsbuew/image/upload/v1694098671/kekpddka5eimdzjfpebs.jpg'),(10,'2051050021@ou.edu.vn','$2a$12$ZZtS0hP3Q.qzeMtj/LJfv.q6OeoTe/.C5VyXLJV9W2hYTYEqUNv/a',3,'https://res.cloudinary.com/dhcvsbuew/image/upload/v1693411526/r5p1bbftvkfwg63akh1p.jpg'),(34,'thanhvi','$2a$10$K599eXIER88KrE41rbeOZORYk/SNTEpk05ULA42uxIOGAtx9v/BMG',2,'https://res.cloudinary.com/dhcvsbuew/image/upload/v1694246122/cozbha1e0w8urvm66bcv.jpg'),(35,'baoduy','$2a$10$HcmRtCU8Dqq7axZTs6PkVeacTKV3DTIfK4/QqBqxpRqeeWAcbGJXa',2,''),(37,'phat789','$2a$10$j7PFjCfev3urSyau2t7daeV7apSoeaJBPEbokEl75rIKmKyiEwrnC',2,NULL),(39,'thuyenngu','$2a$10$1RdOE7QnpxveF2HQsFhfSukGU8PcYEUo.jbGtA.WJ8/QYmE9K2JGa',2,NULL),(47,'anhkhoa@ou.edu.vn','$2a$10$flUZEtnxd1LtKBLT5LI/SOZGvlDb/I3hZ2JQYtozY7mYT5aj/p8Yy',3,NULL),(48,'ynhi@ou.edu.vn','$2a$10$AKe.iGORM4RrlGdMa1ui4uXTLy1LwJxdXQ7qBSEyuMsVgHJ4XAYRi',3,NULL),(49,'khanhvan@ou.edu.vn','$2a$10$z99amQNFQgWmPa/EsEVNfORXsAAxuVSfULJgucmqfSrHpCg9BP9/G',3,NULL),(50,'thanhan@ou.edu.vn','$2a$10$X8gFSV.WbwQ/gKRHoUPNzOx2CynFaRPqqSWJQdQdQEPpo7g9.9CYW',3,NULL);
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
  `noiDungTraLoi` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `idTaiKhoan` int DEFAULT NULL,
  `idCauHoiDienDan` int DEFAULT NULL,
  PRIMARY KEY (`idTraLoiDienDan`),
  KEY `idCauHoi_idx` (`idCauHoiDienDan`),
  KEY `idTaiKhoan_idx` (`idTaiKhoan`),
  CONSTRAINT `idCauHoi` FOREIGN KEY (`idCauHoiDienDan`) REFERENCES `cauhoidiendang` (`idCauHoiDienDan`),
  CONSTRAINT `idTaiKhoanCauTraLoi` FOREIGN KEY (`idTaiKhoan`) REFERENCES `taikhoan` (`idTaiKhoan`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traloidiendan`
--

LOCK TABLES `traloidiendan` WRITE;
/*!40000 ALTER TABLE `traloidiendan` DISABLE KEYS */;
INSERT INTO `traloidiendan` VALUES (23,'Cái chết là sự khỏi đầu của một cuộc sống khác theo hình thức khác.',34,16),(24,'Cái chết là sự ràng buộc và bổ sung cho sự sống.',34,16),(25,'Sự sống có mối liên kết với khoa học và tôn giáo không? ',9,16),(26,'Sự sống là sự tồn tại và hoạt động của các hệ thống hữu cơ, bao gồm con người, động vật, cây cỏ và vi khuẩn.',9,16),(27,'Sự sống có ý nghĩa quan trọng đối với tôi vì nó mang theo nhiều trải nghiệm.',9,16),(28,'Cuộc sống con người và cuộc sống của các loài khác.',9,16),(29,'Bạn nghĩ sự sống có mục đích cụ thể hay chỉ là một sự ngẫu nhiên?',9,16),(30,'Sự sống có khả năng tự tiến hóa và thích nghi không?',9,16),(31,'Cuộc sống có nghĩa là phải trải qua thách thức và khó khăn không?',34,17),(32,'Sự sống có mối liên kết với khoa học và tôn giáo không? Nếu có, thì làm thế nào?',34,17);
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

-- Dump completed on 2023-09-10 17:36:31
