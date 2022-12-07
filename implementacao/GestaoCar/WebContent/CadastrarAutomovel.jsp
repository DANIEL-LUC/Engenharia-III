<%@ page
	import="gestao.util.Resultado, gestao.dominio.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styleCadModelo.css">
<title>Insert title here</title>
</head>
<body>
<%
	String idVendedor = request.getParameter("txtIdVendedor");
	String idModelo = request.getParameter("txtIdModelo");
		System.out.println(idVendedor);
		System.out.println(idModelo);
	%>
	
	
	<div id="container">
  <h1>&bull; Cadastro Automóvel &bull;</h1>
  <div class="underline">
  </div>
  <div class="icon_wrapper">
    
  </div>
  
  <form action="Automovel" method="post" id="contact_form">
  <input TYPE="hidden" id="txtIdVendedor" name="txtIdVendedor" required="required" value=<%out.print(idVendedor);%>>
  <input TYPE="hidden" id="txtIdModelo" name="txtIdModelo" required="required" value=<%out.print(idModelo);%>>
  
    <div class="name">
      <label for="name"></label>
      <input type="text" placeholder="N°VIN" name="txtVin" id="txtVin" required>
    </div>
    <div class="anoLancamento">
      <label for="name">Ano de Fabricação</label>
      <input type="date" placeholder="Ano Fabricação" name="txtAnoFabricacao" id="txtAnoFabricacao" required>
    </div>
    <div class="preco">
      <label for="name"></label>
      <input type="number" step="0.01" placeholder="Preço R$" name="txtPreco" id="txtPreco" required>
    </div>
    <div class="subject">
      <label for="subject"></label>
      <select placeholder="Cor Externa" name="txtCor" id="txtCor" required>
        <option disabled hidden selected>Cor Externa</option>
        <option value="Azul">Azul</option>
        <option value="Cinza">Cinza</option>
        <option value="Preto">Preto</option>
        <option value="Vermelho">Vermelho</option>
        <option value="Verde">Verde</option>
        <option value="Branco">Branco</option>
        <option value="laranja">laranja</option>
      </select>
    </div>
    
    

    <div class="valorLeft">
      <label for="name"></label>
      <input type="number" step="0.01" placeholder="Km rodado" name="numberKmRodado" id="numberKmRodado" required>
    </div>
   
    <div class="subject">
      <label for="subject">Publicar:</label>
    <select name="txtPublicar" id="txtPublicar" required>
        <option value="nao">Não</option>
        <option value="sim">Sim</option>
     
      </select>
     
    </div>
    
    <div class="message">
      <label for="message"></label>
      <textarea name="txtDescricao" placeholder="" id="txtDescricao" cols="30" rows="5" >Descrição:</textarea>
    </div>
    <div class="submit">
      <input type="submit" name="operacao" value="Cadastrar" id="form_button" />
    </div>
    
      <a href="index.jsp" id="form_button">Home</a>
    
    
  </form><!-- // End form -->
</div><!-- // End #container -->
</body>
</html>