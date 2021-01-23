<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23-01-21
  Time: 08:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter Produit</title>

</head>
<body>

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
</body>
</html>
