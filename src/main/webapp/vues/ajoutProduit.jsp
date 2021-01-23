<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>

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

    <input type="number"  name="mesure" placeholder="mesure">

    <input list="mesure" id="mesure_choice" name="mesure_choice" />
    <datalist id = "mesure">
        <option value = "kg" selected></option>
    </datalist>



    <button type="submit">Connect</button>
</form>
</body>

