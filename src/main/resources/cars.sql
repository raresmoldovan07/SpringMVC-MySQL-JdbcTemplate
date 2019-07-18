-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: my_database
-- ------------------------------------------------------
-- Server version	8.0.16

 SET NAMES utf8 ;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cars` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `car_brand` varchar(45) NOT NULL,
  `car_model` varchar(45) NOT NULL,
  `car_year` int(11) NOT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
INSERT INTO `cars` VALUES (1,'Mercedes','C63',2018),(2,'BMW','M850i',2019),(3,'Audi','RS6',2017),
                          (4,'Mercedes','S63-AMG',2019),(5,'Volkswagen','Arteon',2018);
UNLOCK TABLES;

-- Dump completed on 2019-07-18 16:24:12
