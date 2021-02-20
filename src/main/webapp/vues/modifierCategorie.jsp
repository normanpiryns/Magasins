<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Modifier catégorie</title>

</head>
<body>

<h1>Modifier catégorie</h1>

<form action="catmod" method="post">
    <input type="text"  name="categorie" value="${categorie.getNom()}"  />
    <input type="hidden"  name="id" value="${categorie.getId()}"  />
    <!-- Je ne suis pas sûr que ça se fait de cette manière - Norman -->

    <br>
    <button type="submit">submit</button>
</form>


<%@include file="../template/footer.jsp"%>

