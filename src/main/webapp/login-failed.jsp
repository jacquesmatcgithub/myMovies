<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">

<c:set var="pageTitle" value="myMovies" scope="request" />

<c:import url="jsp/head-tag.jsp" />
<body>
<div id="wrap">
  <c:import url="jsp/header.jsp" />

  <c:import url="jsp/menu-sign-in-failed.jsp" />

  <c:import url="content/content-home.jsp" />

  <c:import url="jsp/footer.jsp" />
</div>
</body>
</html>