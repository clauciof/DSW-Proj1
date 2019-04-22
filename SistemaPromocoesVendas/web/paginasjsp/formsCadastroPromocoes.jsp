<%-- 
    Document   : formCadastroPromocoes
    Created on : 20/04/2019, 22:43:28
    Author     : clauc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema de Gerenciamento</title>
          <link rel = "stylesheet" type = "text/css" href = "css/stylesheet.css"/>
    </head>
    <body>
    <center>
        <h1>Cadastro de Promocoes</h1>


        <div class="container1">
          <h2>
              <div class="container1header" >Adicione Nova Promocao</div>
              &nbsp;&nbsp;&nbsp;
          </h2>

            <form> <!--action="/action_page.php" !-->
              <a>URL</a></br>
              <input type = "url" name="url" class="inputfield"><br><br>
              <a>CNPJ:</a><br>
              <input type="CNPJ" name="cnpj" class="inputfield"><br><br>
              <a>Nome da peça:</a><br>
              <input type="text" name="nome" class="inputfield"><br><br>
              <a>Preço:</a><br>
              <input type="email" name="email" class="inputfield"><br><br>
              <a>Data:</a><br>
              <input type="date"name="data" class="inputfield"><br><br>
              <a>Hora:</a><br>
              <input type="time"name="hora" class="inputfield"><br><br>


              <button type="button" class="btnsubmit">Cadastrar</button>


            </form>

      </div>
  </center>
</body>
</html>
