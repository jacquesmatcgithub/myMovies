<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar">
    <h2>Actions</h2>
    <div class="box">
        <ul>
            <li><a href="performMovieActions?movieDetailAction=watched">Watched it!</a></li>
            <li><a href="performMovieActions?movieDetailAction=delete" onclick="confirmMovieDelete(this)">Delete it!</a></li>
            <br/><br/>
            <li><a href="performMovieActions?movieDetailAction=clearStats" onclick="confirmClearStats(this)">Clear Stats</a></li>
            <l1>${signInMessage}</l1>
            <br/><br/><br/>
            <a href="prepareCollectorPage"><img src="images/back-button-1-small.png"></a>

            <br/><br/><br/>
            <br/><br/><br/>
            <br/><br/>

            <a href="http://www.wunderground.com"><img src="http://icons.wxug.com/graphics/wu2/logo_130x80.png"></a>

        </ul>
    </div>
</div>

<script type="text/javascript">
    function confirmMovieDelete(obj) {
        if (confirm("Are you sure you want to delete the movie?")) {
            obj.href = "performMovieActions?movieDetailAction=delete";
            return true;
        } else {
            obj.href = "";
            return false;
        }
    }

    function confirmClearStats(obj) {
        if (confirm("Are you sure you want to clear the movie stats?")) {
            obj.href = "performMovieActions?movieDetailAction=clearStats";
            return true;
        } else {
            obj.href = "";
            return false;
        }
    }
</script>
