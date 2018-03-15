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
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Jack Reacher','38bmEXmuJuInLs9dwfgOGCHmZ7l.jpg','test','test','test',5,'jackreacher','jfourie',3),(2,'War Games','rQocmooj7bFKS2vZfzWBB5O12eR.jpg','test','test','test',5,'wargames','jfourie',3),(3,'Blade Runner 2048','gajva2L0rPYkEWjzgFlBXCAVBE5.jpg','test','test','test',3,'bladerunner2048','jfourie',3),(4,'Blade Runner','p64TtbZGCElxQHpAMWmDHkWJlH2.jpg','test','test','test',3,'bladerunner','lfoxy',4),(5,'Abyss','kRP5dGXDhKt7bDpXX4YBa4dRwlL.jpg','test','test','test',3,'abyss','lfoxy',4),(6,'The Accountant','afhAUuWVB7k7PjJUd4lwO3rzhSq.jpg','test','test','test',4,'accountant','lfoxy',4),(7,'Atomic Blonde','kV9R5h0Yct1kR8Hf8sJ1nX0Vz4x.jpg','test','test','test',3,'atomicblonde','lfoxy',4),(8,'Ultimate Avengers','we6igIU5gXVwuSL6M6pJP75TwEf.jpg','test','test','test',3,'ultimateavengers','lfoxy',4),(9,'After Earth','d0vReo0jcMhBjCLYZAFqWHcb7Lj.jpg','test','test','test',3,'afterearth','lfoxy',4),(10,'Blade','r0RQ9ZOEZglLOeYDNJTehVTRoR6.jpg','test','test','test',4,'blade','lfoxy',4),(11,'Blade II','jlURNpXCMK830CsGRd939PJLh8c.jpg','test','test','test',2,'bladeii','lfoxy',4),(12,'Blade of the Imortal','bFaxg006Dt6J1k7qa7a5YuqbAhe.jpg','test','test','test',2,'bladeofhteimortal','lfoxy',4),(13,'Dragon Blade','3gl11EsZS5vboQvvMYeCIzitaJz.jpg','test','test','test',1,'dragonblade','lfoxy',4),(14,'The Fate of the Furious','dImWM7GJqryWJO9LHa3XQ8DD5NH.jpg','test','test','test',1,'fateofthefurious','lfoxy',4),(15,'Fast Food Nation','s13uyUCCYs7zKj4MqsAPdK0lN4X.jpg','test','test','test',3,'fastfoodnation','lfoxy',4),(16,'Fast Times at Ridgemont High','9y5rSeO0xH3m5oRJmhBusDkiS0j.jpg','test','test','test',3,'fasttimesatridgemonthigh','lfoxy',4),(17,'Bandits','3wTzOr0CekiBJZL7ZiNE2y2H16N.jpg','test','test','test',3,'bandits','lfoxy',4),(18,'Bandidas','6WnSdouYhXDowg9NrKY2fSV5o1W.jpg','test','test','test',3,'bandidas','lfoxy',4),(19,'B. Monkey','owKZAo5QxyulBwMvHqKn4a2abNc.jpg','test','test','test',3,'bmonkey','lfoxy',4),(20,'Band Aid','lcxx0vN0hhQi7KFpRaJlxAaLLhR.jpg','test','test','test',3,'bandaid','lfoxy',4),(21,'B','bvpfVMt0MRSXNXcycxOGiHQMevk.jpg','test','test','test',3,'b','lfoxy',4),(22,'The Back-Up Plan','1Ig6ZQpLZfLsdvMLHD0inc2w0HB.jpg','test','test','test',3,'backupplan','lfoxy',4),(23,'B-Day','cDgrrQnCmC6kqUGaFZmK7DmsE7.jpg','test','test','test',3,'bday','lfoxy',4),(24,'Bandolero!','kmqy27Mk8zT0viBTZkqemkSZInQ.jpg','test','test','test',3,'bandolero','lfoxy',4),(25,'Be Afraid','ytkaL1wZcqgQKHLuU7Go3UxGpON.jpg','test','test','test',3,'beafraid','lfoxy',4),(26,'Be Cool','ekKCH7Zkb5ZTr1f1AczZY23FH.jpg','test','test','test',3,'becool','lfoxy',4),(27,'Be Somebody','igRnsNTGOLwnCIn0gnSnAQ95qx0.jpg','test','test','test',3,'besomebody','lfoxy',4),(28,'Be With You','sEeH8ce2YeZHFng3AddqsQ2niLf.jpg','test','test','test',3,'bewithyou','lfoxy',4),(29,'Be Kind Rewind','f0oX20YrQEiVPDH9InCQ1d3Cm66.jpg','test','test','test',3,'bekindrewind','lfoxy',4),(30,'Born To Be Blue','iEdh2CkSyDXBTAPlNS6uLF9yTTH.jpg','test','test','test',3,'borntobeblue','lfoxy',4),(31,'10','u8QzBwoCrCkXZUZr9pFTcRIVMxc.jpg','test','test','test',3,'10','lfoxy',4),(32,'Cars 2','AblhtULOVtrkSnFxRPQ8gBemxw9.jpg','test','test','test',3,'cars2','lfoxy',4),(33,'Iron Man 2','ArqpkNYGfcTIA6umWt6xihfIZZv.jpg','test','test','test',3,'ironman2','lfoxy',4),(34,'20,000 Leagues Under the Sea','yhoL2CxBp9IwMhHrCj6FIb2lrYR.jpg','test','test','test',3,'20000leaguesunderthesea','lfoxy',4);
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

-- Dump completed on 2018-03-10 11:59:48
