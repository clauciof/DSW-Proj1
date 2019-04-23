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
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/remocao":
                    remove(request, response);
                    break;
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao":
                    atualize(request, response);
                    break;
                case "/formsCadastroSite":
                    apresentaFormCadastroSite(request, response);
                    break;
                case "/formsCadastroPromoces":
                    apresentaFormCadastroPromocoes(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //List<Site> listaSites = site_dao.getAll();
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

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("paginasjsp/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String endereco = request.getParameter("endereco");
        Site site = site_dao.get(endereco);
        RequestDispatcher dispatcher = request.getRequestDispatcher("paginasjsp/formulario.jsp");
        request.setAttribute("site", site);
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        /*request.setCharacterEncoding("UTF-8");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String ano = Integer.parseInt(request.getParameter("ano"));
        float preco = Float.parseFloat(request.getParameter("preco"));
        site = new Site(endereco, email, senha, nome, telefone);
        dao.insert(livro);
        response.sendRedirect("lista");*/
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
       /* int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        int ano = Integer.parseInt(request.getParameter("ano"));
        float preco = Float.parseFloat(request.getParameter("preco"));
        Livro livro = new Livro(id, titulo, autor, ano, preco);
        dao.update(livro);
        response.sendRedirect("lista");*/
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
       /* int id = Integer.parseInt(request.getParameter("id"));
        Livro book = new Livro(id);
        dao.delete(book);
        response.sendRedirect("lista");*/
    }
}