<%--
  Created by IntelliJ IDEA.
  User: bemerauld
  Date: 30/01/2021
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>


<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>
<%@page pageEncoding="UTF-8" %>

<body>

<h2>Liste de magasins</h2>
<br>

<ul class="list-group">
    <c:forEach items="${magasins}" var="magasin">

        <li class="list-group-item"><a href="prod?id=${magasin.getID()}">${magasin.getNom()}</a> </li>
    </c:forEach>
</ul>
<c:if test="${magasins.isEmpty()}">
<form action="magadd" method="post">
    <input type="text" placeholder="Ajouter un magasin" name="magasin">
    <input class="add-button" type="submit"/>
</form>
</c:if>

<%@include file="../template/footer.jsp"%>
