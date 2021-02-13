<%@page pageEncoding="UTF-8" %>
<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>

<h1>Modifier produit</h1>


<form action="" method="post">


    <input type="text"  name="nom" placeholder=${produit.getNom()}>



    <select name="categorie" >
        <c:forEach items="${listCategorie}" var="categorie">
           <option value="${categorie.getId()}" <c:if test = "${fkCategorie == categorie.getId()}">selected</c:if>>${categorie.getNom()}</option>
        </c:forEach>
    </select>

    <br>

    <select name="mesure">
        <c:forEach items="${mesureList}" var="mesure">
            <option value="${mesure.getId()}" <c:if test = "${fkMesure == mesure.getId()}">selected</c:if>>${mesure.getNom()}</option>
        </c:forEach>
    </select>

    <input type="number" name="quantite" placeholder="${produit.getQuantite()}" >

    <input type="hidden"  name="id" value="${produit.getId()}"  />
    <input type="hidden"  name="id" value="${produit.getMagasin()}"  />

    <br>
    <button type="submit">submit</button>
</form>
<%@include file="../template/footer.jsp"%>
