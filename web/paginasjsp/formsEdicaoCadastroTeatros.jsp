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
          <h1>Edição de Teatros</h1>
          <div class="container1">
            <h2>
                <div class="container1header">Edição de Teatro</div>
                &nbsp;&nbsp;&nbsp;
            </h2>



              <form action="atualizacaoteatro" method="POST"> <!--action="/action_page.php" !-->
              Email:<br>
              <c:if test="${salateatro != null}"> 
                <input type="email" name="email" class="inputfield" id="campoemail" value='${salateatro.email}' /> <br><br>
              </c:if>
              Senha:<br>
              <c:if test="${salateatro != null}"> 
                <input type="password" name="password" class="inputfield" id="camposenha" value='${salateatro.senha}'/> <br><br>
              </c:if>  
              CNPJ:<br>
              <c:if test="${salateatro != null}"> 
                <input type="CNPJ" name="cnpj" class="inputfield" id="campocnpj" value='${salateatro.cnpj}'/><br><br>
              </c:if> 
              Nome:<br>
              <c:if test="${salateatro != null}"> 
                <input type="text" name="nome" class="inputfield" id="camponome" value='${salateatro.nome}'/><br><br>
              </c:if>
              Cidade<br>
              <c:if test="${salateatro != null}"> 
                <input type="text" name="cidade" class="inputfield" id="campocidade" value='${salateatro.cidade}'/><br><br>
              </c:if>
              <button type="submit" class="btnsubmit" class="inputfield" onclick="return validaform();">Atualizar</button>
              <button type="submit" class="btnsubmit" class="inputfield" onclick="return validaform();">Apagar</button>

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
        
          }
      </script>
</html>
