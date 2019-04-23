<%-- 
    Document   : index
    Created on : 20/04/2019, 22:40:55
    Author     : clauc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema de Gerenciamento</title>
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css" />
        <style>
            <%@ include file="css/stylesheet.css"%>
        </style>
    </head>
    <body>
    <center >
      <div class="div-header">
        <h1>Gerenciamento de Sites e Teatros</h1>

        <nav>
          <ul>
            <li> <a href="">Promoções</a></li>
            <li> <a href="/SistemaPromocoesVendas/formsCadastroSite">Cadastrar Site</a></li>
            <li> <a href="/SistemaPromocoesVendas/formsCadastroTeatros">Cadastrar Teatro<a/></li>
            <li> <a href="">Login<a/></li>
          </ul>
      </nav>

      </div>

    <div class="layout-body">

     <div class="container-esquerdo-principal">
        <h2><a>Promoções</a></h2>
          
          
          
        <div class="table">
            <div class="thead">
              <li>Peça</li>
              <li>Link</li>
              <li>Preço</li>
              <li>Data</li>
              <li>Horário</li>

            </div>
            
            <div class="tbody">
                <c:forEach var="promocao" items="${listaPromocoes}"> 
                          <div class="tr">
                              <li><c:out value="${promocao.nome_peca}" /></li> 
                              <li><c:out value="${promocao.url}" /></li> 
                              <li id="lipreco"><c:out value="${promocao.preco}" /></li> 
                              <li><c:out value="${promocao.data_peca}" /></li>
                              <li><c:out value="${promocao.horario}" /></li>
                          </div>
                 </c:forEach>
            </div>
        </div>
           
        
      </div>

        <div class="container-direito-principal">
          <h2><a>Teatros</a></h2>
          
          
          <div class="table-teatro">
            <div class="thead-teatro">
              <li>Nome</li>
              <li>Cidade</li>
              <li>Email</li>
              <li id="headcnpj">CNPJ</li>

            </div>
            
            <div class="tbody-teatro">
                <c:forEach var="teatro" items="${listaTeatros}"> 
                          <div class="tr-teatro">
                              <li><c:out value="${teatro.nome}" /></li> 
                              <li><c:out value="${teatro.cidade}" /></li> 
                              <li id="liemail"><c:out value="${teatro.email}" /></li> 
                              <li><c:out value="${teatro.cnpj}" /></li>
                             
                          </div>
                 </c:forEach>
            </div>
        </div>

        </div>
    </div>
          <!--  &nbsp;&nbsp;&nbsp; <!-->
    </center>
</body>
</html>
