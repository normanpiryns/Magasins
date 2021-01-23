<%--
  Created by IntelliJ IDEA.
  User: bemerauld
  Date: 23/01/2021
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>

<h2>Mésures</h2>
<br>
<ul class="list-group"><!-- foreach loop from db -->
    <li class="list-group-item">Lorem ipsum<div class="edit-del-wrap"><a href="#">✎</a><a href="#">✖</a></div></li>

    <li class="list-group-item">Lorem ipsum<div class="edit-del-wrap"><a href="#">✎</a><a href="#">✖</a></div></li>
</ul>
<br>
<form action="" method="post">
    <input type="text" placeholder="Ajouter une mésure">
    <input type="submit">

</form>

<%@include file="../template/footer.jsp"%>


