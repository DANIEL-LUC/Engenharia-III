<%@ page
	import="gestao.util.Resultado, gestao.dominio.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="shortcut icon" href="img/alunos-121x121.png">
<link rel="stylesheet" href="css/style.css">
<title>Busca Modelo</title>
</head>
<body>
<%
		Resultado resultado = (Resultado) session.getAttribute("resultado");
		Resultado vendedor = (Resultado) session.getAttribute("vendedor");
		List<EntidadeDominio> entidades = vendedor.getEntidades();
		
		Vendedor v = (Vendedor) entidades.get(0);
		
		System.out.print(v.getId());
		
	%>
	<%!
  public void method()  {
		System.out.print("OLAAAAA");
  };
%>
<header>
        <div class= "center">
            <div class = "logo">
                <h2 >
                    <a class="log" href="index.jsp">
                    
                    Cadastro de Automoveis
                    </a>
                </h2>
            </div><!--logo-->
            <div class="menu">
                <div class="dropdown">
                    <button class="dropbtn">Vendedor</button>
                    <div class="dropdown-content">
                      <form name = "formVendedor" action ="Vendedor" method="get">   
                      <a class="buton" id="operacao" name="operacao"  href="cadastrarVendedor.jsp" >Cadastrar</a>
                      </form>
                      <form name = "formAluno" action = "csAluno" method="get">   
                        <a class="buton" href="Vendedor" >Consultar</a>
                      </form>
                    </div>
                  </div>

                  <div class="dropdown">
                    <button class="dropbtn">Modelo Automovel</button>
                    <div class="dropdown-content">
                      <form name = "formProfessor" action = "ccProfessor" method="get">   
                        <a class="buton" id="operacao" name="operacao" href="cadastrarModeloAutomovel.jsp">Cadastrar</a>
                      </form>
                      <form name = "formProfessor" action = "csProfessor" method="get">   
                        <a class="buton" href="ModeloAutomovel">Consultar</a>
                      </form>
                    </div>
                  </div>

                <div class="dropdown">
                    <button class="dropbtn">Automovel</button>
                    <div class="dropdown-content">
                      <a class="buton" id="operacao" href="BuscarCpf.html">Cadastrar</a>
                      <form name = "formCurso" action = "csCurso" method="get">   
                        <input class="buton" id="operacao" name="operacao" type = "submit" value = "CONSULTAR" >
                      </form>
                    </div>
                  </div>
                    
            </div>
        </div><!--centro-->
    </header>
    <section class="main">
       <div class="cursando">
        Selecione o modelo do Automovel
       </div>
       <form name = "formCurso" action = "CadastrarAutomovel.jsp" method="get"> 
       <input TYPE="hidden" id="txtIdVendedor" name="txtIdVendedor" required="required" value=<%out.print(v.getId());%>><br>  
      		<div>
       			<select class="buttonSelect"  name="txtIdModelo" id="txtCambio" required>
		        <option disabled hidden selected>Modelos de Automoveis</option>
    
		 <%
			if (resultado != null) {
				List<EntidadeDominio> entidadesModelo = resultado.getEntidades();
				StringBuilder sbRegistro = new StringBuilder();
				StringBuilder sbLink = new StringBuilder();
				StringBuilder sbLinkExcluir = new StringBuilder();

				if (entidadesModelo != null) {
					for (int i = 0; i < entidadesModelo.size(); i++) {
						ModeloAutomovel m = (ModeloAutomovel) entidadesModelo.get(i);
						sbRegistro.setLength(0);
						sbLink.setLength(0);

						
						sbRegistro.append("<option value=");
						sbRegistro.append(m.getId());
						sbRegistro.append(">");
						sbRegistro.append(m.getNome());
						sbRegistro.append("</option>");
						
						out.print(sbRegistro.toString());

					}
				}

			}
		%>
		        
		        
		        
		     </select>
		     <input class="button" id="operacao" name="operacao" type = "submit" value = "Consultar" >
       		</div>
         	    
		</form>
		
    
    </section>
    <div>
        <div class="fatec">
            Fatec Mogi das Cruzes
 
        </div>
        
    </div>
</body>
</html>