<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar">
    <h2>Stats</h2>
    <div class="box">
        Admin Users:<br/>${adminUserCount}<br/><br/>
        Regular Users:<br/>${regularUserCount}<br/><br/>
        Total Movies:<br/>${totalNumberOfMovies}<br/><br/>
        <br/><br/><br/><br/>
        <form action="newPassword" method="GET">
            <input type="button" name="adminPageButton" value="Change Password" onClick="passwordChange(this.form);"/>
            <input type="hidden" id="hiddenPassword" name="hiddenPassword"/>
            <input type="hidden" id="hiddenUserLevel" name="hiddenUserLevel"/>
        </form>
        ${passwordMessage}
    </div>
</div>

<script language="JavaScript">
    function passwordChange(form) {
        var password;
        password = prompt('Enter New Password', ' ');
        if (password != null) {
            document.getElementById("hiddenPassword").value=password;
            document.getElementById("hiddenUserLevel").value="admin";

            form.submit();
        }
    }
</script>
