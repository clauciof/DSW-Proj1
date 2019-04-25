<%-- 
    Document   : formsCadastroSite
    Created on : 20/04/2019, 22:43:52
    Author     : clauc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema de Gerenciamento</title>
          <link rel = "stylesheet" type = "text/css" href = "css/stylesheet.css"/>
           <style>
            <%@ include file="css/stylesheet.css"%>
        </style>
    </head>
    <body>
    <center>
        <h1>Cadastro de Sites</h1>

        <div class="container1">
          <h2>
            <div class="container1head">Adicione Novo Site</div>
          </h2>

            <form action="insercaosite" method="POST"> <!--action="/action_page.php" !-->
            Email:<br>
            <input type="email" name="email" class="inputfield"  id="campoemail"><br><br>
            Senha:<br>
            <input type="password" name="password" class="inputfield"  id="camposenha"><br><br>
            URL:<br>
            <input type="text" name="url" class="inputfield"  id="campourl"><br><br>
            Nome:<br>
            <input type="text" name="nome" class="inputfield"  id="camponome"> <br><br>
            Telefone<br>
            <input type="text" name="telefone" class="inputfield"  id="campotelefone"><br><br>

            <button type="submit" class="btnsubmit" onclick="return validaformsite();">Cadastrar</button>


          </form>

        </div>
      </center>
    </body>
    
    <script>
        function validaformsite(){
            
             var email = document.getElementById("campoemail").value;
              var senha = document.getElementById("camposenha").value;
              var url = document.getElementById("campourl").value;
              var nome = document.getElementById("camponome").value;
              var telefone = document.getElementById("campotelefone").value;
               
            if(email.length==0 || senha.length==0 ||url.length==0 || nome.length==0 || telefone.length==0 ){
                alert("Todos os campos devem ser preenchidos");
                return false;
            }
            
            return true;
 
        }
    </script>
    
</html>
