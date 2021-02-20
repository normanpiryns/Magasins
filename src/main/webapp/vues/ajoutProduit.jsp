<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>
<%@page pageEncoding="UTF-8" %>
<body>

<h1>Ajouter produit</h1>

<form action="prodadd" method="post">

    <input type="text" name="nom_produit" placeholder="produit" />


    <select name="categorie">
        <c:forEach items="${categories}" var="categorie">
            <option value="${categorie.getId()}">${categorie.getNom()}</option>
        </c:forEach>

    </select>
    <br>

    <input type="number"  name="quantite" placeholder="quantite">

    <select name="mesure">
        <c:forEach items="${mesures}" var="mesure">
            <option value="${mesure.getId()}">${mesure.getNom()}</option>
        </c:forEach>

    </select>

    <input type="hidden"  name="id_magasin"  value="${id_magasin}"> <!-- overwrite? -->

    <br>
    <button class="add-button" type="submit">submit</button>
</form>
</body>

