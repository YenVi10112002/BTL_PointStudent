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
  `ngayTao` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
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
  `tenDiem` int NOT NULL,
  `soDiem` double NOT NULL,
  `idMonHoc` int NOT NULL,
  `khoaDiem` tinyint NOT NULL,
  PRIMARY KEY (`idDiem`),
  KEY `diem_monhoc_idx` (`idMonHoc`),
  KEY `loaiDiem_idx` (`tenDiem`),
  CONSTRAINT `diem_monhoc` FOREIGN KEY (`idMonHoc`) REFERENCES `monhocdangky` (`idMonHocDangKy`),
  CONSTRAINT `loaiDiem` FOREIGN KEY (`tenDiem`) REFERENCES `loaidiem` (`idLoaiDiem`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diem`
--

LOCK TABLES `diem` WRITE;
/*!40000 ALTER TABLE `diem` DISABLE KEYS */;
INSERT INTO `diem` VALUES (134,1,9,1,0),(135,2,9,1,0),(136,3,9,1,0),(137,6,9,1,0),(138,1,8,2,0),(139,2,8,2,0),(140,3,8,2,0),(141,4,8,2,0),(142,6,8,2,0),(143,1,8.5,3,0),(144,2,8.5,3,0),(145,3,8.5,3,0),(146,4,8.5,3,0),(147,5,8.5,3,0),(148,6,8.5,3,0),(149,1,8,4,0),(150,2,8,4,0),(151,3,8,4,0),(152,6,8,4,0),(153,1,9,5,0),(154,2,9,5,0),(155,3,9,5,0),(156,4,9,5,0),(157,6,9,5,0),(158,1,7,6,0),(159,2,7,6,0),(160,3,7,6,0),(161,4,7,6,0),(162,5,7,6,0),(163,6,7,6,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giangvien`
--

LOCK TABLES `giangvien` WRITE;
/*!40000 ALTER TABLE `giangvien` DISABLE KEYS */;
INSERT INTO `giangvien` VALUES (19,'Dương Hữu Thành','1990-03-07',1,'huuthanh@gmail.com','37/46 Phan Văn Trị, P12, Gò Vấp','0377221375',54),(20,'Phan Thị Dương','1985-11-12',0,'duong@gmail.com','450 Lê ai, Tân Kỳ, Tân Phú','0255715246',NULL),(21,'Phạm Hoàng Thiên Ân','1995-07-09',0,'thienan@gmail.com','235 Gò Dầu, Tân Quý, tân Phú','0776655789',NULL),(22,'Phạm Hoàng Gia Khang','1989-03-04',1,'giakhoang@gmail.com','205 Năm Kỳ Khởi Nghĩa, P5, Quận 3','0724556785',55);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giaovu`
--

LOCK TABLES `giaovu` WRITE;
/*!40000 ALTER TABLE `giaovu` DISABLE KEYS */;
INSERT INTO `giaovu` VALUES (4,'Phạm Hoàng Ân',1,'0397769522',52),(5,'Phan Yến Vi',0,'0377765521',53);
/*!40000 ALTER TABLE `giaovu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hedaotao`
--

DROP TABLE IF EXISTS `hedaotao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hedaotao` (
  `idhedaotao` int NOT NULL,
  `tenHeDaoTao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`idhedaotao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hedaotao`
--

LOCK TABLES `hedaotao` WRITE;
/*!40000 ALTER TABLE `hedaotao` DISABLE KEYS */;
INSERT INTO `hedaotao` VALUES (1,'Chất Lượng Cao'),(2,'Đại Trà');
/*!40000 ALTER TABLE `hedaotao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocky`
--

DROP TABLE IF EXISTS `hocky`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hocky` (
  `idHocKy` int NOT NULL AUTO_INCREMENT,
  `tenHocKy` int NOT NULL,
  `ngayBatDau` datetime NOT NULL,
  `ngayKetThuc` datetime NOT NULL,
  `idLop` int NOT NULL,
  `ngayDangKy` datetime NOT NULL,
  `ngayHetHan` datetime NOT NULL,
  PRIMARY KEY (`idHocKy`),
  KEY `hocky_lophoc_idx` (`idLop`),
  KEY `hocKy_loaiHocKY_idx` (`tenHocKy`),
  CONSTRAINT `hocKy_loaiHocKY` FOREIGN KEY (`tenHocKy`) REFERENCES `loaihocky` (`idLoaiHocKy`),
  CONSTRAINT `hocky_lophoc` FOREIGN KEY (`idLop`) REFERENCES `lophoc` (`idLopHoc`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocky`
--

LOCK TABLES `hocky` WRITE;
/*!40000 ALTER TABLE `hocky` DISABLE KEYS */;
INSERT INTO `hocky` VALUES (1,1,'2023-10-25 00:00:00','2023-12-30 00:00:00',9,'2023-09-25 00:00:00','2023-10-25 00:00:00');
/*!40000 ALTER TABLE `hocky` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa`
--

DROP TABLE IF EXISTS `khoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoa` (
  `idkhoa` int NOT NULL AUTO_INCREMENT,
  `tenKhoa` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`idkhoa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa`
--

LOCK TABLES `khoa` WRITE;
/*!40000 ALTER TABLE `khoa` DISABLE KEYS */;
INSERT INTO `khoa` VALUES (1,'2020-2024'),(2,'2021-2025');
/*!40000 ALTER TABLE `khoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoadaotao`
--

DROP TABLE IF EXISTS `khoadaotao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoadaotao` (
  `idKhoaDaoTao` int NOT NULL AUTO_INCREMENT,
  `tenKhoaDaoTao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`idKhoaDaoTao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoadaotao`
--

LOCK TABLES `khoadaotao` WRITE;
/*!40000 ALTER TABLE `khoadaotao` DISABLE KEYS */;
INSERT INTO `khoadaotao` VALUES (1,'Công Nghệ Thông Tin'),(2,'Kinh Tế');
/*!40000 ALTER TABLE `khoadaotao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaidiem`
--

DROP TABLE IF EXISTS `loaidiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaidiem` (
  `idLoaiDiem` int NOT NULL AUTO_INCREMENT,
  `tenDiem` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`idLoaiDiem`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaidiem`
--

LOCK TABLES `loaidiem` WRITE;
/*!40000 ALTER TABLE `loaidiem` DISABLE KEYS */;
INSERT INTO `loaidiem` VALUES (1,'Điểm Giữa Kỳ'),(2,'Điểm Cuối Kỳ'),(3,'Điểm KT1'),(4,'Điểm KT2'),(5,'Điểm KT3'),(6,'Điểm Trung Bình');
/*!40000 ALTER TABLE `loaidiem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaihocky`
--

DROP TABLE IF EXISTS `loaihocky`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaihocky` (
  `idLoaiHocKy` int NOT NULL AUTO_INCREMENT,
  `tenHocKy` varchar(45) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`idLoaiHocKy`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaihocky`
--

LOCK TABLES `loaihocky` WRITE;
/*!40000 ALTER TABLE `loaihocky` DISABLE KEYS */;
INSERT INTO `loaihocky` VALUES (1,'Học Kỳ 1'),(2,'Học Kỳ 2'),(3,'Học Kỳ 3'),(4,'Học Kỳ 4'),(5,'Học Kỳ 5'),(6,'Học Kỳ 6'),(7,'Học Kỳ 7'),(8,'Học Kỳ 8'),(9,'Học Kỳ 9'),(10,'Học Kỳ 10'),(11,'Học Kỳ 11');
/*!40000 ALTER TABLE `loaihocky` ENABLE KEYS */;
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
  `idKhoaHoc` int NOT NULL,
  `idNganh` int NOT NULL,
  `idHeDaoTao` int NOT NULL,
  PRIMARY KEY (`idLopHoc`),
  KEY `lophoc_hedaotao_idx` (`idHeDaoTao`),
  KEY `lophoc_nganh_idx` (`idNganh`),
  CONSTRAINT `lophoc_hedaotao` FOREIGN KEY (`idHeDaoTao`) REFERENCES `hedaotao` (`idhedaotao`),
  CONSTRAINT `lophoc_nganh` FOREIGN KEY (`idNganh`) REFERENCES `nganhdaotao` (`idNganhDaoTao`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lophoc`
--

LOCK TABLES `lophoc` WRITE;
/*!40000 ALTER TABLE `lophoc` DISABLE KEYS */;
INSERT INTO `lophoc` VALUES (9,'DH20IT01',1,1,2),(10,'DH20CS01',1,2,2);
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
  `soTinChi` int NOT NULL,
  PRIMARY KEY (`idMonHoc`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` VALUES (26,'Công Nghệ Phần Mềm',4),(27,'Thiết Kế Web',4),(28,'Hệ Thống Thông Tin',4),(29,'Kiểm Thử',4),(30,'Khoa Học Máy Tính',4),(31,'Lập Trình Hiện Đại',4),(32,'Cơ Sở Lập Trình',4),(33,'Kiến Trúc Lập Trình',4),(34,'Lập Trình Hướng Đối Tượng',4);
/*!40000 ALTER TABLE `monhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc_hocky`
--

DROP TABLE IF EXISTS `monhoc_hocky`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monhoc_hocky` (
  `idMonHoc_HocKy` int NOT NULL AUTO_INCREMENT,
  `idMonHoc` int NOT NULL,
  `idHocky` int NOT NULL,
  `soLuong` int NOT NULL,
  `ngayBatDau` datetime NOT NULL,
  `ngayKetThuc` datetime NOT NULL,
  `idGiangVien` int DEFAULT NULL,
  `phongHoc` int DEFAULT NULL,
  PRIMARY KEY (`idMonHoc_HocKy`),
  KEY `monhoc_hocKy_idx` (`idMonHoc`),
  KEY `monhoc_GiangVien_idx` (`idGiangVien`),
  KEY `monhoc_hockyy` (`idHocky`),
  CONSTRAINT `monhoc_GiangVien` FOREIGN KEY (`idGiangVien`) REFERENCES `giangvien` (`idGiangVien`),
  CONSTRAINT `monhoc_hocKy` FOREIGN KEY (`idMonHoc`) REFERENCES `monhoc` (`idMonHoc`),
  CONSTRAINT `monhoc_hockyy` FOREIGN KEY (`idHocky`) REFERENCES `hocky` (`idHocKy`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc_hocky`
--

LOCK TABLES `monhoc_hocky` WRITE;
/*!40000 ALTER TABLE `monhoc_hocky` DISABLE KEYS */;
INSERT INTO `monhoc_hocky` VALUES (1,26,1,80,'2023-10-25 00:00:00','2023-12-30 00:00:00',19,1),(2,27,1,80,'2023-10-25 00:00:00','2023-12-30 00:00:00',20,2),(3,28,1,80,'2023-10-25 00:00:00','2023-12-30 00:00:00',21,3);
/*!40000 ALTER TABLE `monhoc_hocky` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhocdangky`
--

DROP TABLE IF EXISTS `monhocdangky`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monhocdangky` (
  `idMonHocDangKy` int NOT NULL AUTO_INCREMENT,
  `idMonHoc` int NOT NULL,
  `idSinhVien` int NOT NULL,
  `xepLoai` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `trangThai` tinyint DEFAULT NULL,
  PRIMARY KEY (`idMonHocDangKy`),
  KEY `monhocdangky_sinhvien_idx` (`idSinhVien`),
  KEY `monhocdangky_monhochocky_idx` (`idMonHoc`),
  CONSTRAINT `monhocdangky_monhochocky` FOREIGN KEY (`idMonHoc`) REFERENCES `monhoc_hocky` (`idMonHoc_HocKy`),
  CONSTRAINT `monhocdangky_sinhvien` FOREIGN KEY (`idSinhVien`) REFERENCES `sinhvien` (`idSinhVien`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhocdangky`
--

LOCK TABLES `monhocdangky` WRITE;
/*!40000 ALTER TABLE `monhocdangky` DISABLE KEYS */;
INSERT INTO `monhocdangky` VALUES (1,1,52,NULL,0),(2,2,52,NULL,0),(3,3,52,NULL,0),(4,1,53,NULL,0),(5,2,53,NULL,0),(6,3,53,NULL,0),(7,1,54,NULL,0),(8,2,54,NULL,0),(9,3,54,NULL,0);
/*!40000 ALTER TABLE `monhocdangky` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nganhdaotao`
--

DROP TABLE IF EXISTS `nganhdaotao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nganhdaotao` (
  `idNganhDaoTao` int NOT NULL AUTO_INCREMENT,
  `tenNganhDaoTao` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `idKhoaDaoTao` int NOT NULL,
  PRIMARY KEY (`idNganhDaoTao`),
  KEY `nganh_khoa_idx` (`idKhoaDaoTao`),
  CONSTRAINT `nganh_khoa` FOREIGN KEY (`idKhoaDaoTao`) REFERENCES `khoadaotao` (`idKhoaDaoTao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nganhdaotao`
--

LOCK TABLES `nganhdaotao` WRITE;
/*!40000 ALTER TABLE `nganhdaotao` DISABLE KEYS */;
INSERT INTO `nganhdaotao` VALUES (1,'Công Nghệ Thông Tin',1),(2,'Khoa Học Máy Tính',1);
/*!40000 ALTER TABLE `nganhdaotao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phonghoc`
--

DROP TABLE IF EXISTS `phonghoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phonghoc` (
  `idPhongHoc` int NOT NULL AUTO_INCREMENT,
  `tenPhongHoc` varchar(45) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`idPhongHoc`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phonghoc`
--

LOCK TABLES `phonghoc` WRITE;
/*!40000 ALTER TABLE `phonghoc` DISABLE KEYS */;
INSERT INTO `phonghoc` VALUES (1,'NK-001'),(2,'NK-002'),(3,'NK-003'),(4,'NK-004'),(5,'NK-005'),(6,'NK-006'),(7,'NK-007'),(8,'NK-101'),(9,'NK-102'),(10,'NK-103'),(11,'NK-104'),(12,'NK-105');
/*!40000 ALTER TABLE `phonghoc` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinhvien`
--

LOCK TABLES `sinhvien` WRITE;
/*!40000 ALTER TABLE `sinhvien` DISABLE KEYS */;
INSERT INTO `sinhvien` VALUES (52,'Nguyễn Thanh Thuyền','2002-04-22','200/14 Gò Dầu, Tân Quý, Tân Phú',1,'0371251727',9,'thanhthuyen@ou.edu.vn',NULL),(53,'Lê Anh Khoa','2002-03-21','37 Lê Thánh Tông, P11, Tân Bình',1,'0277650217',9,'anhkhoa@ou.edu.vn',NULL),(54,'Phan Quế Thanh','2002-03-05','41 Tân Hải, P13, Tân Bình',0,'0722451702',9,'quethanh@ou.edu.vn',NULL),(55,'Phan Anh Thư','2002-04-06','31 Lê Lai, p14, Gò Vấp',0,'0211745022',9,'anhthu@ou.edu.vn',NULL),(56,'Nguyễn Trần Gia Hân','2002-06-07','421 Nguyễn Kiêm, P10, Gò Vấp',0,'0345052771',9,'giahan@ou.edu.vn',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES (52,'hoangan@gmail.com','123456',1,NULL),(53,'yenvi@gmail.com','123456',1,NULL),(54,'huuthanh@gmail.com','123456',2,NULL),(55,'giakhoang@gmail.com','123456',2,NULL);
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

-- Dump completed on 2023-09-25 23:28:54
