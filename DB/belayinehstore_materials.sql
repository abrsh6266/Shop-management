CREATE DATABASE  IF NOT EXISTS `belayinehstore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `belayinehstore`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: belayinehstore
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `materials`
--

DROP TABLE IF EXISTS `materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materials` (
  `materialname` varchar(50) NOT NULL,
  `price` float NOT NULL,
  `quantity` int NOT NULL,
  `category` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`materialname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` VALUES (' sumsung A13',20000,10,'Mobile'),('bale 10',10,1000,'Card'),('bale 15',15,1000,'Card'),('bale 25',25,600,'Card'),('bale 5',5,2000,'Card'),('bale 50',50,100,'Card'),('itel 2180',800,20,'Mobile'),('LEG M18',1400,5,'Receiver'),('m12',13000,8,'Mobile'),('mini divider',50,80,'Divider'),('mx',400,17,'Radio'),('mxx',400,18,'Radio'),('tecno 470',700,20,'Mobile'),('tecno chrger',50,100,'Charger');
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-19  8:02:50
