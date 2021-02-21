<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>

<head>
    <title>Modifier mesure</title>

</head>
<body>

<h2>Modifier mesure</h2>
<br>
<form action="mesmod" method="post">
    <input type="hidden" name="id" value="${mesure.getId()}">
    <input type="text"  name="mesure" value="${mesure.getNom()}">
    <br><br>
    <button type="submit">Submit</button>
</form>
</body>
