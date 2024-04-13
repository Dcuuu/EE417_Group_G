-- MySQL dump 10.13  Distrib 8.3.0, for Win64 (x86_64)
--
-- Host: localhost    Database: smartdcu
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `accesslogs`
--

DROP TABLE IF EXISTS `accesslogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accesslogs` (
  `log_id` int NOT NULL,
  `user_id` int DEFAULT NULL,
  `action` text,
  `timestamp` time(6) DEFAULT NULL,
  PRIMARY KEY (`log_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `accesslogs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `adminusers` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accesslogs`
--

LOCK TABLES `accesslogs` WRITE;
/*!40000 ALTER TABLE `accesslogs` DISABLE KEYS */;
INSERT INTO `accesslogs` VALUES (1,1,'login','19:09:04.000000'),(2,2,'update inventory','19:09:04.000000'),(3,3,'check occupancy','19:09:04.000000');
/*!40000 ALTER TABLE `accesslogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adminusers`
--

DROP TABLE IF EXISTS `adminusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adminusers` (
  `user_id` int NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `account_number` varchar(20) DEFAULT NULL COMMENT 'Job number or student number',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminusers`
--

LOCK TABLES `adminusers` WRITE;
/*!40000 ALTER TABLE `adminusers` DISABLE KEYS */;
INSERT INTO `adminusers` VALUES (1,'adminuser','5f4dcc3b5aa765d61d8327deb882cf99','admin','1234567890','admin@smartdcu.org','admin001'),(2,'libstaff','7c6a180b36896a0a8c02787eeafb0e4c','staff','0987654321','libstaff@smartdcu.org','staff001'),(3,'cafemanager','e99a18c428cb38d5f260853678922e03','manager','1122334455','cafe@smartdcu.org','cafe001'),(4,'admin','admin','admin','11111111111','admin@mail.com','admin002'),(5,'user','usertest','user','2222222222','user@mail.ie','user001');
/*!40000 ALTER TABLE `adminusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cafeteriamenu`
--

DROP TABLE IF EXISTS `cafeteriamenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cafeteriamenu` (
  `menu_id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `meal_time` varchar(50) DEFAULT NULL,
  `menu_items` text,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cafeteriamenu`
--

LOCK TABLES `cafeteriamenu` WRITE;
/*!40000 ALTER TABLE `cafeteriamenu` DISABLE KEYS */;
INSERT INTO `cafeteriamenu` VALUES (1,'2024-04-05','dinner2','pasta, salad, chicken sandwich'),(2,'2024-04-05','lunch','vegetarian wrap, sushi, fruit salad'),(3,'2024-03-03','lunch','pasta, salad, chicken sandwich'),(4,'2024-03-03','lunch','pasta, salad, chicken sandwich'),(5,'2024-03-03','lunch','pasta, salad, chicken sandwich'),(7,'2024-03-03','lunch','pasta, salad, chicken sandwich');
/*!40000 ALTER TABLE `cafeteriamenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cafeteriaoccupancy`
--

DROP TABLE IF EXISTS `cafeteriaoccupancy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cafeteriaoccupancy` (
  `record_id` int NOT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `current_occupancy` int DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cafeteriaoccupancy`
--

LOCK TABLES `cafeteriaoccupancy` WRITE;
/*!40000 ALTER TABLE `cafeteriaoccupancy` DISABLE KEYS */;
INSERT INTO `cafeteriaoccupancy` VALUES (1,'2024-04-05','12:00:00',80),(2,'2024-04-05','12:30:00',60),(3,'2024-04-05','11:00:00',30);
/*!40000 ALTER TABLE `cafeteriaoccupancy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classroomoccupancy`
--

DROP TABLE IF EXISTS `classroomoccupancy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classroomoccupancy` (
  `occupancy_id` int NOT NULL,
  `classroom_id` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `is_occupied` tinyint(1) DEFAULT NULL,
  `occupied` bit(1) NOT NULL,
  PRIMARY KEY (`occupancy_id`),
  KEY `classroom_id` (`classroom_id`),
  CONSTRAINT `classroomoccupancy_ibfk_1` FOREIGN KEY (`classroom_id`) REFERENCES `classrooms` (`classroom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroomoccupancy`
--

LOCK TABLES `classroomoccupancy` WRITE;
/*!40000 ALTER TABLE `classroomoccupancy` DISABLE KEYS */;
INSERT INTO `classroomoccupancy` VALUES (1,1,'2024-04-05','09:00:00',1,_binary '\0'),(2,2,'2024-04-05','10:00:00',0,_binary '\0'),(3,3,'2024-04-05','11:00:00',1,_binary '\0');
/*!40000 ALTER TABLE `classroomoccupancy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classrooms`
--

DROP TABLE IF EXISTS `classrooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classrooms` (
  `classroom_id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `capacity` int DEFAULT NULL,
  PRIMARY KEY (`classroom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classrooms`
--

LOCK TABLES `classrooms` WRITE;
/*!40000 ALTER TABLE `classrooms` DISABLE KEYS */;
INSERT INTO `classrooms` VALUES (1,'A103',42),(2,'B202',30),(3,'C303',50);
/*!40000 ALTER TABLE `classrooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libraryresources`
--

DROP TABLE IF EXISTS `libraryresources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libraryresources` (
  `resource_id` int NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `total` int DEFAULT NULL,
  `available` int DEFAULT NULL,
  `last_updated` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libraryresources`
--

LOCK TABLES `libraryresources` WRITE;
/*!40000 ALTER TABLE `libraryresources` DISABLE KEYS */;
INSERT INTO `libraryresources` VALUES (1,'book',300,280,'2024-04-11 18:09:04'),(2,'ebook',150,145,'2024-04-11 18:09:04'),(3,'magazine',50,45,'2024-04-11 18:09:04');
/*!40000 ALTER TABLE `libraryresources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libraryvisitors`
--

DROP TABLE IF EXISTS `libraryvisitors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libraryvisitors` (
  `visitor_id` int NOT NULL,
  `date` date DEFAULT NULL,
  `current_count` int DEFAULT NULL,
  PRIMARY KEY (`visitor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libraryvisitors`
--

LOCK TABLES `libraryvisitors` WRITE;
/*!40000 ALTER TABLE `libraryvisitors` DISABLE KEYS */;
INSERT INTO `libraryvisitors` VALUES (1,'2024-04-05',120),(2,'2024-04-04',95),(3,'2024-04-03',110),(4,'2024-04-05',180),(5,'2024-04-06',175),(6,'2024-04-07',165),(7,'2024-04-08',144),(8,'2024-04-09',183),(9,'2024-04-10',201),(10,'2024-04-11',204),(11,'2024-04-12',190);
/*!40000 ALTER TABLE `libraryvisitors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parkingspots`
--

DROP TABLE IF EXISTS `parkingspots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parkingspots` (
  `spot_id` int NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `last_updated` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`spot_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parkingspots`
--

LOCK TABLES `parkingspots` WRITE;
/*!40000 ALTER TABLE `parkingspots` DISABLE KEYS */;
INSERT INTO `parkingspots` VALUES (1,'level 1','occupied','2024-04-11 18:09:04'),(2,'level 1','free','2024-04-11 18:09:04'),(3,'level 1','occupied','2024-04-11 18:09:04'),(4,'level 1','free','2024-04-11 18:09:04');
/*!40000 ALTER TABLE `parkingspots` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-13  0:11:55
