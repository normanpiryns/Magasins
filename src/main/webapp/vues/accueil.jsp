<%--
  Created by IntelliJ IDEA.
  User: bemerauld
  Date: 30/01/2021
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>


<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>
<%@page pageEncoding="UTF-8" %>

<body>

<ul class="list-group">
    <c:forEach items="${magasins}" var="magasin">

        <li class="list-group-item"><a href="liste?id=${magasin.getID()}">${magasin.getNom()}</a> </li>
    </c:forEach>



</ul>

<%@include file="../template/footer.jsp"%>
