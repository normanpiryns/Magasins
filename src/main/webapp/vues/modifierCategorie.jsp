<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>

<head>
    <title>Modifier catégorie</title>

</head>
<body>

<h1>Modifier catégorie</h1>
${categorie.getNom()}
${categorie.getId()}
<form action="catmod" method="post">
    <input type="text"  name="categorie" placeholder="${categorie.getNom()}"  />
    <input type="text"  name="id" value="${categorie.getId()}" hidden />
    <!-- Je ne suis pas sûr que ça se fait de cette manière - Norman -->

    <br>
    <button type="submit">submit</button>
</form>


<%@include file="../template/footer.jsp"%>

