-- MySQL dump 10.13  Distrib 5.7.20, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: test_myMovies
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
-- Table structure for table `metadata_tmdb`
--

DROP TABLE IF EXISTS `metadata_tmdb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metadata_tmdb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `base_url` varchar(255) NOT NULL,
  `logo_size` varchar(255) NOT NULL,
  `backdrop_size` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tmdb_metadata_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metadata_tmdb`
--

LOCK TABLES `metadata_tmdb` WRITE;
/*!40000 ALTER TABLE `metadata_tmdb` DISABLE KEYS */;
INSERT INTO `metadata_tmdb` VALUES (1,'http://image.tmdb.org/t/p/','w92','w300');
/*!40000 ALTER TABLE `metadata_tmdb` ENABLE KEYS */;
UNLOCK TABLES;

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
  `tmdb_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `movie_id_uindex` (`id`),
  KEY `movie_user_id_fk` (`user_id`),
  CONSTRAINT `movie_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Jack Reacher','38bmEXmuJuInLs9dwfgOGCHmZ7l.jpg','test','test','test',5,'jackreacher','jfourie',3,75780),(2,'War Games','rQocmooj7bFKS2vZfzWBB5O12eR.jpg','test','test','test',5,'wargames','jfourie',3,860),(3,'Blade Runner 2048','gajva2L0rPYkEWjzgFlBXCAVBE5.jpg','test','test','test',3,'bladerunner2048','jfourie',3,335984),(4,'Blade Runner','p64TtbZGCElxQHpAMWmDHkWJlH2.jpg','test','test','test',3,'bladerunner','lfoxy',4,78),(5,'Abyss','kRP5dGXDhKt7bDpXX4YBa4dRwlL.jpg','test','test','test',3,'abyss','lfoxy',4,2756),(6,'The Accountant','afhAUuWVB7k7PjJUd4lwO3rzhSq.jpg','test','test','test',4,'accountant','lfoxy',4,302946),(7,'Atomic Blonde','kV9R5h0Yct1kR8Hf8sJ1nX0Vz4x.jpg','test','test','test',3,'atomicblonde','lfoxy',4,341013),(8,'Ultimate Avengers','we6igIU5gXVwuSL6M6pJP75TwEf.jpg','test','test','test',3,'ultimateavengers','lfoxy',4,14609),(9,'After Earth','d0vReo0jcMhBjCLYZAFqWHcb7Lj.jpg','test','test','test',3,'afterearth','lfoxy',4,82700),(10,'Blade','r0RQ9ZOEZglLOeYDNJTehVTRoR6.jpg','test','test','test',4,'blade','lfoxy',4,36647),(11,'Blade II','jlURNpXCMK830CsGRd939PJLh8c.jpg','test','test','test',2,'bladeii','lfoxy',4,436586),(12,'Blade of the Imortal','bFaxg006Dt6J1k7qa7a5YuqbAhe.jpg','test','test','test',2,'bladeofhteimortal','lfoxy',4,426284),(13,'Dragon Blade','3gl11EsZS5vboQvvMYeCIzitaJz.jpg','test','test','test',1,'dragonblade','lfoxy',4,300168),(14,'The Fate of the Furious','dImWM7GJqryWJO9LHa3XQ8DD5NH.jpg','test','test','test',1,'fateofthefurious','lfoxy',4,337339),(15,'Fast Food Nation','s13uyUCCYs7zKj4MqsAPdK0lN4X.jpg','test','test','test',3,'fastfoodnation','lfoxy',4,8324),(16,'Fast Times at Ridgemont High','9y5rSeO0xH3m5oRJmhBusDkiS0j.jpg','test','test','test',3,'fasttimesatridgemonthigh','lfoxy',4,13342),(17,'Bandits','3wTzOr0CekiBJZL7ZiNE2y2H16N.jpg','test','test','test',3,'bandits','lfoxy',4,3172),(18,'Bandidas','6WnSdouYhXDowg9NrKY2fSV5o1W.jpg','test','test','test',3,'bandidas','lfoxy',4,1969),(19,'B. Monkey','owKZAo5QxyulBwMvHqKn4a2abNc.jpg','test','test','test',3,'bmonkey','lfoxy',4,2923),(20,'Band Aid','lcxx0vN0hhQi7KFpRaJlxAaLLhR.jpg','test','test','test',3,'bandaid','lfoxy',4,426230),(21,'B','bvpfVMt0MRSXNXcycxOGiHQMevk.jpg','test','test','test',3,'b','lfoxy',4,346352),(22,'The Back-Up Plan','1Ig6ZQpLZfLsdvMLHD0inc2w0HB.jpg','test','test','test',3,'backupplan','lfoxy',4,34806),(23,'B-Day','cDgrrQnCmC6kqUGaFZmK7DmsE7.jpg','test','test','test',3,'bday','lfoxy',4,471970),(24,'Bandolero!','kmqy27Mk8zT0viBTZkqemkSZInQ.jpg','test','test','test',3,'bandolero','lfoxy',4,41857),(25,'Be Afraid','ytkaL1wZcqgQKHLuU7Go3UxGpON.jpg','test','test','test',3,'beafraid','lfoxy',4,448252);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(25) NOT NULL,
  `login_id` varchar(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id_uindex` (`id`),
  KEY `role_user_id_fk` (`user_id`),
  CONSTRAINT `role_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','badadmin',1),(2,'admin','jfourieadmin',2),(3,'regular','jfourie',3),(4,'regular','lfoxy',4),(5,'regular','baduser',5),(6,'regular','pwaite',6),(7,'admin','pwaiteadmin',7);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_id` varchar(20) NOT NULL COMMENT 'This is the user id the user uses to log into the system.',
  `user_password` varchar(20) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `admin` tinyint(1) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `date_active` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'badadmin','ssecrett','Bad','Admin',1,0,'2018-01-01'),(2,'jfourieadmin','ssecrett','Jacques','Fourie',1,1,'2018-01-02'),(3,'jfourie','ssecrett','Jacques','Fourie',0,1,'2018-01-02'),(4,'lfoxy','ssecrett','Lucy','Foxy',0,1,'2018-02-10'),(5,'baduser','ssecrett','Bad','User',0,0,'2018-02-10'),(6,'pwaite','ssecrett','Paula','Waite',0,1,'2018-03-15'),(7,'pwaiteadmin','ssecrett','Paula','Waite',1,1,'2018-03-15'),(9,'ppan','secret','Peter','Pan',1,1,'2018-01-20');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viewing_habit`
--

DROP TABLE IF EXISTS `viewing_habit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viewing_habit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id` int(11) DEFAULT NULL,
  `date_watched` date DEFAULT NULL,
  `temp` int(11) DEFAULT NULL,
  `weather_sunny` tinyint(1) DEFAULT NULL,
  `weather_rainy` tinyint(1) DEFAULT NULL,
  `weather_foggy` tinyint(1) DEFAULT NULL,
  `weather_snowy` tinyint(1) DEFAULT NULL,
  `weather_hail` tinyint(1) DEFAULT NULL,
  `weather_thunder` tinyint(1) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `viewing_habit_id_uindex` (`id`),
  KEY `viewing_habit_user_id_fk` (`user_id`),
  CONSTRAINT `viewing_habit_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viewing_habit`
--

LOCK TABLES `viewing_habit` WRITE;
/*!40000 ALTER TABLE `viewing_habit` DISABLE KEYS */;
INSERT INTO `viewing_habit` VALUES (1,1,'2018-01-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,3),(2,1,'2018-02-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,3),(3,2,'2018-03-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,4),(4,3,'2018-04-01',NULL,NULL,NULL,NULL,NULL,NULL,NULL,4);
/*!40000 ALTER TABLE `viewing_habit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-16 19:00:16
