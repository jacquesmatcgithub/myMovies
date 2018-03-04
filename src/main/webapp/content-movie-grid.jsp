<%@ page import="edu.matc.controller.GenerateMovieGrid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content" style="height:473px; width:830px; overflow-y: scroll;">
<%
    GenerateMovieGrid.generateGrid(out, request);
%>
</div>
