<html>
<head>
<title>Cadastro do Aluno</title>
<meta charset="utf-8">
<link rel="shortcut icon" href="img/alunos-121x121.png">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
    <header>
        <div class= "center">
            <div class = "logo">
                <h2 >
                    <a class="log" href="index.html">
                    
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
       <div class="cursando">
        Analise e Desenvolvimento de Sistemas
       </div>
       <div class="materia">
            Engenharia de Software III
       </div>
       <div class="aluno">
           Nome do aluno
       </div>
    
    </section>
    <div>
        <div class="fatec">
            Fatec Mogi das Cruzes
 
        </div>
        
    </div>
</body>
</html>  