<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar">
    <h2>Actions</h2>
    <div class="box">
        <ul>
            <FORM ACTION="j_security_check" METHOD="POST">
                Username:<br />
                <INPUT TYPE="TEXT" NAME="j_username" size="10" maxlength="45" autofocus><br /><br />
                Password:<br />
                <INPUT TYPE="PASSWORD" NAME="j_password" size="10" maxlength="45"> <br /> <br/>
                <INPUT TYPE="SUBMIT" value="Go!" /><br/><br/>
            </FORM>
        </ul>
    </div>
</div>
