<%-- 
    Document   : formsCadastroTeatros
    Created on : 20/04/2019, 22:44:12
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
          <h1>Cadastro de Teatros</h1>
          <div class="container1">
            <h2>
                <div class="container1header">Adicione Novo Teatro</div>
                &nbsp;&nbsp;&nbsp;
            </h2>



              <form action="insercaoteatro" method="POST"> <!--action="/action_page.php" !-->
              Email:<br>
              <input type="email" name="email" class="inputfield" id="campoemail"><br><br>
              Senha:<br>
              <input type="password" name="password" class="inputfield" id="camposenha"><br><br>
              CNPJ:<br>
              <input type="CNPJ" name="cnpj" class="inputfield" id="campocnpj"><br><br>
              Nome:<br>
              <input type="text" name="nome" class="inputfield" id="camponome"><br><br>
              Cidade<br>
              <input type="text" name="cidade" class="inputfield" id="campocidade"><br><br>

              <button type="submit" class="btnsubmit" class="inputfield" onclick="return validaform();">Cadastrar</button>

            </form>

          </div>
        </center>
      </body>
    
      <script>
          function validaform(){
              var email = document.getElementById("campoemail").value;
              var senha = document.getElementById("camposenha").value;
              var cnpj = document.getElementById("campocnpj").value;
              var nome = document.getElementById("camponome").value;
              var cidade = document.getElementById("campocidade").value;
               
            if(email.length==0 || senha.length==0 || cnpj.length==0 || nome.length==0 || cidade.length==0   ){
                alert("Todos os campos devem ser preenchidos");
                return false;
            }
            
            return true;
        
          }
      </script>
</html>
