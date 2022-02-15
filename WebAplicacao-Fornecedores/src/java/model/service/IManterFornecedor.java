package model.service;

import util.db.exception.NegocioException;
import util.db.exception.PersistenciaException;
import java.util.List;
import model.domain.Fornecedor;

public interface IManterFornecedor {
    public boolean alterar(Fornecedor fornecedor) throws PersistenciaException, NegocioException;
    Fornecedor pesquisarPorCod(Integer cod) throws PersistenciaException;
    public List<Fornecedor> listarTodos() throws PersistenciaException;
    public boolean excluir(Integer id) throws PersistenciaException;
    public boolean cadastrar(Fornecedor fornecedor) throws PersistenciaException, NegocioException;

}
