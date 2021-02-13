<%--
  Created by IntelliJ IDEA.
  User: bemerauld
  Date: 23/01/2021
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!-- Nom du magasin -->
<h2>${magasin.nom}</h2>


<body>



<a href="#" id="del-liste">DEL</a>

<div class="content">
    <ul class="list-group">
        <c:forEach items="${produits}" var="produit">
            <li class="list-group-item">${produit.nom} - ${produit.categorie} ${produit.quantite} ${produit.mesure}<div class="edit-del-wrap"><a href="/prodmod?id=${produit.id}">✎</a><a href="/prodsup?id=${produit.id}">✖</a></div></li>
        </c:forEach>

    </ul>
</div>

<a href="prodadd?id_magasin=${id_magasin}" id="add-produit">Ajouter produit</a>



<%@include file="../template/footer.jsp"%>