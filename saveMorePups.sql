-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: pups
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adopted_list`
--

DROP TABLE IF EXISTS `adopted_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `adopted_list` (
  `ADOPTED_ID` int(11) NOT NULL,
  `LIST_ID` int(11) NOT NULL,
  KEY `LIST_ID` (`LIST_ID`),
  KEY `ADOPTED_ID` (`ADOPTED_ID`),
  CONSTRAINT `adopted_list_ibfk_1` FOREIGN KEY (`LIST_ID`) REFERENCES `adoption_details` (`adoption_id`),
  CONSTRAINT `adopted_list_ibfk_2` FOREIGN KEY (`ADOPTED_ID`) REFERENCES `puppies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adopted_list`
--

LOCK TABLES `adopted_list` WRITE;
/*!40000 ALTER TABLE `adopted_list` DISABLE KEYS */;
INSERT INTO `adopted_list` VALUES (20,3);
/*!40000 ALTER TABLE `adopted_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adopter`
--

DROP TABLE IF EXISTS `adopter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `adopter` (
  `ADOPTER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ADOPTER_NAME` varchar(25) NOT NULL,
  PRIMARY KEY (`ADOPTER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adopter`
--

LOCK TABLES `adopter` WRITE;
/*!40000 ALTER TABLE `adopter` DISABLE KEYS */;
INSERT INTO `adopter` VALUES (1,'Don'),(2,'Lauren'),(3,'Lauren'),(4,'Lauren'),(5,'Lauren'),(6,'Lauren'),(7,'SVP');
/*!40000 ALTER TABLE `adopter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adoption_details`
--

DROP TABLE IF EXISTS `adoption_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `adoption_details` (
  `ADOPTION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `COORDINATOR_NAME` varchar(25) DEFAULT NULL,
  `ADOPTION_DATE` date DEFAULT NULL,
  `ADOPTER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ADOPTION_ID`),
  KEY `ADOPTER_ID` (`ADOPTER_ID`),
  CONSTRAINT `adoption_details_ibfk_1` FOREIGN KEY (`ADOPTER_ID`) REFERENCES `adopter` (`adopter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adoption_details`
--

LOCK TABLES `adoption_details` WRITE;
/*!40000 ALTER TABLE `adoption_details` DISABLE KEYS */;
INSERT INTO `adoption_details` VALUES (1,'Lauren\'s Adoption','2019-02-20',4),(2,'Lauren\'s Adoption','2019-02-20',6),(3,'SVP\'s Adoption','2019-02-20',7);
/*!40000 ALTER TABLE `adoption_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puppies`
--

DROP TABLE IF EXISTS `puppies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `puppies` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(12) NOT NULL,
  `FAVTOY` varchar(12) NOT NULL,
  `STATUS` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puppies`
--

LOCK TABLES `puppies` WRITE;
/*!40000 ALTER TABLE `puppies` DISABLE KEYS */;
INSERT INTO `puppies` VALUES (1,'Penny','ball','Resident'),(2,'Ivy','mooser','Adopted'),(3,'Rae','tissue box','Adopted'),(4,'Scarlet','hedgey','Adopted'),(20,'Otis','Kong','Adopted');
/*!40000 ALTER TABLE `puppies` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-21  1:18:04
