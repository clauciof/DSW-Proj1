/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.SiteDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Site;

/**
 *
 * @author clauc
 */
@WebServlet(urlPatterns = "/")
public class Controller extends HttpServlet {

    private SiteDAO site_dao;
    

    @Override
    public void init() {
        site_dao = new SiteDAO();
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
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Site> listaLivros = site_dao.getAll();
        request.setAttribute("listaLivros", listaLivros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("livro/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("livro/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String endereco = request.getParameter("endereco");
        Site site = site_dao.get(endereco);
        RequestDispatcher dispatcher = request.getRequestDispatcher("livro/formulario.jsp");
        request.setAttribute("livro", site);
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