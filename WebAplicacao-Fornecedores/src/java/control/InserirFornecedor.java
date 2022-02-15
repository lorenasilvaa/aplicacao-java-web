package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.domain.Fornecedor;
import model.service.IManterFornecedor;
import service.impl.ManterFornecedor;
import util.db.exception.NegocioException;
import util.db.exception.PersistenciaException;

public class InserirFornecedor extends HttpServlet {
    IManterFornecedor manterFornecedor = new ManterFornecedor();
    Fornecedor fornecedor;
    String id;
    int retorno = -1;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(InserirFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            Logger.getLogger(InserirFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(InserirFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(InserirFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            Logger.getLogger(InserirFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NegocioException ex) {
            Logger.getLogger(InserirFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, PersistenciaException, NegocioException {
            String acao = request.getParameter("acao");

            if (acao.equals("listagem")) {
                listaFornecedor(request, response);
            }else if(acao.equals("deleta")){
                deletarFornecedor(request, response);
            }else if(acao.equals("editar")){
                editarFornecedor(request, response);
            }else{
                salvaFornecedor(request, response);
            }
                
    }
    private Fornecedor preencheFornecedor(HttpServletRequest request) throws ParseException {
        id = request.getParameter("idFornecedor");
        String nome = request.getParameter("nome");
        String razao = request.getParameter("razao");
        String cnpj = request.getParameter("cnpj");
        String cidade = request.getParameter("cidade");
        String regiao = request.getParameter("regiao");
        fornecedor = new Fornecedor();
        
        fornecedor.setNomeFantasia(nome);
        fornecedor.setRazaoSocial(razao);
        fornecedor.setCNPJ(cnpj);
        fornecedor.setCidade(cidade);
        fornecedor.setRegiao(regiao);
  
        return fornecedor;
    }
    protected void salvaFornecedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, PersistenciaException, NegocioException {
        
        fornecedor = preencheFornecedor(request);
        if ((id == null) || (id.equalsIgnoreCase(""))) {
            if(manterFornecedor.cadastrar(fornecedor)){
                retorno = 1;
            }else{
                retorno = 0;
            }
           
        }else{
            fornecedor.setFornecedorID(Integer.parseInt(id));
            if(manterFornecedor.alterar(fornecedor)){
                retorno = 1;
            }else{
                retorno = 0;
            }
        }  
        request.setAttribute("retorno", retorno);
        request.getRequestDispatcher("InserirFornecedor?acao=listagem").forward(request, response);

    }
     protected void editarFornecedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PersistenciaException {
        fornecedor = manterFornecedor.pesquisarPorCod(Integer.parseInt(request.getParameter("id")));
        if(fornecedor == null){
            retorno = 0;
            request.setAttribute("retorno", retorno);
            request.getRequestDispatcher("InserirFornecedor?acao=listagem").forward(request, response);

        }else{
        request.setAttribute("fornecedor", fornecedor);
        request.getRequestDispatcher("/cadastro.jsp").forward(request, response);
        }
    }
     protected void listaFornecedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PersistenciaException {
        request.setAttribute("fornecedores", manterFornecedor.listarTodos());
        request.getRequestDispatcher("/listaFornecedores.jsp").forward(request, response);
    }
     protected void deletarFornecedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, PersistenciaException {
        fornecedor = manterFornecedor.pesquisarPorCod(Integer.parseInt(request.getParameter("id")));
        if(fornecedor == null){
            retorno = 0;
            request.setAttribute("retorno", retorno);
            request.getRequestDispatcher("InserirFornecedor?acao=listagem").forward(request, response);

        }else{
            if(manterFornecedor.excluir(Integer.parseInt(request.getParameter("id")))){
                retorno = 1;
            }else{
                retorno = 0;
            }
          request.setAttribute("retorno", retorno);
          listaFornecedor(request, response);
        }
        
    }
}