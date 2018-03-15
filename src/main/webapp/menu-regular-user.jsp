<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar">
    <h2>Actions</h2>
    <div class="box">
        <ul>
            <li>
                <form action="addNewMovie" method="get">
                    <a href="addNewMovie" onClick="enterMovieName(this.form);">Add Movie</a>
                    <input type="hidden" id="hiddenMovieName" name="hiddenMovieName"/>
                </form>
            </li>
            <b style="color:indianred"><a href="signOut">Sign Out</a></b>
            <l1>${signInMessage}</l1>
        </ul>
        <br/><br/><br/><br/>
        <br/><br/><br/><br/>
        <br/><br/><br/><br/>
        <br/><br/><br/><br/>
        <br/><br/>
        <form action="newPassword" method="GET">
            <input type="button" name="adminPageButton" value="New Password" onClick="passwordChange(this.form);"/>
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
            document.getElementById("hiddenUserLevel").value="regular";

            form.submit();
        }
    }

    function enterMovieName(form) {
        var movieSearchName;
        movieSearchName = prompt('Movie Title', ' ');
        if (movieSearchName != null) {
            document.getElementById("hiddenMovieName").value=movieSearchName;

            form.submit();
        }
    }
</script>
