<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>

<head>
    <title>Modifier produit</title>

</head>
<body>

<h1>Modifier produit</h1>

<form action="" method="post">
    <input type="text"  name="produit" placeholder="produit">

    <input list="categorie" id="categorie_choice" name="categorie_choice" />
    <datalist id = "categorie">
        <option value="pomme" selected></option>
    </datalist>

    <br>

    <input type="nombre"  name="mesure" placeholder="mesure">

    <input list="mesure" id="mesure_choice" name="mesure_choice" />
    <datalist id = "mesure">
        <option value = "kg" selected></option>
    </datalist>

    <br>
    <button type="submit">submit</button>
</form>
</body>
