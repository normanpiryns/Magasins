<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>

<h1>Magasins</h1>
${errorMsg}
<ul class="list-group"><!-- foreach loop from db -->

    <c:forEach items="${magasins}" var="magasin">
        <li class="list-group-item">${magasin.getNom()}<div class="edit-del-wrap"><a href="magmod?id=${magasin.getID()}">✎</a><a href="magsup?id=${magasin.getID()}">✖</a></div></li>
    </c:forEach>
</ul>

<br>
<form action="magadd" method="post">
    <input type="text" placeholder="Ajouter un magasin" name="magasin">
    <input type="submit">

</form>

<%@include file="../template/footer.jsp"%>

