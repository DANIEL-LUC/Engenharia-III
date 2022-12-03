<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
	import="gestao.util.Resultado, gestao.dominio.*, java.util.*"%>
    <%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styleCadModelo.css">
<title>Insert title here</title>
</head>
<body>

		<%
			Resultado resultado = (Resultado) session.getAttribute("resultado");
			ModeloAutomovel modelo = (ModeloAutomovel)resultado.getEntidades().get(0);
			
			System.out.println(modelo.getAnoLancamento());
			
			String marcaSelect = "<option value="+modelo.getMarca().getNome()+">"+modelo.getMarca().getNome()+"</option>";
			
			String cambioSelect = " <option value="
			+modelo.getEspecificacaoTecnica().getCambio()+">"+modelo.getEspecificacaoTecnica().getCambio()+"</option>";
			
			String combustivelSelect = "<option value"
			+modelo.getEspecificacaoTecnica().getCombustivel()+">"+modelo.getEspecificacaoTecnica().getCombustivel()+"</option>";
			
			String tipo = " <option value"+modelo.getTipoAutomovel()+">"+modelo.getTipoAutomovel().getTipo()+"</option>";
		%>
<div id="container">
  <h1>&bull; Editar Modelo do Automóvel #ID <c:out value="${resultado.getEntidades().get(0).getId()}"/>&bull;</h1>
  
  <div class="underline">
  </div>
  <div class="icon_wrapper">
    
  </div>
  
  <form action="ModeloAutomovel" method="post" id="contact_form">
  <input TYPE="hidden" id="txtId" name="txtId" required="required" value=<c:out value="${resultado.getEntidades().get(0).getId()}"/>><br>
  
    <div class="name">
      <label for="name"></label>
      <input type="text" placeholder="Nome modelo" name="txtNomeModelo" id="txtNomeModelo" required  value=<c:out value="${resultado.getEntidades().get(0).getNome()}"/> >
    </div>
    <div class="anoLancamento">
      <label for="name"></label>
      <input type="date" placeholder="Ano Lançamento" name="txtAnoLancamento" id="txtAnoLancamento" required value=<c:out value="${resultado.getEntidades().get(0).getAnoLancamento()}"/>>
    </div>
    <div class="preco">
      <label for="name"></label>
      <input type="number" step="0.01" placeholder="Preço médio" name="txtPreco" id="txtPreco" required value=<c:out value="${resultado.getEntidades().get(0).getMediaPreco()}"/>>
    </div>
    <div class="subject">
      <label for="subject"></label>
      <select placeholder="Marca" name="txtMarca" id="txtMarca" required>
        <%out.print(marcaSelect); %>
        <option value="Marca_1">Marca_1</option>
        <option value="Marca_2">Marca_2</option>
        <option value="Marca_3">Marca_3</option>
      </select>
    </div>
    <h1>Ficha técnica</h1>
    <div class="valorRith">
      <label for="name"></label>
      <input type="number" step="0.01"placeholder="Potência CV" name="numberPotencia" id="numberPotencia" required value=<c:out value="${resultado.getEntidades().get(0).getEspecificacaoTecnica().getPotenciaCv()}"/>>
    </div>
    
    <div class="valorLeft">
      <label for="name"></label>
      <input type="number" step="0.01" placeholder="Gasto km/litro" name="numberGastoLitro" id="numberGastoLitro" required 
      value=<c:out value="${resultado.getEntidades().get(0).getEspecificacaoTecnica().getKmLitro()}"/>>
    </div>
    
    <div class="selectRight">
      <label for="subject"></label>
      <select placeholder="Cambio" name="txtCambio" id="txtCambio" required>
       <%out.print(cambioSelect); %>
        <option value="Automatico">Automático</option>
        <option value="Manual">Manual</option>
        <option value="Automatizado">Automatizado</option>
      </select>
    </div>
    <div class="selectLeft">
      <label for="subject"></label>
      <select placeholder="Combustivel" name="txtCombustivel" id="txtCombustivel" required>
        <%out.print(combustivelSelect); %>
        <option value="Gasolina">Gasolina</option>
        <option value="Alcool">Alcool</option>
        <option value="Flex">Flex</option>
      </select>
    </div>
    
    <div class="valorRith">
      <label for="name"></label>
      <input type="number"  placeholder="N° portas" name="numberPortas" id="numberPortas" required 
value=<c:out value="${resultado.getEntidades().get(0).getPortas()}"/>>
    </div>
    
    <div class="valorLeft">
      <label for="name"></label>
      <input type="number"  placeholder="N° acentos" name="numberAcentos" id="numberAcentos" required
value=<c:out value="${resultado.getEntidades().get(0).getAcento()}"/>>
    </div>
    
    
     <div class="selectLeft">
      <label for="subject"></label>
      <select placeholder="Combustivel" name="txtTipoAutomovel" id="txtTipoAutomovel" required>
       <%out.print(tipo); %>
        <option value="Convencional">Convencional</option>
        <option value="Caminhonete">Caminhonete</option>
        <option value="Moto">Moto</option>
      </select>
    </div>
    
    
    <div class="message">
      <label for="message"></label>
      <textarea name="message" placeholder="" id="message_input" cols="30" rows="5" ></textarea>
    </div>
    <div class="submit">
      <input type="submit" name="operacao" value="Editar" id="form_button" />
    </div>
    
      <a href="index.jsp" id="form_button">Home</a>
    
    
  </form><!-- // End form -->
</div><!-- // End #container -->
</body>
</html>