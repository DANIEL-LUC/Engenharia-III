<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
	import="gestao.util.Resultado, gestao.dominio.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Resposta</title>
<meta charset="utf-8">
<%
Resultado resultado = (Resultado)session.getAttribute("resultado");
String mensagem = "<h1>" +resultado.getMsg()+"</h1>";

resultado.setMsg(null);
request.getSession().setAttribute("resultado", resultado);

%>
<link rel="shortcut icon" href="img/alunos-121x121.png">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <div class= "center">
            <div class = "logo">
                <h2 >
                    <a class="log" href="index.html">
                    
                    Cadastro de automóveis
                    </a>
                </h2>
                <%out.print(mensagem);%>
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
                      <a class="buton" href="cadastrar-curso.html">CADASTRAR</a>
                      <form name = "formCurso" action = "csCurso" method="get">   
                        <input class="buton" id="operacao" name="operacao" type = "submit" value = "CONSULTAR" >
                      </form>
                    </div>
                  </div>
                    
            </div>
        </div><!--centro-->
    </header>
    <section class="main">
      
    <input class ="button" type='button' value='Voltar' onClick='history.go(-1)'> 
    </section>
    <div>
        <div class="fatec">
            Fatec Mogi das Cruzes
 
        </div>
        
    </div>
</body>
</html>