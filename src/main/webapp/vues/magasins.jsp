<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>

<h2>Magasins</h2>
<br>
<p id="error">${errorMsg}</p>
<ul class="list-group"><!-- foreach loop from db -->
    <c:forEach items="${magasins}" var="magasin">
        <li class="list-group-item">${magasin.getNom()}<div class="edit-del-wrap"><a href="magmod?id=${magasin.getID()}">✎</a><a href="magsup?id=${magasin.getID()}">✖</a></div></li>
    </c:forEach>
</ul>

<br>
<form action="magadd?accueil=0" method="post">
    <input type="text" placeholder="Ajouter un magasin" name="magasin">
    <input class="add-button" type="submit"/>

</form>

<%@include file="../template/footer.jsp"%>

