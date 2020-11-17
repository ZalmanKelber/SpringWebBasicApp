<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="fragments/header.jspf" %>
<body>
    <div class="container">
        <%@ include file="fragments/nav.jspf" %>
        Welcome, ${name}
        <p>view your todos at <a href="/list-todos">your todos page</a></p>
    </div>
<%@ include file="fragments/closingtags.jspf" %>
</body>
</html>