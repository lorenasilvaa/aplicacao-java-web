<%-- 
    Document   : index
    Created on : 25 de mar. de 2021, 19:58:03
    Author     : lonus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            div#conteiner{
                width:390px;
                height: 460px;
                background-color:#FFFFFF;
                margin: 21px auto 0px auto; 
                box-shadow: 0px 0px 10px rgba(0,0,0,.5);
                padding: 30px;
            }           
            div#conteiner h2, h1{
                font-family: 'Arial', sans-serif;
                padding: 10px;
            }
        </style>
    </head>
    <body>
        <div id="conteiner">
        <h1>Menu</h1>
        <h2><a href="cadastro.jsp">Cadastrar Fornecedor<a></h2>
        <h2><a href="InserirFornecedor?acao=listagem">Listar Fornecedores<a></h2>
        </div>
    </body>
</html>
