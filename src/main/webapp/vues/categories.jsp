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
        <li class="list-group-item">categorie.getNom<div class="edit-del-wrap"><a href="#">✎</a><a href="#">✖</a></div></li>
    </c:forEach>



    <li class="list-group-item">Lorem ipsum<div class="edit-del-wrap"><a href="#">✎</a><a href="#">✖</a></div></li>
</ul>
<br>
<form action="" method="post">
    <input type="text" placeholder="Ajouter une catégorie">
    <input type="submit">

</form>

<%@include file="../template/footer.jsp"%>


