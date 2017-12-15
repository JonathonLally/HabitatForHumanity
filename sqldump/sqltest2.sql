-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: habitatsql
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `inv_id` int(11) NOT NULL AUTO_INCREMENT,
  `inv_type` varchar(45) DEFAULT NULL COMMENT 'TYPE of item : Door, Window, ect',
  `inv_picture` varchar(90) DEFAULT NULL COMMENT 'link to picture',
  `inv_dimensions` varchar(45) DEFAULT NULL COMMENT 'dimensions of item',
  `inv_date` datetime DEFAULT NULL COMMENT 'date added',
  `inv_price` varchar(45) DEFAULT NULL COMMENT 'price of item',
  `inv_description` varchar(45) DEFAULT NULL COMMENT 'short description',
  `inv_material` varchar(45) DEFAULT NULL COMMENT 'What it''s made of',
  PRIMARY KEY (`inv_id`),
  UNIQUE KEY `inv_id_UNIQUE` (`inv_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='Stores inventory of habitat humanity project';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (13,'Door','door.jpg','60\" x 12\"',NULL,'$30','A wooden door','Wood'),(16,'Door','door1.jpg','68\" x 120\"',NULL,'$80','Dual glass doors','Wood+Glass'),(17,'Door','door2.JPG','60\"x24\"',NULL,'$25','Interior Door','Wood'),(18,'Door','door3.jpg','80\" x 36\"',NULL,'$20','Discount door','Wood'),(19,'Door','door4.JPG','80\"x36\"',NULL,'$30','White wood door','Wood'),(20,'Door','door5.jpg','92\"x66\"',NULL,'$50','Old bank door','Metal + Wood'),(21,'Door','door6.jpg','80\"x36\"',NULL,'$40','Rustic cabin wood door','Wood'),(22,'Electrical','electical1.jpg','6 Guage',NULL,'$80','6 GA copper wire','Copper'),(23,'Electrical','electical2.jpg','6\"x2\"',NULL,'$5','Light switch','Plastic+Metal'),(24,'Furniture','furniture1.jpg','32\"x 80\"',NULL,'$60','Sofa','Wood'),(25,'Furniture','furniture2.jpg','48\"x 32\"',NULL,'$40','A nice chair','Wood'),(26,'Plumbing','	oilet1.jpg','48\"x32\"',NULL,'$100','A new white toilet','Poreclain'),(29,'Window','window1.jpg','80\"x48\"',NULL,'$40','New window','Glass'),(30,'Window','window2.jpg','62\"x48\"',NULL,'$40','Window','Glass'),(31,'Lighting','lights.jpg','12\"',NULL,'$15','Set of 6 lights','na'),(33,'Plumbing','pipe.jpg','6\"',NULL,'$5','PVC','PVC'),(34,'Hardware','hardware1.jpg','6\"',NULL,'$5','Hardware','Steel');
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_idnum` int(11) NOT NULL AUTO_INCREMENT COMMENT 'number of account starting at 1 increment',
  `user_name` varchar(45) NOT NULL COMMENT 'name for user account, used for login',
  `user_password` varchar(45) NOT NULL COMMENT 'password for account, used for login',
  `user_type` int(11) NOT NULL DEFAULT '1' COMMENT 'level of account 1 - customer, 2 - employee 3 - manager',
  PRIMARY KEY (`user_idnum`),
  UNIQUE KEY `user_idnum_UNIQUE` (`user_idnum`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='user list for habitat project';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'customer','password',1),(2,'employee','password',2),(3,'manager','password',3),(8,'usertest','hunter2',1),(9,'anothertest','pw',2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-13 15:16:04
