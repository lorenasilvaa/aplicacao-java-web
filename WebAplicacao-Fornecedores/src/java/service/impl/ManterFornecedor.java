package service.impl;

import util.db.exception.NegocioException;
import util.db.exception.PersistenciaException;
import java.util.List;
import model.dao.IFornecedorDAO;
import model.dao.impl.FornecedorDAO;
import model.domain.Fornecedor;
import model.service.IManterFornecedor;

public class ManterFornecedor implements IManterFornecedor {
    
    @Override
    public boolean alterar(Fornecedor fornecedor) throws PersistenciaException, NegocioException {
        IFornecedorDAO fornecedorDAO = new FornecedorDAO();        
        boolean result = fornecedorDAO.editar(fornecedor);
        return result;
    }
    
    @Override
    public Fornecedor pesquisarPorCod(Integer cod) throws PersistenciaException {
        IFornecedorDAO fornDAO = new FornecedorDAO();
        Fornecedor result = fornDAO.consultarPorCodigo(cod);
        return result;
    }
    @Override
    public List<Fornecedor> listarTodos() throws PersistenciaException {
        IFornecedorDAO fornecedorDAO = new FornecedorDAO();
        List<Fornecedor> listFornecedor = fornecedorDAO.exibirTodos();
        return listFornecedor;
    }

    @Override
    public boolean cadastrar(Fornecedor fornecedor) throws PersistenciaException, NegocioException {
        IFornecedorDAO fornecedorDAO = new FornecedorDAO();
        boolean result = fornecedorDAO.adicionar(fornecedor);
        return result;
    }
    
    public boolean excluir(Integer id) throws PersistenciaException{
        IFornecedorDAO fornecedorDAO = new FornecedorDAO();
        boolean result = fornecedorDAO.excluir(id);
        return result;
    }   
}