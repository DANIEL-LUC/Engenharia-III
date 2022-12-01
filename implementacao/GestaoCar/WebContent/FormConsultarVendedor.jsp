<%@ page
	import="gestao.util.Resultado, gestao.dominio.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>:::: CONSULTAR VENDEDOR::::</title>
</head>
<body>
	<a href="index.jsp">Home</a>
	<%
		Resultado resultado = (Resultado) session.getAttribute("resultado");
	%>


	<a href="cadastrarVendedor.jsp">Novo</a>

	<%
		if (resultado != null && resultado.getMsg() != null) {
			out.print(resultado.getMsg());
		}
	%>
	<BR>

	<TABLE BORDER="5" WIDTH="50%" CELLPADDING="4" CELLSPACING="3">
		<TR>
			<TH COLSPAN="5"><BR>
				<H3>VENDEDORES</H3></TH>
		</TR>

		<TR>
			<TH>ID:</TH>
			<TH>Nome</TH>
			<TH>CPF:</TH>
			<TH>E-mail:</TH>
			<TH>Telefone:</TH>
		</TR>


		<%
			if (resultado != null) {
				List<EntidadeDominio> entidades = resultado.getEntidades();
				StringBuilder sbRegistro = new StringBuilder();
				StringBuilder sbLink = new StringBuilder();
				StringBuilder sbLinkExcluir = new StringBuilder();

				if (entidades != null) {
					for (int i = 0; i < entidades.size(); i++) {
						Vendedor p = (Vendedor) entidades.get(i);
						sbRegistro.setLength(0);
						sbLink.setLength(0);

						//	<a href="nome-do-lugar-a-ser-levado">descrição</a>

						sbRegistro.append("<TR ALIGN='CENTER'>");

						sbLinkExcluir.append("<a href=Vendedor?");
						sbLinkExcluir.append("txtId=");
						sbLinkExcluir.append(p.getId());
						sbLinkExcluir.append("&");
						sbLinkExcluir.append("operacao=");
						sbLinkExcluir.append("Excluir");
						sbLinkExcluir.append(">");
						
						sbLink.append("<a href=Vendedor?");
						sbLink.append("txtId=");
						sbLink.append(p.getId());
						sbLink.append("&");
						sbLink.append("operacao=");
						sbLink.append("Consultar");
						sbLink.append(">");

						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());
						sbRegistro.append(p.getId());
						sbRegistro.append("</a>");
						sbRegistro.append("</TD>");

						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());
						sbRegistro.append(p.getNome());
						sbRegistro.append("</a>");
						sbRegistro.append("</TD>");

						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());
						sbRegistro.append(p.getCpf());
						sbRegistro.append("</a>");
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());
						sbRegistro.append(p.getEmail());
						sbRegistro.append("</a>");
						sbRegistro.append("</TD>");
						
						sbRegistro.append("<TD>");
						sbRegistro.append(sbLink.toString());
						sbRegistro.append(p.getTelefone());
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