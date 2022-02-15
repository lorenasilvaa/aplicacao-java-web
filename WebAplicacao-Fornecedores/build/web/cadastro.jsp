<%-- 
    Document   : cadastro
    Created on : 16 de mar. de 2021, 19:11:39
    Author     : lonus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            function validar() {
                var nome = form.nome.value;
                var razao = form.razao.value;
                
                var r = true;
                if (nome == "") {
                    alert('Preencha os campos obrigatórios!');
                    form.nome.focus();
                    r = false;
                }else if(razao == ""){
                    alert('Preencha os campos obrigatórios!');
                    form.razao.focus();
                    r = false;
                }
                return r;
            }
            
            function verificaRegiao(){
                if(${fornecedor.fornecedorID} != null){
                var regiao = document.getElementById("regiao");
                for (var i = 0; i < regiao.options.length; i++){
                    if (regiao.options[i].value == '${fornecedor.regiao}'){
                        regiao.options[i].selected = "true";
                        
                    }
                }
                }
            }
            
            
        </script>
        <style>
            div#conteiner{
                width:390px;
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
            
        </style>
    </head>
    <body onload="verificaRegiao()">
        <div id="conteiner">
        <a href="index.jsp"> <- Voltar ao Menu</a>
        <form name="form" action="InserirFornecedor" method="POST">
            <h1>Dados de Fornecedor</h1>
            <input type="hidden" value='${fornecedor.fornecedorID}' name="idFornecedor"/>
            <input type="hidden" name="acao" value="salva"/>
            <p style="color:red; font-size:11px;">* Informações obrigatórias</p>
            <p><label for="n"><span style="color:red">*</span>Nome Fantasia: </label><input type="text" id="n" name="nome" required="" value='${fornecedor.nomeFantasia}' size="20" maxlength="50"/></p>
            <p><label for="r"><span style="color:red">*</span>Razão Social: </label><input type="text" id="r" name="razao" required="" value='${fornecedor.razaoSocial}' size="20" maxlength="50"/></p>
            <p><label for="cn">CNPJ: </label><input type="text" id="cn" name="cnpj" value='${fornecedor.CNPJ}' size="20" maxlength="50"/></p>
            <p><label for="c">Cidade: </label><input type="text" id="c" name="cidade" value='${fornecedor.cidade}' size="20" maxlength="50"/></p>
            <p><label for="e">Região: </label>
                <select id="regiao" name="regiao">
 
                    <option value="Sul">Sul</option>
                    <option value="Sudeste">Sudeste</option>
                    <option value="Centro-Oeste">Centro-Oeste</option>
                    <option value="Norte">Norte </option>
                    <option value="Nordeste">Nordeste</option>
                    
		</select></p>
            <input Style="margin-left:10px;" type="reset" value="Limpar">
            <input Style="margin-left:40px;" type="submit" onclick="return validar()" value="Cadastrar">   
        </form>
        </div>
    </body>
</html>
