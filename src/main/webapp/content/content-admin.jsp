<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content" style="height:473px; width:800px;">

    <div style="width:150px; float:left; padding-left: 30px;">
        <br/>
        <h2>User List</h2>

        <h2>
        <form action="selectedUser" method="GET">
            <select name="listOfUsers" onchange="this.form.submit()" size="15" style="width: 140px; padding-left: 2px; color: #555;">
                <c:forEach var="userList" items="${users}">
                    <option value="${userList.userId}">${userList.userId}</option>
                </c:forEach>
            </select>
        </form>
        </h2>
    </div>



    <div style="width:300px; float:left; padding-left: 25px;">
        <br/>
        <form action="crudUser" method="GET">
            <table>
                <tr><td align="right"><h2>Details</h2></td></tr>
                <tr>
                    <td align="right">User ID:</td>
                    <td><input autofocus type="text" name="userId" id="inputField" size="25" maxlength="45" value="${detailsUserId}"/><br/></td>
                </tr>
                <tr></tr>
                <tr>
                    <td align="right">First Name:</td>
                    <td><input type="text" name="firstName" size="25" maxlength="45" value="${detailsFirstName}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">Last Name:</td>
                    <td><input type="text" name="lastName" size="25" maxlength="45" value="${detailsLastName}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">Catalog Name:</td>
                    <td><input type="text" name="catalogName" size="25" maxlength="45" value="${detailsCatalogName}"/></td>
                </tr>
                <tr>
                    <td align="right">Date Active:</td>
                    <td><input type="text" name="dateActive" size="25" maxlength="45" value="${detailsDateActive}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="checkbox" name="adminUser" value="adminUser" ${userDetailsAdminCheckBox}> Admin User?
                    <input type="checkbox" name="activeUser" value="activeUser" ${userDetailsActiveCheckBox}>Active?</td>
                </tr>
                <tr>
                    <td></td>
                    <td><br/>
                        <input type="submit" name="userDetailsButton" value="Add/Update" />
                        <input type="submit" name="userDetailsButton" value="Search"/>
                        <input type="submit" name="userDetailsButton" value="Delete"/>
                    </td>
                </tr>
                <tr><td></td><td>${userDetailsMessage}</td></tr>
            </table>
        </form>

    </div>



    <div style="width:200px; border:1px; float:left; padding-left: 30px;">
        <br/>
        <h2>Movies</h2>
        <h2>
        <select name="movieList" size="15" style="width: 190px; padding-left: 2px; color: #555;">
            <option value="movie1">movie1</option>
            <option value="movie2">movie2</option>
            <option value="movie3">movie3</option>
            <option value="movie4">movie4</option>
            <option value="movie4">movie5</option>
            <option value="movie4">movie6</option>
            <option value="movie4">movie7</option>
            <option value="movie4">movie8</option>
            <option value="movie4">movie9</option>
            <option value="movie4">movie10</option>
            <option value="movie4">movie11</option>
            <option value="movie4">movie12</option>
            <option value="movie4">movie13</option>
            <option value="movie4">movie14</option>
            <option value="movie4">movie15</option>
            <option value="movie4">movie16</option>
            <option value="movie4">movie17</option>
            <option value="movie4">movie18</option>
            <option value="movie4">movie19</option>
            <option value="movie4">movie20</option>
            <option value="movie4">movie21</option>
            <option value="movie4">movie22</option>
            <option value="movie4">movie23</option>
            <option value="movie4">movie24</option>
            <option value="movie4">movie25</option>
            <option value="movie4">movie26</option>
            <option value="movie4">movie27</option>
            <option value="movie4">movie28</option>
            <option value="movie4">movie29</option>
            <option value="movie4">movie30</option>
        </select>
        </h2>
    </div>



    <div style="width:50px; border:1px; float:left;">
        <br/>
        <h2>Sats</h2>
        <form action="resetStats" method="GET">
            <input type="submit" name="resetStats" value="Reset" /><br/>
            <input type="submit" formaction="resetAllStats" value="Reset All"/>
        </form>
    </div>
</div>

