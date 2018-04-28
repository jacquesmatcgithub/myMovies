<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar">
    <h2>Actions</h2>
    <div class="box">
        <form action="addNewMovie" method="GET">
            Add New Movie:<br/>
            <input type="text" name="movieName" size="12" maxlength="45"/> <br/>
            <input type="submit" value="Go!" />
            ${addNewMovieMessage}
        </form>
        <br/><br><br><br/><br/>
        <a href="suggestMovie"><img src="images/suggest_button.png"></a>
        <br/><br/><br/><br/>
        <form action="newPassword" method="GET">
            Old Password:<br/>
            <input type="password" name="currentPassword" size="12" maxlength="45"/> <br/>
            New Password:<br/>
            <input type="password" name="newPassword" size="12" maxlength="45"/>
            <input type="submit" value="Go!" />
        </form>
        ${passwordMessage}
        <br/>
        <b><a href="signOut" style="color:indianred">Sign Out</a></b>
    </div>
</div>
