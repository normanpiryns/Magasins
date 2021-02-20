<%--
  Created by IntelliJ IDEA.
  User: bemerauld
  Date: 23/01/2021
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>

<h2>Mesures</h2>
<br>
<p id="error">${errorMsg}</p>
<ul class="list-group">
    <c:forEach items="${mesures}" var="mesure">
        <li class="list-group-item">${mesure.getNom()}<div class="edit-del-wrap"><a href="mesmod?id=${mesure.getId()}">✎</a><a href="messup?id=${mesure.getId()}">✖</a></div></li>
    </c:forEach>
</ul>
<br>
<form action="mesadd" method="post">
    <input type="text" placeholder="Ajouter une mesure" name="mesure">
    <input class="add-button" type="submit">
</form>

<%@include file="../template/footer.jsp"%>
