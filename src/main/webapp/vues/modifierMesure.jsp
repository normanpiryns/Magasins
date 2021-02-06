<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>

<head>
    <title>Modifier mesure</title>

</head>
<body>

<h1>Modifier mesure</h1>
<form action="mesadd" method="post">
    <input type="text"  name="mesure" value="${mesure.getNom()}">

    <button type="submit">submit</button>
</form>
</body>
