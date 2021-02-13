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



<h2>${mag_name}</h2>


<body>



<a href="/delliste?id=${fk_magasin}" id="del-liste">DEL</a>
<div style="clear: both"></div>

    <ul class="list-group">
        <c:forEach items="${produits}" var="produit">
            <li class="list-group-item">${produit.getNom()} - ${produit.getCategorie()} ${produit.getQuantite()} ${produit.getMesure()}<div class="edit-del-wrap"><a href="/ServletProdMod?id=${produit.getId()}">✎</a><a href="/prodsup?id=${produit.getId()}">✖</a></div></li>
        </c:forEach>

    </ul>


<a href="prodadd?id_magasin=${fk_magasin}" id="add-produit">Ajouter produit</a>



<%@include file="../template/footer.jsp"%>