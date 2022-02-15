<%-- 
    Document   : listaFornecedores
    Created on : 18 de mar. de 2021, 18:25:59
    Author     : lonus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Fornecedores</title>
        <style>
            div#conteiner{
                width:690px;
                height: 460px;
                background-color:#FFFFFF;
                margin: 21px auto 0px auto; 
                box-shadow: 0px 0px 10px rgba(0,0,0,.5);
                padding: 30px;
            }           
            div#conteiner p{
                font-family: 'Arial', sans-serif;
                padding: 10px;
            }
            table,th,td{
                border: 1px solid black;
            }
            td{
                padding: 5px;
            }
        </style>
        <script>
            function verificaAcao(){
               if('${retorno}' == "0"){
                    alert('Ação não realizada!');
               }else if('${retorno}' == "1"){
                    alert('Ação realizada!');
               }
            }
        </script>
    </head>
    <body onload="verificaAcao()">
        <div id="conteiner">
            <a href="index.jsp"> <- Voltar ao Menu</a>
            <h1 Style="text-align: center;">Listar Fornecedores</h1>
            <div style="overflow: auto; width: 690px; height: 380px; border:solid 1px"> 
            <table>
                <tr>
                    <th>Id</th>
                    <th>Nome Fantasia</th>
                    <th>Razão Social</th>
                    <th>CNPJ</th>
                    <th>Cidade</th>
                    <th>Região</th>
                    <th>Editar</th>
                    <th>Excluir</th>
                </tr>
                    <c:forEach items="${fornecedores}" var="fornecedor" >
                <tr>
                    <td><c:out value="${fornecedor.fornecedorID}"/> </td>
                    <td><c:out value="${fornecedor.nomeFantasia}"/> </td>
                    <td><c:out value="${fornecedor.razaoSocial}"/> </td>
                    <td><c:out value="${fornecedor.CNPJ}"/> </td>
                    <td><c:out value="${fornecedor.cidade}"/> </td>
                    <td><c:out value="${fornecedor.regiao}"/> </td>
                    <td><a href='InserirFornecedor?acao=editar&id=<c:out value="${fornecedor.fornecedorID}"/>'>Editar</a></td>
                    <td><a href='InserirFornecedor?acao=deleta&id=<c:out value="${fornecedor.fornecedorID}"/>'>Excluir</a></td>
                </tr>
                   </c:forEach>
            </table>
            </div>
        </div>
    </body>
</html>
