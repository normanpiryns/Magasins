<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>

<head>
    <title>Modifier magasin</title>

</head>
<body>

<h1>Modifier magasin</h1>

<form action="" method="post">
    <input type="text"  name="magasin" placeholder="${magasin.getNom()}">
    <input type="hidden"  name="id" value="${magasin.getID()}"  />
    <br>
    <button type="submit">submit</button>
</form>
</body>
