delete from user;
delete from movie;
delete from metadata_tmdb;
INSERT INTO `user` VALUES  (1,'badadmin','secret','Bad','Admin',TRUE,FALSE,'2018-01-01');
INSERT INTO `user` VALUES  (2,'jfourieadmin','secret','Jacques','Fourie',TRUE,TRUE,'2018-01-02');
INSERT INTO `user` VALUES  (3,'jfourie','secret','Jacques','Fourie',FALSE,TRUE,'2018-01-02');
INSERT INTO `user` VALUES  (4,'lfoxy','secret','Lucy','Foxy',FALSE,TRUE,'2018-02-10');
INSERT INTO `user` VALUES  (5,'baduser','secret','Bad','User',FALSE,FALSE,'2018-02-10');
INSERT INTO `movie` VALUES (1,'Jack Reacher', '38bmEXmuJuInLs9dwfgOGCHmZ7l.jpg','test','test','test',5,'jackreacher',3);
INSERT INTO `movie` VALUES (2,'War Games', 'rQocmooj7bFKS2vZfzWBB5O12eR.jpg','test','test','test',5,'wargames',3);
INSERT INTO `movie` VALUES (3,'Blade Runner 2048', 'gajva2L0rPYkEWjzgFlBXCAVBE5.jpg','test','test','test',3,'bladerunner2048',3);
INSERT INTO `movie` VALUES (4,'Blade Runner', 'p64TtbZGCElxQHpAMWmDHkWJlH2.jpg','test','test','test',3,'bladerunner',4);
INSERT INTO `movie` VALUES (5,'Abyss', 'kRP5dGXDhKt7bDpXX4YBa4dRwlL.jpg','test','test','test',3,'abyss',4);
INSERT INTO `movie` VALUES (6,'The Accountant', 'afhAUuWVB7k7PjJUd4lwO3rzhSq.jpg','test','test','test',4,'accountant',4);
INSERT INTO `movie` VALUES (7,'Atomic Blonde', 'kV9R5h0Yct1kR8Hf8sJ1nX0Vz4x.jpg','test','test','test',3,'atomicblonde',4);
INSERT INTO `movie` VALUES (8,'Ultimate Avengers', 'we6igIU5gXVwuSL6M6pJP75TwEf.jpg','test','test','test',3,'ultimateavengers',4);
INSERT INTO `movie` VALUES (9,'After Earth', 'd0vReo0jcMhBjCLYZAFqWHcb7Lj.jpg','test','test','test',3,'afterearth',4);
INSERT INTO `metadata_tmdb` VALUES (1, 'http://image.tmdb.org/t/p/', 'w92', 'w300');


