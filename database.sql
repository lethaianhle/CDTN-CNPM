-- MySQL dump 10.13  Distrib 5.7.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: demo
-- ------------------------------------------------------
-- Server version	5.7.34-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `combo`
--

DROP TABLE IF EXISTS `combo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `combo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `discount_percent` double NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `price_after_discount` double NOT NULL,
  `total_price` double NOT NULL,
  `image` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `combo`
--

LOCK TABLES `combo` WRITE;
/*!40000 ALTER TABLE `combo` DISABLE KEYS */;
INSERT INTO `combo` VALUES (2,'Dành cho 02 người: 01 Pizza Bò, 01 Mỳ Ý Spaghetti + 02 Lon Coca Cola/Trà Sữa.',10,'Thêm bạn thêm ngon',144000,160000,'no images');
/*!40000 ALTER TABLE `combo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `combo_thucdon`
--

DROP TABLE IF EXISTS `combo_thucdon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `combo_thucdon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `combo_id` bigint(20) DEFAULT NULL,
  `thuc_don_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `combo_thucdon`
--

LOCK TABLES `combo_thucdon` WRITE;
/*!40000 ALTER TABLE `combo_thucdon` DISABLE KEYS */;
INSERT INTO `combo_thucdon` VALUES (4,2,3),(5,2,9),(6,2,5);
/*!40000 ALTER TABLE `combo_thucdon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhom`
--

DROP TABLE IF EXISTS `nhom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nhom` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhom`
--

LOCK TABLES `nhom` WRITE;
/*!40000 ALTER TABLE `nhom` DISABLE KEYS */;
INSERT INTO `nhom` VALUES (1,'Mỳ Ý'),(2,'Pizza'),(3,'Nước Uống');
/*!40000 ALTER TABLE `nhom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuc_don`
--

DROP TABLE IF EXISTS `thuc_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thuc_don` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `discount_percent` double NOT NULL,
  `image` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `nhom_id` bigint(20) DEFAULT NULL,
  `price` double NOT NULL,
  `price_after_discount` double NOT NULL,
  `status` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuc_don`
--

LOCK TABLES `thuc_don` WRITE;
/*!40000 ALTER TABLE `thuc_don` DISABLE KEYS */;
INSERT INTO `thuc_don` VALUES (1,'Pizza hải sản phô mai là một món nướng với sự kết hợp hài hoà giữa vị tươi ngon của hải sản và vị thơm béo từ phô mai tạo nên vị ngon khó cưỡng, chắc chắn sẽ khiến bạn thích mê.',0,'no images','Pizza Hải Sản',2,65000,65000,'Available'),(3,'Nếu bạn là fan cuồng nhiệt của những chiếc pizza bò băm béo ngậy vị phô mai và thịt, lại xen thêm vị ngọt thơm của dứa hãy mua chiếc bánh thơm ngon này.',10,'no images','Pizza Bò',2,85000,76500,'Available'),(4,'Thành phần: Thịt gà xay, nấm, hành tây, sốt BBQ, pho mai.',5,'no images','BBQ Chicken Pizza',2,90000,85500,'Available'),(5,'Coca-Cola là một thương hiệu nước ngọt có ga chứa nước cacbon dioxide bão hòa được sản xuất bởi Công ty Coca-Cola.',0,'no images','Coca Cola',3,10000,10000,'Available'),(6,'Sản phẩm nước tăng lực với mùi vị thơm ngon, sảng khoái, bổ sung hồng sâm chất lượng. Sting giúp cơ thể bù đắp nước, bổ sung năng lượng, vitamin C và E.',0,'no images','Sting Đỏ',3,10000,10000,'Available'),(7,'Trà sữa trân châu hay trà sữa Đài Loan là thức uống được chế biến từ trà xanh hoặc trà đen được các cửa hàng đồ uống tại Đài Trung, Đài Loan phát triển từ những năm 1980.',15,'no images','Trà Sữa Trân Châu',3,30000,10000,'Available'),(8,'Mì Ý ăn kèm với sốt Bolognese không chỉ tạo nên sự kết hợp vô cùng hoàn hảo mà còn là món ăn cực kì dễ làm.',10,'no images','Mì Ý Bolognese',1,45000,40500,'Ngừng phục vụ'),(9,'Spaghetti, hay thường được gọi là mì Ý, là một loại pasta sợi dài, nhỏ, hình trụ. Nó là một loại thực phẩm thiết yếu của nền ẩm thực Ý truyền thống.',0,'no images','Mỳ Ý Spaghetti',3,65000,40500,'Available');
/*!40000 ALTER TABLE `thuc_don` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `bod` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Kim Quan, Thạch Thất, Hà Nội','26/12/2000','Lê Thái Anh','0979842998',1,'lethaianh@gmail.com','123456'),(2,'Quận 7, Thủ Đức, HCM','12/12/1999','Nguyễn Thế Thành','01645333628',1,'thanhnguyen@gmail.com','123456'),(3,'Administrator','08/10/1997','Admin','0383838888',0,'admin@gmail.com','123456');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-24 17:28:39
