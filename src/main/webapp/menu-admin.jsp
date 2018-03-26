<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar">
    <h2>Stats</h2>
    <div class="box">
        Admin Users:<br/>${adminUserCount}<br/><br/>
        Regular Users:<br/>${regularUserCount}<br/><br/>
        Total Movies:<br/>${totalNumberOfMovies}<br/><br/>
        <br/><br><br><br/>
        <form action="newPassword" method="GET">
            Old Password:<br/>
            <input type="password" name="currentPassword" size="12" maxlength="45"/> <br/>
            New Password:<br/>
            <input type="password" name="newPassword" size="12" maxlength="45"/>
            <input type="submit" value="Go!" />
        </form>
        ${passwordMessage}
        <br/><br/><br/><br/>
        <b><a href="signOut" style="color:indianred">Sign Out</a></b>
        <br/>
        ${signInMessage}
    </div>
</div>
