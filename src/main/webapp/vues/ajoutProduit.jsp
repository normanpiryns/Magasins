<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>
<head>
    <title>Ajouter Produit</title>

</head>
<body>

<h1>Ajouter produit</h1>

<form action="prodadd" method="post">

    <input list="produit" id="produit_choice" name="produit_choice" placeholder="produit" />
    <datalist id = "produit">
        <option value="pomme" selected></option>
    </datalist>

    <input list="categorie" id="categorie_choice" name="categorie_choice" placeholder="catégorie" />
    <datalist id = "categorie">
        <option value="fruit" selected></option>
    </datalist>

    <br>

    <input type="number"  name="mesure" placeholder="mesure">

    <input list="mesure_type" id="mesure_choice" name="mesure_choice" placeholder="mesure"/>
    <datalist id = "mesure_type">
        <option value = "kg" selected ></option>
    </datalist>

    <input type="hidden"  name="magasin"  value="">

    <br>
    <button type="submit">submit</button>
</form>
</body>

