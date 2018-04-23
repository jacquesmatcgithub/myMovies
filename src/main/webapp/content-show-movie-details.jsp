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
        <table class="ratingTable" >
            <tr>
                <td align="center"><h2><br/>Public Rating</h2></td>
            </tr>
            <tr>
                <td align="center">
                    <img src="${publicRating1}" title="Movie Rating1">
                    <img src="${publicRating2}" title="Movie Rating2">
                    <img src="${publicRating3}" title="Movie Rating3">
                    <img src="${publicRating4}" title="Movie Rating4">
                    <img src="${publicRating5}" title="Movie Rating5">
                </td>
            </tr>
            <tr>
                <td align="center"><h2><br/><br/>Your Rating</h2></td>
            </tr>
            <tr>
                <td align="center">
                    <a href="clickedRating?ratingNumber=${ratingNumber1}"><img src="${userRating1}" title="1 star"></a>
                    <a href="clickedRating?ratingNumber=${ratingNumber2}"><img src="${userRating2}" title="2 stars"></a>
                    <a href="clickedRating?ratingNumber=${ratingNumber3}"><img src="${userRating3}" title="3 stars"></a>
                    <a href="clickedRating?ratingNumber=${ratingNumber4}"><img src="${userRating4}" title="4 stars"></a>
                    <a href="clickedRating?ratingNumber=${ratingNumber5}"><img src="${userRating5}" title="5 stars"></a>
                </td>
            </tr>
        </table>
        <table>

            <tr>
                <td class="weatherCondition" align="right"><br/><br/><br/><br/>Last Watched : <br/></td>
                <td><br/><br/><br/><br/>${lastWatched}<br/></td>
            </tr>
            <tr>
                <td class="weatherCondition" align="right">Conditions :</td>
                <td>${weatherConditions}<a href="${forecastUrl}"><img src="${weatherIcon}" class="weatherIcon"></a></td>
            </tr>
            <tr>
                <td class="weatherCondition" align="right"><br/>Temperature : <br/><br/></td>
                <td><br/>${temperature}<br/><br/></td></tr>
            <tr>
                <td class="weatherCondition" align="right">Viewings : <br/><br/></td>
                <td>${viewings}<br/><br/></td></tr>
        </table>
    </div>
</div>

