<%@ page
	import="gestao.util.Resultado, gestao.dominio.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<META http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>:::: CONSULTAR MODELO::::</title>
</head>
<body>
	<a href="index.jsp">Home</a>
	<%
		Resultado resultado = (Resultado) session.getAttribute("resultado");
	%>


	<a href="BuscarCpf.html">Novo</a>

	<%
		if (resultado != null && resultado.getMsg() != null) {
			out.print(resultado.getMsg());
		}
	%>
	<BR>

	<TABLE BORDER="5" WIDTH="50%" CELLPADDING="4" CELLSPACING="3">
		<TR>
			<TH COLSPAN="7"><BR>
				<H3>AUTOMOVEIS</H3></TH>
		</TR>

		<TR>
			<TH>ID:</TH>
			<TH>VIN</TH>
			<TH>Ano de Fabricação:</TH>
			<TH>Preço :</TH>
			<TH>Km Rodado:</TH>
		</TR>


		<%
			if (resultado != null) {
				List<EntidadeDominio> entidades = resultado.getEntidades();
				StringBuilder sbRegistro = new StringBuilder();
				StringBuilder sbLink = new StringBuilder();
				StringBuilder sbLinkExcluir = new StringBuilder();

				if (entidades != null) {
					for (int i = 0; i < entidades.size(); i++) {
						Automovel m = (Automovel) entidades.get(i);
						sbRegistro.setLength(0);
						sbLink.setLength(0);

						//	<a href="nome-do-lugar-a-ser-levado">descrição</a>

						sbRegistro.append("<TR ALIGN='CENTER'>");

						sbLinkExcluir.append("<a href=Automovel?");
						sbLinkExcluir.append("txtId=");
						sbLinkExcluir.append(m.getId());
						sbLinkExcluir.append("&");
						sbLinkExcluir.append("operacao=");
						sbLinkExcluir.append("Excluir");
						sbLinkExcluir.append(">");
						
						sbLink.append("<a href=Automovel?");
						sbLink.append("txtId=");
						sbLink.append(m.getId());
						sbLink.append("&");
						sbLink.append("operacao=");
						sbLink.append("Consultar");
						sbLink.append(">");

						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());
						sbRegistro.append(m.getId());
						sbRegistro.append("</a>");
						sbRegistro.append("</TD>");

						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());
						sbRegistro.append(m.getVin());
						sbRegistro.append("</a>");
						sbRegistro.append("</TD>");

						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());
						sbRegistro.append(m.getAnoFabricacao());
						sbRegistro.append("</a>");
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());
						sbRegistro.append(m.getPreco());
						sbRegistro.append("</a>");
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());
						sbRegistro.append(m.getKmRodado());
						sbRegistro.append("</a>");
						sbRegistro.append("</TD>");
						
						
						sbRegistro.append("<TD>");
						sbRegistro.append(sbLinkExcluir.toString());
						sbRegistro.append("Excluir</a>");
						sbRegistro.append("</TD>");

						sbRegistro.append("</TR>");

						out.print(sbRegistro.toString());

					}
				}

			}
		%>




	</TABLE>


</body>
</html>