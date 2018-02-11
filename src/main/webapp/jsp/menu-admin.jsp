<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar">
    <h2>Actions</h2><br/>
    <div class="box">
        <ul>
            <li><a href="searchUserServlet">Search User</a><br/><br/></li>
            <li><a href="newUserServlet">New User</a><br/><br/></li>
            <li><a href="deleteUserServlet">Delete User</a><br/><br/></li>
            <li><a href="updateUserServlet">Update User</a><br/><br/></li>
            <li><a href="resetPasswordUserServlet">Reset Password</a><br/><br/></li>
            <li><a href="suspendUserServlet">Suspend User</a><br/><br/></li>
            <li><a href="restoreUserServlet">Restore User</a><br/><br/></li>
            <l1>${signInMessage}</l1>
        </ul>
    </div>
</div>
