<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<c:set var="pageTitle" value="Movie Details" scope="request" />

<html xmlns="http://www.w3.org/1999/xhtml">

<c:import url="head-tag.jsp" />
<body>
<div id="wrap">
    <c:import url="header.jsp" />

    <c:import url="menu-show-movie-details.jsp" />

    <c:import url="../content/content-show-movie-details.jsp" />

    <c:import url="footer.jsp" />
</div>
</body>
</html>