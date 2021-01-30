<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>

<head>
    <title>Modifier catégorie</title>

</head>
<body>

<h1>Modifier catégorie</h1>

<form action="" method="post">
    <input type="text"  name="catégorie" placeholder="catégorie" value='<c:out value="${categorie.nom_categorie}"/>'> <!-- Je ne suis pas sûr que ça se fait de cette manière - Norman -->

    <br>
    <button type="submit">submit</button>
</form>


<%@include file="../template/footer.jsp"%>

