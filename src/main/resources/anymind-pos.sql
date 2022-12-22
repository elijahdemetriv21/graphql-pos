CREATE DATABASE  IF NOT EXISTS `anymind` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `anymind`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: anymind
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
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `payment_method_cd` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `price_modifier` float NOT NULL,
  `final_price` float NOT NULL,
  `points` float NOT NULL,
  `date_time` datetime NOT NULL,
  `additional_item_type` varchar(45) DEFAULT NULL,
  `additional_item_description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (52,1,'CASH',100,1,100,5,'2022-01-01 05:00:00',NULL,NULL),(53,2,'CASH_ON_DELIVERY',120.5,1.01,121.7,6.02,'2022-01-01 05:20:00',NULL,NULL),(54,3,'VISA',50,0.95,47.5,1.5,'2022-01-01 05:40:00','last4','4444'),(55,4,'MASTERCARD',75,1,75,2.25,'2022-01-01 06:30:00','last4','3333'),(56,5,'AMEX',100.5,1,100.5,2.01,'2022-01-01 06:40:00','last4','2222'),(57,6,'JCB',100,0.96,96,5,'2022-01-01 07:00:00','last4','1111'),(58,7,'LINE PAY',120,1,120,1.19,'2022-01-02 03:00:00',NULL,NULL),(59,8,'PAYPAY',130,1,130,1.3,'2022-01-03 03:00:00',NULL,NULL),(60,9,'POINTS',80,1,80,0,'2022-01-03 04:30:00',NULL,NULL),(61,10,'GRAB PAY',99,1,99,0.98,'2022-01-03 04:35:00',NULL,NULL),(62,11,'BANK TRANSFER',160,1,160,0,'2022-01-03 04:35:00','accountInfo','BANK_123456789'),(63,12,'CHEQUE',150,0.9,135,0,'2022-01-04 04:30:00','accountInfo','CHEQUE_1111111111');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_method`
--

DROP TABLE IF EXISTS `payment_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_method` (
  `payment_method_cd` varchar(45) NOT NULL,
  `points_modifier` float NOT NULL,
  `min_price_modifier` float NOT NULL,
  `max_price_modifier` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_method`
--

LOCK TABLES `payment_method` WRITE;
/*!40000 ALTER TABLE `payment_method` DISABLE KEYS */;
INSERT INTO `payment_method` VALUES ('CASH',0.05,0.9,1),('CASH_ON_DELIVERY',0.05,1,1.02),('VISA',0.03,0.95,1),('MASTERCARD',0.03,0.95,1),('AMEX',0.02,0.98,1.01),('JCB',0.05,0.95,1),('LINE PAY',0.01,1,1),('PAYPAY',0.01,1,1),('POINTS',0,1,1),('GRAB PAY',0.01,1,1),('BANK TRANSFER',0,1,1),('CHEQUE',0,0.09,1);
/*!40000 ALTER TABLE `payment_method` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-22 19:11:23
