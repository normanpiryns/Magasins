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
<br>
<p id="error">${errorMsg}</p>
<body>

<table class="table">
    <thead>
        <th scope="col">Nom du produit</th>
        <th scope="col">Nom de catégorie</th>
        <th scope="col">Quantité</th>
        <th scope="col">Mesure</th>
        <th scope="col"></th>
    </thead>
    <tbody>
        <c:forEach items="${produits}" var="produit">
            <tr>
                <td>${produit.getNom()}</td>
                <td>${produit.getCategorie()}</td>
                <td>${produit.getQuantite()}</td>
                <td>${produit.getMesure()}</td>
                <td>
                    <div class="edit-del-wrap">
                        <a href="prodmod?id=${produit.getId()}">✎</a>
                        <a href="prodsup?id=${produit.getId()}&fk_magasin=${fk_magasin}">✖</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<a href="prodadd?id_magasin=${fk_magasin}" id="add-produit">Ajouter produit</a>
<a href="delliste?fk_magasin=${fk_magasin}" id="del-liste" >
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
    </svg>
    Suppression de la liste du magasin
</a>



<%@include file="../template/footer.jsp"%>