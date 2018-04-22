<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content" style="height:473px; width:830px;">
    <div style="width:310px; float:left; padding-left: 5px;">
        <img src="${posterUri}" class="post-img" title="${movieName}">
    </div>

    <div style="width:240px; float:left">
        <h2>Description</h2>
        <textarea style="width:230px; height:180px; resize:none; font-family: 'Roboto Condensed', sans-serif; font-size: 1em;" rows="10" cols="30">${movieDescription}</textarea>
        <br/><br/>
        <h2>Cast & Crew</h2>
        <select disabled name="castList" size="12" style="width: 230px; font-family: 'Roboto Condensed', sans-serif; font-size: 1em; padding-left: 2px; color: #555;">
            <option>---- Cast ----</option>
            <c:forEach var="castMember" items="${movieCast}">
                <option value="${castMember.name}">${castMember.name} (${castMember.character})</option>
            </c:forEach>
            <option></option>
            <option>---- Crew ----</option>
            <c:forEach var="crewMember" items="${movieCrew}">
                <option value="${CrewMember.name}">${crewMember.name} (${crewMember.job})</option>
            </c:forEach>
        </select>
    </div>

    <div style="width:260px; float:left; padding-left: 10px;">
        <table>
            <tr>
                <td align="center"><h2>Rating</h2></td><td align="center"><h2>Your Rating</h2></td>
            </tr>
            <tr>
                <td align="center"><img src="${publicRating}" width="100" class="post-img" title="Movie Rating"></td>
                <td align="center"><a href="clickedRating?ratingNumber=${ratingNumber}"><img src="${userRating}" width="100" class="post-img" title="Your Rating"></td>
            </tr>
            <tr><td align="right"><br/><br/><br/><br/>Last Watched : <br/><br/></td><td><br/><br/><br/><br/>${lastWatched}<br/><br/></td></tr>
            <tr><td align="right">Conditions : <br/><br/></td><td>${weatherConditions}<br/><br/></td></tr>
            <tr><td align="right">Temperature : <br/><br/></td><td>${temperature}<br/><br/></td></tr>
            <tr><td align="right">Viewings : <br/><br/></td><td>${viewings}<br/><br/></td></tr>
        </table>
    </div>
</div>

                                              <!-- <a href="https://www.themoviedb.org"><img src="images/408x161-powered-by-rectangle-green.png" width="120"></a>  -->
