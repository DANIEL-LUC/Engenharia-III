<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
	import="gestao.util.Resultado, gestao.dominio.*, java.util.*"%>
    <%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/formVendedorStyle.css">
<title>Venda de carros</title>
</head>
<body>
		

	<form class="formulario" action="Vendedor" method="post">
		
		<div id="formularioVendedor" class="formularioVendedor">

                <div class="tituloPrincipal">
                    <h2> Cadastrar Vendedor</h2>
                    <label></label>
                    <input TYPE="hidden" id="txtId" name="txtId" required="required" value=""><br>
              		
                </div>
                
                <div class="metade left">
                    <label>CPF </label>
                    <input type="text" id="txtCPF" name="txtCPF" required="required" value=""><br>
                    <label>Nome Vendedor</label>
                    <input type="text" id="txtNomeVendedor" name="txtNomeVendedor" required="required" value=""><br>
                    
                </div>
                
                 <div class="metade right">
                    <label>E-mail</label>
                    <input type="text" id="txtEmail" name="txtEmail" required="required" value="" ><br>
                    <label>Telefone</label>
                    <input type="text" id="txtTelefone" name="txtTelefone" required="required" value=""><br>
                </div>
                
                
        </div>
        
        <div class="formularioEndereco">
                <div class="Subtitulos">
                    <h2> Endereço</h2>
                </div> 
                <div id="campoEndereco" class="endereco campoPadrao">
                    

                    <div class="campoLogradouro campoPadrao mesma-linha">
                        <label>Logradouro</label>
                        <input type="text" class="logradouro" id="txtLogradouro" name="txtLogradouro" required="required" value=""><br>
                    </div><br>

                    <div class="campoNumero campoPadrao mesma-linha">
                        <label>Número</label>
                        <input type="text" id="txtNumero" name="txtNumero" required="required" value=""/><br>         
                    </div><br>

                    <div class="campoCEP campoPadrao mesma-linha">
                        <label>CEP</label> 
                        <input type="text" class="cep" id="txtCep" name="txtCep" minlength="9" required="required" value=""><br>          
                    </div>
                    <br>
                   
                    <div class="campoCidade campoPadrao mesma-linha">
                        <label>Cidade</label>
                        <input type="text" class="cidade" id="txtCidade" name="txtCidade" required="required" value=""><br>
                    </div><br>
                    
                    <div class="campoUF campoPadrao mesma-linha">
                        <label>Unidade Federal</label>
                        <select name="txtEstado" class="estado" id="txtEstado" required="required">
                            <option value="">Selecione...</option>
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
			<input type="submit" name = "operacao" value="Cadastrar" id="botaoSalvar">
                
        </div> 
	</form>


</html>