/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PromocaoDAO;
import DAO.SalaDAO;
import DAO.SiteDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Promocao;
import model.SalaTeatro;
import model.Site;


/**
 *
 * @author clauc
 */
@WebServlet(urlPatterns = "/")
public class Controller extends HttpServlet {

    private SiteDAO site_dao;
    private PromocaoDAO promocao_dao;
    private SalaDAO teatro_dao;
    
    @Override
    public void init() {
        site_dao = new SiteDAO();
        promocao_dao = new PromocaoDAO();
        teatro_dao = new SalaDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/formsEdicaoCadastroTeatro":
                    apresentaFormEdicaoCadastroTeatro(request, response);
                    break;
                case "/insercaosite":
                    inseresite(request, response);
                    break;
                case "/insercaoteatro":
                    insereteatro(request, response);
                    break;                    
                case "/atualizateatro":
                    atualizaTeatro(request, response);
                    break;
                case "/formsCadastroSite":
                    apresentaFormCadastroSite(request, response);
                    break;
                case "/formsCadastroPromoces":
                    apresentaFormCadastroPromocoes(request, response);
                    break;
                case "/formsCadastroTeatros":
                    apresentaFormCadastroTeatro(request, response);
                    break;
                case "/apagateatro":
                    deleteTeatro(request, response);
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<Promocao> listaPromocoes = promocao_dao.getAlmostAll();
        
        List<SalaTeatro> listaTeatros = teatro_dao.getAlmostAll();
        request.setAttribute("listaTeatros", listaTeatros);
        request.setAttribute("listaPromocoes", listaPromocoes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("paginasjsp/index.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormCadastroSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("paginasjsp/formsCadastroSite.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormCadastroPromocoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("paginasjsp/formsCadastroSite.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormCadastroTeatro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("paginasjsp/formsCadastroTeatros.jsp");
        dispatcher.forward(request, response);
    }
  

    private void apresentaFormEdicaoCadastroTeatro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String cnpj = request.getParameter("id");
        SalaTeatro salateatro = teatro_dao.get(cnpj);
        RequestDispatcher dispatcher = request.getRequestDispatcher("paginasjsp/formsEdicaoCadastroTeatros.jsp");
        request.setAttribute("salateatro", salateatro);
        dispatcher.forward(request, response);
    }

    private void insereteatro(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("password");
        String cnpj =  request.getParameter("cnpj");
        String nome =  request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        SalaTeatro teatro = new SalaTeatro(email, senha, cidade, nome, cnpj);
        teatro_dao.insert(teatro);
        response.sendRedirect("index");
    }
    
    
    private void inseresite(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String senha = request.getParameter("password");
        String endereco =  request.getParameter("url");
        String nome =  request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        Site site = new Site(email, senha, nome, endereco, telefone);
        site_dao.insert(site);
        response.sendRedirect("index");
    }

    private void atualizaTeatro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String cnpj = request.getParameter("cnpj");
        String email = request.getParameter("email");
        String senha = request.getParameter("password");
        String cidade = request.getParameter("cidade");
        String nome = request.getParameter("nome");
        SalaTeatro teatro = new SalaTeatro(email, senha, cidade, nome, cnpj);
        teatro_dao.update(teatro);
       response.sendRedirect("index");
       
    }

    private void deleteTeatro(HttpServletRequest request, HttpServletResponse response) throws IOException {    
        String cnpj = request.getParameter("id");
        SalaTeatro salaTeatro = new SalaTeatro(cnpj);
        teatro_dao.delete(salaTeatro);
    }
}