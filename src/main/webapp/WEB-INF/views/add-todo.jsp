<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="fragments/header.jspf" %>
<body>
    <%@ include file="fragments/nav.jspf" %>
    <div class="container">
        <h3>Add todo:</h3>
        <form:form method="post" commandName="todo">
            <form:hidden path="id" />
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label>
                <form:input path="desc" type="text" class="form-control" required="required"/>
                <form:errors path="desc" cssClass="text-warning"/>
            </fieldset>
            <fieldset class="form-group">
				<form:label path="targetDate">Date</form:label>
                <form:input path="targetDate" type="text" class="form-control" required="required"/>
                <form:errors path="targetDate" cssClass="text-warning"/>
            </fieldset>
            <input class="btn btn-primary" type="submit" value="Submit">
		</form:form>
    </div>
</body>
</html>