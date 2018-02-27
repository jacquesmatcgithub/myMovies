## myMovies
### Problem Statement
Over the last 25 years I've built up quit a large movie collection, and sometimes I find myself unable to decide what to watch when I'm in the mood for a movie.

myMovies will aim to solve that problem by making suggestions on what to watch based on the season and current weather conditions.

### Project Technologies/Techniques
* Security/Authentication
	* Tomcat's JDBC Realm Authentication
	* Admin role: create/read/update/delete (crud) of all data
	* User role: Add & Remove movies. Rate movies and flag movies after watching


* Database
	* MySQL
	* Store users and roles
	* Store all data for the movies


* ORM Framework
	* Hybernate 5


* Dependency Management
	* Maven


* Web Services consumed
	* The Movie Database (TMDb)
	* Wundermap Weather


* CSS
	* Bootstrap Validator for front end
   * Explore Hibernate's validation


* Logging
	* Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting.


* Hosting
	* AWS

* Independent Research Topic/s
	* ????

* JUnit tests to achieve 80%+ code coverage

* IDE: IntelliJ IDEA	  



### Design
* [Screen Design](https://github.com/jacquesmatcgithub/myMovies/blob/master/design_documents/page_design.pdf)
* [Database Design](https://github.com/jacquesmatcgithub/myMovies/blob/master/design_documents/data_design.jpeg)
* [Class Design](https://github.com/jacquesmatcgithub/myMovies/blob/master/design_documents/class_design.pdf)


### Project Plan
* [Project Plan](https://github.com/jacquesmatcgithub/myMovies/blob/master/design_documents/project_plan.md)

### Time Log
* [Timelog](https://github.com/jacquesmatcgithub/myMovies/blob/master/design_documents/time_log.md)