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
  `movie_state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `movie_id_uindex` (`id`),
  KEY `movie_user_id_fk` (`user_id`),
  CONSTRAINT `movie_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2053 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (2,'War Games','/rQocmooj7bFKS2vZfzWBB5O12eR.jpg','test','test','test',5,'wargames','jfourie',3,860,'IC'),(3,'Blade Runner 2048','/gajva2L0rPYkEWjzgFlBXCAVBE5.jpg','test','test','test',5,'bladerunner2048','jfourie',3,335984,'IC'),(538,'TRON: Legacy','/vllvystwQjmXzy5OvBKnGl1JREF.jpg','test','test','test',0,'tron:legacy','jfourie',3,20526,'IC'),(557,'First Blood','/bbYNNEGLXrV3lJpHDg7CKaPscCb.jpg','test','test','test',0,'firstblood','jfourie',3,1368,'IC'),(559,'Captain America: The First Avenger','/vSNxAJTlD0r02V9sPYpOjqDZXUK.jpg','test','test','test',0,'captainamerica:thefirstavenger','jfourie',3,1771,'IC'),(561,'First Daughter','/qo1ZnZfbf77FYAGPp1fIx50BPUc.jpg','test','test','test',0,'firstdaughter','jfourie',3,13969,'IC'),(563,'Star Trek: First Contact','/qhVB8eUGwkdVvd8Fezk0AgcMPDH.jpg','test','test','test',0,'startrek:firstcontact','jfourie',3,199,'IC'),(566,'The First Purge','/e6i3n5qb2wd72kXeS6N6vriYPA2.jpg','test','test','test',0,'firstpurge','jfourie',3,442249,'IC'),(568,'First Snow','/1POL9zH0IXbwyspitpXMVvI8i2R.jpg','test','test','test',0,'firstsnow','jfourie',3,16083,'IC'),(570,'Rambo: First Blood Part II','/l6zUaYqaQ5TFokesv3BPzBvSN0.jpg','test','test','test',0,'rambo:firstbloodpartii','jfourie',3,1369,'IC'),(577,'Fantasia 2000','/5rwAtUaKEK48CPUijVfVU0IPKPZ.jpg','test','test','test',0,'fantasia2000','jfourie',3,49948,'IC'),(589,'April 1, 2000','/4Y2dg7Pb60zUI90EYuOe87Vg9RA.jpg','test','test','test',0,'april1,2000','jfourie',3,30024,'IC'),(597,'2001: A Space Odyssey','/90T7b2LIrL07ndYQBmSm09yqVEH.jpg','test','test','test',5,'2001:aspaceodyssey','jfourie',3,62,'IC'),(599,'2001: A Space Travesty','/t3FxuhWeyo0U4QhQIovuwy22WLo.jpg','test','test','test',2,'2001:aspacetravesty','jfourie',3,7290,'IC'),(617,'2010','/9Rcz2n16HEYRi2EKGliByP6ESYR.jpg','test','test','test',5,'2010','jfourie',3,4437,'IC'),(628,'Knight Rider 2010','/ePmPfGq4kLqdffvKB6Y1VHJgsPA.jpg','test','test','test',0,'knightrider2010','jfourie',3,44829,'IC'),(635,'Wartorn: 1861-2010','/iavoz5Shuna0ffJtXlBGF84IzyE.jpg','test','test','test',0,'wartorn:1861-2010','jfourie',3,49542,'IC'),(641,'Brain on Fire','/q6ccPYj1eWoNaEDWi7ALCKqOPv5.jpg','test','test','test',0,'brainonfire','jfourie',3,340027,'IC'),(655,'Brain Twisters','/kSnNDD87GrlCRogDyj04t1fmoCO.jpg','test','test','test',1,'braintwisters','jfourie',3,81425,'IC'),(661,'April Rain','/8DVTuPHPv9BemELX1SKhAaYG9Yw.jpg','test','test','test',0,'aprilrain','jfourie',3,268823,'IC'),(677,'Ben-Hur','/syPMBvvZsADTTRu3UKuxO1Wflq.jpg','test','test','test',3,'ben-hur','jfourie',3,665,'IC'),(697,'Over the Hedge','/fGvoD6n6blbFprgbl3BJ2U8YHSF.jpg','test','test','test',0,'overthehedge','jfourie',3,7518,'IC'),(699,'Crossing Over','/hxclf9r06O2e842r6lwnJ4qn5AG.jpg','test','test','test',0,'crossingover','jfourie',3,15577,'IC'),(704,'Over','/tAzbYC9ZILyuiXKdDrhiyN9v9vF.jpg','test','test','test',0,'over','jfourie',3,365932,'IC'),(705,'Over the Top','/cOqpo9vsrhLyAA0aSv5VCOZQaBG.jpg','test','test','test',2,'overthetop','jfourie',3,1825,'IC'),(710,'OVER DRIVE','/zfRUs3oCZemD8dLXzHyGXnqphJd.jpg','test','test','test',0,'overdrive','jfourie',3,517380,'IC'),(711,'Head Over Heels','/wM6Lnc2qYzyh3WjwZ3Hu3TM9qNl.jpg','test','test','test',0,'headoverheels','jfourie',3,24940,'IC'),(717,'Mystic River','/qeHasONCKH5sR9HcTWquXI5ZN5y.jpg','test','test','test',4,'mysticriver','jfourie',3,322,'IC'),(735,'Who Is Julia?','/oTvzHTKgj6iEUtDw9rTTfpNaq7K.jpg','test','test','test',0,'whoisjulia?','jfourie',3,435610,'IC'),(738,'300','/bYR8O1H1ZlME7Dm9ysfTYZnRDpw.jpg','test','test','test',5,'300','jfourie',3,1271,'IC'),(753,'Swing Vote','/rdFvFBm7POklOuXnnM8cMVHgpH5.jpg','test','test','test',0,'swingvote','jfourie',3,10187,'IC'),(757,'At Any Price','/9gUTJ5dM2T7rfTXzMDI4naIglWk.jpg','test','test','test',2,'atanyprice','jfourie',3,121789,'IC'),(763,'Knock on Any Door','/c90qKTetStCpZHP3UvkaPdp6q6s.jpg','test','test','test',0,'knockonanydoor','jfourie',3,41214,'IC'),(767,'Success At Any Price','/nLguw6khLJ0ym0j6UZlSZsl1xH5.jpg','test','test','test',0,'successatanyprice','jfourie',3,236395,'IC'),(769,'Any Old Port!','/i4XEtvT4STBYAshgHyEnHJEQKZS.jpg','test','test','test',0,'anyoldport!','jfourie',3,44891,'IC'),(775,'Die Another Day','/1iUZqUXS7x5FcGM5J0u01xuObWC.jpg','test','test','test',0,'dieanotherday','jfourie',3,36669,'IC'),(777,'Another 48 Hrs.','/cIk8Hag7uHVhLMyaCHJpA0jwI2z.jpg','test','test','test',2,'another48hrs.','jfourie',3,11595,'IC'),(784,'Another Gantz','/3uuKtxp3lFySHkGdnkFxeeO68VH.jpg','test','test','test',0,'anothergantz','jfourie',3,244478,'IC'),(793,'Another Day in Paradise','/hDv9bepgQGSWoyhRUgegSzPL7tL.jpg','test','test','test',0,'anotherdayinparadise','jfourie',3,36136,'IC'),(795,'Anaconda','/yGku6UoX3MKbjnVbcUtrJcyghyi.jpg','test','test','test',3,'anaconda','jfourie',3,9360,'IC'),(811,'A Bug\'s Life','/u9qGMRwcPwP0WETxulS5hKUsEum.jpg','test','test','test',4,'bug\'slife','jfourie',3,9487,'IC'),(813,'A Ghost Story','/ydENrBUenr4khaP6tj4JZn1CpMs.jpg','test','test','test',1,'ghoststory','jfourie',3,428449,'IC'),(816,'A Clockwork Orange','/kgAi87gyx6b4oGJYSC36tVkJyJu.jpg','test','test','test',5,'clockworkorange','jfourie',3,185,'IC'),(817,'A Beautiful Mind','/4SFqHDZ1NvWdysucWbgnYlobdxC.jpg','test','test','test',4,'beautifulmind','jfourie',3,453,'IC'),(823,'A Walk to Remember','/kso0otMalKy9qSEdrzYP7Bc3Rjg.jpg','test','test','test',0,'walktoremember','jfourie',3,10229,'IC'),(826,'Memoirs of a Geisha','/rhqL5iuhfwtDnpwMYAY2iuNZbxo.jpg','test','test','test',0,'memoirsofageisha','jfourie',3,1904,'IC'),(829,'A Good Wife','/waiO6TCyMIiTFtmp1tE0eTjEjpi.jpg','test','test','test',0,'goodwife','jfourie',3,371459,'IC'),(830,'The Woman with a Broken Nose','/k9lgNmq8yegB5a0qSlb2KJLhVxJ.jpg','test','test','test',0,'thewomanwithabrokennose','jfourie',3,70745,'IC'),(832,'The Third Woman','/ukYDzha5NHlE8bkt8veixzWqpYb.jpg','test','test','test',0,'thirdwoman','jfourie',3,508998,'IC'),(833,'Village Without Women','/2RT59tA9hKxgaJw9VSa5ujWMA2i.jpg','test','test','test',3,'villagewithoutwomen','jfourie',3,262643,'IC'),(835,'What Will My Wife Say to This?','/1aR7QYhYL0cuu8kyvFGAVYQmPQu.jpg','test','test','test',0,'whatwillmywifesaytothis?','jfourie',3,465054,'IC'),(837,'Catwoman','/3E1XPZ2lZmL4lJV1KSUi1jaSx3w.jpg','test','test','test',0,'catwoman','jfourie',3,314,'IC'),(838,'Outrage','/fmlSL6qwOQT2AHaFbn8bHFHCaQm.jpg','test','test','test',0,'outrage','jfourie',3,45301,'IC'),(839,'The Woman in Black','/y4Z9m5jbPhFAEMWsMHo71Bh1vzi.jpg','test','test','test',0,'womaninblack','jfourie',3,65086,'IC'),(840,'All of Me','/k6z49N7FL8jlY0IG14wMmlOZFxa.jpg','test','test','test',3,'allofme','jfourie',3,10631,'IC'),(842,'Easy Virtue','/blrQSfCOBJAKxWptjRnVI3AYvH2.jpg','test','test','test',0,'easyvirtue','jfourie',3,36055,'IC'),(843,'The Time Traveler\'s Wife','/ayGp00uS6XRrNfbR59XWrJh9jpC.jpg','test','test','test',0,'thetimetraveler\'swife','jfourie',3,24420,'IC'),(845,'Notorious','/vcdSvOr5NcY6alt0kBqDQlFC3Nk.jpg','test','test','test',0,'notorious','jfourie',3,303,'IC'),(847,'The Neverending Story II: The Next Chapter','/phOI8kStf6pSxsAI3OaBpiw0ypZ.jpg','test','test','test',0,'neverendingstoryii:thenextchapter','jfourie',3,34636,'IC'),(879,'War for the Planet of the Apes','/3vYhLLxrTtZLysXtIWktmd57Snv.jpg','test','test','test',0,'warfortheplanetoftheapes','jfourie',3,281338,'IC'),(887,'Look Who\'s Talking','/zyq8wUKk3FVfgkYnI1IVgmypOtG.jpg','test','test','test',3,'lookwho\'stalking','jfourie',3,9494,'IC'),(888,'Look Who\'s Talking Too','/7HtSFUYBPOUd9ylUXU0LyPsxpRm.jpg','test','test','test',0,'lookwho\'stalkingtoo','jfourie',3,9356,'IC'),(889,'Look Who\'s Talking Now!','/kgtTgLOVvMY4QMRSJVMMGKxjqpt.jpg','test','test','test',0,'lookwho\'stalkingnow!','jfourie',3,11982,'IC'),(890,'Escape from New York','/m1xx0wtWXTL82VJmA1Y5DHndL3H.jpg','test','test','test',3,'escapefromnewyork','jfourie',3,1103,'IC'),(891,'Escape from L.A.','/rAjz6XFC6Zs07oraJSnajbaAbG9.jpg','test','test','test',4,'escapefroml.a.','jfourie',3,10061,'IC'),(894,'Frankenstein','/rwQamiUQELLGQVa2J9VhpRNC2EF.jpg','test','test','test',0,'frankenstein','jfourie',3,3056,'IC'),(898,'Frankenstein','/5LjlxuSC9SXvvQYsHMOPrs0bNl8.jpg','test','test','test',0,'frankenstein','jfourie',3,337029,'IC'),(919,'Saint Bernard','/pWTxm82VCdiJJvUGuC4cvL7H501.jpg','test','test','test',1,'saintbernard','jfourie',3,448976,'IC'),(925,'My Friend Bernard','/ckkaK8w0czZfaJxFFYS4uWbXQkO.jpg','test','test','test',0,'myfriendbernard','jfourie',3,47649,'IC'),(930,'Harry Brown','/68V1ClrCT7ik7UDiAkIDliRaAXf.jpg','test','test','test',0,'harrybrown','jfourie',3,25941,'IC'),(941,'Alien Abduction','/vRP3IfrGCB0oXX5HubCkiNcwCcj.jpg','test','test','test',2,'alienabduction','jfourie',3,258193,'IC'),(950,'NASA DREAMTiME','/m2TzpsmUPMtJgqsKyYfO16ggE3v.png','test','test','test',0,'nasadreamtime','jfourie',3,25240,'IC'),(955,'Alien Contact: NASA Exposed','/cFJ63qtCUkX9n5sWtdv7X37WRef.jpg','test','test','test',0,'aliencontact:nasaexposed','jfourie',3,304033,'IC'),(956,'Alien Contact: NASA Exposed 2','/1j02hTX0C6cs8fKcCNnjFn4QzeD.jpg','test','test','test',1,'aliencontact:nasaexposed2','jfourie',3,496894,'IC'),(957,'NASA 50 Years of Space Exploration','/c8jIZc123VVS4dHxCknI7OJELas.jpg','test','test','test',0,'nasa50yearsofspaceexploration','jfourie',3,346036,'IC'),(958,'NASA: The First 25 Years','/sdbrkWfIgILuW13UT7w3Fn15xVD.jpg','test','test','test',0,'nasa:thefirst25years','jfourie',3,436092,'IC'),(961,'NASA 50 Years of Space Exploration: Volume 3','/A6lU5F18ZMmrjdBk1pWsHAdsSzr.jpg','test','test','test',0,'nasa50yearsofspaceexploration:volume3','jfourie',3,346205,'IC'),(962,'NASA 50 Years of Space Exploration: Volume 1','/uePMt7deBmK6HIWoJHJQoUpIVJ3.jpg','test','test','test',0,'nasa50yearsofspaceexploration:volume1','jfourie',3,346202,'IC'),(964,'NASA 50 Years of Space Exploration: Volume 4','/rJqRPg3w3QJ82zxVn5Xh32z4FED.jpg','test','test','test',0,'nasa50yearsofspaceexploration:volume4','jfourie',3,346206,'IC'),(965,'The Secret NASA Transmissions The Smoking Gun','/innuBA9AHeWthku3lLowCCooFAd.jpg','test','test','test',0,'secretnasatransmissionsthesmokinggun','jfourie',3,52976,'IC'),(967,'Mission: Impossible','/vmj2PzTLC6xJvshpq8SlaYE3gbd.jpg','test','test','test',5,'mission:impossible','jfourie',3,954,'IC'),(968,'Mission: Impossible II','/eRaEC0vf5q5TSvaoJPwGTt2wa9T.jpg','test','test','test',0,'mission:impossibleii','jfourie',3,955,'IC'),(969,'Mission: Impossible III','/qjy8ABAbWooV4jLG6UjzDHlv4RB.jpg','test','test','test',0,'mission:impossibleiii','jfourie',3,956,'IC'),(970,'Mission: Impossible - Rogue Nation','/z2sJd1OvAGZLxgjBdSnQoLCfn3M.jpg','test','test','test',0,'mission:impossible-roguenation','jfourie',3,177677,'IC'),(971,'Mission: Impossible - Ghost Protocol','/s58mMsgIVOFfoXPtwPWJ3hDYpXf.jpg','test','test','test',0,'mission:impossible-ghostprotocol','jfourie',3,56292,'IC'),(973,'Mission to Mars','/eco5chujn3Mt7HnuMTUIuobPMoX.jpg','test','test','test',0,'missiontomars','jfourie',3,2067,'IC'),(974,'Mission: Impossible - Fallout','/A2W75CVz9l8gEeWhQiiftlOCkgi.jpg','test','test','test',0,'mission:impossible-fallout','jfourie',3,353081,'IC'),(976,'Dug\'s Special Mission','/gcWhEXk5dnZ8UkGESdfgJ7OIaxF.jpg','test','test','test',3,'dug\'sspecialmission','jfourie',3,24589,'IC'),(977,'Mission Park','/WzLCqQfGU1ODLURKDwqCCq45H2.jpg','test','test','test',0,'missionpark','jfourie',3,208495,'IC'),(982,'Mission Blue','/oo9evUcGESyR3UYSp8VBjEDDk2j.jpg','test','test','test',0,'missionblue','jfourie',3,286407,'IC'),(987,'Moon','/2tgl9q3ZaVQUfSsbftqhRxXCElB.jpg','test','test','test',0,'moon','jfourie',3,17431,'IC'),(989,'Alabama Moon','/zTExJLGaHxGnEtbo2n0vCgvxx7k.jpg','test','test','test',3,'alabamamoon','jfourie',3,51249,'IC'),(991,'Bitter Moon','/sUiqWj0k5oPcThd1WaXvt9Vymzr.jpg','test','test','test',0,'bittermoon','jfourie',3,10497,'IC'),(992,'Black Moon','/37z2YdnGnesEhY7LlJRfM8EWrW7.jpg','test','test','test',0,'blackmoon','jfourie',3,27361,'IC'),(994,'Moon 44','/opy8lmBInujEWRcEZUAsq7ezdke.jpg','test','test','test',0,'moon44','jfourie',3,2927,'IC'),(995,'China Moon','/d3NZeytOftjdpcZt0se6rvo93yd.jpg','test','test','test',3,'chinamoon','jfourie',3,26337,'IC'),(997,'Seventh Moon','/kSzp3W2kgH8kNe9ySnFRK8mfx8i.jpg','test','test','test',1,'seventhmoon','jfourie',3,24330,'IC'),(998,'Jupiter\'s Moon','/tyIBOEAduMfRy0kVcf9wxTqxp5a.jpg','test','test','test',1,'jupiter\'smoon','jfourie',3,444395,'IC'),(1001,'Moon of the Wolf','/vCQc1efj9JLOUzK2hsan76DL5P8.jpg','test','test','test',0,'moonofthewolf','jfourie',3,49354,'IC'),(1004,'Bad Moon','/ivjPm80ZT4MXO1DifALrP0GkOBZ.jpg','test','test','test',0,'badmoon','jfourie',3,49763,'IC'),(1005,'High Moon','/lm74TCPuOtbVxO80AiBjDEeaLtx.jpg','test','test','test',1,'highmoon','jfourie',3,287358,'IC'),(1006,'Crazy Moon','/evgipxvm655EYbQPEBmrR9FELd3.jpg','test','test','test',0,'crazymoon','jfourie',3,197435,'IC'),(1007,'Rambo','/ec1m7YgBYb4os06OSNW3QBaNYqZ.jpg','test','test','test',5,'rambo','jfourie',3,7555,'IC'),(1008,'Rambo III','/oCD41FfUs1OMCdPaf5EcJ6dxxMW.jpg','test','test','test',0,'ramboiii','jfourie',3,1370,'IC'),(1010,'Rambo','/8WHzOXKQBx83tr8ZBYlfttl8YEl.jpg','test','test','test',0,'rambo','jfourie',3,458578,'IC'),(1011,'Planet Terror','/7Yjzttt0VfPphSsUg8vFUO9WaEt.jpg','test','test','test',0,'planetterror','jfourie',3,1992,'IC'),(1012,'Forbidden Planet','/qdH1Fm5vl1DAjXNHPmRZ4yEiUgM.jpg','test','test','test',0,'forbiddenplanet','jfourie',3,830,'IC'),(1013,'Planet 51','/n4Azjb2DyclHySvHWMUAsGW2Zb1.jpg','test','test','test',0,'planet51','jfourie',3,16866,'IC'),(1014,'Treasure Planet','/yfcoA7q9n852yVnYa0VcAchgA72.jpg','test','test','test',0,'treasureplanet','jfourie',3,9016,'IC'),(1015,'Dawn of the Planet of the Apes','/2EUAUIu5lHFlkj5FRryohlH6CRO.jpg','test','test','test',4,'dawnoftheplanetoftheapes','jfourie',3,119450,'IC'),(1016,'Planet of the Apes','/uHp6PTo7SCrqdH5wCSrCCf8EQFX.jpg','test','test','test',0,'planetoftheapes','jfourie',3,869,'IC'),(1018,'Red Planet','/sMholOUc89LQhp0X33JZExgxupB.jpg','test','test','test',0,'redplanet','jfourie',3,8870,'IC'),(1019,'Planet Hulk','/qNyMAPesh9SgtXtKN6N9r10cley.jpg','test','test','test',0,'planethulk','jfourie',3,30675,'IC'),(1021,'Planet of the Apes','/lkYLPBboomtDKK4e41BlwBVfsIS.jpg','test','test','test',0,'planetoftheapes','jfourie',3,871,'IC'),(1022,'Battle Planet','/yDcFZ9WVjBqMvUoMIGMpAlW0T4A.jpg','test','test','test',0,'battleplanet','jfourie',3,17571,'IC'),(1024,'Planet ?','/nWbuitcfbglBO0dIzh0Atv0hIzB.jpg','test','test','test',0,'planet?','jfourie',3,497716,'IC'),(1025,'Alien Planet','/gh282XtTrhzNQtebr7tAdkX142u.jpg','test','test','test',3,'alienplanet','jfourie',3,18606,'IC'),(1026,'Ghost Planet','/AeWnt3V7Cb86C5X2HJiOpSTTiP.jpg','test','test','test',0,'ghostplanet','jfourie',3,70865,'IC'),(1027,'Ferocious Planet','/b643GLMzEVqL4439FqtsNCYiipH.jpg','test','test','test',0,'ferociousplanet','jfourie',3,61341,'IC'),(1028,'Ice Planet','/53rVvFlv04P6LwtwLB5puze4d5d.jpg','test','test','test',1,'iceplanet','jfourie',3,20031,'IC'),(1029,'Badlanders','/uaXThIgCgtibQFjHi6245wPvEtE.jpg','test','test','test',0,'badlanders','jfourie',3,116883,'IC'),(1030,'Blue Planet','/xddijtieZxKOFZV4L2v6xIGgAw9.jpg','test','test','test',4,'blueplanet','jfourie',3,15087,'IC'),(1031,'Captain America: The Winter Soldier','/5TQ6YDmymBpnF005OyoB7ohZps9.jpg','test','test','test',0,'captainamerica:thewintersoldier','jfourie',3,100402,'IC'),(1032,'Winter','/175I9mHlKcVEbvBY3RFvjBcT9Yl.jpg','test','test','test',0,'winter','jfourie',3,273241,'IC'),(1033,'Winter','/zXa7E70DA1GACHxYzDAOD76VjME.jpg','test','test','test',0,'winter','jfourie',3,209679,'IC'),(1034,'Winter Brothers','/3CkwSE6Q1UtQbRb270D9s741yRx.jpg','test','test','test',0,'winterbrothers','jfourie',3,466172,'IC'),(1035,'The Lion in Winter','/zzK551e51k00SlofHZfmS5zcWhy.jpg','test','test','test',0,'lioninwinter','jfourie',3,18988,'IC'),(1036,'Winter','/kjc4w4UxY0I8TJqGzIdC30weFU5.jpg','test','test','test',0,'winter','jfourie',3,67788,'IC'),(1037,'Winter Passing','/aiHI0C26MIuGL6NjivvjyMCwTQN.jpg','test','test','test',0,'winterpassing','jfourie',3,14256,'IC'),(1038,'Winter War','/gwPL8EO9UGacZ0Sh4L7PiwEhHxd.jpg','test','test','test',0,'winterwar','jfourie',3,452739,'IC'),(1039,'A Royal Winter','/lxeJQe4lcW8AzDrRjzixOrlmihv.jpg','test','test','test',0,'oyalwinter','jfourie',3,435107,'IC'),(1040,'Winter','/rA0fpelmIk3A3SLpVX6H6LAO0sh.jpg','test','test','test',0,'winter','jfourie',3,226942,'IC'),(1041,'The Last Winter','/7heZp0irXazXV9uipgJm5FjZrbC.jpg','test','test','test',0,'lastwinter','jfourie',3,15667,'IC'),(1042,'Hiver 54, l\'abbé Pierre','/qNBgjmZYSJVNDe1jGMjLEKjFflA.jpg','test','test','test',0,'hiver54,l\'abbépierre','jfourie',3,179956,'IC'),(1043,'Winter','/f2YPomxgwL15YROE6HQ0ttk1H44.jpg','test','test','test',0,'winter','jfourie',3,217241,'IC'),(1044,'Winter Kills','/za4znhaOA5G1laSnczfrFeTWejY.jpg','test','test','test',0,'winterkills','jfourie',3,42178,'IC'),(1045,'Winter','/tRsn1eUUyWMrbgTQEes8YkBwaK7.jpg','test','test','test',0,'winter','jfourie',3,413275,'IC'),(1046,'Winter','/l9jiV6Ns89aDu2N2bCpUimSFm1h.jpg','test','test','test',0,'winter','jfourie',3,331060,'IC'),(1047,'Winter','/wzhygLIg7mNsqSWxve4OXd8aaCn.jpg','test','test','test',0,'winter','jfourie',3,384734,'IC'),(1048,'Winter','/b8hbGtN42AuX3jTbdB2vJacXRcr.jpg','test','test','test',0,'winter','jfourie',3,245798,'IC'),(1049,'Winter','/ozrzeTRfZYwx44ckR3WqG4FBqXq.jpg','test','test','test',0,'winter','jfourie',3,303816,'IC'),(1065,'Z','/kSyT7q0XPKK4ruuodTAYg5Ueng7.jpg','test','test','test',2,'z','jfourie',3,454655,'IC'),(1067,'World War Z','/Ha5t0J21eyiq6Az1EXzx0iwsGH.jpg','test','test','test',5,'worldwarz','jfourie',3,72190,'IC'),(1068,'Zombie 108','/3bCbRsBmbOmgpTft64Mj2wuqhwb.jpg','test','test','test',0,'zombie108','jfourie',3,119471,'IC'),(1079,'The Making of The Empire Strikes Back','/aHJLFCwKsnKLryf2dSQN9o7L5ZJ.jpg','test','test','test',3,'makingoftheempirestrikesback','jfourie',3,485213,'IC'),(1100,'Cats','/5HceqylyY9WWNYzWs1MlyuvJGPb.jpg','test','test','test',0,'cats','jfourie',3,26598,'IC'),(1101,'Cats & Dogs','/1RLlzNwnrpMMNFt71OVFAnJp6ww.jpg','test','test','test',0,'cats&dogs','jfourie',3,10992,'IC'),(1103,'Cats Don\'t Dance','/sSx6WDj5moqTLVjyHB3COG0ELMq.jpg','test','test','test',0,'catsdon\'tdance','jfourie',3,24662,'IC'),(1104,'Cats','/fC7lIvZFalbdW9bqmSjDtfum9Xv.jpg','test','test','test',0,'cats','jfourie',3,517860,'IC'),(1105,'Cats Kill','/shoqpk1zyO9Ap7wxxeOalA0AqhF.jpg','test','test','test',0,'catskill','jfourie',3,502642,'IC'),(1106,'Cats and Peachtopia','/Yn1whJc5Q4RSfD1AIYI8pHVUjf.jpg','test','test','test',0,'catsandpeachtopia','jfourie',3,513386,'IC'),(1107,'Cats & Dogs: The Revenge of Kitty Galore','/6V1TFvZsbQi2fpxIZtseqBCvuRM.jpg','test','test','test',0,'cats&dogs:therevengeofkittygalore','jfourie',3,39691,'IC'),(1108,'Sufferin\' Cats!','/vAj6xEsSsinvgQwo8C4Q6FvJbMq.jpg','test','test','test',0,'sufferin\'cats!','jfourie',3,40212,'IC'),(1109,'Like Cats & Dogs','/94c3PLJii1ymQPAttlvxrBw4i3I.jpg','test','test','test',0,'likecats&dogs','jfourie',3,446866,'IC'),(1110,'Because of the Cats','/qLXeiv5dAgbSBWHSnuz3XkhvYfd.jpg','test','test','test',2,'becauseofthecats','jfourie',3,46554,'IC'),(1111,'The Truth About Cats & Dogs','/5V10mg1rAbwWYNF6IjnEYokIR8f.jpg','test','test','test',0,'truthaboutcats&dogs','jfourie',3,8866,'IC'),(1112,'Scat Cats','/yZII0snIrekqTqc9EwgHDOPKm4B.jpg','test','test','test',0,'scatcats','jfourie',3,235025,'IC'),(1113,'Cat\'s Eye','/A65sQJbEAAV4wC9QQc0Mn4ZaMZV.jpg','test','test','test',0,'cat\'seye','jfourie',3,10552,'IC'),(1114,'Sufferin\' Cats','/2MmibU11ILOoXcZBzdKOBQBSY8H.jpg','test','test','test',0,'sufferin\'cats','jfourie',3,234667,'IC'),(1115,'Harmony Cats','/p1Mc6I6ioqi83TbpHMZzkbHFLQV.jpg','test','test','test',0,'harmonycats','jfourie',3,285483,'IC'),(1116,'Cats and Dogs','/3ImCr58W8zSTvbvUQ6pcVywDN2t.jpg','test','test','test',0,'catsanddogs','jfourie',3,289294,'IC'),(1135,'The Man from Snowy River','/aucJ9euy1Wj0TKPSbeLnX07qI07.jpg','test','test','test',0,'manfromsnowyriver','jfourie',3,24266,'IC'),(1136,'Return to Snowy River','/mI3K4qCYAzNTZgkl9Lrh86FLklD.jpg','test','test','test',0,'returntosnowyriver','jfourie',3,13965,'IC'),(1138,'Revenge','/njOIcbg9NeNnpRDhYNZO9cXJjHY.jpg','test','test','test',0,'revenge','jfourie',3,467938,'IC'),(1143,'Revenge of the Nerds','/wCcMAx1J4JxBviEzy5Ay2FW79Nb.jpg','test','test','test',0,'revengeofthenerds','jfourie',3,14052,'IC'),(1145,'Transformers: Revenge of the Fallen','/kVISXAXDYhjQCfu50QZeCCzzbPv.jpg','test','test','test',0,'transformers:revengeofthefallen','jfourie',3,8373,'IC'),(1150,'Revenge','/enFHjuIsSofqEpTBRe9oZKOhGmJ.jpg','test','test','test',0,'revenge','jfourie',3,216046,'IC'),(1151,'Revenge of the Pink Panther','/rbSHQ2wslGEJHjN8Y7XpdKaihyR.jpg','test','test','test',0,'revengeofthepinkpanther','jfourie',3,6081,'IC'),(1158,'Midnight Cowboy','/jEeyGsyoiRPwwxDkR1WWNT8eoyN.jpg','test','test','test',5,'midnightcowboy','jfourie',3,3116,'IC'),(1581,'Blue Jasmine','/tXzOAeub5ZaxGv9vkJLtU0aNenl.jpg','test','test','test',0,'bluejasmine','jfourie',3,160588,'IC'),(1585,'Blue Velvet','/pxC4YsYIL4eSg1zDwrQQuxJegjA.jpg','test','test','test',5,'bluevelvet','jfourie',3,793,'IC'),(1586,'Blue','/wQffxzw30Ng8kZ0wJVTPUYRHqrm.jpg','test','test','test',3,'blue','jfourie',3,94794,'IC'),(1591,'Blue Thunder','/sdsA2shw0TA81idpx2EafI6FEwN.jpg','test','test','test',0,'bluethunder','jfourie',3,6341,'IC'),(1596,'Deep Blue Sea','/r386y8YpePXoS7P4jHWZRTF36Zb.jpg','test','test','test',0,'deepbluesea','jfourie',3,8914,'IC'),(1793,'Sunny Side Up','/klSM5Y11ZwK5W2loq8958dM8ZKt.jpg','test','test','test',0,'sunnysideup','jfourie',3,305668,'IC'),(1797,'One Sunny Day','/pJAKs9b2ucq1ifYkntxpDefDwLn.jpg','test','test','test',0,'onesunnyday','jfourie',3,340854,'IC'),(1993,'Red Scorpion','/vAOaT9nyh1IMrXm0AkWgbbiSqad.jpg','test','test','test',0,'redscorpion','jfourie',3,12663,'IC'),(1995,'Night at the Museum','/NUbCSwy2EQ9Z6psUjPqr3WdVI2.jpg','test','test','test',0,'nightatthemuseum','testuser',18,1593,'IC'),(1996,'The Night Before','/eEGZgNZgN3sZWwoSaL1u2rTGlzj.jpg','test','test','test',0,'nightbefore','testuser',18,296100,'IC'),(2000,'Night of the Creeps','/uLNwrWd4QcwkNEMnt7R0ZGLVpHy.jpg','test','test','test',0,'nightofthecreeps','testuser',18,15762,'IC'),(2011,'The Night Listener','/jBcQZRnTgAGWLBzKxcjK99VGBIq.jpg','test','test','test',0,'nightlistener','testuser',18,9782,'IC'),(2015,'A Night at the Roxbury','/s4GoobEeEKQcWpbBnJ0TSXFt67B.jpg','test','test','test',0,'nightattheroxbury','testuser',18,9429,'IC'),(2036,'An Ending','/k6Ziu6FpAVeDNZymPAc47Gyk9l6.jpg','test','test','test',0,'ending','testuser',18,397273,'IC'),(2038,'Rango','/afxRbCwwKjrWgGJtsVNs1BW1Dk5.jpg','test','test','test',0,'rango','testuser',18,44896,'IC');
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','badadmin',1),(2,'admin','jfourieadmin',2),(3,'regular','jfourie',3),(5,'regular','baduser',5),(16,'regular','testuser',18);
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
  `city` varchar(30) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'badadmin','ssecrett','Bad','Admin',1,0,'2018-01-01','Los Angeles','CA'),(2,'jfourieadmin','ssecrett','Jacques','Fourie',1,1,'2018-01-02','Madison','WI'),(3,'jfourie','supersecret','Jacques','Fourie',0,1,'2018-01-02','Madison','WI'),(5,'baduser','ssecrett','Bad','User',0,0,'2018-04-21','Phoenix','AZ'),(18,'testuser','temp','Jane','Doe',0,1,'2018-01-01','Houston','TX');
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
  `weather_conditions` varchar(20) DEFAULT NULL,
  `icon_name` varchar(255) DEFAULT NULL,
  `icon_url` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `viewing_habit_id_uindex` (`id`),
  KEY `viewing_habit_user_id_fk` (`user_id`),
  CONSTRAINT `viewing_habit_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viewing_habit`
--

LOCK TABLES `viewing_habit` WRITE;
/*!40000 ALTER TABLE `viewing_habit` DISABLE KEYS */;
INSERT INTO `viewing_habit` VALUES (7,3,'2018-04-21',51,'Overcast','cloudy','http://icons.wxug.com/i/c/k/nt_cloudy.gif',3),(9,3,'2018-04-21',50,'Overcast','cloudy','http://icons.wxug.com/i/c/k/cloudy.gif',3),(14,3,'2018-04-21',51,'Overcast','cloudy','http://icons.wxug.com/i/c/k/nt_cloudy.gif',3),(15,3,'2018-04-21',51,'Overcast','cloudy','http://icons.wxug.com/i/c/k/cloudy.gif',3),(17,617,'2018-04-22',51,'Partly Cloudy','partlycloudy','http://icons.wxug.com/i/c/k/nt_mostlycloudy.gif',3),(18,890,'2018-04-22',52,'Partly Cloudy','partlycloudy','http://icons.wxug.com/i/c/k/nt_mostlycloudy.gif',3),(19,919,'2018-04-22',52,'Partly Cloudy','partlycloudy','http://icons.wxug.com/i/c/k/nt_mostlycloudy.gif',3),(20,597,'2018-04-22',52,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(21,941,'2018-04-22',54,'Clear','clear','http://icons.wxug.com/i/c/k/nt_clear.gif',3),(23,816,'2018-04-22',53,'Clear','clear','http://icons.wxug.com/i/c/k/nt_clear.gif',3),(24,777,'2018-04-22',52,'Clear','clear','http://icons.wxug.com/i/c/k/nt_clear.gif',3),(25,840,'2018-04-22',52,'Clear','clear','http://icons.wxug.com/i/c/k/nt_clear.gif',3),(26,617,'2018-04-22',52,'Clear','clear','http://icons.wxug.com/i/c/k/nt_clear.gif',3),(27,995,'2018-04-22',51,'Clear','clear','http://icons.wxug.com/i/c/k/nt_clear.gif',3),(28,817,'2018-04-22',51,'Clear','clear','http://icons.wxug.com/i/c/k/nt_clear.gif',3),(29,1007,'2018-04-22',51,'Clear','clear','http://icons.wxug.com/i/c/k/nt_clear.gif',3),(30,617,'2018-04-24',65,'Mostly Cloudy','mostlycloudy','http://icons.wxug.com/i/c/k/mostlycloudy.gif',3),(32,1110,'2018-04-25',57,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(35,1005,'2018-04-25',53,'Clear','clear','http://icons.wxug.com/i/c/k/nt_clear.gif',3),(36,717,'2018-04-25',52,'Clear','clear','http://icons.wxug.com/i/c/k/nt_clear.gif',3),(37,1025,'2018-04-28',38,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(38,677,'2018-04-28',38,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(39,811,'2018-04-28',40,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(40,976,'2018-04-28',40,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(41,976,'2018-04-28',48,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(42,976,'2018-04-28',40,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(43,1586,'2018-04-28',46,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(44,1030,'2018-04-28',48,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(45,1585,'2018-04-28',46,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(100,1015,'2018-04-29',39,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(180,1079,'2018-04-29',46,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(181,1065,'2018-04-29',46,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(182,1067,'2018-04-29',46,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3),(183,989,'2018-04-29',46,'Clear','clear','http://icons.wxug.com/i/c/k/clear.gif',3);
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

-- Dump completed on 2018-04-29 11:16:49
