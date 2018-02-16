<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content" style="height:473px; width:800px;">
    <div style="width:150px; float:left; padding-left: 60px;">
        <br/>
        <h2>User List(${totalUserCount})</h2>

        <h2>
        <form action="selectedUser" method="GET">
            <select name="listOfUsers" onchange="this.form.submit()" size="15" style="width: 140px; padding-left: 2px; color: #555;">
                <c:forEach var="userList" items="${users}">
                    <c:choose>
                        <c:when test="${userList.loginId == detailsLoginId}">
                            <option value="${userList.loginId}" selected>${userList.loginId}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${userList.loginId}">${userList.loginId}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </form>
        </h2>
    </div>



    <div style="width:300px; float:left; padding-left: 25px;">
        <br/>
        <form action="crudUser" method="GET">
            <table>
                <tr><td align="right"><h2>Details</h2></td><td align="center"><b>${userDetailsMessage}</b></td></tr>
                <tr>
                    <td align="right">Login ID:</td>
                    <td><input ${loginIdAutofocus} type="text" name="loginId" id="inputField" size="25" maxlength="45" value="${detailsLoginId}"/><br/></td>
                </tr>
                <tr></tr>
                <tr>
                    <td align="right">First Name:</td>
                    <td><input ${firstNameAutofocus} type="text" name="firstName" size="25" maxlength="45" value="${detailsFirstName}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">Last Name:</td>
                    <td><input ${lastNameAutofocus} type="text" name="lastName" size="25" maxlength="45" value="${detailsLastName}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">Date Active:</td>
                    <td><input ${dateActiveAutofocus} type="date" name="dateActive" size="25" maxlength="45" value="${detailsDateActive}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="checkbox" name="adminUser" value="adminUser" ${userDetailsAdminCheckBox}> Admin User?
                    <input type="checkbox" name="activeUser" value="activeUser" ${userDetailsActiveCheckBox}>Active?</td>
                </tr>
                <tr>
                    <td></td>
                    <td><br/>
                        <input type="submit" name="adminPageButton" value="Add/Update" />
                        <input type="submit" name="adminPageButton" value="Delete"/>
                    </td>
                </tr>
            </table>
        </form>

    </div>


    <form action="crudMovieStats" method="GET">

    <div style="width:200px; border:1px; float:left; padding-left: 30px;">
        <br/>
        <h2>Movies(${userMovieCount})</h2>
        <h2>
        <select disabled name="movieList" size="15" style="width: 190px; padding-left: 2px; color: #555;">
            <c:forEach var="listOfMovies" items="${movies}">
                <option value="${listOfMovies.name}">${listOfMovies.name}</option>
            </c:forEach>
        </select>
        </h2>
    </div>
    </form>
</div>

