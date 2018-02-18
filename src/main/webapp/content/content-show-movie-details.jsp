<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content" style="height:473px; width:830px;">
    <div style="width:310px; float:left; padding-left: 5px;">
        <img src="${posterUri}" class="post-img" title="${movieName}">
    </div>

    <div style="width:240px; float:left">
        <h2>Description</h2>
        <textarea rows="32" cols="30">${movieDescription}</textarea>
    </div>

    <div style="width:260px; float:left; padding-left: 10px;">
        <table>
            <tr>
                <td align="center"><h2>Rating</h2></td><td align="center"><h2>Your Rating</h2></td>
            </tr>
            <tr>
                <td align="center"><img src="${publicRating}" width="100" class="post-img" title="Movie Rating"></td>
                <td align="center"><img src="${yourRating}" width="100" class="post-img" title="Your Rating"></td>
            </tr>
        </table>
        <br/><br/>
        <table>
            <tr>
                <td></td><td align="center"><h2>Cast</h2></td>
            </tr>
            <tr>
                <td></td><td><textarea rows="10" cols="20">${movieCast}</textarea><br/><br/><br/></td>
            </tr>
            <tr><td align="right">Last Watched:<br/><br/></td><td>${lastTimeWatched}<br/><br/></td></tr>
            <tr><td align="right">Season:<br/><br/></td><td>${seasonOfYear}<br/><br/></td></tr>
            <tr><td align="right">Conditions:<br/><br/></td><td>${weatherConditions}<br/><br/></td></tr>
            <tr><td align="right">Temperature:<br/><br/></td><td>${temperature}<br/><br/></td></tr>
        </table>
    </div>
</div>