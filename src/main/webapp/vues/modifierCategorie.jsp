<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Modifier catégorie</title>

</head>
<body>

<h2>Modifier catégorie</h2>
<br>
<form action="catmod" method="post">
    <input type="text"  name="categorie" value="${categorie.getNom()}"  />
    <input type="hidden"  name="id" value="${categorie.getId()}"  />


    <br><br>
    <button type="submit">Submit</button>
</form>


<%@include file="../template/footer.jsp"%>

