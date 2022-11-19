<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
	import="gestao.util.Resultado, gestao.dominio.*, java.util.*"%>
    <%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Venda de carros</title>
</head>
<body>
		<%
		
			Resultado resultado = (Resultado) session.getAttribute("resultado");
			String titulo;
			String operacao;
			if (resultado != null) {
				 titulo = "Editar";
			}else{
				titulo = "Cadastrar";
				operacao = "Salvar";
			}
			
			out.print("<h1>"+ titulo+"</h1>");
		%>

	<form action="Vendedor" method="post">
		
		<div id="formularioVendedor" class="formularioVendedor">

                <div class="tituloPrincipal">
                    <h2> <%out.print(titulo);%> Vendedor #ID <c:out value="${resultado.getEntidades().get(0).getId()}"/></h2>
                    <label></label>
                    <input TYPE="hidden" id="txtId" name="txtId" required="required" value=<c:out value="${resultado.getEntidades().get(0).getId()}"/>><br>
              
                </div>
                <div class="msgObrigatoria">
                    <label> Os campos destacados em vermelho são de preenchimento obrigatório.</label>
                </div> <br>
                <div class="campoCPF">
                    <label>CPF </label>
                    <input type="text" id="txtCPF" name="txtCPF" required="required" value=<c:out value="${resultado.getEntidades().get(0).getCpf()}"/> ><br>
                </div>
                <div class="campoNomeVendedor">
                    <label>Nome Vendedor</label>
                    <input type="text" id="txtNomeVendedor" name="txtNomeVendedor" required="required" value=<c:out value="${resultado.getEntidades().get(0).getNome()}"/>><br>
                </div>
                 <div class="campoEmail">
                    <label>E-mail</label>
                    <input type="text" id="txtEmail" name="txtEmail" required="required" value=<c:out value="${resultado.getEntidades().get(0).getEmail()}"/> ><br>
                </div>
                 <div class="campoTelefone">
                    <label>Telefone</label>
                    <input type="text" id="txtTelefone" name="txtTelefone" required="required" value=<c:out value="${resultado.getEntidades().get(0).getTelefone()}"/>><br>
                </div>
                
        </div>
        
        <div class="formularioEndereco">
                <div class="Subtitulos">
                    <h2> Endereço</h2>
                </div> 
                <div id="campoEndereco" class="endereco campoPadrao">
                    

                    <div class="campoLogradouro campoPadrao mesma-linha">
                        <label>Logradouro</label>
                        <input type="text" class="logradouro" id="txtLogradouro" name="txtLogradouro" required="required" value="Rua narciso"><br>
                    </div><br>

                    <div class="campoNumero campoPadrao mesma-linha">
                        <label>Número</label>
                        <input type="text" id="txtNumero" name="txtNumero" required="required" value="555"><br>         
                    </div><br>

                    <div class="campoCEP campoPadrao mesma-linha">
                        <label>CEP</label> 
                        <input type="text" class="cep" id="txtCep" name="txtCep" minlength="9" required="required" value="08970000"><br>          
                    </div>
                    <br>
                    <div class="campoBairro campoPadrao mesma-linha">
                        <label>Bairro</label>
                        <input type="text" class="bairro" id="txtBairro" name="txtBairro" required="required" value="Bracaia"><br>
                    </div><br>

                    <div class="campoCidade campoPadrao mesma-linha">
                        <label>Cidade</label>
                        <input type="text" class="cidade" id="txtCidade" name="txtCidade" required="required" value="Salesopolis"><br>
                    </div><br>
                    
                    <div class="campoUF campoPadrao mesma-linha">
                        <label>Unidade Federal</label>
                        <select name="txtEstado" class="estado" id="txtEstado" required="required">
                            <option value="Sao Paulo">Selecione...</option>
                            <option value="Sao Paulo - SP">São Paulo - SP</option>
                            <option value="Rio de Janeiro - RJ">Rio de Janeiro - RJ</option>
                        </select><br>
                    </div>

                    <br>
                    <div class="campoComplemento campoPadrao">
                        <label>Complemento</label>
                        <input type="text" class="txtComplemento" id="txtComplemento" name="complemento"><br>
                    </div>
                </div>
               
            </div>
        
		<br/>
		<div class="formulario">
                <input type="submit" name = "operacao" value="Salvar" id="botaoSalvar">
        </div> 
	</form>


</html>