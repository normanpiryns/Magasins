<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>
<%@page pageEncoding="UTF-8" %>
<body>

<h1>Ajouter produit</h1>
<br>

<form action="prodadd" method="post">

    <input type="text" name="nom_produit" placeholder="Nom du produit" />


    <select name="categorie">
        <c:forEach items="${categories}" var="categorie">
            <option value="${categorie.getId()}">${categorie.getNom()}</option>
        </c:forEach>

    </select>
    <br>

    <input type="number"  name="quantite" placeholder="Quantité">

    <select name="mesure">
        <c:forEach items="${mesures}" var="mesure">
            <option value="${mesure.getId()}">${mesure.getNom()}</option>
        </c:forEach>

    </select>

    <input type="hidden"  name="id_magasin"  value="${id_magasin}"> <!-- overwrite? -->

    <br>
    <button type="submit">Submit</button>
</form>
</body>

