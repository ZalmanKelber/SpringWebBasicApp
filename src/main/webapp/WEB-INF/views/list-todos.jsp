<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="fragments/header.jspf" %>
<body>
    <div class="container">
        <%@ include file="fragments/nav.jspf" %>
        <h3>Hello, ${name}</h3><br>
        <table class="table table-striped">
            <caption>Your todos are:</caption>
            <thead>
                <td>description:</td><td>date:</td><td>status</td>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.desc}</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
                        <td>${todo.done ? "completed" : "incomplete"}</td>
                        <td>
                            <a class="btn btn-primary" href="/update-todo?id=${todo.id}">Update</a>
                            <a class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
        
            </tbody>
        </table>
        <br>
        <a class="btn btn-primary" href="/add-todo">Add</a>
    </div>
    <%@ include file="fragments/closingtags.jspf" %>
</body>
</html>