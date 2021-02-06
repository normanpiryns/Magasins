<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>

<head>
    <title>Modifier mesure</title>

</head>
<body>

<h1>Modifier mesure</h1>
<form action="mesmod" method="post">
    <input type="hidden" name="id" value="${mesure.getId()}">
    <input type="text"  name="mesure" value="${mesure.getNom()}">

    <button type="submit">submit</button>
</form>
</body>
