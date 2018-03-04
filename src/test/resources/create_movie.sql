-- MySQL dump 10.13  Distrib 5.7.20, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: myMovies
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `poster_uri` varchar(255) NOT NULL,
  `thumb_uri` varchar(255) DEFAULT NULL,
  `desc_uri` varchar(255) DEFAULT NULL,
  `rating_uri` varchar(255) NOT NULL,
  `user_rating` int(11) DEFAULT NULL,
  `sort_key` varchar(255) DEFAULT NULL,
  `login_id` varchar(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `movie_id_uindex` (`id`),
  KEY `movie_user_id_fk` (`user_id`),
  CONSTRAINT `movie_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Jack Reacher','38bmEXmuJuInLs9dwfgOGCHmZ7l.jpg','test','test','test',5,'jackreacher','jfourie',3),(2,'War Games','rQocmooj7bFKS2vZfzWBB5O12eR.jpg','test','test','test',5,'wargames','jfourie',3),(3,'Blade Runner 2048','gajva2L0rPYkEWjzgFlBXCAVBE5.jpg','test','test','test',3,'bladerunner2048','jfourie',3),(4,'Blade Runner','p64TtbZGCElxQHpAMWmDHkWJlH2.jpg','test','test','test',3,'bladerunner','lfoxy',4),(5,'Abyss','kRP5dGXDhKt7bDpXX4YBa4dRwlL.jpg','test','test','test',3,'abyss','lfoxy',4),(6,'The Accountant','afhAUuWVB7k7PjJUd4lwO3rzhSq.jpg','test','test','test',4,'accountant','lfoxy',4),(7,'Atomic Blonde','kV9R5h0Yct1kR8Hf8sJ1nX0Vz4x.jpg','test','test','test',3,'atomicblonde','lfoxy',4),(8,'Ultimate Avengers','we6igIU5gXVwuSL6M6pJP75TwEf.jpg','test','test','test',3,'ultimateavengers','lfoxy',4),(9,'After Earth','d0vReo0jcMhBjCLYZAFqWHcb7Lj.jpg','test','test','test',3,'afterearth','lfoxy',4);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-04  9:34:20
