<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="pageTitle" value="myMovies" scope="request" />

<head>
  <title>myMovies</title>
  <meta http-equiv="Content-Language" content="German" />
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="css/myMovieStyle.css" media="screen" />
  <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed' rel='stylesheet' type='text/css' />
</head>

<body>
<div id="wrap">
  <div id="header">
    <h1>
      <a href="index.jsp">myMovies</a>
      <span class="post-span">Jacques Fourie, Enterprise Java,
            Spring 2018 (This product uses the TMDb API but is not endorsed or certified by TMDb)</span>
      <div style="float: right; padding-right: 20px;">
        <a href="https://www.themoviedb.org"><img src="images/408x161-powered-by-rectangle-green.png" width="120"></a>
      </div>
    </h1>
  </div>

  <c:import url="/menu-sign-in.jsp" />

  <div id="content" style="position:center; top:250px; height:473px;">
    <img src="images/background.jpeg" class="post-img" alt="background" />
  </div>

  <c:import url="/footer.jsp" />
</div>
</body>
</html>