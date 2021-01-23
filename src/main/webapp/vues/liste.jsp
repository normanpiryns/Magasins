<%--
  Created by IntelliJ IDEA.
  User: bemerauld
  Date: 23/01/2021
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<!-- Il faut inclure le header and la navigation -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .collapsible {
        background-color: #777;
        color: white;
        cursor: pointer;
        padding: 18px;
        width: 100%;
        border: none;
        text-align: left;
        outline: none;
        font-size: 15px;
    }

    .active, .collapsible:hover {
        background-color: #555;
    }

    .content {
        padding: 0 18px;
        display: none;
        overflow: hidden;
        background-color: #f1f1f1;
    }
    .edit-del-wrap{
        display: inline-block;
        float: right;
        margin-top: 16px;
        margin-bottom: 16px;

    }

    .edit-del-wrap a{
        margin-left: 10px;
        text-decoration: none;
        color: gray;
    }
    #del-liste{
        float: right;
    }
    .content p{
        display: inline-block;
    }
    #add-produit{
        display: inline-block;
        padding: 8px 16px;
        background-color: green;
        color: white;
        text-decoration: none;
        border-radius: 4px;
        margin-top: 1em;
    }
</style>

<!-- Nom du magasin -->
<h2>Lorem Ipsum</h2>


<body>



<a href="#" id="del-liste">DEL</a>
<!-- foreach categorie -->
<button type="button" class="collapsible">Lorem ipsum</button>
<div class="content">
    <!-- foreach produit in categorie in liste -->
    <p>Lorem ipsum </p><div class="edit-del-wrap"><a href="#">✎</a><a href="#">✖</a></div>
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


<!-- Il faut inclure le footer -->