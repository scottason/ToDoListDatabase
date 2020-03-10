-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: cis175.ckt4e0simkcl.us-east-2.rds.amazonaws.com    Database: TODOLIST
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `TASKS`
--

DROP TABLE IF EXISTS `TASKS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TASKS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TASK_DESCRIPTION` varchar(280) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `TASK_DUE_DATE` date DEFAULT NULL,
  `TASK_COMPLETED` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `TASK_LIST_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `TASK_LIST_ID_idx` (`TASK_LIST_ID`),
  CONSTRAINT `TASK_LIST_ID` FOREIGN KEY (`TASK_LIST_ID`) REFERENCES `TASK_LISTS` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TASKS`
--

LOCK TABLES `TASKS` WRITE;
/*!40000 ALTER TABLE `TASKS` DISABLE KEYS */;
INSERT INTO `TASKS` VALUES (72,'Java II','2020-03-05','\0',71),(73,'Finish JavaScript','2020-03-16','\0',71),(74,'Python','2020-03-11','\0',71),(75,'Pick up formula','2020-03-16','\0',72),(76,'Getting Groceries','2020-03-10','\0',72),(77,'Deposit Check','2020-04-01','\0',72),(78,'Work project','2020-03-31','\0',73),(79,'Math homework','9999-12-31','\0',73),(80,'Clean house','2020-03-11','\0',73),(92,'Test task 16','2020-05-01','\0',77),(93,'Test task 15','2099-09-30','\0',77),(94,'Test task 10','2050-03-31','Y',77),(95,'database','2020-03-10','\0',78),(96,'c++','2020-03-09','\0',78),(97,'javaII','2020-03-10','Y',78);
/*!40000 ALTER TABLE `TASKS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TASK_LISTS`
--

DROP TABLE IF EXISTS `TASK_LISTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TASK_LISTS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TASK_LIST_NAME` varchar(280) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TASK_LISTS`
--

LOCK TABLES `TASK_LISTS` WRITE;
/*!40000 ALTER TABLE `TASK_LISTS` DISABLE KEYS */;
INSERT INTO `TASK_LISTS` VALUES (71,'Work and Homework'),(72,'Errands'),(73,'Greg\'s test list 1'),(77,'Greg\'s Test list #3'),(78,'Scott');
/*!40000 ALTER TABLE `TASK_LISTS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-09 20:26:03
