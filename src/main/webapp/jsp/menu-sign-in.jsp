<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar">
    <h2>Actions</h2>
    <div class="box">
        <ul>
            <form action="validateSignIn" method="GET">
                Username:<br />
                <input type="text" name="loginId" size="10" maxlength="45" autofocus><br /><br />
                Password: <input type="password" name="password" size="10" maxlength="45" <br /> <br/>
                <input type="submit" name="submit" value="Go!" /><br/><br/>
                <input type="submit" formaction="registerNewUser" value="Register"/>
            </form>

            <br/>${signInMessage}
        </ul>
    </div>
</div>
