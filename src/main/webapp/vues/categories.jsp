<%--
  Created by IntelliJ IDEA.
  User: bemerauld
  Date: 23/01/2021
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>

<h2>Catégories</h2>
<br>
<ul class="list-group"><!-- foreach loop from db -->

    <c:forEach items="${categories}" var="categorie">
        <li class="list-group-item">${categorie.getNom()}<div class="edit-del-wrap"><a href="catmod?id=${categorie.getId()}">✎</a><a href="catsup?id=${categorie.getId()}">✖</a></div></li>
    </c:forEach>

</ul>
<br>
<form action="catadd" method="post">
    <input type="text" placeholder="Ajouter une catégorie" name="categorie">
    <input type="submit">

</form>

<%@include file="../template/footer.jsp"%>


