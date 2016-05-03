<%-- 
    Document   : VerProduto
    Created on : 03/05/2016, 13:42:44
    Author     : José
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            pageContext.setAttribute("produto",request.getSession().getAttribute("produto"));
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-md-4 text-center">
                            <img id="capa" src="${produto.imagem}" style='width: 200px; height:290px; object-fit: cover' class='avatar img-thumbnail' alt="capa do livro">
                  
                            <div>
         <div class="col-md-8">
                            <br>
                            <dl class="dl-horizontal">
                                <dt>nome:</dt>
                                <dd>${produto.nome}</dd>
                            </dl>

                            <dl class="dl-horizontal">
                                <dt>:</dt>
                                <dd>${produto.categoria}</dd>
                            </dl>

                            <dl class="dl-horizontal">
                                <dt>quant:</dt>
                                <dd>${produto.quantidade}</dd>
                            </dl>

                            <dl class="dl-horizontal">
                                <dt>Ano de Publicação:</dt>
                                <dd>${livro.anoPublicacao}</dd>
                            </dl>

                            <dl class="dl-horizontal">
                               
                            </dl>
                            
    </body>
</html>
