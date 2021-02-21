<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>

<head>
    <title>Modifier magasin</title>

</head>
<body>

<h2>Modifier magasin</h2>
<br>
<form action="" method="post">
    <input type="text"  name="magasin" value="${magasin.getNom()}">
    <input type="hidden"  name="id" value="${magasin.getID()}"  />
    <br><br>
    <button type="submit">Submit</button>
</form>
</body>
