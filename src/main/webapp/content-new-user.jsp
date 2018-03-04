<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="newUserMessage" value="new user" scope="session" />

<div id="content" style="position:center; top:250px; height:473px;">
        <form method="POST" action="registerUser">
            <table cellspacing="10">
                <tr><td><h2>Register as a new user</h2></td></tr>
                <tr><td><br/><h3>${newUserMessage}</h3><br/></td></tr>
            </table>
            <table cellspacing="10">
                <tr><td>First Name</td>
                    <td><input type="text" name="firstName" size="30" maxlength="25" autofocus></td>
                </tr>
                <tr><td>Last Name</td>
                    <td><input type="text" name="lastName" size="30" maxlength="30"></td>
                </tr>
                <tr><td>User ID</td>
                    <td><input type="text" name="uerId" size="30" maxlength="20"></td>
                </tr>
                <tr><td><br /><input type="submit" value="Register"></td></tr>
            </table>
        </form>
</div>
