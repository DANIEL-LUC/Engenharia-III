<%@ page
	import="gestao.util.Resultado, gestao.dominio.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styleCadModelo.css">
<title>Editar</title>
</head>
<body>
<%
	String idVendedor = request.getParameter("txtIdVendedor");
	String idModelo = request.getParameter("txtIdModelo");
		System.out.println(idVendedor);
		System.out.println(idModelo);
		
		
		Resultado resultado = (Resultado) session.getAttribute("resultado");
		Automovel automovel = (Automovel)resultado.getEntidades().get(0);
		
		
		String corSelect = "<option value="+automovel.getCorExterna()+">"+automovel.getCorExterna()+"</option>";
		
	%>
	
	
	<div id="container">
  <h1>&bull; Editar Automóvel &bull;</h1>
  <div class="underline">
  </div>
  <div class="icon_wrapper">
    
  </div>
  
  <form action="Automovel" method="post" id="contact_form">
  <input TYPE="hidden" id="txtId" name="txtId" required="required" value=<%out.print(automovel.getId());%>>
  <input TYPE="hidden" id="txtIdVendedor" name="txtIdVendedor" required="required" value=<%out.print(automovel.getVendedor().getId());%>>
  <input TYPE="hidden" id="txtIdModelo" name="txtIdModelo" required="required" value=<%out.print(automovel.getModeloAutomovel().getId());%>>
  
    <div class="name">
      <label for="name"></label>
      <input type="text" placeholder="N°VIN" name="txtVin" id="txtVin" required value=<%out.print(automovel.getVin());%>>
    </div>
    <div class="anoLancamento">
      <label for="name">Ano de Fabricação</label>
      <input type="date" placeholder="Ano Fabricação" name="txtAnoFabricacao" id="txtAnoFabricacao" required value=<%out.print(automovel.getAnoFabricacao());%>>
    </div>
    <div class="preco">
      <label for="name"></label>
      <input type="number" step="0.01" placeholder="Preço R$" name="txtPreco" id="txtPreco" required value=<%out.print(automovel.getPreco());%>>
    </div>
    <div class="subject">
      <label for="subject"></label>
      <select placeholder="Cor Externa" name="txtCor" id="txtCor" required>
        <%out.print(corSelect); %>
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
      <input type="number" step="0.01" placeholder="Km rodado" name="numberKmRodado" id="numberKmRodado" required value=<%out.print(automovel.getKmRodado());%>>
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
      <textarea name="txtDescricao" placeholder="" id="txtDescricao" cols="30" rows="5" value=<%out.print(automovel.getDescricao());%>></textarea>
    </div>
    <div class="submit">
      <input type="submit" name="operacao" value="Editar" id="form_button" />
    </div>
    
      <a href="index.jsp" id="form_button">Home</a>
    
    
  </form><!-- // End form -->
</div><!-- // End #container -->
</body>
</html>