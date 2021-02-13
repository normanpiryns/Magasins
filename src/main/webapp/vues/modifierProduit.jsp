<%@page pageEncoding="UTF-8" %>
<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>

<h1>Modifier produit</h1>


<form action="prodmod" method="post">


    <input type="text"  name="produit" placeholder=${produit.getNom()}>



    <select name="categorie">
        <c:forEach items="${categories}" var="categorie">
           <option> ${categorie.getNom()}</option>
        </c:forEach>
    </select>

    <br>

    <select name="mesure">
        <c:forEach items="${mesures}" var="mesure">
            <option> ${mesure.getNom()}</option>
        </c:forEach>
    </select>

    <input type="number" name="quantite" placeholder="${produit.getQuantite()}" >

    <input type="hidden"  name="id" value="${produit.getId()}"  />

    <br>
    <button type="submit">submit</button>
</form>
<%@include file="../template/footer.jsp"%>
