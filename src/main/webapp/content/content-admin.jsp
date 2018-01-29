<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="content">
    <div class = "tabinator">
        <input type = "radio" id = "tab1" name = "tabs" checked>
        <label for = "tab1">Users</label>
        <input type = "radio" id = "tab2" name = "tabs">
        <label for = "tab2">Catalogs</label>
        <input type = "radio" id = "tab3" name = "tabs">
        <label for = "tab2">Movies</label>

        <div id = "content1" style="height:500px; width:650px; overflow-y: scroll;">
        </div>
        <div id = "content2" style="height:500px; width:650px; overflow-y: scroll;">
        </div>
        <div id = "content3" style="height:500px; width:650px; overflow-y: scroll;">
        </div>
    </div>
</div>

