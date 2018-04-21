<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar">
    <h2>Actions</h2>
    <div class="box">
        <ul>
            <li><a href="performMovieActions?movieDetailAction=watched">Watched it!</a></li>
            <li><a href="performMovieActions?movieDetailAction=delete">Delete it!</a></li>
            <br/>
            <li><a href="performMovieActions?movieDetailAction=clearStats">Clear Stats</a></li>
            <l1>${signInMessage}</l1>
        </ul>
    </div>
</div>
