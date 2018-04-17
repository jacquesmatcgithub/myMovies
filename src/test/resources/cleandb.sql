delete from user;
delete from movie;
delete from metadata_tmdb;
delete from role;
delete from viewing_habit;
INSERT INTO `user` VALUES  (1,'badadmin','ssecrett','Bad','Admin',TRUE,FALSE,'2018-01-01');
INSERT INTO `user` VALUES  (2,'jfourieadmin','ssecrett','Jacques','Fourie',TRUE,TRUE,'2018-01-02');
INSERT INTO `user` VALUES  (3,'jfourie','ssecrett','Jacques','Fourie',FALSE,TRUE,'2018-01-02');
INSERT INTO `user` VALUES  (4,'lfoxy','ssecrett','Lucy','Foxy',FALSE,TRUE,'2018-02-10');
INSERT INTO `user` VALUES  (5,'baduser','ssecrett','Bad','User',FALSE,FALSE,'2018-02-10');
INSERT INTO `user` VALUES  (6,'pwaite','ssecrett','Paula','Waite',FALSE,TRUE,'2018-03-15');
INSERT INTO `user` VALUES  (7,'pwaiteadmin','ssecrett','Paula','Waite',TRUE,TRUE,'2018-03-15');
INSERT INTO `movie` VALUES (1,'Jack Reacher', '38bmEXmuJuInLs9dwfgOGCHmZ7l.jpg','test','test','test',5,'jackreacher','jfourie',3,75780);
INSERT INTO `movie` VALUES (2,'War Games', 'rQocmooj7bFKS2vZfzWBB5O12eR.jpg','test','test','test',5,'wargames','jfourie',3,860);
INSERT INTO `movie` VALUES (3,'Blade Runner 2048', 'gajva2L0rPYkEWjzgFlBXCAVBE5.jpg','test','test','test',3,'bladerunner2048','jfourie',3,335984);
INSERT INTO `movie` VALUES (4,'Blade Runner', 'p64TtbZGCElxQHpAMWmDHkWJlH2.jpg','test','test','test',3,'bladerunner','lfoxy',4,78);
INSERT INTO `movie` VALUES (5,'Abyss', 'kRP5dGXDhKt7bDpXX4YBa4dRwlL.jpg','test','test','test',3,'abyss','lfoxy',4,2756);
INSERT INTO `movie` VALUES (6,'The Accountant', 'afhAUuWVB7k7PjJUd4lwO3rzhSq.jpg','test','test','test',4,'accountant','lfoxy',4,302946);
INSERT INTO `movie` VALUES (7,'Atomic Blonde', 'kV9R5h0Yct1kR8Hf8sJ1nX0Vz4x.jpg','test','test','test',3,'atomicblonde','lfoxy',4,341013);
INSERT INTO `movie` VALUES (8,'Ultimate Avengers', 'we6igIU5gXVwuSL6M6pJP75TwEf.jpg','test','test','test',3,'ultimateavengers','lfoxy',4,14609);
INSERT INTO `movie` VALUES (9,'After Earth', 'd0vReo0jcMhBjCLYZAFqWHcb7Lj.jpg','test','test','test',3,'afterearth','lfoxy',4,82700);
INSERT INTO `movie` VALUES (10,'Blade', 'r0RQ9ZOEZglLOeYDNJTehVTRoR6.jpg','test','test','test',4,'blade','lfoxy',4,36647);
INSERT INTO `movie` VALUES (11,'Blade II', 'jlURNpXCMK830CsGRd939PJLh8c.jpg','test','test','test',2,'bladeii','lfoxy',4,436586);
INSERT INTO `movie` VALUES (12,'Blade of the Imortal', 'bFaxg006Dt6J1k7qa7a5YuqbAhe.jpg','test','test','test',2,'bladeofhteimortal','lfoxy',4,426284);
INSERT INTO `movie` VALUES (13,'Dragon Blade', '3gl11EsZS5vboQvvMYeCIzitaJz.jpg','test','test','test',1,'dragonblade','lfoxy',4, 300168);
INSERT INTO `movie` VALUES (14,'The Fate of the Furious', 'dImWM7GJqryWJO9LHa3XQ8DD5NH.jpg','test','test','test',1,'fateofthefurious','lfoxy',4,337339);
INSERT INTO `movie` VALUES (15,'Fast Food Nation', 's13uyUCCYs7zKj4MqsAPdK0lN4X.jpg','test','test','test',3,'fastfoodnation','lfoxy',4,8324);
INSERT INTO `movie` VALUES (16,'Fast Times at Ridgemont High', '9y5rSeO0xH3m5oRJmhBusDkiS0j.jpg','test','test','test',3,'fasttimesatridgemonthigh','lfoxy',4,13342);
INSERT INTO `movie` VALUES (17,'Bandits', '3wTzOr0CekiBJZL7ZiNE2y2H16N.jpg','test','test','test',3,'bandits','lfoxy',4,3172);
INSERT INTO `movie` VALUES (18,'Bandidas', '6WnSdouYhXDowg9NrKY2fSV5o1W.jpg','test','test','test',3,'bandidas','lfoxy',4,1969);
INSERT INTO `movie` VALUES (19,'B. Monkey', 'owKZAo5QxyulBwMvHqKn4a2abNc.jpg','test','test','test',3,'bmonkey','lfoxy',4,2923);
INSERT INTO `movie` VALUES (20,'Band Aid', 'lcxx0vN0hhQi7KFpRaJlxAaLLhR.jpg','test','test','test',3,'bandaid','lfoxy',4,426230);
INSERT INTO `movie` VALUES (21,'B', 'bvpfVMt0MRSXNXcycxOGiHQMevk.jpg','test','test','test',3,'b','lfoxy',4,346352);
INSERT INTO `movie` VALUES (22,'The Back-Up Plan', '1Ig6ZQpLZfLsdvMLHD0inc2w0HB.jpg','test','test','test',3,'backupplan','lfoxy',4,34806);
INSERT INTO `movie` VALUES (23,'B-Day', 'cDgrrQnCmC6kqUGaFZmK7DmsE7.jpg','test','test','test',3,'bday','lfoxy',4,471970);
INSERT INTO `movie` VALUES (24,'Bandolero!', 'kmqy27Mk8zT0viBTZkqemkSZInQ.jpg','test','test','test',3,'bandolero','lfoxy',4,41857);
INSERT INTO `movie` VALUES (25,'Be Afraid', 'ytkaL1wZcqgQKHLuU7Go3UxGpON.jpg','test','test','test',3,'beafraid','lfoxy',4,448252);
INSERT INTO `metadata_tmdb` VALUES (1, 'http://image.tmdb.org/t/p/', 'w92', 'w300');
INSERT INTO `role` VALUES (1,'admin','badadmin',1);
INSERT INTO `role` VALUES (2,'admin','jfourieadmin',2);
INSERT INTO `role` VALUES (3,'regular','jfourie',3);
INSERT INTO `role` VALUES (4,'regular','lfoxy',4);
INSERT INTO `role` VALUES (5,'regular','baduser',5);
INSERT INTO `role` VALUES (6,'regular','pwaite',6);
INSERT INTO `role` VALUES (7,'admin','pwaiteadmin',7);
INSERT INTO `viewing_habit` VALUES (1,1,'2018-01-01',28,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,3);
INSERT INTO `viewing_habit` VALUES (2,1,'2018-02-01',28,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,3);
INSERT INTO `viewing_habit` VALUES (3,2,'2018-03-01',28,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,4);
INSERT INTO `viewing_habit` VALUES (4,3,'2018-04-01',28,TRUE,TRUE,TRUE,TRUE,TRUE,TRUE,4);

