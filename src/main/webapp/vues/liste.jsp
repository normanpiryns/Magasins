<%--
  Created by IntelliJ IDEA.
  User: bemerauld
  Date: 23/01/2021
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../template/header.jsp"%>
<%@include file="../template/navigation.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!-- Nom du magasin -->
<h2>Lorem Ipsum</h2>


<body>



<a href="#" id="del-liste">DEL</a>
<!-- foreach categorie -->
<button type="button" class="collapsible">Lorem ipsum</button>
<div class="content">
    <!-- foreach produit in categorie in liste -->
    <ul class="list-group">
        <li class="list-group-item">Lorem ipsum<div class="edit-del-wrap"><a href="#">✎</a><a href="#">✖</a></div></li>

        <li class="list-group-item">Lorem ipsum<div class="edit-del-wrap"><a href="#">✎</a><a href="#">✖</a></div></li>
    </ul>
</div>

<a href="#" id="add-produit">Ajouter produit</a>
<script>
    var coll = document.getElementsByClassName("collapsible");
    var i;

    for (i = 0; i < coll.length; i++) {
        coll[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var content = this.nextElementSibling;
            if (content.style.display === "block") {
                content.style.display = "none";
            } else {
                content.style.display = "block";
            }
        });
    }
</script>


<%@include file="../template/footer.jsp"%>