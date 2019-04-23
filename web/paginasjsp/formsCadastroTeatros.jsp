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



            <form> <!--action="/action_page.php" !-->
              Email:<br>
              <input type="email" name="email" class="inputfield"><br><br>
              Senha:<br>
              <input type="password" name="password" class="inputfield"><br><br>
              CNPJ:<br>
              <input type="CNPJ" name="cnpj" class="inputfield"><br><br>
              Nome:<br>
              <input type="text" name="nome" class="inputfield"><br><br>
              Cidade<br>
              <input type="text" name="telefone" class="inputfield"><br><br>

              <button type="button" class="btnsubmit" class="inputfield">Cadastrar</button>

            </form>



          </div>
        </center>
      </body>
</html>
