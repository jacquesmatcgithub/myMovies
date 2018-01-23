<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<c:set var = "pageTitle" value="Hello Admin" scope="request" />

<html xmlns="http://www.w3.org/1999/xhtml">

<c:import url="head-tag.jsp" />
<body>
<div id="wrap">
    <c:import url="header.jsp" />

    <c:import url="menu-admin.jsp" />

    <c:import url="../content/content-admin.jsp" />

    <c:import url="footer.jsp" />
</div>
</body>
</html>