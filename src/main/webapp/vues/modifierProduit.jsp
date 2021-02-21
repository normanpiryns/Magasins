<%@page pageEncoding="UTF-8" %>
<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>

<h2>Modifier produit</h2>
<br>


<form action="prodmod" method="post">


    <input type="text"  name="nom" value="${produit.getNom()}">

    <select name="categorie" >
        <c:forEach items="${listCategorie}" var="categorie">
           <option value="${categorie.getId()}" <c:if test = "${fkCategorie == categorie.getId()}">selected</c:if>>${categorie.getNom()}</option>
        </c:forEach>
    </select>

    <br>

    <input type="number" name="quantite" value="${produit.getQuantite()}" >

    <select name="mesure">
        <c:forEach items="${mesureList}" var="mesure">
            <option value="${mesure.getId()}" <c:if test = "${fkMesure == mesure.getId()}">selected</c:if>>${mesure.getNom()}</option>
        </c:forEach>
    </select>



    <input type="hidden"  name="id" value="${produit.getId()}"  />
    <input type="hidden"  name="magasin" value="${produit.getMagasin()}"  />

    <br>
    <button type="submit">Submit</button>
</form>
<%@include file="../template/footer.jsp"%>
