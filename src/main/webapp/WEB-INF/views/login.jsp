<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="fragments/header.jspf" %>
<body>
    <%@ include file="fragments/nav.jspf" %>
<div class="container">
    <h3>Sign in</h3>
    <p style="color: red;">${errorMessage}</p>
    <form action="/login.do" method="post">
        <fieldset class="form-group">
            <flabel >Enter your name:</label>
            <input name="name" type="text" class="form-control" required="required"/>
        </fieldset>
        <fieldset class="form-group">
            <flabel >Password:</label>
            <input name="password" type="password" class="form-control" required="required"/>
        </fieldset>
        <input class="btn btn-primary" type="submit" value="Submit">
    </form>
</div>
<%@ include file="fragments/closingtags.jspf" %>
</body>
</html>