<%@page pageEncoding="UTF-8" %>
<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>

<h1>Ajouter produit</h1>

<form action="" method="post">
    <input type="text"  name="nom du produit" placeholder="produit">

    <input list="categorie" id="categorie_choice" name="categorie_choice" />
    <datalist id = "categorie">
        <option value="pomme" selected></option>
    </datalist>

    <br>

    <input type="nombre"  name="nom du produit" placeholder="mesure">

    <input list="mesure" id="mesure_choice" name="mesure_choice" />
    <datalist id = "mesure">
        <option value = "kg" selected></option>
    </datalist>

    <br>

    <input type="text" readonly name="magasin" placeholder="magasin">
    <input list="magasin" id="magasin_choice" name="magasin_choice" />
    <datalist id = "magasin">
        <option value="delhaize" selected></option>
    </datalist>

    <br>

    <button type="submit">Connect</button>
</form>
<%@include file="../template/footer.jsp"%>
